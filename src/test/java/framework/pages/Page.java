package framework.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    private String pageURL;

    public Page(String pageURL) {
        this.pageURL = pageURL;
    }

    protected abstract String getPageURL();

    protected abstract String getCurrentPageURL();

    protected abstract String getPageTitle();

    protected abstract Boolean isPageOpen();

    protected abstract Boolean isPageLoaded(Integer timeout);

    protected abstract Boolean isAlertOpen();

    protected abstract Page acceptAlert();

    protected abstract Page denyAlert();

    protected abstract Page typeInAlert(String text);

    protected abstract Page openInNewTab();

    protected abstract Page closeCurrentTab();

    protected abstract Page switchToTab(Integer tabIndex);
}
