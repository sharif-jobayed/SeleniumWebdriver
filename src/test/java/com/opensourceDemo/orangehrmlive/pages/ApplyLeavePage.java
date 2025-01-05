package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.getDriver;

public class ApplyLeavePage extends BasePage {
    private By leaveTypeArrow;
    private Select leaveTypeSelection;
    private By leaveTypeDropdown;
    private By leaveTypeItem;
    private By fromDate;
    private By toDate;
    private By applyBtn;

    public ApplyLeavePage() {
        this.leaveTypeArrow = By.xpath("//div[@class='oxd-select-text-input']");
        this.leaveTypeSelection = new Select(getDriver().findElement(By.xpath("//div[@class='oxd-select-text-input']")));
        this.leaveTypeDropdown = By.xpath("");
    }
}
