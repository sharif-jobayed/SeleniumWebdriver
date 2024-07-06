package com.theInternetHerokuApp.framework;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.theInternetHerokuApp.data.Constants.getBaseURL;
import static com.theInternetHerokuApp.framework.DriverTools.getDriver;

public class BaseTest {
    @BeforeTest
    void setUp() {
        new DriverTools("Chrome");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(getBaseURL());
    }

    @AfterTest
    void tearDown() {
        getDriver().close();
    }
}
