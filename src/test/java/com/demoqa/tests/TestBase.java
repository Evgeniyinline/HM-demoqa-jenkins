package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import java.util.Locale;

import static com.demoqa.utils.RandomUtils.*;

public class TestBase {


    Faker faker = new Faker(new Locale("en"));
    String firstName =faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            gender = getRandomGender(),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            day = String.format("%02d",faker.number().numberBetween(1,28)),
            month = getRandomMonth(),
            year = faker.number().numberBetween(1940, 2000) + "",
            userSubject = "Computer Science",
            userHobbies = getRandomHobby(),
            file = "test-image.jpg",
            userAddress = faker.harryPotter().location(),
            userState = "NCR",
            userCity = "Delhi";
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserSize = "1080x1080";

    }

}
