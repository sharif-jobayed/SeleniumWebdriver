package com.opensourceDemo.orangehrmlive.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Page {
    protected Page() {
    }

    protected abstract String getPageURL();

    protected abstract WebElement getElement(By locator);

    protected abstract List<WebElement> getElements(By locator);

    protected abstract void doClick(By locator);

    protected abstract void clickByText(String text, By locator);

    protected abstract void clearAndType(String text, By locator);

    protected abstract void typeInFirstFld(String text, By locator);

    protected abstract void typeInLastFld(String text, By locator);

    protected abstract String textOf(By locator);

    protected abstract Boolean isThere(By locator);

    protected abstract Boolean isChecked(By locator, Integer timeout);

    protected abstract Boolean isVisible(By locator, Integer timeout);

    protected abstract void waitTillInvisible(By locator, Integer timeout);

    protected abstract Boolean isEnabled(By locator);

    protected abstract Boolean isPageOpen(String pageURL);

    protected abstract Boolean isPageLoaded();

    protected abstract <P extends BasePage> P getPageInstance(Class<P> pClass);
}
