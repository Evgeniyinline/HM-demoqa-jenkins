package com.demoqa.tests;

import com.demoqa.pages.AutomationPracticeFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class AutomationPracticeFormPageObjectTest extends TestBase {
    AutomationPracticeFormPage automationPracticeFormPage = new AutomationPracticeFormPage();

    @Test
    @DisplayName("Проверка работы автозаполнения формы регистрации")
    void fillRegistrationFormTest() {
        automationPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(day,month,year)
                .setSubject(userSubject)
                .setHobbies(userHobbies)
                .setPicture(file)
                .setAddress(userAddress)
                .setStateAndCity(userState, userCity)
                .setSumbit();

        automationPracticeFormPage.checkResultVisible()
                .checkResult("Student Name", format("%s %s",firstName, lastName))
                .checkResult("Student Email",userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", format("%s %s,%s",day, month, year))
                .checkResult("Subjects", userSubject)
                .checkResult("Hobbies", userHobbies)
                .checkResult("Picture", file)
                .checkResult("Address", userAddress)
                .checkResult("State and City", format("%s %s",userState, userCity));

    }

    @Test
    @DisplayName("Минимальное автозаполнение регистрационной формы")
    void fillFormWithMinimumDataTest() {
        automationPracticeFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setSumbit()
                .checkResultVisible()
                .checkResult("Student Name", format("%s %s",firstName, lastName))
                .checkResult("Student Email", userEmail)
                .checkResult("Gender",gender)
                .checkResult("Mobile", userNumber);
    }
}
