package pages;

import framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver, String pageURL, By pageIdentifier) {
        super(driver, pageURL, pageIdentifier);
    }
}
