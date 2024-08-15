package framework;

import framework.utils.DataProcessor;
import framework.utils.Pages;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.*;

import static framework.DriverTools.*;

public class BaseTest {
    public DataProcessor getDataProcessor() {
        return new DataProcessor();
    }

    public Pages getPages() {
        return new Pages();
    }

    @BeforeClass
    protected void setUp() {
        new DriverTools("Edge");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(getPages().getHomePage().getPAGE_URL());
        Assert.assertTrue(getPages().getHomePage().isPageOpen(), "The home page is not open");
        Assert.assertTrue(getPages().getHomePage().isPageLoaded(getDataProcessor().getTimeouts().getMedium()), "The page is not loaded");
    }

    @AfterClass
    protected void tearDown() {
        getDriver().close();
    }
}
