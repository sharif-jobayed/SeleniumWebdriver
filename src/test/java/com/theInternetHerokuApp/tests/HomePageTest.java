package com.theInternetHerokuApp.tests;

import com.theInternetHerokuApp.framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.pages.PagesList.getPagesList;

public class HomePageTest extends BaseTest {

    @Test(testName = "Test A/B Testing link", priority = 1)
    public void testABTestingLink() {
        getPagesList().getHomePage().getLinkByText("A/B Testing").doClick();
        getPagesList().getABTestingPage().isPageOpen();
        getPagesList().getABTestingPage().isPageLoaded();
    }
}
