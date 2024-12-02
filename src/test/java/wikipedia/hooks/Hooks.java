package wikipedia.hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import wikipedia.utils.DataProcessor;
import wikipedia.utils.DriverTools;
import static io.qameta.allure.Allure.step;

public class Hooks {

    private Browser browser= AqualityServices.getBrowser();

    @Before
    public void setUp(){
//        browser.maximize();
        browser.setWindowSize(1440, 900);
        browser.goTo(DataProcessor.processedData().getURL());
    }

    @After
    public void tearDown(){
        browser.quit();
    }

}
