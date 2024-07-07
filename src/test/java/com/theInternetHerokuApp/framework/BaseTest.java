package com.theInternetHerokuApp.framework;

import com.theInternetHerokuApp.pages.PagesList;
import org.openqa.selenium.Dimension;
import org.testng.annotations.*;

import static com.theInternetHerokuApp.data.Constants.getBaseURL;
import static com.theInternetHerokuApp.framework.DriverTools.getDriver;
import static com.theInternetHerokuApp.pages.PagesList.getPagesList;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        new DriverTools("Chrome");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(getBaseURL());
        getPagesList().getHomePage().isPageOpen();
        getPagesList().getHomePage().isPageLoaded();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().close();
    }
}
