package framework.tests;

import framework.utils.DataConverter;
import framework.utils.Pages;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class BaseTest {
    protected WebDriver driver;
    protected DataConverter dataConverter;
    protected Pages pages;

    protected BaseTest() {
        this.dataConverter = new DataConverter();
        this.setDriver(this.dataConverter.getAppData().getBrowsers().getEdge());
        this.pages = new Pages(this.driver);
    }

    private void setDriver(String driverTitle) {
        String dt = driverTitle.toLowerCase(Locale.ROOT);
        if (dt.contains(this.dataConverter.getAppData().getBrowsers().getFirefox())) {
            this.driver = new FirefoxDriver();
        } else if (dt.contains(this.dataConverter.getAppData().getBrowsers().getEdge())) {
            this.driver = new EdgeDriver();
        } else if (dt.contains(this.dataConverter.getAppData().getBrowsers().getChrome())) {
            this.driver = new ChromeDriver();
        } else {
            throw new InvalidArgumentException("Invalid driver request");
        }

    }

    @BeforeMethod
    @Step("Initiate the session, resize the browser & go to 'https://www.wikipedia.org/'")
    protected void setUP() {
        this.driver.manage().window().setSize(new Dimension(1440, 900));
        this.driver.get(this.dataConverter.getAppData().getBaseURL());
        Assert.assertTrue(this.pages.getSearchPage().isPageOpen(), "The page is not open");
        Assert.assertTrue(this.pages.getSearchPage().isPageLoaded(this.dataConverter.getTestData().getTimeouts().getMed()), "The page is not loaded");
    }

    @AfterMethod
    @Step("Quit the test session")
    protected void tearDown() {
        this.driver.quit();
    }
}
