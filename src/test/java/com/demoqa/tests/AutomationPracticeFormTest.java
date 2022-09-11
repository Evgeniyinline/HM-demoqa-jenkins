package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTest {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "400x900";

    }

    @Test
    void fillRegistrationFormTest() {

        open("/automation-practice-form");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue("Evgeniy");
        $("#lastName").setValue("Orlov");

        $("#userEmail").setValue("OrlovTest@gmail.com");

        $(byText("Male")).click();

        $("#userNumber").setValue("9876543210");

        $("#dateOfBirthInput").click();

        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOptionByValue("1995");

        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOptionByValue("6");

        $(".react-datepicker__day--030").click();

        $("#subjectsInput").setValue("Computer Science").pressEnter();

        $(byText("Sports")).click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/test-image.jpg"));

        $("#currentAddress").setValue("Russia, SaintP");

        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();

        $("#submit").pressEnter();

        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(
                text("Evgeniy Orlov"),
                text("OrlovTest@gmail.com"),
                text("Male"),
                text("9876543210"),
                text("30 June,1995"),
                text("Computer Science"),
                text("Sports"),
                text("test-image.jpg"),
                text("Russia, SaintP"),
                text("NCR Delhi"));

    }
}