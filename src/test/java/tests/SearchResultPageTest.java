package tests;

import framework.tests.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultPage;

public class SearchResultPageTest extends BaseTest {
    private SearchResultPage searchResultPage = this.pages.getSearchResultPage();

    @Test(dependsOnMethods = "tests.SearchPageTest.searchAndSubmitQuery")
    public void clickOnThePDFDownloadButton() {
        searchResultPage.isPageOpen();
        searchResultPage.isPageLoaded(dataConverter.getTestData().getTimeouts().getMed());
        searchResultPage.clickToolsBtn();
        searchResultPage.getToolsDropdownMenu().waitTillElementIsVisible(this.dataConverter.getTestData().getTimeouts().getMed());
        Assert.assertTrue(searchResultPage.getToolsDropdownMenu().isElementVisible(), "The dropdown menu is not visible");
        searchResultPage.clickPDFDownloadLink();
    }
}
