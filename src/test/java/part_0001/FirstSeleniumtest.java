package part_0001;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumtest {
    private WebDriver driver;

    @BeforeClass
    protected void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterClass
    protected void tearDown() {
        driver.quit();
    }

    @Test
    protected void testLoggingInToApplication() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
        usernameField.sendKeys("Admin");

        WebElement passwordField = driver.findElement(By.xpath("//input[@name='password']"));
        passwordField.sendKeys("admin123");

        WebElement loginBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
        loginBtn.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String actualResult = driver.findElement(By.xpath("//h6[normalize-space()='Dashboard']")).getText();
        String expectedResult = "Dashboard";
        Assert.assertEquals(actualResult, expectedResult, expectedResult + " page is not open yet.");
    }
}
