package com.opensourceDemo.orangehrmlive.framework;

import com.opensourceDemo.orangehrmlive.framework.utils.DriverTools;
import org.openqa.selenium.Dimension;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.getDriver;

public class BaseTest {
    protected final String BASE_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/";
    @BeforeTest
    public void setUp() {
        new DriverTools("Edge");
        getDriver()
                .manage()
                .window()
                .setSize(new Dimension(1440, 900));
        getDriver().get(this.BASE_URL);
    }

    @AfterTest
    public void tearDown() {
        if(getDriver() != null) {
            getDriver().quit();
        }
    }
}
