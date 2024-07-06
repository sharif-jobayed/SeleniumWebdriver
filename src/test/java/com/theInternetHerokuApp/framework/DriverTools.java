package com.theInternetHerokuApp.framework;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class DriverTools {
    private static WebDriver driver;

    public DriverTools(String webDriver) {
        String browser = webDriver.toLowerCase(Locale.ROOT);
        // Make driver
        switch (browser) {
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("The " + webDriver + " is not a valid WebDriver");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getxWait(int seconds) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(seconds));
    }

    public static Actions getActions() {
        return new Actions(getDriver());
    }

    public static JavascriptExecutor getJsExec() {
        return (JavascriptExecutor) getDriver();
    }
}
