package framework;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected String baseURL;
    protected WebDriver driver;

    protected BaseTest() {
        this.baseURL = "https://opensource-demo.orangehrmlive.com/";
    }

    @BeforeMethod(description = "Open the browser & hit the target URL")
    public void setUp() {
        this.driver = new EdgeDriver();
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get(this.baseURL);
    }

    @AfterMethod(description = "End the test session")
    public void tearDown() {
        if (driver != null) {
            try {
                driver.close();
                driver.quit();
            } catch (Exception e) {
                System.err.println("Error during driver cleanup: " + e.getMessage());
            }
        }
    }
}
