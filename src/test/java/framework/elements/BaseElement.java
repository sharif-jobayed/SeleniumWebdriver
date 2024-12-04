package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static framework.tests.BaseTest.getDriver;

public class BaseElement {
    private By locator;

    public BaseElement(By locator) {
        this.locator = locator;
    }

    public WebElement getElement() {
        return getDriver().findElement(this.locator);
    }

    public List<WebElement> getElements() {
        return getDriver().findElements(this.locator);
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

    public void waitTillElementIsVisible(Integer timeout) {
        new WebDriverWait(getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(this.locator));
    }

    public void clickElement() {
        this.getElement().click();
    }

    public void clearAndTypeInElement(String text) {
        this.getElement().clear();
        this.getElement().sendKeys(text);
    }

    public void scrollToElement() {
        Actions actions = new Actions(getDriver()).scrollToElement(this.getElement());
    }
}
