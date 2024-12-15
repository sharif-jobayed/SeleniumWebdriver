package wikipedia_0001.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    protected abstract String getPageTitle();

    protected abstract Boolean isPageOpen(Integer timeout);

    protected abstract Boolean isPageLoaded(Integer timeout);

    protected abstract Boolean isAlertOpen(Integer timeout);

    protected abstract WebElement getElement(By locator);

    protected abstract List<WebElement> getElements(By locator);

    protected abstract String getElementText(By locator);

    protected abstract Boolean isElementEnabled(By locator, Integer timeout);

    protected abstract Boolean isElementChecked(By locator, Integer timeout);

    protected abstract Page goToPage();

    protected abstract Page waitTillElementVisibility(By locator, Integer timeout);

    protected abstract Page clickElement(By locator);

    protected abstract Page doubleClickElement(By locator);

    protected abstract Page typeInElement(By locator, String text);

    protected abstract Page hoverOnElement(By locator);

    protected abstract Page scrollToElement(By locator);
}
