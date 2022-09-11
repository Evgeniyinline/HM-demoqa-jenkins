package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    private CalendarComponent calendarComponents = new CalendarComponent();
    private ResultsModal resultsTableComponents = new ResultsModal();
    private SelectComponent selectComponents = new SelectComponent();
    private ElemetsComponent elementsComponents = new ElemetsComponent();
    private final static String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            genderSelect = $("#genterWrapper"),
            phoneNumberInput = $("#userNumber"),
            userEmailInput = $("#userEmail"),
            dateInput = $("#dateOfBirthInput"),
            formTitle = $(".practice-form-wrapper"),
            addressInput = $("#currentAddress");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationFormPage removeGarbageElements() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderSelect.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateInput.click();
        calendarComponents.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage checkResultsTableVisible() {
        resultsTableComponents.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponents.checkResult(key, value);

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        selectComponents.hobbies(value);

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        selectComponents.citySelect(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        selectComponents.stateSelect(value);

        return this;
    }

    public RegistrationFormPage setPicture(String fileName) {
        elementsComponents.pictureLoader(fileName);

        return this;
    }

    public RegistrationFormPage submit() {
        elementsComponents.submitButton();

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        elementsComponents.subjectsInsert(value);

        return this;
    }

}
