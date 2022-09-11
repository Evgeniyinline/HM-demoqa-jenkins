package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class PageObjectsPatternRegistrationFormTests extends TestBase {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Feature("Заполнение регистрационной формы")
    @Story("Заполнение формы используя паттерн \"PageObjects\"")
    @Test
    @DisplayName("Регистрация с личными данными")
    void fillRegistrationFormTestPageObjects() {
        registrationFormPage
                .openPage()
                .removeGarbageElements()
                .setFirstName("Evgeniy")
                .setLastName("Orlov")
                .setEmail("testForm@gmail.com")
                .setGender("Male")
                .setPhoneNumber("9876543210")
                .setBirthDate("30", "June", "1995")
                .setSubject("Physics")
                .setHobbies("Sports")
                .setHobbies("Music")
                .setPicture("test-image.jpg")
                .setAddress("Russia, SaintP")
                .setState("Haryana")
                .setCity("Karnal")
                .submit()

                .checkResultsTableVisible()
                .checkResult("Student Name", "Evgeniy Orlov")
                .checkResult("Student Email", "testForm@gmail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "9876543210")
                .checkResult("Date of Birth", "30 June,1995")
                .checkResult("Subjects", "Physics")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "test-image.jpg")
                .checkResult("Address", "Russia, SaintP")
                .checkResult("State and City", "Haryana Karnal");
    }
}
