package framework;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected DriverTools driverTools;
    protected String baseURL;
    protected PageBuilder pageBuilder;

    public BaseTest() {
        this.baseURL = "https://opensource-demo.orangehrmlive.com/web/index.php/";
    }

    protected DriverTools getDriverTools() {
        return this.driverTools;
    }

    protected PageBuilder getPageBuilder() {
        return new PageBuilder(this.getDriverTools());
    }

    @BeforeMethod()
    public void setUp() {
        this.driverTools = new DriverTools("firefox");
        this.driverTools.getDriver().manage().window().setSize(new Dimension(1440, 900));
        this.driverTools.getDriver().get(this.baseURL);
        this.getPageBuilder().getPage("login").isPageOpen(5);
        this.getPageBuilder().getPage("login").isPageLoaded(5);
    }

    @AfterMethod()
    public void tearDown() {
        if (this.driverTools.getDriver() != null) {
            this.driverTools.getDriver().quit();
        }
    }
}
