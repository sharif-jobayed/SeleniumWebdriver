package com.TheInternetHerokuApp.utils;

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
    private Actions actions;
    private WebDriverWait wait;
    private JavascriptExecutor jsExecutor;

    public DriverTools(String myDriver) {
        setDriver(myDriver);
        this.actions = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    // Driver assignment
    public void setDriver(String myDriver) {
        switch (myDriver) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + myDriver);
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
    public Actions getActions() {
        return actions;
    }
    public WebDriverWait getWait() {
        return wait;
    }
    public JavascriptExecutor getJsExecutor() {
        return jsExecutor;
    }
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
