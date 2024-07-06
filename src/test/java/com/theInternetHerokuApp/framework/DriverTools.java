package com.theInternetHerokuApp.framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverTools {
    private WebDriver driver;
    private WebDriverWait xWait;
    private Actions actions;
    private JavascriptExecutor jsExec;

    public DriverTools (String webDriver) {
        // Make driver
        if(webDriver.equals("Firefox".toLowerCase())) {
            this.driver = new FirefoxDriver();
        } else if (webDriver.equals("Chrome".toLowerCase())) {
            this.driver = new ChromeDriver();
        } else if (webDriver.equals("Edge".toLowerCase())) {
            this.driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("The "+webDriver+" is not a valid Webdriver");
        }

        // Make xWait
        this.xWait = new WebDriverWait(driver, Duration.ofSeconds(10000));

        // Make actions
        this.actions = new Actions(driver);

        // Make jsExec
        this.jsExec = (JavascriptExecutor) driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getxWait() {
        return this.xWait;
    }

    public Actions getActions() {
        return this.actions;
    }

    public JavascriptExecutor getJsExec() {
        return this.jsExec;
    }
}
