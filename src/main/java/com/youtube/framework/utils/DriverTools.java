package com.youtube.framework.utils;

import org.openqa.selenium.InvalidArgumentException;
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

    public DriverTools(String driverTitle) {
        this.setDriver(driverTitle);
    }

    private void setDriver(String driverTitle) {
        String dt = driverTitle.toLowerCase(Locale.ROOT);

        switch (dt) {
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
                throw new InvalidArgumentException("Invalid driver request");
        }
    }

    public static WebDriver testDriver() {
        return driver;
    }

    public static WebDriverWait getXWait(Integer timeout) {
        return new WebDriverWait(testDriver(), Duration.ofMillis(timeout));
    }

    public static Actions getActions() {
        return new Actions(testDriver());
    }

    public static JavascriptExecutor getJS() {
        return (JavascriptExecutor) testDriver();
    }
}
