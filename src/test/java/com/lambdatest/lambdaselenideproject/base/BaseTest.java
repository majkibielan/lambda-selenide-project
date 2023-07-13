package com.lambdatest.lambdaselenideproject.base;

import com.lambdatest.lambdaselenideproject.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.lambdatest.lambdaselenideproject.configuration.PropertiesManager.setUpProperties;

public class BaseTest {

    @BeforeTest
    public void setup() {
        setUpProperties();
        open("");
    }

    @AfterTest
    public void tearDown() {
        getWebDriver().close();
    }
}
