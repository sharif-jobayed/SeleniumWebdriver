package com.opensourceDemo.orangehrmlive.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.getDriver;
import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.getXWait;

public class BasePage extends Page {
    private static final int DEFAULT_TIMEOUT = 10;

    protected BasePage() {
    }

    @Override
    protected String getPageURL() {
        return getDriver().getCurrentUrl();
    }

    @Override
    public Page doClick(By locator) {
        getDriver().findElement(locator).click();
        return this;
    }

    @Override
    public Page clearAndType(String text, By locator) {
        this.isEnabled(locator, 10);
        WebElement element = getDriver().findElement(locator);
        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Override
    public String getText(By locator) {
        return getDriver().findElement(locator).getText();
    }

    @Override
    public Boolean isChecked(By locator, Integer timeout) {
        WebElement element = getXWait(timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
        return element.isSelected();
    }

    @Override
    public Boolean isVisible(By locator, Integer timeout) {
        try {
            getXWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isEnabled(By locator, Integer timeout) {
        try {
            WebElement element = getXWait(timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isPageOpen(String pageURL, Integer timeout) {
        try {
            return this.getPageURL().equals(pageURL);
        } catch (Exception e) {
            System.err.println("Page title did not match within " + timeout + " seconds. Expected: " + pageURL);
            System.err.println("Exception: " + e.getMessage());
            return false;
        }
    }


    @Override
    public Boolean isPageLoaded(By locator, Integer timeout) {
        try {
            getXWait(timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
            getXWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public <P extends BasePage> P getPageInstance(Class<P> pClass) {
        try {
            return pClass.getDeclaredConstructor(WebDriver.class).newInstance(getDriver());
        } catch (Exception e) {
            throw new RuntimeException("Failed to create an instance of: " + pClass.getName(), e);
        }
    }
}
