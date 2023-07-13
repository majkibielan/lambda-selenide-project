package com.lambdatest.lambdaselenideproject.pages.account;

import com.codeborne.selenide.SelenideElement;
import com.lambdatest.lambdaselenideproject.pages.AccountPage;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.lambdatest.lambdaselenideproject.common.DataGenerator.*;

@Slf4j
public class InformationPage {

    private SelenideElement editPageHeader = $("div#content h1");
    private SelenideElement firstNameInput = $("input#input-firstname");
    private SelenideElement lastNameInput = $("input#input-lastname");
    private SelenideElement emailInput = $("input#input-email");
    private SelenideElement telephoneInput = $("input#input-telephone");
    private SelenideElement backBtn = $x("//form//a[contains(@href, 'route=account/account')]");
    private SelenideElement continueBtn = $("input[value='Continue']");

    public String getEditInfoPageURL() {
        return url();
    }

    public String getFirstNameText() {
        log.info(firstNameInput.getValue());
        return firstNameInput.getValue();
    }

    public String getLastNameText() {
        log.info(lastNameInput.getValue());
        return lastNameInput.getValue();
    }

    public String getEmailText() {
        log.info(emailInput.getValue());
        return emailInput.getValue();
    }

    public String getTelephoneText() {
        log.info(telephoneInput.getValue());
        return telephoneInput.getValue();
    }

    public AccountPage backToAccountPage() {
        backBtn.click();
        return page(AccountPage.class);
    }

    public AccountPage editAccountInfo() {
        firstNameInput.val(getFirstName());
        lastNameInput.val(getLastName());
        telephoneInput.val(getTelephoneNumber());
        continueBtn.click();
        return page(AccountPage.class);
    }
}
