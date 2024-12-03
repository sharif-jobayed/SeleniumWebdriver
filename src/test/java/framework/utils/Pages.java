package framework.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import pages.SearchResultPage;

public class Pages {
    private WebDriver driver;
    private String baseURL;
    private DataConverter dataConverter;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    public Pages(WebDriver driver) {
        this.driver = driver;
        this.baseURL = new DataConverter().getAppData().getBaseURL();
        this.dataConverter = new DataConverter();

        this.searchPage = new SearchPage(
                this.driver,
                this.baseURL,
                By.xpath("//span[@class='lang-list-button-text jsl10n']")
        );
        this.searchResultPage = new SearchResultPage(
                this.driver,
                this.baseURL + "wiki/" + this.makePathText(this.dataConverter.getTestData().getSearchTitle()),
                By.xpath("//span[@class='mw-page-title-main']")
        );
    }

    private String makePathText(String text) {
        return text.replace(" ", "_");
    }

    public SearchPage getSearchPage() {
        return this.searchPage;
    }

    public SearchResultPage getSearchResultPage() {
        return this.searchResultPage;
    }
}
