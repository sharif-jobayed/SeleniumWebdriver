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
        System.out.println("Entered in the appLanguageIsEnglish...");
        DashboardPage dashboardPage = this.getPages().getDashboardPage();
        System.out.println("Dashboard page is instantiated...");

        dashboardPage.isPageOpen(1);
        System.out.println("Dashboard page is open...");

        dashboardPage.isPageLoaded(3);
        System.out.println("Dashboard page is loaded...");

        Assert.assertEquals(dashboardPage.getApplicationHeaderTitle(), "Dashboard", "The application isn't in English");
        System.out.println("Assert complete...");
    }

}
