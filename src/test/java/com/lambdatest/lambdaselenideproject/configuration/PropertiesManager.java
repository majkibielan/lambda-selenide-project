package com.lambdatest.lambdaselenideproject.configuration;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Properties;

public class PropertiesManager {

    static Properties properties;

    public static void setUpProperties() {
        properties = ConfigFileReader.getPropertiesFromFile("config/config.properties");
        Configuration.browser = getBrowserType();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        Configuration.baseUrl = getUrl();
        Configuration.browserCapabilities = options;
    }


    public static String getBrowserType() {
        return properties.getProperty("browser");
    }
    public static String getUrl() {
        return properties.getProperty("url");
    }

    public static String getLogin() {
        return properties.getProperty("login");
    }

    public static String getPassword() {
        return properties.getProperty("password");
    }
}
