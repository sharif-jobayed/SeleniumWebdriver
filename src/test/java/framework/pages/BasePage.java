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

import static framework.tests.BaseTest.getDriver;

public class BasePage extends Page {
    public BasePage(WebDriver driver, String pageURL, By pageIdentifier) {
        super(driver, pageURL, pageIdentifier);
    }

    @Override
    public String getPageURL() {
        return this.pageURL;
    }

    @Override
    public String getCurrentPageURL() {
        return getDriver().getCurrentUrl();
    }

    @Override
    public String getPageTitle() {
        return getDriver().getTitle();
    }

    @Override
    public Boolean isPageOpen() {
        try {
            return this.pageIdentifier.isElementVisible();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
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
    public Boolean isAlertOpen(Integer timeout) {
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(timeout)).until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Page acceptAlert() {
        getDriver().switchTo().alert().accept();
        return this;
    }

    @Override
    public Page denyAlert() {
        getDriver().switchTo().alert().dismiss();
        return this;
    }

    @Override
    public Page typeInAlert(String text) {
        getDriver().switchTo().alert().sendKeys(text);
        return this;
    }

    @Override
    public Page toDefaultContent() {
        getDriver().switchTo().defaultContent();
        return this;
    }

    @Override
    public Page openInNewTab() {
        ((JavascriptExecutor) getDriver()).executeScript("window.open('" + this.getPageURL() + "', '_blank');");

        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        return this; // Return the current instance
    }

    @Override
    public Page closeCurrentTab() {
        getDriver().close();

        if (!getDriver().getWindowHandles().isEmpty()) {
            String prevTab = getDriver().getWindowHandles().iterator().next();
            getDriver().switchTo().window(prevTab);
        }
        return this;
    }

    @Override
    public Page switchToTab(Integer tabIndex) {
        Set<String> windowHandles = getDriver().getWindowHandles();
        List<String> handlesList = new ArrayList<>(windowHandles);

        if (tabIndex < 0 || tabIndex >= handlesList.size()) {
            throw new IllegalArgumentException("Invalid tab index: " + tabIndex);
        }

        getDriver().switchTo().window(handlesList.get(tabIndex));
        return this;
    }
}
