package wikipedia_0001.runners;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {
    private WebDriver driver;

    public Hooks() {
        this.driver = new EdgeDriver();
    }

    private void setDriver(String driverTitile) {
        // Conditional driver return code...
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    @Before
    public void setUp() {
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get("https://www.wikipedia.org/");
    }

    @After
    public void tearDown() {
        if (this.driver != null) {
            getDriver().quit();
        }
    }
}
