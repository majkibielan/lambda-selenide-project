package com.lambdatest.lambdaselenideproject.pages.register;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

@Slf4j
public class RegisterSuccess {

    private SelenideElement successRegistrationHeader = $("div#content h1");
    private SelenideElement continueBtn = $x("//div[contains(@class, 'buttons')]/a");

    public String getSuccessRegistrationURL() {
        return url();
    }
}
