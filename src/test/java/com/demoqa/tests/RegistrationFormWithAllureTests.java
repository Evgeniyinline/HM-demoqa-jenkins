package com.demoqa.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.data.TestData;
import com.demoqa.pages.RegistrationFormPageAllure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RegistrationFormWithAllureTests extends TestBase {

    RegistrationFormPageAllure registrationFormPageAllure = new RegistrationFormPageAllure();
    TestData testData = new TestData();

    @Feature("Заполнение регистрационной формы")
    @Story("Заполнение формы с добавлением описаний шагов в Аллюр")
    @Test
    @DisplayName("Регистрация с фейкером для Allure")
    void fillRegistrationFormAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        registrationFormPageAllure.openPage();
        registrationFormPageAllure.removeGarbageElements();
        registrationFormPageAllure.setFirstName(testData.firstName);
        registrationFormPageAllure.setLastName(testData.lastName);
        registrationFormPageAllure.setEmail(testData.email);
        registrationFormPageAllure.setGender(testData.gender);
        registrationFormPageAllure.setPhoneNumber(testData.phoneNumber);
        registrationFormPageAllure.setBirthDate(testData.day, testData.month, testData.year);
        registrationFormPageAllure.setSubject(testData.subjects);
        registrationFormPageAllure.setHobbies(testData.firstHobby);
        registrationFormPageAllure.setHobbies(testData.secondHobby);
        registrationFormPageAllure.setPicture(testData.fileName);
        registrationFormPageAllure.setAddress(testData.address);
        registrationFormPageAllure.setState(testData.state);
        registrationFormPageAllure.setCity(testData.city);
        registrationFormPageAllure.submit();

        registrationFormPageAllure.checkResultsTableVisible();
        registrationFormPageAllure.checkResult("Student Name", testData.firstName + " " + testData.lastName);
        registrationFormPageAllure.checkResult("Student Email", testData.email);
        registrationFormPageAllure.checkResult("Gender", testData.gender);
        registrationFormPageAllure.checkResult("Mobile", testData.phoneNumber);
        registrationFormPageAllure.checkResult("Date of Birth", testData.day + " "
                + testData.month + "," + testData.year);
        registrationFormPageAllure.checkResult("Subjects", testData.subjects);
        registrationFormPageAllure.checkResult("Hobbies", testData.firstHobby + ", " + testData.secondHobby);
        registrationFormPageAllure.checkResult("Picture", testData.fileName);
        registrationFormPageAllure.checkResult("Address", testData.address);
        registrationFormPageAllure.checkResult("State and City", testData.state + " " + testData.city);
    }
}
