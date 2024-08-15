package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;

public class HomePageTest extends BaseTest {
    @Test(
            description = "Open AB Testing page",
            groups = {"ABTestingPage"},
            priority = 1
    )
    void testOpenABTestingPage() {
        getPages().getHomePage().openABTestingPage();
        Assert.assertTrue(getPages().getABTestingPage().isPageOpen(), "The page is not open");
        Assert.assertTrue(getPages().getABTestingPage().isPageLoaded(getDataProcessor().getTimeouts().getMedium()));
    }
}
