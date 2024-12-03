package framework.tests;

import framework.utils.DataConverter;
import framework.utils.Pages;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Locale;

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
    protected void setUP() {
        this.driver.manage().window().setSize(new Dimension(1440, 900));
        this.driver.get(this.dataConverter.getAppData().getBaseURL());
    }

    @AfterMethod
    protected void tearDown() {
        this.driver.quit();
    }
}
