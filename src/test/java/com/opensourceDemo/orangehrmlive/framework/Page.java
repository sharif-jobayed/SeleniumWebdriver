package com.opensourceDemo.orangehrmlive.framework;

import org.openqa.selenium.By;

public abstract class Page {
    protected Page() {
    }

    protected abstract String getPageURL();

    protected abstract Page doClick(By locator);

    protected abstract Page clearAndType(String text, By locator);

    protected abstract String getText(By locator);

    protected abstract Boolean isChecked(By locator, Integer timeout);

    protected abstract Boolean isVisible(By locator, Integer timeout);

    protected abstract Boolean isEnabled(By locator, Integer timeout);

    protected abstract Boolean isPageOpen(String pageTitle, Integer timeout);

    protected abstract <P extends BasePage> P getPageInstance(Class<P> pClass);
}
