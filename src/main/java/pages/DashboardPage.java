package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final By PROFILE_ITM;

    public DashboardPage(WebDriver driver) {
        super(driver);

        this.PROFILE_ITM = By.xpath("//li[@class='oxd-userdropdown']");
    }

    public Boolean isDashboardPageOpen() {
        this.isPageOpen(5);
        return this.isPageLoaded(5);
    }


}
