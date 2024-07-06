package com.theInternetHerokuApp.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.theInternetHerokuApp.framework.DriverTools.getDriver;
import static com.theInternetHerokuApp.framework.DriverTools.getxWait;

public class BaseElement {
    private WebElement elLocator;
    private List<WebElement> elLocators;
    private String elName;

    public BaseElement (By elLocator, String elName) {
        this.elLocator = getDriver().findElement(elLocator);
        this.elLocators = getDriver().findElements(elLocator);
        this.elName = elName;
    }

    public void doClick () {
        this.elLocator.click();
    }

    public void itsText () {
        this.elLocator.getText();
    }

    public void clearAndType (String text) {
        this.elLocator.clear();
        this.elLocator.sendKeys(text);
    }

    public Boolean isChecked() {
        return this.elLocator.isSelected();
    }

    public Boolean isEnabled() {
        return this.elLocator.isEnabled();
    }

    public void waitTillVisible(int time) {
        getxWait(time).until(ExpectedConditions.visibilityOf(this.elLocator));
    }

    public void waitTillInteractable(int time) {
        getxWait(time).until(ExpectedConditions.elementToBeClickable(this.elLocator));
    }

    public WebElement getThat(int index) {
        if (index >= 0 && index < this.elLocators.size()) {
            return this.elLocators.get(index);
        } else {
            throw new IndexOutOfBoundsException(index+" Index is out of bounds for element list");
        }
    }
}
