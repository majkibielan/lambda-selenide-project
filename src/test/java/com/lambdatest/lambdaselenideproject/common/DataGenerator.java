package com.lambdatest.lambdaselenideproject.common;

import com.github.javafaker.Faker;

public class DataGenerator {

    private static final Faker faker = new Faker();
    public static String previousFirstName;
    public static String previousLastName;
    public static String previousTelephone;
    public static String previousPassword;
    public static String previousEmail;

    public static String getFirstName() {
        String firstName = faker.name().firstName();

        if (previousFirstName == null) {
            previousFirstName = firstName;
        }
        return firstName;
    }

    public static String getLastName() {
        String lastName = faker.name().lastName();

        if (previousLastName == null) {
            previousLastName = lastName;
        }
        return lastName;
    }

    public static String getEmailAddress() {
        String email = previousFirstName.toLowerCase() + "." + previousLastName.toLowerCase() + "@mail.test";

        if (previousEmail == null) {
            previousEmail = email;
        }
        return email;
    }

    public static String getTelephoneNumber() {
        String telephone = faker.phoneNumber().cellPhone();

        if (previousTelephone == null) {
            previousTelephone = telephone;
        }
        return telephone;
    }

    public static String getPassword() {
        String password = faker.funnyName().name() + faker.number().randomDigit();
        if (previousPassword == null) {
            previousPassword = password;
        }
        return password;
    }
}
