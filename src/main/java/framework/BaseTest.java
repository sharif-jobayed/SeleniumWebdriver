package framework;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

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

    @AfterMethod(enabled = false)
    public void takeScreenshotOnFailure(ITestResult result) {
        File screenshotFile = ((TakesScreenshot) this.getDriverTools().getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            String screenshotName = result.getName() + "-" + System.currentTimeMillis() + ".png";
            File destination = new File("./src/test/resources/screenShots/" + screenshotName);
            FileUtils.copyFile(screenshotFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            this.getDriverTools().saveScreenshot();
        }
    }
}
