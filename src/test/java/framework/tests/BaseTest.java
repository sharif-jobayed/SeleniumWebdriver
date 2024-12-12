package framework.tests;

import framework.utils.DataConverter;
import framework.utils.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Locale;

public class BaseTest {
    private static WebDriver driver;
    protected DataConverter dataConverter;
    protected Pages pages;

    protected BaseTest() {
        this.dataConverter = new DataConverter();
        this.pages = new Pages(getDriver());
    }

    private static void setDriver(String driverTitle) {
        String dt = driverTitle.toLowerCase(Locale.ROOT);
        if (dt.contains("firefox")) {
            driver = new FirefoxDriver();
        } else if (dt.contains("edge")) {
            driver = new EdgeDriver();
        } else if (dt.contains("chrome")) {
            driver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Invalid driver request");
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = new DataConverter().getAppData().getBrowsers().getEdge(); // Default browser
            setDriver(browser);
        }
        return driver;
    }

    @BeforeSuite
    @Step("Initiate the session, resize the browser & go to the Base URL")
    protected void setUp() {
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(dataConverter.getAppData().getBaseURL());
        Assert.assertTrue(this.pages.getSearchPage().isPageOpen(), "The page is not open");
        Assert.assertTrue(this.pages.getSearchPage().isPageLoaded(dataConverter.getTestData().getTimeouts().getMed()), "The page is not loaded");
    }

    @AfterSuite
    @Step("Quit the test session")
    protected void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
