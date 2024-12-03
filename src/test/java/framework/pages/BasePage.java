package framework.pages;

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
    protected String getPageURL() {
        return this.pageURL;
    }

    @Override
    protected String getCurrentPageURL() {
        return this.driver.getCurrentUrl();
    }

    @Override
    protected String getPageTitle() {
        return this.driver.getTitle();
    }

    @Override
    protected Boolean isPageOpen() {
        try {
            return this.pageIdentifier.isElementVisible();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected Boolean isPageLoaded(Integer timeout) {
        try {
            this.pageIdentifier.scrollToElement();
            this.pageIdentifier.waitTillElementIsVisible(timeout);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected Boolean isAlertOpen(Integer timeout) {
        try {
            new WebDriverWait(this.driver, Duration.ofSeconds(timeout)).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    protected Page acceptAlert() {
        this.driver.switchTo().alert().accept();
        return this;
    }

    @Override
    protected Page denyAlert() {
        this.driver.switchTo().alert().dismiss();
        return this;
    }

    @Override
    protected Page typeInAlert(String text) {
        this.driver.switchTo().alert().sendKeys(text);
        return this;
    }

    @Override
    protected Page toDefaultContent() {
        this.driver.switchTo().defaultContent();
        return this;
    }

    @Override
    protected Page openInNewTab() {
        ((JavascriptExecutor) this.driver).executeScript("window.open('" + this.getPageURL() + "', '_blank');");

        for (String handle : this.driver.getWindowHandles()) {
            this.driver.switchTo().window(handle);
        }
        return this; // Return the current instance
    }

    @Override
    protected Page closeCurrentTab() {
        this.driver.close();

        if (!this.driver.getWindowHandles().isEmpty()) {
            String prevTab = this.driver.getWindowHandles().iterator().next();
            this.driver.switchTo().window(prevTab);
        }
        return this;
    }

    @Override
    protected Page switchToTab(Integer tabIndex) {
        Set<String> windowHandles = this.driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(windowHandles);

        if (tabIndex < 0 || tabIndex >= handlesList.size()) {
            throw new IllegalArgumentException("Invalid tab index: " + tabIndex);
        }

        this.driver.switchTo().window(handlesList.get(tabIndex));
        return this;
    }
}
