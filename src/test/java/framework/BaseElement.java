package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static framework.DriverTools.getDriver;

public class BaseElement {
    private final WebElement EL_LOCATOR;
    private final List<WebElement> EL_LOCATORS;
    private final String EL_NAME;

    public BaseElement(By webElement, String elementName) {
        this.EL_LOCATOR = getDriver().findElement(webElement);
        this.EL_LOCATORS = getDriver().findElements(webElement);
        this.EL_NAME = elementName;
    }

    public WebElement getEL_LOCATOR() {
        return EL_LOCATOR;
    }
    public List<WebElement> getEL_LOCATORS() {
        return EL_LOCATORS;
    }
    public String getEL_NAME() {
        return EL_NAME;
    }
}
