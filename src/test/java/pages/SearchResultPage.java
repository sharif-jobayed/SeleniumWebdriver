package pages;

import framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    public SearchResultPage(WebDriver driver, String pageURL, By pageIdentifier) {
        super(driver, pageURL, pageIdentifier);
    }
}
