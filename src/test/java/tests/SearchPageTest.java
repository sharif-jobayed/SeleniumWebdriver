package tests;

import framework.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SearchResultPage;

public class SearchPageTest extends BaseTest {
    protected SearchPage searchPage = this.pages.getSearchPage();
    protected SearchResultPage searchResultPage = this.pages.getSearchResultPage();

    @Test()
    protected void searchAndSubmitQuery() {
        searchPage.inputSearchContext();
        searchPage.getSearchListDropdown().waitTillElementIsVisible(this.dataConverter.getTestData().getTimeouts().getMed());
        Assert.assertTrue(searchPage.getSearchListDropdown().isElementVisible(), "The search list is not visible");
        searchPage.clickOnTheFirstResult();
    }
}
