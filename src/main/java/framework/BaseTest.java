package framework;

import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.*;

public class BaseTest {

    private static DriverTools driverTools;

    protected DriverTools getDriverTools() {
        return driverTools;
    }

    protected Pages getPages() {
        return new Pages(this.getDriverTools());
    }

    @Step("Set up the driver and navigate to the login page")
    @BeforeSuite
    public void setUp() {
        if (driverTools == null) {
            driverTools = new DriverTools("Chrome");
        }
        driverTools.getDriver().manage().window().setSize(new Dimension(1440, 900));
        driverTools.getDriver().get(getPages().getLoginPage().getBaseURL());
        Assert.assertTrue(this.getPages().getLoginPage().isPageOpen(5), "The login page is not open");
    }

//    @AfterMethod(enabled = false)
//    public void takeScreenshotOnFailure(ITestResult result) {
//        File screenshotFile = ((TakesScreenshot) this.getDriverTools().getDriver()).getScreenshotAs(OutputType.FILE);
//
//        try {
//            String screenshotName = result.getName() + "-" + System.currentTimeMillis() + ".png";
//            File fileDestination = new File("./src/test/resources/screenShots/" + screenshotName);
//            FileUtils.copyFile(screenshotFile, fileDestination);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (result.getStatus() == ITestResult.FAILURE) {
//            this.getDriverTools().saveScreenshot();
//        }
//    }

    @Step("Tear down the driver")
    @AfterSuite
    public void tearDown() {
        if (driverTools != null && driverTools.getDriver() != null) {
            driverTools.getDriver().quit();
        }
    }
}
