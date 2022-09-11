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




}