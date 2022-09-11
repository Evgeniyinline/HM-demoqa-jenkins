package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.data.TestData;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.remote.DesiredCapabilities;

@ExtendWith({BrowserPerTestStrategyExtension.class})
public class TestBase {

    public static final String
            remote = System.getProperty("selenoid.autotests.cloud/wd/hub"),
            browserName = System.getProperty("browser_name", "chrome"),
            browserVersion = System.getProperty("browser_version"),
            browserSize = System.getProperty("browser_size", "800x800"),
            LOGIN_REMOTE = "user1",
            PASSWORD_REMOTE = "1234",
            baseUrl = "https://demoqa.com";

    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();

        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = TestBase.baseUrl;
        Configuration.browser = TestBase.browserName;
        Configuration.browserVersion = TestBase.browserVersion;
        Configuration.browserSize = TestBase.browserSize;

        if (TestBase.remote == null || TestBase.remote.equals("")) {
        } else {
            Configuration.remote = "https://"
                    + TestBase.LOGIN_REMOTE + ":"
                    + TestBase.PASSWORD_REMOTE + "@"
                    + TestBase.remote;

            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }

        if (TestBase.browserVersion != null) {
            Configuration.browserVersion = TestBase.browserVersion;
        }
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if (TestBase.remote == null || TestBase.remote.equals("")) {
        } else {
            Attach.addVideo();
        }
    }
}