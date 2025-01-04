package com.opensourceDemo.orangehrmlive.tests;

import com.opensourceDemo.orangehrmlive.framework.BaseTest;
import com.opensourceDemo.orangehrmlive.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @Test
    public void loginToTheDashboard() {
        LoginPage loginPage = new LoginPage();
        loginPage.login()
                .isPageOpen(this.BASE_URL+"dashboard/index", 5)
        ;
    }
}
