package com.opensourceDemo.orangehrmlive.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.*;

public class BasePage extends Page {
    public BasePage() {
    }

    @Override
    public String getPageURL() {
        return getDriver().getCurrentUrl();
    }

    @Override
    public WebElement getElement(By locator) {
        return getXWait(10).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public List<WebElement> getElements(By locator) {
        return getDriver().findElements(locator);
    }

    @Override
    public void doClick(By locator) {
        this.getElement(locator).click();
    }

    @Override
    public void clickByText(String text, By locator) {
        for (WebElement element : this.getElements(locator)) {
            if (element.getText().equals(text)) {
                element.click();
                break;
            }
        }
    }

    @Override
    public void clearAndType(String text, By locator) {
        this.getElement(locator).clear();
        this.getElement(locator).sendKeys(text);
    }

    @Override
    public void typeInFirstFld(String text, By locator) {
        this.getElements(locator).get(0).sendKeys(text);
    }

    @Override
    public void typeInLastFld(String text, By locator) {
        this.getElements(locator).get(this.getElements(locator).size() - 1).sendKeys(text);

    }

    @Override
    public String textOf(By locator) {
        return this.getElement(locator).getText();
    }

    @Override
    public Boolean isThere(By locator) {
        getXWait(30).until(ExpectedConditions.presenceOfElementLocated(locator));
        return true;
    }

    @Override
    public Boolean isChecked(By locator, Integer timeout) {
        return getXWait(timeout).until(ExpectedConditions.elementToBeClickable(locator)).isSelected();
    }

    @Override
    public Boolean isVisible(By locator, Integer timeout) {
        return getXWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
    }

    @Override
    public Boolean isEnabled(By locator) {
        return this.getElement(locator).isEnabled();
    }

    @Override
    public Boolean isPageOpen(String pageURL) {
        return this.getPageURL().equals(pageURL);
    }

    @Override
    public Boolean isPageLoaded(Integer timeout) {
        return getXWait(timeout).until((ExpectedCondition<Boolean>) rs -> getJS().executeScript("return document.readyState").equals("complete"));
    }
}
