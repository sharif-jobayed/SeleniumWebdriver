package com.theInternetHerokuApp.framework;

import org.openqa.selenium.Dimension;
import org.testng.annotations.*;

import static com.theInternetHerokuApp.framework.DriverTools.getDriver;
import static com.theInternetHerokuApp.pages.PagesList.getPagesList;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        new DriverTools("Chrome");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getPagesList().getHomePage().openPage();
        getPagesList().getHomePage().isPageOpen();
        getPagesList().getHomePage().isPageLoaded();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }
}
