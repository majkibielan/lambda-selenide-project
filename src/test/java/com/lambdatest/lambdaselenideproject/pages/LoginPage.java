package com.lambdatest.lambdaselenideproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;
import static com.lambdatest.lambdaselenideproject.common.Constants.LOGIN;
import static com.lambdatest.lambdaselenideproject.common.Constants.PASSWORD;

public class LoginPage {

    private SelenideElement emalInput = $("input#input-email");
    private SelenideElement passwordInput = $("input#input-password");
    private SelenideElement forgottenPasswordLink = $x("//div[@class='form-group']/a[contains(@href, 'route=account/forgotten')]");
    private SelenideElement loginBtn = $("input[value='Login']");
    private SelenideElement alertMessage = $x("//div[@id='account-login']/div[contains(@class, 'alert-danger')]");

    public String getLoginPageURL() {
        return WebDriverRunner.url();
    }

    public boolean isForgotPwdLinkExist() {
        return forgottenPasswordLink.isDisplayed();
    }

    public AccountPage performValidLogin() {
        emalInput.val(LOGIN);
        passwordInput.val(PASSWORD);
        loginBtn.click();
        return page(AccountPage.class);
    }

    public String performInvalidLogin() {
        emalInput.val("testemail@mail.test");
        passwordInput.val("test");
        loginBtn.click();
        String alertText = alertMessage.text();
        return alertText;
    }

    public AccountPage login() {
        performValidLogin();
        return page(AccountPage.class);
    }
}
