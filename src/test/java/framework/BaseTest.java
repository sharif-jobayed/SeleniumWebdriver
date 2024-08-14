package framework;

import framework.utils.DataProcessor;
import framework.utils.Pages;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.*;

import static framework.DriverTools.*;

public class BaseTest {
    protected DataProcessor dataProcessor = new DataProcessor();
    protected Pages pages = new Pages();

    @BeforeMethod
    protected void setUp() {
        new DriverTools("Edge");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(pages.getHomePage().getPAGE_URL());
        Assert.assertTrue(pages.getHomePage().isPageOpen(), "The home page is not open");
        Assert.assertTrue(pages.getHomePage().isPageLoaded(dataProcessor.getTimeouts().getMedium()), "The page is not loaded");
    }

    @AfterMethod
    protected void tearDown() {
        getDriver().close();
    }
}
