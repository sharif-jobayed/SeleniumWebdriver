package framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import pages.SearchResultPage;

import static framework.tests.BaseTest.getDriver;

public class Pages {
    private String baseURL;
    private DataConverter dataConverter;
    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    public Pages(WebDriver driver) {
        this.baseURL = new DataConverter().getAppData().getBaseURL();
        this.dataConverter = new DataConverter();

        this.searchPage = new SearchPage(
                getDriver(),
                this.baseURL,
                By.xpath("//span[@class='lang-list-button-text jsl10n']")
        );
        this.searchResultPage = new SearchResultPage(
                getDriver(),
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
