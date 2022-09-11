package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.data.TestData;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

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
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        Configuration.browserSize = "1080x1080";

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = TestData.baseUrl;
        Configuration.browser = TestData.browserName;
        Configuration.browserVersion = TestData.browserVersion;
        Configuration.browserSize = TestData.browserSize;

        if (TestData.remote == null || TestData.remote.equals("")) {
        } else {
            Configuration.remote = "https://"
                    + TestData.LOGIN_REMOTE + ":"
                    + TestData.PASSWORD_REMOTE + "@"
                    + TestData.remote;

            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }

        if (TestData.browserVersion != null) {
            Configuration.browserVersion = TestData.browserVersion;
        }
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if (TestData.remote == null || TestData.remote.equals("")) {
        } else {
            Attach.addVideo();
        }
    }

}
