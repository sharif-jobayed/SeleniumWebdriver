package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseElement {
    private WebDriver driver;
    private By locator;

    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
    }

    public WebElement getElement() {
        return this.driver.findElement(this.locator);
    }

    public List<WebElement> getElements() {
        return this.driver.findElements(this.locator);
    }

    public String getElementText() {
        return this.getElement().getText();
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

    public Boolean isElementChecked() {
        return this.getElement().isSelected();
    }

    public BaseElement waitTillElementIsVisible(Integer timeout) {
        new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(this.locator));
        return this;
    }

    public BaseElement clickElement() {
        this.getElement().click();
        return this;
    }

    public BaseElement clearAndTypeInElement(String text) {
        this.getElement().clear();
        this.getElement().sendKeys(text);
        return this;
    }

    public BaseElement scrollToElement() {
        Actions actions = new Actions(this.driver).scrollToElement(this.getElement());
        return this;
    }
}
