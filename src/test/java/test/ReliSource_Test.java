package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ReliSource_Test {

    WebDriver driver = new ChromeDriver();
    WebDriverWait xWait = new WebDriverWait(driver, Duration.ofMillis(5000));
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    @BeforeMethod
    protected void setUp() {
        driver.manage().window().setSize(new Dimension(1440, 900));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    @Test(description = "Select Bangladesh from the country dropdown.")
    protected void test1() {
        WebElement countrySearchField = driver.findElement(By.xpath("//input[@id='autosuggest']"));
        countrySearchField.clear();
        countrySearchField.sendKeys("BAN");

        WebElement countriesDropdown = xWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id=\"ui-id-1\"]")));
        Assert.assertTrue(countriesDropdown.isDisplayed(), "The countries dropdown is not visible yet.");

        WebElement itemBD = driver.findElement(By.xpath("//a[@tabindex='-1'][normalize-space()='Bangladesh']"));
        itemBD.click();
        String inputText = (String) jsExecutor.executeScript("return arguments[0].value", countrySearchField);
        Assert.assertEquals(inputText, "Bangladesh", "The country input is not correct.");
    }

    @AfterMethod
    protected void tearDown() {
        driver.quit();
    }
}
