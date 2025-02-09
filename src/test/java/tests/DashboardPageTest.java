package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ViewLeaveListPage;

public class DashboardPageTest extends BaseTest {

    @Test(priority = 1, description = "Validate that, the Dashboard page is open & loaded", dependsOnMethods = "tests.LoginPageTest.loginWithValidCredentials")
    public void isDashboardPageOpen() {
        DashboardPage dashboardPage = new DashboardPage(this.driver);

        Assert.assertTrue(dashboardPage.isDashboardPageOpen(), "The Dashboard page isn't open");
    }

    @Test(priority = 2, description = "Validate that, the application language is English", dependsOnMethods = "tests.LoginPageTest.loginWithValidCredentials")
    public void isLanguageEnglish() {
        DashboardPage dashboardPage = new DashboardPage(this.driver);

        Assert.assertEquals(dashboardPage.getPageTitleHeaderText(), "Dashboard",
                "The application language isn't English ");
    }

    @Test(priority = 3, description = "Validate that, the view leave list page is open & loaded", dependsOnMethods = "tests.LoginPageTest.loginWithValidCredentials")
    public void clickViewLeaveList() {
        DashboardPage dashboardPage = new DashboardPage(this.driver);
        dashboardPage.clickViewLeaveList();

        ViewLeaveListPage viewLeaveListPage = new ViewLeaveListPage(this.driver);
        viewLeaveListPage.isPageOpen(3);
        viewLeaveListPage.isPageLoaded(3);
    }

}
