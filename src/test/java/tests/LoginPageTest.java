package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import pages.SentPWResetPage;

public class LoginPageTest extends BaseTest {
    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected SentPWResetPage sentPWResetPage;

    @Test(
            priority = 1,
            description = "Login using valid credentials"
    )
    public void loginUsingValidCredentials() {
        this.loginPage = getPages().getLoginPage();
        this.dashboardPage = getPages().getDashboardPage();

        if (this.loginPage.isPageOpen(3)) {
            this.loginPage.login("Admin", "admin123");
            Assert.assertTrue(this.dashboardPage.isPageOpen(3), "The Dashboard page is not open");
        } else if (!this.loginPage.isPageOpen(3)) {
            this.dashboardPage.logout();
            if (this.loginPage.isPageOpen(5)) {
                this.loginPage.login("Admin", "admin123");
                Assert.assertTrue(this.dashboardPage.isPageOpen(3), "The Dashboard page is not open");
            } else {
                throw new RuntimeException("The login page is not open");
            }
        } else {
            throw new RuntimeException("The login page is not open");
        }
    }

    @Test(
            priority = 2,
            description = "Login using invalid username & valid password"
    )
    public void loginUsingInvalidUsernameAndValidPassword() {
        this.loginPage = getPages().getLoginPage();
        this.dashboardPage = getPages().getDashboardPage();

        if (this.loginPage.isPageOpen(3)) {
            this.loginPage.login("InvUser", "admin123");
            Assert.assertTrue(this.loginPage.isInputWrong(), "Wrong credentials error is not displayed");
        } else if (!this.loginPage.isPageOpen(3)) {
            this.dashboardPage.logout();
            if (this.loginPage.isPageOpen(5)) {
                this.loginPage.login("InvUser", "admin123");
                Assert.assertTrue(this.loginPage.isInputWrong(), "Wrong credentials error is not displayed");
            } else {
                throw new RuntimeException("The login page is not open");
            }
        } else {
            throw new RuntimeException("The login page is not open");
        }
    }

    @Test(
            priority = 3,
            description = "Login using valid username & invalid password"
    )
    public void loginUsingValidUsernameAndInvalidPassword() {
        this.loginPage = getPages().getLoginPage();
        this.dashboardPage = getPages().getDashboardPage();

        if (this.loginPage.isPageOpen(3)) {
            this.loginPage.login("Admin", "InvPass");
            Assert.assertTrue(this.loginPage.isInputWrong(), "Wrong credentials error is not displayed");
        } else if (!this.loginPage.isPageOpen(3)) {
            this.dashboardPage.logout();
            if (this.loginPage.isPageOpen(5)) {
                this.loginPage.login("Admin", "InvPass");
                Assert.assertTrue(this.loginPage.isInputWrong(), "Wrong credentials error is not displayed");
            } else {
                throw new RuntimeException("The login page is not open");
            }
        } else {
            throw new RuntimeException("The login page is not open");
        }
    }

    @Test(
            priority = 4,
            description = "Login using invalid username & invalid password"
    )
    public void loginUsingInvalidUsernameAndInvalidPassword() {
        this.loginPage = getPages().getLoginPage();
        this.dashboardPage = getPages().getDashboardPage();

        if (this.loginPage.isPageOpen(3)) {
            this.loginPage.login("InvUser", "InvPass");
            Assert.assertTrue(this.loginPage.isInputWrong(), "Wrong credentials error is not displayed");
        } else if (!this.loginPage.isPageOpen(3)) {
            this.dashboardPage.logout();
            if (this.loginPage.isPageOpen(5)) {
                this.loginPage.login("InvUser", "InvPass");
                Assert.assertTrue(this.loginPage.isInputWrong(), "Wrong credentials error is not displayed");
            } else {
                throw new RuntimeException("The login page is not open");
            }
        } else {
            throw new RuntimeException("The login page is not open");
        }
    }

    @Test(
            priority = 5,
            description = "Validate that, the application banner is visible"
    )
    public void validateThatTheApplicationBannerIsVisible() {
        this.loginPage = getPages().getLoginPage();
        Assert.assertTrue(this.loginPage.isBannerLogoVisible(), "The banner logo is not visible");
    }

    @Test(
            priority = 6,
            description = "Reset password with valid Username"
    )
    public void resetPasswordWithValidUsername() {
        this.loginPage = getPages().getLoginPage();
        this.forgotPasswordPage = getPages().getForgotPasswordPage();
        this.sentPWResetPage = getPages().getSentPWResetPage();

        if(this.loginPage.isPageOpen(3)) {
            this.loginPage
                    .clickForgotPwLink()
                    .enterUsername()
                    .clickResetPwBtn()
            ;
            Assert.assertEquals(this.sentPWResetPage.getSentLinkConfirmationText(), "Reset Password link sent successfully", "Password reset link sent confirmation text does not match");
        } else {
            throw new RuntimeException("The login page is not open");
        }
    }
}
