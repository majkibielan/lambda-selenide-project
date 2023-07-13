package com.lambdatest.lambdaselenideproject.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

@Slf4j
public class HomePage {

    private SelenideElement myAccountLink = $x("//a[@role='button'][.//span[contains(text(), 'My account')]]");
    private SelenideElement loginPageLink = $x("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/login']");
    private SelenideElement registerPageLink = $x("//a[@href='https://ecommerce-playground.lambdatest.io/index.php?route=account/register']");

    public String getHomePageURL() {
        return url();
    }

    public LoginPage navigateToLoginPage() {
        myAccountLink.hover();
        loginPageLink.click();
        return page(LoginPage.class);
    }
}
