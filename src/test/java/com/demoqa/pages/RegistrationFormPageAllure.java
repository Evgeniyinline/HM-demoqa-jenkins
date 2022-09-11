package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ElemetsComponent;
import com.demoqa.pages.components.ResultsModal;
import com.demoqa.pages.components.SelectComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPageAllure {

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

    @Step("Открываем форму для регистрации")
    public void openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(TITLE_TEXT));

    }

    @Step("Удаляем мешающие элементы со страницы")
    public void removeGarbageElements() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");

    }

    @Step("Указываем имя: {value}")
    public void setFirstName(String value) {
        firstNameInput.setValue(value);

    }

    @Step("Указываем фамилию: {value}")
    public void setLastName(String value) {
        lastNameInput.setValue(value);

    }

    @Step("Выбираем пол: {value}")
    public void setGender(String value) {
        genderSelect.$(byText(value)).click();

    }

    @Step("Указываем адресс: {value}")
    public void setAddress(String value) {
        addressInput.setValue(value);

    }

    @Step("Указываем email: {value}")
    public void setEmail(String value) {
        userEmailInput.setValue(value);

    }

    @Step("Указываем телефон: {value}")
    public void setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);

    }

    @Step("Указываем дату рождения: {day} {month}, {year}")
    public void setBirthDate(String day, String month, String year) {
        dateInput.click();
        calendarComponents.setDate(day, month, year);

    }

    @Step("Проверяем отображение таблицы результатов")
    public void checkResultsTableVisible() {
        resultsTableComponents.checkVisible();

    }

    @Step("Сверяемся с итоговым результатом: {key} - {value}")
    public void checkResult(String key, String value) {
        resultsTableComponents.checkResult(key, value);

    }

    @Step("Выбираем хобби: {value}")
    public void setHobbies(String value) {
        selectComponents.hobbies(value);

    }

    @Step("Выбираем город: {value}")
    public void setCity(String value) {
        selectComponents.citySelect(value);

    }

    @Step("Выбираем штат: {value}")
    public void setState(String value) {
        selectComponents.stateSelect(value);

    }

    @Step("Указываем фото: {fileName}")
    public void setPicture(String fileName) {
        elementsComponents.pictureLoader(fileName);

    }

    @Step("Жмём на кнопку подтверждения")
    public void submit() {
        elementsComponents.submitButton();

    }

    @Step("Указываем предметную область: {value}")
    public void setSubject(String value) {
        elementsComponents.subjectsInsert(value);

    }

}