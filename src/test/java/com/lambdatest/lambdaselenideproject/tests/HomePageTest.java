package com.lambdatest.lambdaselenideproject.tests;

import com.lambdatest.lambdaselenideproject.base.BaseTest;
import com.lambdatest.lambdaselenideproject.pages.HomePage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.lambdatest.lambdaselenideproject.common.Constants.HOME_PAGE_URL;

@Slf4j
public class HomePageTest extends BaseTest {

    HomePage homePage = new HomePage();

    @DataProvider
    public Object[][] getProductData() {
        return new Object[][]{{"Macbook"}, {"Samsung"}, {"Playstation"}};
    }

    @Test(priority = 1)
    public void homePageUrlTest() {
        String actualUrl = homePage.getHomePageURL();
        Assert.assertEquals(actualUrl, HOME_PAGE_URL);
    }

    @Test(priority = 2, dataProvider = "getProductData")
    public void searchTest(String productName) {
        String actualSearchHeader = homePage.doSearch(productName);
        Assert.assertEquals(actualSearchHeader, "Search - " + productName);
    }

}
