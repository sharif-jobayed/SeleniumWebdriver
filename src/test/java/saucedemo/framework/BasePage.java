package saucedemo.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.InvocationTargetException;

import static saucedemo.framework.utils.DriverTools.getDriver;
import static saucedemo.framework.utils.DriverTools.getXWait;

public class BasePage extends Page {

    public BasePage(String pageURL, String pageName) {
        super(pageURL, pageName);
    }

    @Override
    public String getPageURL() {
        return this.pageURL;
    }

    @Override
    public String getPageName() {
        return this.pageName;
    }

    @Override
    public Boolean isPageOpen() {
        if (getPageURL().equals(getDriver().getCurrentUrl())) {
            System.out.println("The " + this.pageName + " is open.");
            return true;
        } else {
            System.out.println("The " + this.pageName + " is not yet open.");
            return false;
        }
    }

    @Override
    public Boolean isPageLoaded(Integer milliSeconds, By locator) {
        WebElement element = getXWait(milliSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
        if (element.isDisplayed()) {
            System.out.println("The " + this.pageName + " is now loaded");
            return true;
        } else {
            System.out.println("The " + this.pageName + " is not yet loaded.");
            return false;
        }
    }
}
