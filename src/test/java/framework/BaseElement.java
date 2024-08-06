package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static framework.DriverTools.*;

public class BaseElement {
    private final By EL_LOCATOR;
    private final String EL_NAME;

    public BaseElement(By webElement, String elementName) {
        this.EL_LOCATOR = webElement;
        this.EL_NAME = elementName;
    }

    public WebElement getEL_LOCATOR() {
        return getDriver().findElement(EL_LOCATOR);
    }

    public List<WebElement> getEL_LOCATORS() {
        return getDriver().findElements(EL_LOCATOR);
    }

    public String getEL_NAME() {
        return EL_NAME;
    }

    public String itsText(Integer timeOut) {
        WebElement element = getXWait(timeOut).until(ExpectedConditions.visibilityOfElementLocated(EL_LOCATOR));
        return element.getText();
    }

    public Boolean isVisible(Integer timeOut) {
        try {
            getXWait(timeOut).until(ExpectedConditions.visibilityOfElementLocated(EL_LOCATOR));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isEnabled(Integer timeOut) {
        try {
            WebElement element = getXWait(timeOut).until(ExpectedConditions.elementToBeClickable(EL_LOCATOR));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isChecked(Integer timeOut) {
        try {
            WebElement element = getXWait(timeOut).until(ExpectedConditions.visibilityOfElementLocated(EL_LOCATOR));
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public BaseElement doClick(Integer timeOut) {
        WebElement element = getXWait(timeOut).until(ExpectedConditions.elementToBeClickable(EL_LOCATOR));
        element.click();
        return this;
    }

    public BaseElement clearAndType(Integer timeOut, String text) {
        WebElement element = getXWait(timeOut).until(ExpectedConditions.visibilityOfElementLocated(EL_LOCATOR));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public BaseElement doCheck(Integer timeOut) {
        WebElement element = getXWait(timeOut).until(ExpectedConditions.elementToBeClickable(EL_LOCATOR));
        if (!element.isSelected()) {
            element.click();
        }
        return this;
    }

    public BaseElement scrollTo(Integer timeOut) {
        WebElement element = getXWait(timeOut).until(ExpectedConditions.visibilityOfElementLocated(EL_LOCATOR));
        getJS().executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }
}
