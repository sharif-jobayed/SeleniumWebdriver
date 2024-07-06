package com.theInternetHerokuApp.framework;

import com.theInternetHerokuApp.pages.HomePage;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.data.Constants.getBaseURL;
import static com.theInternetHerokuApp.framework.DriverTools.getDriver;

public class BaseTest {
    private HomePage homePage = new HomePage();

    @BeforeTest
    void setUp() {
        new DriverTools("Chrome");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        homePage.openPage();
        homePage.isPageOpen();
        homePage.isPageLoaded();
    }

    @AfterTest
    void tearDown() {
        getDriver().close();
    }
}
