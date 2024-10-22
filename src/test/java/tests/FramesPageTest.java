package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesPageTest extends HomePageTest{
    @Test(
            description = "Click iFrame page link & open the page",
            groups = "FramesPage",
            dependsOnMethods = "testOpenFramsPage",
            priority = 1
    )
    void clickIFramePageLink() {
        getPages().getFramesPage().clickIFrameLink();
        Assert.assertTrue(getPages().getIFramePage().isPageOpen(), "The page is not open");
        Assert.assertTrue(getPages().getIFramePage().isPageLoaded(getDataProcessor().getTimeouts().getMedium()));
    }
}
