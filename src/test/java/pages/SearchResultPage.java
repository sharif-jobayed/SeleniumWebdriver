package pages;

import framework.elements.BaseElement;
import framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends BasePage {
    private BaseElement toolsBtn;
    private BaseElement toolsDropdownMenu;
    private BaseElement pdfDownloadLink;

    public SearchResultPage(WebDriver driver, String pageURL, By pageIdentifier) {
        super(driver, pageURL, pageIdentifier);

        this.toolsBtn = new BaseElement(By.xpath("//input[@id='vector-page-tools-dropdown-checkbox']"));
        this.toolsDropdownMenu = new BaseElement(By.xpath("//div[@id='vector-page-tools']"));
        this.pdfDownloadLink = new BaseElement(By.xpath("//span[normalize-space()='Download as PDF']"));
    }

    public SearchResultPage clickToolsBtn() {
        this.toolsBtn.clickElement();
        return this;
    }

    public BaseElement getToolsDropdownMenu() {
        return this.toolsDropdownMenu;
    }

    public SearchResultPage clickPDFDownloadLink() {
        this.pdfDownloadLink.clickElement();
        return this;
    }
}
