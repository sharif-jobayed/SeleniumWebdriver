package wikipedia_0001.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage extends Page {

    public BasePage(WebDriver driver, String pageURL, String pageName) {
        super(driver, pageURL, pageName);
    }

    @Override
    public String getPageURL() {
        return this.pageURL;
    }

    @Override
    public String getPageName() {
        return this.pageName;
    }

    @Override
    public String getCurrentURL() {
        return this.driver.getCurrentUrl();
    }

    @Override
    public String getPageTitle() {
        return this.driver.getTitle();
    }

    @Override
    public Boolean isPageOpen(Integer timeout) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.urlToBe(this.pageURL));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isPageLoaded(Integer timeout) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isAlertOpen(Integer timeout) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public WebElement getElement(By locator) {
        return this.driver.findElement(locator);
    }

    @Override
    public List<WebElement> getElements(By locator) {
        return this.driver.findElements(locator);
    }

    @Override
    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    @Override
    public Boolean isElementEnabled(By locator, Integer timeout) {
        try {
            WebElement element = new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.elementToBeClickable(locator));
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isElementChecked(By locator, Integer timeout) {
        try {
            WebElement element = new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.presenceOfElementLocated(locator));
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page goToPage() {
        this.driver.navigate().to(this.pageURL);
        return this;
    }

    @Override
    public Page waitTillElementVisibility(By locator, Integer timeout) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Element not visible within timeout");
        }
    }

    @Override
    public Page clickElement(By locator) {
        try {
            WebElement element = this.driver.findElement(locator);
            element.click();
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Unable to click element");
        }
    }

    @Override
    public Page doubleClickElement(By locator) {
        try {
            WebElement element = this.driver.findElement(locator);
            Actions actions = new Actions(this.driver);
            actions.doubleClick(element).perform();
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Unable to double-click element");
        }
    }

    @Override
    public Page typeInElement(By locator, String text) {
        try {
            getElement(locator).clear();
            getElement(locator).sendKeys(text);
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Unable to type in element");
        }
    }

    @Override
    public Page hoverOnElement(By locator) {
        try {
            Actions actions = new Actions(this.driver);
            actions.moveToElement(getElement(locator)).perform();
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Unable to hover on element");
        }
    }

    @Override
    public Page scrollToElement(By locator) {
        try {
            ((JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
            return this;
        } catch (Exception e) {
            throw new RuntimeException("Unable to scroll to element");
        }
    }
}
