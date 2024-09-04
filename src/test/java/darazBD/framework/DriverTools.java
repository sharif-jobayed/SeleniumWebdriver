package darazBD.framework;

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
        driver = setWDriver(driverTitle);
    }

    public WebDriver setWDriver(String driverTitle) {
        return switch (driverTitle.toLowerCase(Locale.ROOT)) {
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
            default -> throw new InvalidArgumentException(driverTitle + " is not a valid driver request");
        };
    }

    public static WebDriver getWDriver() {
        return driver;
    }

    public static WebDriverWait getXWait(Integer timeout) {
        return new WebDriverWait(getWDriver(), Duration.ofSeconds(timeout));
    }

    public static Actions getActions() {
        return new Actions(getWDriver());
    }

    public static JavascriptExecutor getJS() {
        return (JavascriptExecutor) getWDriver();
    }
}
