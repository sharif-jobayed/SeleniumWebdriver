package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;

public class DashboardPageTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Verify that the application language is English",
            dependsOnMethods = {"tests.LoginPageTest.loginToAppWithValidCredentials"}
    )
    public void appLanguageIsEnglish() {
        DashboardPage dashboardPage = this.getPages().getDashboardPage();

        dashboardPage.isPageOpen(1);
        dashboardPage.isPageLoaded(3);

        Assert.assertEquals(dashboardPage.getApplicationHeaderTitle(), "Dashboard", "The application isn't in English");
    }

}
