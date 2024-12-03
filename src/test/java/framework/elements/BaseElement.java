package framework.elements;

import io.qameta.allure.Step;
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

    @Step("Get the element")
    public WebElement getElement() {
        return this.driver.findElement(this.locator);
    }

    @Step("Get the elements")
    public List<WebElement> getElements() {
        return this.driver.findElements(this.locator);
    }

    @Step("Get the text of the element")
    public String getElementText() {
        return this.getElement().getText();
    }

    @Step("Check if the element exists on the page")
    public Boolean doElementsExist() {
        List<WebElement> elements = new ArrayList<>(this.getElements());
        return !elements.isEmpty();
    }

    @Step("Check if the element is visible on the page")
    public Boolean isElementVisible() {
        return this.getElement().isDisplayed();
    }

    @Step("Check if the element is enabled")
    public Boolean isElementEnabled() {
        return this.getElement().isEnabled();
    }

    @Step("Check if the element is ticked")
    public Boolean isElementChecked() {
        return this.getElement().isSelected();
    }

    @Step("Wait until the element is visible on the page")
    public BaseElement waitTillElementIsVisible(Integer timeout) {
        new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(this.locator));
        return this;
    }

    @Step("Click on the element")
    public BaseElement clickElement() {
        this.getElement().click();
        return this;
    }

    @Step("Clear the element & type the given text")
    public BaseElement clearAndTypeInElement(String text) {
        this.getElement().clear();
        this.getElement().sendKeys(text);
        return this;
    }

    @Step("Scroll to the element")
    public BaseElement scrollToElement() {
        Actions actions = new Actions(this.driver).scrollToElement(this.getElement());
        return this;
    }
}
