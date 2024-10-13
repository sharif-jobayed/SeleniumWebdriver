package saucedemo.framework.utils;

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
        setDriver(driverTitle);
    }

    // Assign WebDriver
    private void setDriver(String driverTitle) {
        switch (driverTitle.toLowerCase(Locale.ROOT)) {
            case "firefox" -> driver = new FirefoxDriver();
            case "chrome" -> driver = new ChromeDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> throw new InvalidArgumentException("Invalid WebDriver request");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getXWait(Integer milliSeconds) {
        return new WebDriverWait(getDriver(), Duration.ofMillis(milliSeconds));
    }

    public static Actions getActions() {
        return new Actions(getDriver());
    }

    public static JavascriptExecutor getJS() {
        return (JavascriptExecutor) getDriver();
    }
}
