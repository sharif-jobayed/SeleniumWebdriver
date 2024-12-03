package framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BasePage extends Page {
    public BasePage(WebDriver driver, String pageURL, By pageIdentifier) {
        super(driver, pageURL, pageIdentifier);
    }

    @Override
    @Step("Get this page's URL")
    public String getPageURL() {
        return this.pageURL;
    }

    @Override
    @Step("Get current page's URL")
    public String getCurrentPageURL() {
        return this.driver.getCurrentUrl();
    }

    @Override
    @Step("Get current page's title")
    public String getPageTitle() {
        return this.driver.getTitle();
    }

    @Override
    @Step("Check if the page is open")
    public Boolean isPageOpen() {
        try {
            return this.pageIdentifier.isElementVisible();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Step("Check if the page is loaded")
    public Boolean isPageLoaded(Integer timeout) {
        try {
            this.pageIdentifier.scrollToElement();
            this.pageIdentifier.waitTillElementIsVisible(timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Step("Check if the alert is open")
    public Boolean isAlertOpen(Integer timeout) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Step("Accept current alert")
    public Page acceptAlert() {
        this.driver.switchTo().alert().accept();
        return this;
    }

    @Override
    @Step("Deny current alert")
    public Page denyAlert() {
        this.driver.switchTo().alert().dismiss();
        return this;
    }

    @Override
    @Step("Type in currently open alert")
    public Page typeInAlert(String text) {
        this.driver.switchTo().alert().sendKeys(text);
        return this;
    }

    @Override
    @Step("Get back to the default content")
    public Page toDefaultContent() {
        this.driver.switchTo().defaultContent();
        return this;
    }

    @Override
    @Step("Open the URL in a new tab/window")
    public Page openInNewTab() {
        ((JavascriptExecutor) this.driver).executeScript("window.open('" + this.getPageURL() + "', '_blank');");

        for (String handle : this.driver.getWindowHandles()) {
            this.driver.switchTo().window(handle);
        }
        return this; // Return the current instance
    }

    @Override
    @Step("Close currently open tab/window")
    public Page closeCurrentTab() {
        this.driver.close();

        if (!this.driver.getWindowHandles().isEmpty()) {
            String prevTab = this.driver.getWindowHandles().iterator().next();
            this.driver.switchTo().window(prevTab);
        }
        return this;
    }

    @Override
    @Step("Switch to the target tab/window")
    public Page switchToTab(Integer tabIndex) {
        Set<String> windowHandles = this.driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(windowHandles);

        if (tabIndex < 0 || tabIndex >= handlesList.size()) {
            throw new IllegalArgumentException("Invalid tab index: " + tabIndex);
        }

        this.driver.switchTo().window(handlesList.get(tabIndex));
        return this;
    }
}
