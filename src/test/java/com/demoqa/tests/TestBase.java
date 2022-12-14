package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;



    @ExtendWith({BrowserPerTestStrategyExtension.class})
    public class TestBase {

        @BeforeAll
        static void configure() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            if (System.getProperty("selenide.remote") != null) {
                Configuration.remote = System.getProperty("selenide.remote");
                capabilities.setCapability("enableVNC", true);
                capabilities.setCapability("enableVideo", true);
            }

            Configuration.browserCapabilities = capabilities;
            Configuration.baseUrl = "https://demoqa.com";

            Configuration.browser = System.getProperty("browser_name", "chrome");
            Configuration.browserVersion = System.getProperty("browser_version", "100.0");
            Configuration.browserSize = System.getProperty("browser_size", "1920x1080");
        }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}