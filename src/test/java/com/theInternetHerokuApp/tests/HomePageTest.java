package com.theInternetHerokuApp.tests;

import com.theInternetHerokuApp.framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.pages.PagesList.getPagesList;
import static io.qameta.allure.Allure.step;

public class HomePageTest extends BaseTest {

    @Test(testName = "Test A/B Testing link", priority = 1)
    public void testABTestingLink() {
        step("Click on the ab testing link");
        getPagesList().getHomePage().getLinkByText("A/B Testing").doClick();

        step("Check if the ab testing page has been opened");
        Assert.assertTrue(getPagesList().getABTestingPage().isPageOpen(), getPagesList().getABTestingPage().getPageName() + " is not open yet");

        step("Check if the ab testing page has been loaded");
        Assert.assertTrue(getPagesList().getABTestingPage().isPageLoaded(), getPagesList().getABTestingPage().getPageName() + " is not fully loaded yet");
    }
}
