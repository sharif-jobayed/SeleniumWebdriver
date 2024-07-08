package com.theInternetHerokuApp.framework;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.theInternetHerokuApp.framework.DriverTools.getDriver;
import static com.theInternetHerokuApp.pages.PagesList.getPagesList;
import static io.qameta.allure.Allure.step;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        step("Assign the browser");
        new DriverTools("Chrome");

        step("Set window size");
        getDriver().manage().window().setSize(new Dimension(1440, 900));

        step("Open home page");
        getPagesList().getHomePage().openPage();

        step("Check if the home page has been opened");
        Assert.assertTrue(getPagesList().getHomePage().isPageOpen(), getPagesList().getHomePage().getPageName() + " is not open yet");

        step("Check if the home page has been loaded");
        Assert.assertTrue(getPagesList().getHomePage().isPageLoaded(), getPagesList().getHomePage().getPageName() + " is not fully loaded yet");
    }

    @AfterMethod
    public void tearDown() {
        step("Close the browser");
        if (getDriver() != null) {
            getDriver().close();
        }
    }
}
