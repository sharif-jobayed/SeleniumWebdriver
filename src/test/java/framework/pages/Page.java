package framework.pages;

import framework.elements.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;
    protected String pageURL;
    protected BaseElement pageIdentifier;

    public Page(WebDriver driver, String pageURL, By pageIdentifier) {
        this.driver = driver;
        this.pageURL = pageURL;
        this.pageIdentifier = new BaseElement(this.driver, pageIdentifier);
    }

    protected abstract String getPageURL();

    protected abstract String getCurrentPageURL();

    protected abstract String getPageTitle();

    protected abstract Boolean isPageOpen();

    protected abstract Boolean isPageLoaded(Integer timeout);

    protected abstract Boolean isAlertOpen(Integer timeout);

    protected abstract Page acceptAlert();

    protected abstract Page denyAlert();

    protected abstract Page typeInAlert(String text);

    protected abstract Page toDefaultContent();

    protected abstract Page openInNewTab();

    protected abstract Page closeCurrentTab();

    protected abstract Page switchToTab(Integer tabIndex);
}
