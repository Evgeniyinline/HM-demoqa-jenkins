package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ElemetsComponent {

    private SelenideElement
            pictureInput = $("#uploadPicture"),
            submit = $("#submit"),
            subjects = $("#subjectsInput");

    public ElemetsComponent pictureLoader(String fileName) {
        pictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public ElemetsComponent submitButton() {
        submit.click();

        return this;
    }

    public ElemetsComponent subjectsInsert(String value) {
        subjects.setValue(value).pressEnter();

        return this;
    }
}