package framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page {
    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    protected abstract Boolean isPageOpen(Integer timeout);

    protected abstract Boolean isPageLoaded(Integer timeout);

    protected abstract Boolean isAlertOpen(Integer timeout);

    protected abstract Boolean doesItExist(By locator, Integer timeout);

    protected abstract Boolean isItVisible(By locator, Integer timeout);

    protected abstract Boolean isItActive(By locator, Integer timeout);

    protected abstract String getPageURL(Integer timeout);

    protected abstract String getPageTitle(Integer timeout);

    protected abstract String itsText(By locator);

    protected abstract Page openInNewWindow(String url);

    protected abstract Page closeCurrentWindow();

    protected abstract Page goToDefaultContent();

    protected abstract Page doClick(By locator);

    protected abstract Page clearAndType(Integer timeout, String text, By locator);

    protected abstract Page waitTillExist(Integer timeout, By locator);

    protected abstract Page scrollTo(By locator);

    protected abstract Alert typeInAlert(String text);

    protected abstract Alert acceptIt();

    protected abstract Alert denyIt();

    protected abstract <P extends BasePage> P getPageInstance(Class<P> pClass);
}
