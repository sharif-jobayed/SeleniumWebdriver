package com.theInternetHerokuApp.tests;

import com.theInternetHerokuApp.framework.BaseTest;
import com.theInternetHerokuApp.pages.PagesList;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    private PagesList pagesList;

    public HomePageTest () {
        this.pagesList = new PagesList();
    }

    @Test(priority = 1)
    public void testHomePage () {
        pagesList.getHomePage().getLinkByText("A/B Testing").doClick();
    }
}
