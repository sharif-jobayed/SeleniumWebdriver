package wikipedia_0001.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Page {
    protected BasePage(WebDriver driver, String pageURL, String pageName) {
        super(driver, pageURL, pageName);
    }

    @Override
    protected String getPageURL() {
        return this.pageURL;
    }

    @Override
    protected String getPageName() {
        return this.pageName;
    }

    @Override
    protected String getCurrentURL() {
        return this.driver.getCurrentUrl();
    }

    @Override
    protected Boolean isPageOpen(Integer timeout) {
        try {
            return new BaseTest().getDriverTools().getXWait(timeout).until(ExpectedConditions.urlToBe(this.pageURL));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected Boolean isPageLoaded(Integer timeout) {
        try {
            new BaseTest().getDriverTools().getXWait(timeout).until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected Boolean isAlertOpen(Integer timeout) {
        try {
            new BaseTest().getDriverTools().getXWait(timeout).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
