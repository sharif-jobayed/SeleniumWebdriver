package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    @Test(priority = 1)
    public void loginWithValidCredentials() {
        LoginPage loginPage = new LoginPage(this.driver);
        DashboardPage dashboardPage = new DashboardPage(this.driver);

        loginPage
                .inputUsername("Admin")
                .inputPassword("admin123")
                .clickLoginBtn()
        ;

        Assert.assertTrue(dashboardPage.isPageOpen(5), "The "+DashboardPage.class.getName()+" isn't open");
    }
    @Test(priority = 2)
    public void loginWithInvalidUsername() {
        LoginPage loginPage = new LoginPage(this.driver);

        loginPage
                .inputUsername("InvUser")
                .inputPassword("admin123")
                .clickLoginBtn()
        ;

        Assert.assertTrue(loginPage.isInputWrong(), "The credential isn't correct");
    }

    @Test(priority = 3)
    public void loginWithInvalidPassword() {
        LoginPage loginPage = new LoginPage(this.driver);

        loginPage
                .inputUsername("Admin")
                .inputPassword("InvPass")
                .clickLoginBtn()
        ;

        Assert.assertTrue(loginPage.isInputWrong(), "The credential isn't correct");
    }

    @Test(priority = 4)
    public void loginWithInvalidUserNameAndPassword() {
        LoginPage loginPage = new LoginPage(this.driver);

        loginPage
                .inputUsername("InvUser")
                .inputPassword("InvPass")
                .clickLoginBtn()
        ;

        Assert.assertTrue(loginPage.isInputWrong(), "The credential isn't correct");
    }

    @Test(priority = 5)
    public void isBannerDisplayed() {
        LoginPage loginPage = new LoginPage(this.driver);

        Assert.assertTrue(loginPage.isBannerVisible(), "The banner isn't displayed");
    }
}
