package pages;

import framework.elements.BaseElement;
import framework.pages.BasePage;
import framework.utils.DataConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {
    private BaseElement searchField;
    private BaseElement searchListDropdown;
    private BaseElement firstResultItem;

    public SearchPage(WebDriver driver, String pageURL, By pageIdentifier) {
        super(driver, pageURL, pageIdentifier);

        this.searchField = new BaseElement(
                this.driver,
                By.xpath("//input[@id='searchInput']")
        );
        this.searchListDropdown = new BaseElement(
                this.driver,
                By.xpath("//div[contains(@class,'suggestions-dropdown')]")
        );
        this.firstResultItem = new BaseElement(
                this.driver,
                By.xpath("//a[contains(@class,'suggestion-link')][1]")
        );
    }

    public void inputSearchContext() {
        this.searchField.clearAndTypeInElement(new DataConverter().getTestData().getSearchTitle());
    }

    public BaseElement getSearchListDropdown() {
        return this.searchListDropdown;
    }

    public void clickOnTheFirstResult() {
        this.firstResultItem.clickElement();
    }
}
