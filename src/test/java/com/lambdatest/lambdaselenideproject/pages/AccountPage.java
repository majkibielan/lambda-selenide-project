package com.lambdatest.lambdaselenideproject.pages;

import com.codeborne.selenide.SelenideElement;
import com.lambdatest.lambdaselenideproject.pages.account.InformationPage;
import com.lambdatest.lambdaselenideproject.pages.account.PasswordPage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AccountPage {

    private final SelenideElement editInformationLink = $x("//div[@id='content']//a[contains(@href, 'route=account/edit')]");
    private final SelenideElement changePasswordLink = $x("//div[@id='content']//a[contains(@href, 'route=account/password')]");
    private final SelenideElement addressBookLink = $x("//div[@id='content']//a[contains(@href, 'route=account/address')]");
    private final SelenideElement wishListLink = $x("//div[@id='content']//a[contains(@href, 'route=account/wishlist')]");
    private final SelenideElement newletterLink = $x("//div[@id='content']//a[contains(@href, 'route=account/newsletter')]");
    private final SelenideElement successAlert = $(".alert.alert-success.alert-dismissible");

    public String getAccountPageURL() {
        return url();
    }

    public String getSuccessAlert() {
        String alert = successAlert.getText().trim();
        return alert;
    }

    public InformationPage navigateToEditInfoPage() {
        editInformationLink.click();
        return page(InformationPage.class);
    }

    public PasswordPage navigateToChangePwdPage() {
        changePasswordLink.click();
        return page(PasswordPage.class);
    }
}
