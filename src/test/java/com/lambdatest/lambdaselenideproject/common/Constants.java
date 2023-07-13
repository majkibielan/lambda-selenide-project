package com.lambdatest.lambdaselenideproject.common;

import static com.lambdatest.lambdaselenideproject.configuration.PropertiesManager.getLogin;
import static com.lambdatest.lambdaselenideproject.configuration.PropertiesManager.getPassword;

public class Constants {

    public static final String HOME_PAGE_URL = "https://ecommerce-playground.lambdatest.io/index.php?route=common/home";
    public static final String LOGIN_PAGE_URL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/login";
    public static final String REGISTER_PAGE_URL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    public static final String ACCOUNT_PAGE_URL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/account";
    public static final String SUCCESS_REGISTRATION_PAGE_URL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/success";
    public static final String EDIT_INFO_PAGE_URL = "https://ecommerce-playground.lambdatest.io/index.php?route=account/edit";
    public static final String LOGIN = getLogin();
    public static final String PASSWORD = getPassword();
}
