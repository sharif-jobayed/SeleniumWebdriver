package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.PageCreator;

public class HomePageTest extends BaseTest {
    private final HomePage HOME_PAGE;

    public HomePageTest() {
        this.HOME_PAGE = new PageCreator("").getHomePage();
    }

    @Test(priority = 1, description = "")
    void homePageTest() {
        Assert.assertEquals(this.HOME_PAGE.getPAGE_URL(), "https://status.epicgames.com/", "Home page URL is not correct");
        this.HOME_PAGE.openGameBox("Fortnite");
        this.HOME_PAGE.isGameServiceOperational(1);
    }
}
