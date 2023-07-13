package com.lambdatest.lambdaselenideproject.tests;

import com.lambdatest.lambdaselenideproject.base.BaseTest;
import com.lambdatest.lambdaselenideproject.pages.HomePage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.lambdatest.lambdaselenideproject.common.Constants.HOME_PAGE_URL;

@Slf4j
public class HomePageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @Test
    public void getHomePageUrlTest() {
        String actualUrl = homePage.getHomePageURL();
        Assert.assertEquals(actualUrl, HOME_PAGE_URL);
    }

}
