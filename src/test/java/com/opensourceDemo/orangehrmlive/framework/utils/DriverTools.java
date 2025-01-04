package com.opensourceDemo.orangehrmlive.framework.utils;

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
    private static WebDriver DRIVER;

    public DriverTools(String driverTitle) {
        this.setDriver(driverTitle);
    }

    private void setDriver(String driverTitle) {
        String dt = driverTitle.toLowerCase(Locale.ROOT);

        switch (dt) {
            case "firefox":
                DRIVER = new FirefoxDriver();
                break;
            case "chrome":
                DRIVER = new ChromeDriver();
                break;
            case "edge":
                DRIVER = new EdgeDriver();
                break;
            default:
                throw new InvalidArgumentException("Invalid WebDriver request");
        }
    }

    public static WebDriver getDriver() {
        return DRIVER;
    }

    public static WebDriverWait getXWait(Integer timeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
    }

    public static Actions getActions() {
        return new Actions(getDriver());
    }

    public static JavascriptExecutor JS() {
        return (JavascriptExecutor) getDriver();
    }
}
