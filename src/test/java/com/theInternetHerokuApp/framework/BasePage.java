package com.theInternetHerokuApp.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

import static com.theInternetHerokuApp.framework.DriverTools.getDriver;
import static com.theInternetHerokuApp.framework.DriverTools.getJsExec;

public class BasePage {
    private String pageURL;
    private String pageName;

    public BasePage(String pageURL, String pageName) {
        this.pageURL = pageURL;
        this.pageName = pageName;
    }

    public void openPage() {
        getDriver().get(this.pageURL);
    }

    public Boolean isPageOpen() {
        return getDriver().getCurrentUrl().equals(this.pageURL);
    }

    public Boolean isPageLoaded() {
        try {
            String readyState = getJsExec().executeScript("return document.readyState").toString();
            return readyState.equals("complete");
        } catch (WebDriverException e) {
            return false;
        }
    }

    public void openInNewWindow() {
        getJsExec().executeScript("window.open();");
        for (String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);
        }
        openPage();
    }

    public void closeCurrentWindow() {
        getDriver().close();
        getDriver().switchTo().window(getDriver().getWindowHandles().iterator().next());
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void goBack() {
        getDriver().navigate().back();
    }

    public void goForword() {
        getDriver().navigate().forward();
    }

    public BaseElement getLinkByText(String text) {
        return new BaseElement(
                By.xpath("//a[contains(text()," + "'" + text + "'" + ")]"),
                text + " link"
        );
    }
}
