package com.theInternetHerokuApp.tests;

import com.theInternetHerokuApp.framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.pages.PagesList.getPagesList;

public class ABTestingPageTest extends BaseTest {
    @Test(testName = "Test A/B Testing page", priority = 1)
    void testABTestingPage() {
        getPagesList().getHomePage().getLinkByText("A/B Testing").doClick();
        getPagesList().getABTestingPage().isPageOpen();
        getPagesList().getABTestingPage().isPageLoaded();
        String pHeadingText = getPagesList().getABTestingPage().getParagraphHeading().itsText();
        Assert.assertTrue(pHeadingText.contains("A/B Test"), "The sentence 'A/B Test' is not present in the paragraph heading");
    }
}
