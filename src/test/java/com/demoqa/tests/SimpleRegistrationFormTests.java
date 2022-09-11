package com.demoqa.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimpleRegistrationFormTests extends TestBase {

    @Feature("Заполнение регистрационной формы")
    @Story("Заполнение формы")
    @Test
    @DisplayName("Регистрация с личными данными без PO")
    void fillRegistrationFormTestSimple() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        $("#firstName").setValue("Evgeniy");
        $("#lastName").setValue("Orlov");
        $("#userEmail").setValue("testForm@gmail.com");
        $(byText("Male")).click();
        $("#userNumber").setValue("9876543210");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1995");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");
        $(".react-datepicker__day--030").click();
        $("#subjectsInput").setValue("Physics").pressEnter();
        $(byText("Sports")).click();
        $(byText("Music")).click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test-image.jpg"));
        $("#currentAddress").setValue("Russia, SaintP");
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();
        $("#submit").click();
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Evgeniy Orlov"),
                text("testForm@gmail.com"),
                text("Male"),
                text("987654321"),
                text("30 June,1995"),
                text("Physics"),
                text("Sports, Music"),
                text("test-image.jpg"),
                text("Russia, SaintP"),
                text("Haryana Karnal")
        );
    }
}