package framework;

import framework.utils.DataConverter;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class DriverTools {
    private WebDriver driver;
    private DataConverter dataConverter;

    public DriverTools(String driverTitle) {
        this.dataConverter = new DataConverter();
        this.setDriver(driverTitle);
    }

    private void setDriver(String driverTitle) {
        String rt = driverTitle.toLowerCase(Locale.ROOT);

        if(rt.contains(this.dataConverter.getAppData().getBrowsers().getFirefox())) {
            this.driver = new FirefoxDriver();
        } else if(rt.contains(this.dataConverter.getAppData().getBrowsers().getEdge())) {
            this.driver = new EdgeDriver();
        } else if(rt.contains(this.dataConverter.getAppData().getBrowsers().getChrome())) {
            this.driver = new ChromeDriver();
        } else {
            throw new InvalidArgumentException("Invalid driver request");
        }
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
