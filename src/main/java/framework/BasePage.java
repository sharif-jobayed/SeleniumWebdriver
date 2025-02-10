package framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage extends Page {
    public BasePage(DriverTools driverTools, String path) {
        super(driverTools, path);
    }

    @Override
    protected String getPagePath() {
        return this.path;
    }

    @Override
    public String getPageTitle() {
        return driverTools.getDriver().getTitle();
    }

    @Override
    public String getPageURL() {
        return driverTools.getDriver().getCurrentUrl();
    }

    @Override
    public Boolean isPageOpen(Integer timeout) {
        try {
            WebDriverWait wait = driverTools.getXWait(timeout);
            return wait.until(d -> d.getTitle().equals(this.getPageTitle()));
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public Boolean isPageLoaded(Integer timeout) {
        try {
            WebDriverWait wait = driverTools.getXWait(timeout);
            return wait.until(d -> ((JavascriptExecutor) d).executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public Boolean isAlertOpen(Integer timeout) {
        try {
            WebDriverWait wait = driverTools.getXWait(timeout);
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Override
    public Page typeInAlert(String text) {
        Alert alert = driverTools.getDriver().switchTo().alert();
        alert.sendKeys(text);
        return this;
    }

    @Override
    public Page acceptAlert() {
        Alert alert = driverTools.getDriver().switchTo().alert();
        alert.accept();
        return this;
    }

    @Override
    public Page rejectAlert() {
        Alert alert = driverTools.getDriver().switchTo().alert();
        alert.dismiss();
        return this;
    }

    @Override
    public Page backToDefaultPage() {
        driverTools.getDriver().switchTo().defaultContent();
        return this;
    }

    @Override
    public Page openInNewWindow(String url) {
        driverTools.getJS().executeScript("window.open(arguments[0]);", url);
        return this;
    }

    @Override
    public Page getWindow(Integer index) {
        Set<String> windowHandles = driverTools.getDriver().getWindowHandles();
        String[] handles = windowHandles.toArray(new String[0]);
        if (index >= 0 && index < handles.length) {
            driverTools.getDriver().switchTo().window(handles[index]);
        } else {
            throw new IllegalArgumentException("Invalid window index: " + index);
        }
        return this;
    }

    @Override
    public Page closeCurrentWindow() {
        driverTools.getDriver().close();
        return this;
    }

}
