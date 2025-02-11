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
        Assert.assertTrue(loginPage.isBannerLogoVisible(), "The banner logo isn't visible");
    }

    @Test(
            priority = 2,
            description = "Verify login with valid credentials"
    )
    public void loginToAppWithValidCredentials() {
        LoginPage loginPage = this.getPages().getLoginPage();
        loginPage
                .login("Admin", "admin123")
                .isPageOpen(5);

        DashboardPage dashboardPage = this.getPages().getDashboardPage();
        Assert.assertTrue(dashboardPage.isPageOpen(3), "The Dashboard page isn't open");


    }

    @Test(
            priority = 3,
            description = "Verify login failure with invalid credentials"
    )
    public void loginToAppWithInValidCredentials() {
        LoginPage loginPage = this.getPages().getLoginPage();
        loginPage.login("Invalid", "Invalid");
        Assert.assertTrue(loginPage.isInputWrong(), "Invalid credentials entered");
    }

}
