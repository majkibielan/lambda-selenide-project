package com.lambdatest.lambdaselenideproject.tests;

import com.lambdatest.lambdaselenideproject.base.BaseTest;
import com.lambdatest.lambdaselenideproject.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.lambdatest.lambdaselenideproject.common.Constants.ACCOUNT_PAGE_URL;
import static com.lambdatest.lambdaselenideproject.common.Constants.LOGIN_PAGE_URL;

public class LoginPageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void loginPageNavigationTest() {
        var loginPage = homePage
                .navigateToLoginPage();
        String actualLoginPageURL = loginPage.getLoginPageURL();
        Assert.assertEquals(actualLoginPageURL, LOGIN_PAGE_URL);
    }

    @Test
    public void forgotPwdLinkExistTest() {
        var loginPage = homePage.navigateToLoginPage().isForgotPwdLinkExist();
        Assert.assertTrue(loginPage);
    }

    @Test
    public void validLoginTest() {
        var loginPage = homePage
                .navigateToLoginPage()
                .performValidLogin();
        String actualAccountPageURL = loginPage.getAccountPageURL();
        Assert.assertEquals(actualAccountPageURL, ACCOUNT_PAGE_URL);
    }

    @Test
    public void invalidLoginTest() {
        var loginPage = homePage
                .navigateToLoginPage();
        String warningMessage = loginPage.performInvalidLogin().trim();
        Assert.assertEquals(warningMessage, "Warning: No match for E-Mail Address and/or Password.");
    }
}
