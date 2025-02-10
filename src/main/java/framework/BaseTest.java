package framework;

import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private DriverTools driverTools;
    private Pages pages;

    public BaseTest() {}

    protected DriverTools getDriverTools() {
        return this.driverTools;
    }

    protected Pages getPages() {
        return new Pages(this.getDriverTools());
    }

    @BeforeMethod()
    public void setUp() {
        this.driverTools = new DriverTools("firefox");
        this.getDriverTools().getDriver().manage().window().setSize(new Dimension(1440, 900));
        this.getDriverTools().getDriver().get(this.getPages().getLoginPage().getBaseURL());
        this.getPages().getLoginPage().isPageOpen(5);
        this.getPages().getLoginPage().isPageLoaded(5);
    }

    @AfterMethod()
    public void tearDown() {
        if (this.driverTools.getDriver() != null) {
            this.driverTools.getDriver().quit();
        }
    }
}
