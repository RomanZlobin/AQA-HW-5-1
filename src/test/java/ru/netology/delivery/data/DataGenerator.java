package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.Value;
import lombok.experimental.UtilityClass;
import org.junit.jupiter.api.BeforeAll;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DataGenerator {
    static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

//         TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
//         Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return date;
    }

    public static String generateCity(String locale) {
        String city = faker.address().cityName();
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        return city;
    }

    public static String generateName(String locale) {
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String name = firstName + " " + lastName;
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {}

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo();
            user.setCity(generateCity(locale));
            user.setName(generateName(locale));
            user.setPhone(generatePhone(locale));

            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return user;
        }
    }

    @Data
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
