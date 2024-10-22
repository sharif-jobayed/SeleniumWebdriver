package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IFramePageTest extends FramesPageTest{
    @Test(
            description = "Test actions in the iFrame",
            groups = "FramesPage",
            dependsOnMethods = "clickIFramePageLink",
            priority = 1
    )
    void testIFrame() {
        getPages().getIFramePage().getIFrame();
        Assert.assertTrue(getPages().getIFramePage().getiFrameTextbox().isVisible(getDataProcessor().getTimeouts().getMinimum()), "The textbox is not available");
        getPages().getIFramePage().getiFrameTextbox().clearAndType("Hello!");
    }
}
