package com.lambdatest.lambdaselenideproject.tests;

import com.lambdatest.lambdaselenideproject.base.BaseTest;
import com.lambdatest.lambdaselenideproject.pages.AccountPage;
import com.lambdatest.lambdaselenideproject.pages.HomePage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.lambdatest.lambdaselenideproject.common.Constants.ACCOUNT_PAGE_URL;
import static com.lambdatest.lambdaselenideproject.common.Constants.EDIT_INFO_PAGE_URL;
import static com.lambdatest.lambdaselenideproject.common.DataGenerator.*;

@Slf4j
public class AccountPageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void navigateToAccountPageTest() {
        var accountPage = homePage
                .navigateToLoginPage()
                .login();
        String actualAccountPageURL = accountPage.getAccountPageURL();
        Assert.assertEquals(actualAccountPageURL, ACCOUNT_PAGE_URL);
    }

    @Test
    public void navigateToEditInfoPageTest() {
        var informationPage = homePage
                .navigateToLoginPage()
                .login()
                .navigateToEditInfoPage();
        String actualEditInfoURL = informationPage.getEditInfoPageURL();
        Assert.assertEquals(actualEditInfoURL, EDIT_INFO_PAGE_URL);
    }

    @Test
    public void EditAccountInfoTest() {
        var accountPage = homePage
                .navigateToLoginPage()
                .login()
                .navigateToEditInfoPage()
                .editAccountInfo();
        String actualSuccessMsg = accountPage.getSuccessAlert().trim();
        Assert.assertEquals(actualSuccessMsg, "Success: Your account has been successfully updated.");

        var informationPage = accountPage.navigateToEditInfoPage();

        String actualFirstName = informationPage.getFirstNameText();
        Assert.assertEquals(actualFirstName, previousFirstName);

        String actualLastName = informationPage.getLastNameText();
        Assert.assertEquals(actualLastName, previousLastName);

        String actualTelephone = informationPage.getTelephoneText();
        Assert.assertEquals(actualTelephone, previousTelephone);
    }
}
