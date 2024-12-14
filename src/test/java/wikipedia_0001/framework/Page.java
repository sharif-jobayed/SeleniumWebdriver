package wikipedia_0001.framework;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    protected WebDriver driver;
    protected String pageURL;
    protected String pageName;

    public Page(WebDriver driver, String pageURL, String pageName) {
        this.driver = driver;
        this.pageURL= pageURL;
        this.pageName = pageName;
    }
}
