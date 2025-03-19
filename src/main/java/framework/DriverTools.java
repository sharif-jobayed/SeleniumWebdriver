package framework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Locale;

public class DriverTools {
    private WebDriver driver;

    public DriverTools(String driverTitle) {
        setDriver(driverTitle);
    }

    private void setDriver(String driverTitle) {
        String dt = driverTitle.toLowerCase(Locale.ROOT);

        switch (dt) {
//            case "firefox" -> this.driver = new FirefoxDriver();
//            case "edge" -> this.driver = new EdgeDriver();
//            case "chrome" -> this.driver = new ChromeDriver();
//            default -> throw new InvalidArgumentException("Invalid WebDriver request");

            case "firefox" -> {
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setProfile(firefoxProfile);
                this.driver = new FirefoxDriver(firefoxOptions);
            }
            case "chrome" -> {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                this.driver = new ChromeDriver(chromeOptions);
            }
            case "edge" -> {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--inprivate");
                this.driver = new EdgeDriver(edgeOptions);
            }
            default -> throw new InvalidArgumentException("Invalid WebDriver request");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public WebDriverWait getXWait(Integer timeout) {
        return new WebDriverWait(this.getDriver(), Duration.ofSeconds(timeout));
    }

    public Actions getActions() {
        return new Actions(this.getDriver());
    }

    public JavascriptExecutor getJS() {
        return (JavascriptExecutor) this.getDriver();
    }

    public void saveScreenshot() {
        ((TakesScreenshot) this.getDriver()).getScreenshotAs(OutputType.FILE);
    }
}
