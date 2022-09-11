package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.String.format;

public class AutomationPracticeFormTestDataTest extends TestBase {

    @Test
    void fillRegistrationFormTest() {

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $(byText("Male")).click();
        $("#userNumber").setValue("9876543210");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",day)).click();
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
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + " " + lastName));
        String expectedFullName = format("%s %s", firstName, lastName);
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(expectedFullName));
        $(".table-responsive table").$(byText("Student Email"))
                .parent().shouldHave(text(userEmail));
        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(expectedDateOfBirth));
    }
}