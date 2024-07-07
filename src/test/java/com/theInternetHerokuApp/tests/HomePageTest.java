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
        getPagesList().getABTestingPage().isPageOpen();
        step("Check if the ab testing page has been loaded");
        getPagesList().getABTestingPage().isPageLoaded();
    }
}
