package darazBD.framework;

import org.openqa.selenium.By;

import static darazBD.framework.DriverTools.getWDriver;

public class BaseElement {
    private final By EL_LOCATOR;
    private final String EL_NAME;

    public BaseElement(By elementLocator, String elementName) {
        this.EL_LOCATOR = elementLocator;
        this.EL_NAME = elementName;
    }

    public BaseElement doClick() {
        getWDriver().findElement(this.EL_LOCATOR).click();
        return this;
    }

    public BaseElement clearAndType(String text) {
        getWDriver().findElement(this.EL_LOCATOR).clear();
        getWDriver().findElement(this.EL_LOCATOR).sendKeys(text);
        return this;
    }

    public String getElText() {
        return getWDriver().findElement(this.EL_LOCATOR).getText();
    }

    public Boolean isChecked() {
        return getWDriver().findElement(this.EL_LOCATOR).isSelected();
    }
}
