package wikipedia_0001.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseElement {
    protected WebDriver driver;
    protected By locator;

    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }
}
