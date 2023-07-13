package com.lambdatest.lambdaselenideproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.lambdatest.lambdaselenideproject.pages.register.RegisterSuccess;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.lambdatest.lambdaselenideproject.common.DataGenerator.*;

@Slf4j
public class RegisterPage {

    private SelenideElement firstNameInput = $("input#input-firstname");
    private SelenideElement lastNameInput = $("input#input-lastname");
    private SelenideElement emailInput = $("input#input-email");
    private SelenideElement telephoneInput = $("input#input-telephone");
    private SelenideElement passwordInput = $("input#input-password");
    private SelenideElement passwordConfirmInput = $("input#input-confirm");
    private SelenideElement newsletterYesRadio = $x("//input[@id='input-newsletter-yes']/..");
    private SelenideElement newsletterNoRadio = $x("//input[@id='input-newsletter-no']/..");
    private SelenideElement policyCheckbox = $x("//input[@id='input-agree']/..");
    private SelenideElement continueBtn = $("input[value='Continue']");

    public String getRegisterPageURL() {
        return url();
    }

    public RegisterSuccess performSuccessRegistration() {
        firstNameInput.val(getFirstName());
        lastNameInput.val(getLastName());
        emailInput.val(getEmailAddress());
        telephoneInput.val(getTelephoneNumber());
        passwordInput.val(getPassword());
        passwordConfirmInput.val(previousPassword);
        newsletterYesRadio.click();
        policyCheckbox.click();
        continueBtn.click();
        return page(RegisterSuccess.class);
    }

}
