package framework;

import org.openqa.selenium.support.ui.ExpectedCondition;

import static framework.DriverTools.*;

public class BasePage {
    private final String PAGE_URL;
    private final String PAGE_NAME;

    public BasePage(String pageURL, String pageName) {
        this.PAGE_URL = pageURL;
        this.PAGE_NAME = pageName;
    }

    public String getPAGE_URL() {
        return this.PAGE_URL;
    }

    public String getPAGE_NAME() {
        return this.PAGE_NAME;
    }

    public Boolean isPageOpen() {
        return getDriver().getCurrentUrl().equals(this.getPAGE_URL());
    }

    public Boolean isPageLoaded(int timeOut) {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> getJS().executeScript("return document.readyState").equals("complete");
        return getXWait(timeOut).until(pageLoadCondition);
    }
}
