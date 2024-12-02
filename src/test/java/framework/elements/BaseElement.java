package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseElement {
    private WebDriver driver;
    private By locator;

    protected BaseElement(By locator) {
        this.locator = locator;
    }

    protected WebElement getEl() {
        return this.driver.findElement(this.locator);
    }

    protected Boolean isElsExist() {
        List<WebElement> elements = new ArrayList<>(this.driver.findElements(this.locator));
        return !elements.isEmpty();
    }
}
