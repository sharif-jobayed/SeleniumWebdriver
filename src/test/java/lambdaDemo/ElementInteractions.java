package lambdaDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementInteractions extends BaseTest {

    private int firstNumber = 325;
    private int seconNumber = 238;

    @Test()
    public void myTest() {
        String title = this.driver.getTitle();
        System.out.println(title);

        WebElement simpleFormDemoLink = this.driver.findElement(By.xpath("//a[normalize-space()='Simple Form Demo']"));
        simpleFormDemoLink.click();

        WebElement firstField = this.driver.findElement(By.xpath("//input[@id='sum1']"));
        firstField.sendKeys(String.valueOf(this.firstNumber));
        WebElement secondField = this.driver.findElement(By.xpath("//input[@id='sum2']"));
        secondField.sendKeys(String.valueOf(this.seconNumber));
        WebElement getValuesButton = this.driver.findElement(By.xpath("//button[normalize-space()='Get Sum']"));
        getValuesButton.click();

        WebElement result = this.driver.findElement(By.xpath("//p[@id='addmessage']"));
        Assert.assertEquals(result.getText(), String.valueOf(this.firstNumber + this.seconNumber), "The sum is not correct");
    }

}
