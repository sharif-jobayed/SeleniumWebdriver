package wikipedia_0001.runners;

import io.cucumber.java.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {
    private WebDriver driver;

    public Hooks() {
        this.driver = new FirefoxDriver();
    }

    @Before
    public void setUp() {
        this.driver.manage().window().setSize(new Dimension(1440, 900));
        this.driver.get("https://www.wikipedia.org/");
    }

    @After
    public void tearDown() {
        if(this.driver != null) {
            this.driver.quit();
        }
    }
}
