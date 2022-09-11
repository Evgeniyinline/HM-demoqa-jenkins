package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SelectComponent {

    private SelenideElement
            hobbiesInput = $("#hobbiesWrapper"),
            stateCityInput = $("#stateCity-wrapper"),
            state = $("#state"),
            city = $("#city");


    public SelectComponent hobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public SelectComponent stateSelect(String value) {
        state.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }

    public SelectComponent citySelect(String value) {
        city.click();
        stateCityInput.$(byText(value)).click();

        return this;
    }
}