package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class DashboardPageTest extends BaseTest {

    @Test(priority = 1, description = "Validate that, the Dashboard page is open & loaded", dependsOnMethods = "tests.LoginPageTest.loginWithValidCredentials")
    public void isDashboardPageOpen() {
        DashboardPage dashboardPage = new DashboardPage(this.driver);

        Assert.assertTrue(dashboardPage.isDashboardPageOpen(), "The Dashboard page isn't open");
    }

}
