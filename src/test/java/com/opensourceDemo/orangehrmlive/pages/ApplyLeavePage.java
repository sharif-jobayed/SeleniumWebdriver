package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.getActions;

public class ApplyLeavePage extends BasePage {
    private By leaveTypeDropdownArrow;
    private By leaveTypeField;
    private By leaveTypeDropdownList;
    private By leaveType;

    public ApplyLeavePage() {
        this.leaveTypeDropdownArrow = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
        this.leaveTypeField = By.xpath("//div[@class='oxd-select-text-input']");
        this.leaveTypeDropdownList = By.xpath("//div[@role='listbox']");
        this.leaveType = By.xpath("//div[@role='option'][2]");
    }

    public ApplyLeavePage selectLeaveType() {
        if(this.isVisible(this.leaveTypeDropdownArrow, 5)) {
            try {
                this.doClick(this.leaveTypeDropdownArrow);
                this.isVisible(this.leaveTypeDropdownList, 5);
                this.doClick(this.leaveType);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return this;
    }

    public String getSelectedLeaveType() {
        this.isVisible(this.leaveTypeField, 5);
        return this.getText(this.leaveTypeField);
    }
}
