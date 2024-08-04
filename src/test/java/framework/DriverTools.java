package framework;

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

    public DriverTools(String webDriver) {
        switch (webDriver.toLowerCase(Locale.ROOT)) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> throw new InvalidArgumentException("The requeste WebDriver is not valid");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getXWait(Integer timeOut) {
        return new WebDriverWait(getDriver(), Duration.ofMillis(timeOut));
    }

    public static Actions getActions() {
        return new Actions(getDriver());
    }

    public static JavascriptExecutor getJS() {
        return (JavascriptExecutor) getDriver();
    }
}
