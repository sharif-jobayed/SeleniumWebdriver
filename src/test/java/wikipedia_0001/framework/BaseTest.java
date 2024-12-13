package wikipedia_0001.framework;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Dimension;
import wikipedia_0001.framework.utils.DriverTools;

public class BaseTest {
    private DriverTools driverTools;

    public BaseTest() {
        this.driverTools = new DriverTools("Firefox");
    }

    public DriverTools getDriverTools() {
        return this.driverTools;
    }

    @Before
    protected void setUp() {
        this.driverTools.getDriver().manage().window().setSize(new Dimension(1440, 900));
        this.driverTools.getDriver().get("https://www.wikipedia.org/");
    }

    @After
    protected void tearDown() {
        this.driverTools.getDriver().quit();
    }
}
