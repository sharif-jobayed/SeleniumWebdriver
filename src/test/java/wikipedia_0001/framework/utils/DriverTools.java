package wikipedia_0001.framework.utils;

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
    private WebDriver driver;

    public DriverTools(String driverTitle) {
        setDriver(driverTitle);
    }

    // Set up the WebDriver
    private void setDriver(String driverTitle) {
        String dt = driverTitle.toLowerCase(Locale.ROOT);

        if (dt.contains("firefox")) {
            this.driver = new FirefoxDriver();
        } else if (dt.contains("edge")) {
            this.driver = new EdgeDriver();
        } else if (dt.contains("chrome")) {
            this.driver = new ChromeDriver();
        } else {
            throw new InvalidArgumentException("Invalid WebDriver Request!");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getXWait(Integer timeout) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
    }

    public Actions getActions() {
        return new Actions(getDriver());
    }

    public JavascriptExecutor getJS() {
        return (JavascriptExecutor) getDriver();
    }
}
