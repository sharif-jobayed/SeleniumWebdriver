package framework;

import data.Constants;
import data.Credentials;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import utils.PageCreator;

import static data.Constants.getMinTimeOut;
import static framework.DriverTools.getDriver;

public class BaseTest {
    private final Credentials CREDENTIALS;
    private final HomePage HOME_PAGE;

    public BaseTest() {
        new DriverTools("Edge");
        this.CREDENTIALS = new Credentials();
        this.HOME_PAGE = new PageCreator("").getHomePage();
    }

    @BeforeMethod
    protected void setUp() {
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(this.HOME_PAGE.getPAGE_URL());
        Assert.assertTrue(this.HOME_PAGE.isPageOpen(), "The "+this.HOME_PAGE.getPAGE_NAME()+" is not open");
        Assert.assertTrue(this.HOME_PAGE.isPageLoaded(getMinTimeOut()), "The "+this.HOME_PAGE.getPAGE_NAME()+ " is not loaded");
    }

    @AfterMethod
    protected void tearDown() {
        getDriver().close();
    }
}
