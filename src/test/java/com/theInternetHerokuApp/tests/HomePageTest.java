package com.theInternetHerokuApp.tests;

import com.theInternetHerokuApp.framework.BaseTest;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.pages.PagesList.getPagesList;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void testHomePage() {
        getPagesList().getHomePage().getLinkByText("A/B Testing").doClick();

    }
}
