package com.theInternetHerokuApp.framework;

import com.theInternetHerokuApp.pages.HomePage;
import com.theInternetHerokuApp.pages.PagesList;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.data.Constants.getBaseURL;
import static com.theInternetHerokuApp.framework.DriverTools.getDriver;

public class BaseTest {
    private PagesList pagesList;

    public BaseTest() {
        this.pagesList = new PagesList();this.pagesList.getHomePage();
    }

    @BeforeTest
    void setUp() {
        new DriverTools("Chrome");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        this.pagesList.getHomePage().openPage();
        this.pagesList.getHomePage().isPageOpen();
        this.pagesList.getHomePage().isPageLoaded();
    }

    @AfterTest
    void tearDown() {
        getDriver().close();
    }
}
