package com.theInternetHerokuApp.tests;

import com.theInternetHerokuApp.framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.theInternetHerokuApp.data.Constants.getMinSec;
import static com.theInternetHerokuApp.pages.PagesList.getPagesList;
import static io.qameta.allure.Allure.step;

public class ABTestingPageTest extends BaseTest {
    @Test(testName = "Test A/B Testing page", priority = 1)
    void testABTestingPage() {
        step("Click on the ab testing link");
        getPagesList().getHomePage().getLinkByText("A/B Testing").doClick();

        step("Check if the ab testing page has been opened");
        Assert.assertTrue(getPagesList().getABTestingPage().isPageOpen(), getPagesList().getABTestingPage().getPageName()+ " is not open yet");

        step("Check if the ab testing page has been loaded");
        Assert.assertTrue(getPagesList().getABTestingPage().isPageLoaded(), getPagesList().getABTestingPage().getPageName()+" is not fully loaded yet");

        step("Get the paragraph heading's text");
        String pHeadingText = getPagesList().getABTestingPage().getParagraphHeading().itsText();

        step("Check if the particular text exists in the paragraph heading ");
        Assert.assertTrue(pHeadingText.contains("A/B Test"), "The sentence 'A/B Test' is not present in the paragraph heading");
    }
}
