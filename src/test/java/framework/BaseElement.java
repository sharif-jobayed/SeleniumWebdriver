package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static framework.DriverTools.*;

public class BaseElement {
    private final By EL_LOCATOR;
    private final String EL_NAME;

    public BaseElement(By elLocator, String elName) {
        this.EL_LOCATOR = elLocator;
        this.EL_NAME = elName;
    }

    public WebElement getElement() {
        return getDriver().findElement(this.EL_LOCATOR);
    }

    public List<WebElement> getElements() {
        return getDriver().findElements(this.EL_LOCATOR);
    }

    public String getElementName() {
        return this.EL_NAME;
    }

    public String elementText() {
        return getElement().getText();
    }

    public BaseElement doClick() {
        getElement().click();
        return this;
    }

    public BaseElement clearAndType(String text) {
        getElement().clear();
        getElement().sendKeys(text);
        return this;
    }

    public Boolean isVisible(Integer timeout) {
        getXWait(timeout).until(ExpectedConditions.visibilityOf(getElement()));
        return getElement().isDisplayed();
    }

    public BaseElement scrollToElement() {
        getActions().scrollToElement(getElement());
        return this;
    }

    public Boolean isAlertOpen(Integer timeout) {
        try {
            getXWait(timeout).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (NoAlertPresentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
