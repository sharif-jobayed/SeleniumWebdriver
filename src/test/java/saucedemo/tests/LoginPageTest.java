package saucedemo.tests;

import org.testng.annotations.Test;
import saucedemo.framework.BaseTest;
import saucedemo.framework.utils.PageBuilder;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;

public class LoginPageTest extends BaseTest {
    LoginPage loginPage = new PageBuilder().getPage("Login");
    InventoryPage inventoryPage = new PageBuilder().getPage("Inventory");

    @Test
    void testLoginFeature() {
        loginPage
                .enterUserName()
                .enterPassword()
                .clickLogin()
        ;
    }
}
