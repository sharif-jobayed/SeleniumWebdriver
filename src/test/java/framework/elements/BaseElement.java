package framework.elements;

import framework.utils.DataConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseElement {
    private WebDriver driver;
    private By locator;
    private DataConverter dataConverter;

    public BaseElement(By locator) {
        this.dataConverter = new DataConverter();
        this.locator = locator;
    }

    public WebElement getElement() {
        return this.driver.findElement(this.locator);
    }

    public List<WebElement> getElements() {
        return this.driver.findElements(this.locator);
    }

    public Boolean doElementsExist() {
        List<WebElement> elements = new ArrayList<>(this.getElements());
        return !elements.isEmpty();
    }

    public Boolean isElementVisible() {
        return this.getElement().isDisplayed();
    }

    public Boolean isElementEnabled() {
        return this.getElement().isEnabled();
    }

    public void waitTillVisible(Integer timeout) {
        new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }
}
