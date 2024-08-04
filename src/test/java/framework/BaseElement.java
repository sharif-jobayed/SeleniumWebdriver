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
        return getDriver().findElement(this.EL_LOCATOR);
    }

    public List<WebElement> getEL_LOCATORS() {
        return getDriver().findElements(this.EL_LOCATOR);
    }

    public String getEL_NAME() {
        return this.EL_NAME;
    }

    public Boolean isVisible(Integer timeOut) {
        getXWait(timeOut).until(ExpectedConditions.visibilityOf(getEL_LOCATOR()));
        return getEL_LOCATOR().isDisplayed();
    }

    public Boolean isEnabled(Integer timeOut) {
        return getXWait(timeOut).until(ExpectedConditions.elementToBeClickable(this.EL_LOCATOR)).isEnabled();
    }

    public Boolean isChecked(Integer timeOut) {
        return getXWait(timeOut).until(ExpectedConditions.elementToBeSelected(this.EL_LOCATOR));
    }

    public BaseElement doClick(Integer timeOut) {
        getXWait(timeOut).until(ExpectedConditions.elementToBeClickable(this.EL_LOCATOR));
        getEL_LOCATOR().click();
        return this;
    }

    public BaseElement clearAndType(Integer timeOut, String text) {
        getXWait(timeOut).until(ExpectedConditions.elementToBeClickable(this.EL_LOCATOR)).isEnabled();
        getEL_LOCATOR().clear();
        getEL_LOCATOR().sendKeys(text);
        return this;
    }

    public BaseElement doCheck(Integer timeOut) {
        if (!isChecked(timeOut)) {
            getEL_LOCATOR().click();
        }
        return this;
    }

    public BaseElement scrollTo(Integer timeOut) {
        getXWait(timeOut).until(ExpectedConditions.presenceOfElementLocated(this.EL_LOCATOR));
        getActions().scrollToElement(getEL_LOCATOR());
        return this;
    }
}
