package com.gostechnadzor.test_base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.gostechnadzor.attach.Attachments;
import com.gostechnadzor.insert_data.InsertingMainData;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;


public class TestBase {


    @BeforeAll
    static void setUp() {
        InsertingMainData PersonalData = ConfigFactory.create(InsertingMainData.class);
        String remoteUrl = PersonalData.remoteUrl();
        String site = PersonalData.site();

        Configuration.baseUrl = site;
        Configuration.browserSize = "1920x1080";
        //Configuration.remote = remoteUrl;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open("/");
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
        Selenide.closeWebDriver();
    }

}
