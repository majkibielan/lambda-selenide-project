package com.lambdatest.lambdaselenideproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AccountPage {

    private SelenideElement editInformationLink = $x("//div[@id='content']//a[contains(@href, 'route=account/edit')]");
    private SelenideElement changePasswordLink = $x("//div[@id='content']//a[contains(@href, 'route=account/password')]");
    private SelenideElement addressBookLink = $x("//div[@id='content']//a[contains(@href, 'route=account/address')]");
    private SelenideElement wishListLink = $x("//div[@id='content']//a[contains(@href, 'route=account/wishlist')]");
    private SelenideElement newletterLink = $x("//div[@id='content']//a[contains(@href, 'route=account/newsletter')]");
    private SelenideElement successAlert = $(".alert.alert-success.alert-dismissible");

    public String getAccountPageURL() {
        return WebDriverRunner.url();
    }

    public String getSuccessAlert() {
        String alert = successAlert.getText().trim();
        return  alert;
    }
}
