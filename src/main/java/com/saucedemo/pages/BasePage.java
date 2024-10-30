package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected WebDriver driver;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void clearAndType(By locator, String text) {
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void doClick(By locator) {
        find(locator).click();
    }
}
