package lambdaDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleDropdowns extends BaseTest {

    private String singleDayOfWeek = "Friday";

    @Test(priority = 1)
    public void myTest() {
        WebElement selectDropdownListLink = this.driver.findElement(By.xpath("//a[normalize-space()='Select Dropdown List']"));
        selectDropdownListLink.click();

        WebElement selectOption = this.driver.findElement(By.xpath("//select[@id='select-demo']"));
        Select singleSelectionDD = new Select(selectOption);
        singleSelectionDD.selectByValue(this.singleDayOfWeek);
        WebElement singleDDselectionresult = this.driver.findElement(By.xpath("//p[@class='selected-value text-size-14']"));
        Assert.assertTrue(singleDDselectionresult.getText().contains(this.singleDayOfWeek), this.singleDayOfWeek + "is not selected");
    }

    @Test(priority = 2)
    public void myTest2() {
        WebElement multiSelectorDD = this.driver.findElement(By.xpath("//select[@id='multi-select']"));
        Select multiSelectionDD = new Select(multiSelectorDD);
        multiSelectionDD.selectByIndex(0);
        multiSelectionDD.selectByIndex(3);
    }

}
