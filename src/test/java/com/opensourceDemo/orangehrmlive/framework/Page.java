package com.opensourceDemo.orangehrmlive.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class Page {
    protected Page() {
    }

    protected abstract String getPageURL();

    protected abstract WebElement getElement(By locator);

    protected abstract Page doClick(By locator);

    protected abstract Page clearAndType(String text, By locator);

    protected abstract String getText(By locator);

    protected abstract Boolean isChecked(By locator, Integer timeout);

    protected abstract Boolean isVisible(By locator, Integer timeout);

    protected abstract Boolean isEnabled(By locator, Integer timeout);

    protected abstract Boolean isPageOpen(String pageURL, Integer timeout);

    protected abstract Boolean isPageLoaded(Integer timeout);

    protected abstract <P extends BasePage> P getPageInstance(Class<P> pClass);
}
