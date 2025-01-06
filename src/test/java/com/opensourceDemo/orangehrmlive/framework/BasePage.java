package com.opensourceDemo.orangehrmlive.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.*;

public class BasePage extends Page {
    protected BasePage() {
    }

    @Override
    protected String getPageURL() {
        return getDriver().getCurrentUrl();
    }

    @Override
    protected WebElement getElement(By locator) {
        return getDriver().findElement(locator);
    }

    @Override
    protected List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    @Override
    public void doClick(By locator) {
        this.getElement(locator).click();
    }

    @Override
    public void clickByText(String text, By locator) {
        this.getElements(locator);
        for (int i = 0; i < this.getElements(locator).size(); i++) {
            if (this.getElements(locator).get(i).getText().equals(text)) {
                this.getElements(locator).get(i).click();
                break;
            }
        }
    }

    @Override
    public void clearAndType(String text, By locator) {
        if (this.isEnabled(locator)) {
            this.getElement(locator).clear();
            this.getElement(locator).sendKeys(text);
        }
    }

    @Override
    protected void typeInFirstFld(String text, By locator) {
        this.isVisible(locator, 5);
        this.getElements(locator).getFirst().clear();
        this.getElements(locator).getFirst().sendKeys(text);
    }

    @Override
    protected void typeInLastFld(String text, By locator) {
        this.isVisible(locator, 5);
        this.getElements(locator).getLast().clear();
        this.getElements(locator).getLast().sendKeys(text);
    }

    @Override
    public String textOf(By locator) {
        return this.getElement(locator).getText();
    }

    @Override
    protected Boolean isThere(By locator) {
        return !this.getElements(locator).isEmpty();
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
    public void waitTillInvisible(By locator, Integer timeout) {
        getXWait(timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    @Override
    public Boolean isEnabled(By locator) {
        try {
            return getXWait(10).until(ExpectedConditions.presenceOfElementLocated(locator)).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isPageOpen(String pageURL) {
        try {
            return this.getPageURL().equals(pageURL);
        } catch (Exception e) {
            System.err.println("Page title did not match within " + 5 + " seconds. Expected: " + pageURL);
            System.err.println("Exception: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean isPageLoaded() {
        try {
            return getXWait(10).until((ExpectedCondition<Boolean>) driver -> {
                String readyState = getJS().executeScript("return document.readyState").toString();
                return readyState.equals("complete");
            });
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
