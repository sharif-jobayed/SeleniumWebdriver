package tests;

import framework.BaseTest;
import framework.utils.Pages;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {
    private Pages pages = new Pages();

    @Test(description = "", priority = 1)
    void testABTestingPage() {
        pages.getHomePage().openABTestingPage();
        Assert.assertTrue(pages.getABTestingPage().isPageOpen(), "The page is not open");
        Assert.assertTrue(pages.getABTestingPage().isPageLoaded(dataProcessor.getTimeouts().getMedium()));
    }
}
