package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Verify the banner logo is visible"
    )
    public void bannerLogoIsVisible() {
        LoginPage loginPage = this.getPages().getLoginPage();

        try {
            Assert.assertTrue(loginPage.isBannerLogoVisible(), "The banner logo isn't visible");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    // CRUCIAL for next pages!! This method logs in to the app to navigate to other pages.
    @Test(
            priority = 2,
            description = "Verify login with valid credentials"
    )
    public void loginToAppWithValidCredentials() {
        LoginPage loginPage = this.getPages().getLoginPage();
        DashboardPage dashboardPage = this.getPages().getDashboardPage();

        if (!loginPage.isPageOpen(1)) {
            dashboardPage.logout();
            loginPage.isPageOpen(1);
        }
        try {
            loginPage.isPageLoaded(3);
            loginPage.login("Admin", "admin123");
            Assert.assertTrue(dashboardPage.isPageOpen(2), "The Dashboard page isn't open");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Test(
            priority = 3,
            description = "Verify login failure with invalid credentials"
    )
    public void loginToAppWithInValidCredentials() {
        LoginPage loginPage = this.getPages().getLoginPage();
        DashboardPage dashboardPage = this.getPages().getDashboardPage();

        if (!loginPage.isPageOpen(1)) {
            dashboardPage.logout();
            loginPage.isPageOpen(1);
        }
        try {
            loginPage.isPageLoaded(3);
            loginPage.login("Invalid", "Invalid");
            Assert.assertTrue(loginPage.isInputWrong(), "Entered valid credentials");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
