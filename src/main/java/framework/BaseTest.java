package framework;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private static DriverTools driverTools;
    private Pages pages;

    protected DriverTools getDriverTools() {
        return driverTools;
    }

    protected Pages getPages() {
        return new Pages(this.getDriverTools());
    }

    @Step("Set up the driver and navigate to the login page")
    @BeforeMethod
    public void setUp() {
        if (driverTools == null) {
            driverTools = new DriverTools("Chrome");
            driverTools.getDriver().manage().window().setSize(new Dimension(1440, 900));
            driverTools.getDriver().get(getPages().getLoginPage().getBaseURL());
        }
    }

    @Step("Tear down the driver")
    @AfterSuite
    public void tearDown() {
        if (driverTools != null && driverTools.getDriver() != null) {
            driverTools.getDriver().quit();
        }
    }
}
