package saucedemo.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import saucedemo.framework.utils.DataConverter;

import static saucedemo.framework.utils.DriverTools.getDriver;

public class BaseElement {
    private By elLocator;
    private String elName;
    private DataConverter dataConverter = new DataConverter();

    public BaseElement(By elLocator, String elName) {
        this.elLocator = elLocator;
        this.elName = elName;
    }

    public By getElLocator() {
        return this.elLocator;
    }

    public String getElName() {
        return this.elName;
    }

    public WebElement getElement() {
        return getDriver().findElement(getElLocator());
    }

    public Boolean isElVisible() {
        return getElement().isDisplayed();
    }

    public void doClick() {
        getElement().click();
    }

    public void clearAndType(String text) {
        getElement().clear();
        getElement().sendKeys(text);
    }
}
