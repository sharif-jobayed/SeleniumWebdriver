package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import org.openqa.selenium.By;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.getJS;

public class ApplyLeavePage extends BasePage {
    private By noAvailableLeave;
    private By leaveTypeDropdownArrow;
    private By leaveTypeField;
    private By leaveTypeDropdownList;
    private By leaveTypes;
    private By fromDateFld;
    private By toDateFld;
    private By commentsArea;
    private By applyBtn;

    public ApplyLeavePage() {
        this.noAvailableLeave = By.xpath("//p[normalize-space()='No Leave Types with Leave Balance']");

        this.leaveTypeField = By.xpath("//div[@class='oxd-select-text-input']");
        this.leaveTypeDropdownArrow = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
        this.leaveTypeDropdownList = By.xpath("//div[@role='listbox']");
        this.leaveTypes = By.xpath("//div[@role='option']/span");

        this.fromDateFld = By.xpath("//label[normalize-space()='From Date']/following::input[@placeholder='yyyy-dd-mm'][1]");
        this.toDateFld = By.xpath("//label[normalize-space()='To Date']/following::input[@placeholder='yyyy-dd-mm'][1]");

        this.commentsArea = By.xpath("//textarea[@spellcheck='false']");

        this.applyBtn = By.xpath("//button[@type='submit']");
    }

    public Boolean isNoLeaveApplicable() {
        return this.isThere(this.noAvailableLeave);
    }

    public void selectLeaveType() {
        if (this.isThere(this.leaveTypeDropdownArrow)) {
            try {
                this.doClick(this.leaveTypeDropdownArrow);
                this.isVisible(this.leaveTypeDropdownList, 5);
                this.clickByText("US - Vacation", this.leaveTypes);
                this.isVisible(this.leaveTypeDropdownList, 10);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

    public String getSelectedLeaveType() {
        this.isVisible(this.leaveTypeField, 5);
        return this.textOf(this.leaveTypeField);
    }

    public void selectFromDate() {
        this.clearAndType("2025-11-02", this.fromDateFld);
    }

    public String getFromDateFld() {
        if (this.isEnabled(this.fromDateFld)) {
            return (String) getJS().executeScript("return arguments[0].value;", this.getElement(this.fromDateFld));
        }
        return null;
    }

    public void selectToDate() {
        this.clearAndType("2025-17-02", this.toDateFld);
    }

    public String getToDateFld() {
        if (this.isEnabled(this.toDateFld)) {
            return (String) getJS().executeScript("return arguments[0].value;", this.getElement(this.toDateFld));
        }
        return null;
    }

    public void writeComments() {
        this.clearAndType("Demo comment...", this.commentsArea);
    }

    public void clickApply() {
        this.doClick(this.applyBtn);
    }
}
