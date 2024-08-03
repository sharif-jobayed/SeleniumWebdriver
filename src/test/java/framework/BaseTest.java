package framework;

import data.Credentials;
import org.openqa.selenium.Dimension;
import org.testng.annotations.*;

import static framework.DriverTools.getDriver;

public class BaseTest {
    private final Credentials CREDENTIALS;

    public BaseTest() {
        new DriverTools("Edge");
        this.CREDENTIALS = new Credentials();
    }

    @BeforeMethod
    void setUp() {
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        getDriver().get(CREDENTIALS.getBASE_URL());
    }
//    @Test
//    void test() {
//        System.out.println("Test executed successfully!!");
//    }
    @AfterMethod
    void tearDown() {
        getDriver().close();
    }
}
