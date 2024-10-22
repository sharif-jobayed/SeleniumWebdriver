package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @Test(
            description = "Open AB Testing page",
            groups = {"ABTestingPage"},
            priority = 1,
            enabled = false
    )
    void testOpenABTestingPage() {
        getPages().getHomePage().openABTestingPage();
        Assert.assertTrue(getPages().getABTestingPage().isPageOpen(), "The page is not open");
        Assert.assertTrue(getPages().getABTestingPage().isPageLoaded(getDataProcessor().getTimeouts().getMedium()));
    }

    @Test(
            description = "Open Dropdown page",
            groups = "DropdownPage",
            priority = 2,
            enabled = false
    )
    void testOpenDropdownPage() {
        getPages().getHomePage().openDropdownPage();
        Assert.assertTrue(getPages().getDropdownPage().isPageOpen(), "The page is not open");
        Assert.assertTrue(getPages().getDropdownPage().isPageLoaded(getDataProcessor().getTimeouts().getMedium()));
    }

    @Test(
         description = "Open JS Alert page",
         groups = "JSAlertPage",
         priority = 3,
         enabled = true
    )
    void testOpenJSAlertPage() {
        getPages().getHomePage().openJSAlertsPage();
        Assert.assertTrue(getPages().getJSAlertPage().isPageOpen(), "The page is not open");
        Assert.assertTrue(getPages().getJSAlertPage().isPageLoaded(getDataProcessor().getTimeouts().getMedium()));
    }
}
