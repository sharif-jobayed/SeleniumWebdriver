package framework.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;

public class Pages {
    private WebDriver driver;
    private String baseURL;

    public Pages(WebDriver driver) {
        this.driver = driver;
        this.baseURL = new DataConverter().getAppData().getBaseURL();
    }

    @Step("Call the Search Page")
    public SearchPage getSearchPage() {
        return new SearchPage(
                this.driver,
                this.baseURL,
                By.xpath("//span[@class='lang-list-button-text jsl10n']")
        );
    }
}
