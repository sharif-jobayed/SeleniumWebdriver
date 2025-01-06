package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import org.openqa.selenium.By;

public class ApplyLeavePage extends BasePage {
    private By noAvailableLeave;
    private By leaveTypeDropdownArrow;
    private By leaveTypeField;
    private By leaveTypeDropdownList;
    private By leaveType;
    private By fromDateField;
    private By toDateField;

    public ApplyLeavePage() {
        this.noAvailableLeave = By.xpath("//p[normalize-space()='No Leave Types with Leave Balance']");
        this.leaveTypeDropdownArrow = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
        this.leaveTypeField = By.xpath("//div[@class='oxd-select-text-input']");
        this.leaveTypeDropdownList = By.xpath("//div[@role='listbox']");
        this.leaveType = By.xpath("//div[@role='option'][2]");
        this.fromDateField = By.xpath("//input[@class='oxd-input oxd-input--focus']");
        this.toDateField = By.xpath("//input[@class='oxd-input oxd-input--focus']");
    }

    public Boolean isNoLeaveApplicable() {
        this.isVisible(this.noAvailableLeave, 5);
        return this.textOf(this.noAvailableLeave).equals("No Leave Types with Leave Balance");
    }

    public ApplyLeavePage selectLeaveType() {
        if (this.isVisible(this.leaveTypeDropdownArrow, 5)) {
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
        return this.textOf(this.leaveTypeField);
    }

    public ApplyLeavePage selectFromDate() {
        if (this.isEnabled(this.fromDateField)) {
            this.doClick(this.fromDateField);
            this.clearAndType("2025-31-05", this.fromDateField);
        }
        return this;
    }

    public String getFromDate() {
        return this.textOf(this.fromDateField);
    }

    public ApplyLeavePage selectToDate() {
        if (this.isEnabled(this.toDateField)) {
            this.doClick(this.toDateField);
            this.clearAndType("2025-05-06", this.toDateField);
        }
        return this;
    }

    public String getToDate() {
        return this.textOf(this.toDateField);
    }
}
