package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseElement {
    private DriverTools driverTools;
    private By locator;

    public BaseElement(DriverTools driverTools, By locator) {
        this.driverTools = driverTools;
        this.locator = locator;
    }

    public Boolean isVisible(Integer timeout) {
        try {
            return this.driverTools.getXWait(timeout)
                    .until(ExpectedConditions.visibilityOfElementLocated(this.locator))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isActive(Integer timeout) {
        try {
            WebElement element = this.driverTools.getXWait(timeout)
                    .until(ExpectedConditions.presenceOfElementLocated(this.locator));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public Boolean isChecked(Integer timeout) {
        try {
            WebElement element = this.driverTools.getXWait(timeout)
                    .until(ExpectedConditions.presenceOfElementLocated(this.locator));
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    public BaseElement waitTillPresence(Integer timeout) {
        this.driverTools.getXWait(timeout)
                .until(ExpectedConditions.presenceOfElementLocated(this.locator));
        return this;
    }

    public BaseElement doClick() {
        this.driverTools.getXWait(10)
                .until(ExpectedConditions.elementToBeClickable(this.locator))
                .click();
        return this;
    }

    public BaseElement clearAndType(String text) {
        WebElement element = this.driverTools.getXWait(10)
                .until(ExpectedConditions.elementToBeClickable(this.locator));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    public String text() {
        return this.driverTools.getXWait(10)
                .until(ExpectedConditions.presenceOfElementLocated(this.locator))
                .getText();
    }

    public String getAttribute(String attributeName) {
        return this.driverTools.getXWait(10)
                .until(ExpectedConditions.presenceOfElementLocated(this.locator))
                .getDomProperty(attributeName);
    }

    public BaseElement scrollIntoView() {
        this.driverTools.getJS().executeScript("arguments[0].scrollIntoView(true);", this.driverTools.getDriver().findElement(this.locator));
        return this;
    }

    public BaseElement hover() {
        this.driverTools.getActions()
                .moveToElement(this.driverTools.getDriver().findElement(this.locator))
                .perform();
        return this;
    }

    public BaseElement waitTillInvisible(Integer timeout) {
        this.driverTools.getXWait(timeout)
                .until(ExpectedConditions.invisibilityOfElementLocated(this.locator));
        return this;
    }
}
