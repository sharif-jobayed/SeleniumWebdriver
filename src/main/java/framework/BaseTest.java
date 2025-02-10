package framework;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

public class BaseTest {
    protected DriverTools driverTools;
    protected String baseURL;

    public BaseTest() {
        this.baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/";
    }

    protected DriverTools getDriverTools() {
        return this.driverTools;
    }

    @BeforeMethod()
    public void setUp() {
        this.driverTools = new DriverTools("firefox");
        this.driverTools.getDriver().manage().window().setSize(new Dimension(1440, 900));
        this.driverTools.getDriver().get(this.baseURL);
        new LoginPage(this.driverTools).isPageOpen(5);
        new LoginPage(this.driverTools).isPageLoaded(5);
    }

    @AfterMethod()
    public void tearDown() {
        if (this.driverTools.getDriver() != null) {
            this.driverTools.getDriver().quit();
        }
    }
}
