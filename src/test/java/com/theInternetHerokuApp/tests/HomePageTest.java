package com.theInternetHerokuApp.tests;

import com.theInternetHerokuApp.framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.pages.PagesList.getPagesList;

public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void testHomePage() {
        getPagesList().getHomePage().getLinkByText("A/B Testing").doClick();
        getPagesList().getHomePage().isPageOpen();
        getPagesList().getHomePage().isPageLoaded();
        String pHeadingText = getPagesList().getHomePage().getParagraphHeading().itsText();
        Assert.assertTrue(pHeadingText.contains("A/B Test"), "The sentence 'A/B Test' is not present in the paragraph heading");
    }
}
