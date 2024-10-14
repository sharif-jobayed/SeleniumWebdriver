package saucedemo.framework;

import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import saucedemo.framework.utils.DataConverter;
import saucedemo.framework.utils.DriverTools;
import saucedemo.framework.utils.PageBuilder;
import saucedemo.pages.LoginPage;

import static saucedemo.framework.utils.DriverTools.getDriver;

public class BaseTest {
    private DataConverter dataConverter = new DataConverter();

    @BeforeClass
    public void setUp() {
        new DriverTools("Firefox");
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(dataConverter.getAppData().getBaseURL());

        PageBuilder<LoginPage> loginPagePageBuilder = new PageBuilder<>();
        LoginPage loginPage = loginPagePageBuilder.getPage("login");
        Assert.assertTrue(loginPage.isPageOpen(), "The " + loginPage.pageName + " isn't yet open.");

        Assert.assertTrue(loginPage.isLoginPageLoaded(), "The " + loginPage.pageName + " isn't yet loaded");
    }

    @AfterClass
    public void tearDown() {
        getDriver().quit();
    }
}
