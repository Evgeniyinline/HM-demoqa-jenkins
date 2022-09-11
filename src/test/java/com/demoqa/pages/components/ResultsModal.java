package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {

    private final static String TITLE_TEXT = "Thanks for submitting the form";

    private SelenideElement
            tableResults = $(".table-responsive"),
            tableTitle = $("#example-modal-sizes-title-lg"),
            results = $(".modal-dialog");

    public ResultsModal checkVisible() {
        results.should(appear);
        tableTitle.shouldHave(text(TITLE_TEXT));
        return this;
    }


    public ResultsModal checkResult(String key, String value) {
        tableResults.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }
}