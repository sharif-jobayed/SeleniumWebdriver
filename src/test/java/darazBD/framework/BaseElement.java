package darazBD.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static darazBD.framework.DriverTools.getWDriver;
import static darazBD.framework.DriverTools.getXWait;

public class BaseElement {
    private final By EL_LOCATOR;
    private final String EL_NAME;

    public BaseElement(By elementLocator, String elementName) {
        this.EL_LOCATOR = elementLocator;
        this.EL_NAME = elementName;
    }

    public WebElement getEl() {
        return getWDriver().findElement(this.EL_LOCATOR);
    }

    public List<WebElement> getEls() {
        return getWDriver().findElements(this.EL_LOCATOR);
    }

    public String getElName() {
        return this.EL_NAME;
    }

    public BaseElement doClick() {
        getEl().click();
        return this;
    }

    public BaseElement clearAndType(String text) {
        getEl().clear();
        getEl().sendKeys(text);
        return this;
    }

    public String getElText() {
        return getEl().getText();
    }

    public Boolean isChecked() {
        return getEl().isSelected();
    }

    public Boolean isVisible() {
        return getEl().isDisplayed();
    }

    public Boolean isEnable() {
        return getEl().isEnabled();
    }

    public BaseElement waitTillVisible(Integer timeout) {
        getXWait(timeout).until(ExpectedConditions.visibilityOf(getEl()));
        return this;
    }

    public BaseElement waitTillDisappear(Integer timeout) {
        getXWait(timeout).until(ExpectedConditions.invisibilityOf(getEl()));
        return this;
    }

    public BaseElement waitTillClickable(Integer timeout) {
        getXWait(timeout).until(ExpectedConditions.elementToBeClickable(getEl()));
        return this;
    }
}
