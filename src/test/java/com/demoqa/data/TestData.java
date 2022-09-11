package com.demoqa.data;

import com.github.javafaker.Faker;

public class TestData {
    public Faker faker = new Faker();

    public String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.demographic().sex(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            day = faker.number().numberBetween(10, 28) + "",
            month = "May",
            year = faker.number().numberBetween(1900, 2022) + "",
            subjects = "Physics",
            firstHobby = "Sports",
            secondHobby = "Music",
            fileName = "test-image.jpg",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Karnal";

    public static final String
            remote = System.getProperty("remote"),
            browserName = System.getProperty("browser_name", "chrome"),
            browserVersion = System.getProperty("browser_version"),
            browserSize = System.getProperty("browser_size", "1920x1080"),
            LOGIN_REMOTE = "user1",
            PASSWORD_REMOTE = "1234",
            baseUrl = "https://demoqa.com";

}