package wikipedia_0001.framework;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;
    protected String pageURL;
    protected String pageName;

    protected Page(WebDriver driver, String pageURL, String pageName) {
        this.driver = driver;
        this.pageURL = pageURL;
        this.pageName = pageName;
    }

    protected abstract String getPageURL();
    protected abstract String getPageName();
    protected abstract String getCurrentURL();
    protected abstract Boolean isPageOpen(Integer timeout);
    protected abstract Boolean isPageLoaded(Integer timeout);
    protected abstract Boolean isAlertOpen(Integer timeout);
}
