package saucedemo.framework;

import org.openqa.selenium.By;

public abstract class Page {
    protected String pageURL;
    protected String pageName;

    public Page(String pageURL, String pageName) {
        this.pageURL = pageURL;
        this.pageName = pageName;
    }

    public abstract String getPageURL();

    public abstract String getPageName();

    public abstract Boolean isPageOpen();

    public abstract Boolean isPageLoaded(Integer milliSeconds, By locator);
}
