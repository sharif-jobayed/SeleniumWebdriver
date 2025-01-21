package framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends Page {

    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public Boolean isPageOpen(Integer timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.urlToBe(getPageURL(timeout)));
    }

    @Override
    public Boolean isPageLoaded(Integer timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body"))) != null;
    }

    @Override
    public Boolean isAlertOpen(Integer timeout) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.alertIsPresent()) != null;
    }

    @Override
    public Boolean doesItExist(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isItVisible(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOf(this.driver.findElement(locator)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean isItActive(By locator, Integer timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.elementToBeClickable(this.driver.findElement(locator)));
            return this.driver.findElement(locator).isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getPageURL(Integer timeout) {
        return this.driver.getCurrentUrl();
    }

    @Override
    public String getPageTitle(Integer timeout) {
        return this.driver.getTitle();
    }

    @Override
    public String itsText(By locator) {
        WebElement element = this.driver.findElement(locator);
        return element.getText();
    }

    @Override
    public Page openInNewWindow(String url) {
        this.driver.switchTo().newWindow(org.openqa.selenium.WindowType.WINDOW);
        this.driver.get(url);
        return this;
    }

    @Override
    public Page closeCurrentWindow() {
        this.driver.close();
        this.driver.switchTo().window(this.driver.getWindowHandles().iterator().next());
        return this;
    }

    @Override
    public Page goToDefaultContent() {
        this.driver.switchTo().defaultContent();
        return this;
    }

    @Override
    public Page doClick(By locator) {
        WebElement element = this.driver.findElement(locator);
        element.click();
        return this;
    }

    @Override
    public Page clearAndType(Integer timeout, String text, By locator) {
        WebElement element = this.driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Override
    public Page waitTillExist(Integer timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this;
    }

    @Override
    public Page scrollTo(By locator) {
        WebElement element = this.driver.findElement(locator);
        ((org.openqa.selenium.JavascriptExecutor) this.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        return this;
    }

    @Override
    public Alert typeInAlert(String text) {
        Alert alert = this.driver.switchTo().alert();
        alert.sendKeys(text);
        return alert;
    }

    @Override
    public Alert acceptIt() {
        Alert alert = this.driver.switchTo().alert();
        alert.accept();
        return alert;
    }

    @Override
    public Alert denyIt() {
        Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
        return alert;
    }

    @Override
    public <P extends BasePage> P getPageInstance(Class<P> pClass) {
        try {
            return pClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page instance", e);
        }
    }
}
