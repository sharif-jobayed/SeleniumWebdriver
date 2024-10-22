package framework;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverTools {
    private static WebDriver driver;

    public DriverTools(String driverTitle) {
        this.setDriver(driverTitle);
    }

    private void setDriver(String driverTitle) {
        switch (driverTitle.toLowerCase()) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            case "chrome_hl" -> {
                ChromeOptions options = new ChromeOptions().addArguments("--headless");
                driver = new ChromeDriver(options);
            }
            case "firefox_hl" -> {
                FirefoxOptions options = new FirefoxOptions().addArguments("--headless");
                driver = new FirefoxDriver(options);
            }
            case "edge_hl" -> {
                EdgeOptions options = new EdgeOptions().addArguments("--headless");
                driver = new EdgeDriver(options);
            }
            default -> throw new InvalidArgumentException("Invalid driver request");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getXWait(Integer timeout) {
        return new WebDriverWait(getDriver(), Duration.ofMillis(timeout));
    }

    public static Actions getActions() {
        return new Actions(getDriver());
    }

    public static JavascriptExecutor getJS() {
        return (JavascriptExecutor) getDriver();
    }
}
