package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultTableComponent;
import com.demoqa.pages.components.StateAndCity;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {
    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultTableComponent resultTableComponent = new ResultTableComponent();
    private StateAndCity stateAndCity = new StateAndCity();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderInput = $("#genterWrapper"),
            subject = $("#subjectsInput"),
            pictureInput = $("#uploadPicture"),
            addressInput =  $("#currentAddress"),
            userHobbies = $("#hobbiesWrapper"),
            sumbit = $("#submit");




    public AutomationPracticeFormPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public AutomationPracticeFormPage setEmail(String value) {
         emailInput.setValue(value);

        return this;
    }
    public AutomationPracticeFormPage setGender(String value) {
        genderInput.$(byText(value)).click();

        return this;
    }
    public AutomationPracticeFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }
        
    public AutomationPracticeFormPage setBirthDate(String day,String month,String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day,month,year);

        return this;
    }
    public AutomationPracticeFormPage checkResultVisible() {
        resultTableComponent.checkVisible();

        return this;
    }

    public AutomationPracticeFormPage checkResult(String key, String value) {
        resultTableComponent.checkResult(key,value);

        return this;

    }
    public AutomationPracticeFormPage setSubject(String value) {
        subject.setValue(value).pressEnter();

        return this;

    }

    public AutomationPracticeFormPage setHobbies(String value) {
        userHobbies.$(byText(value)).click();


        return this;
    }

    public AutomationPracticeFormPage setPicture(String value){
        pictureInput.uploadFromClasspath(value);

        return this;

    }

    public AutomationPracticeFormPage setAddress(String value){
        addressInput.setValue(value);

        return this;

    }

    public AutomationPracticeFormPage setStateAndCity(String state, String city) {
        stateAndCity.setStateAndCity(state, city);

        return this;

    }

    public AutomationPracticeFormPage setSumbit() {
        sumbit.pressEnter();
        return this;
    }
}
