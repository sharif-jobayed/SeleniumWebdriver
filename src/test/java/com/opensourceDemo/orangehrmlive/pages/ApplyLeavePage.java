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
    private By fromDate;
    private By toDate;
    private By commentsArea;
    private By applyBtn;

    public ApplyLeavePage() {
        this.noAvailableLeave = By.xpath("//p[normalize-space()='No Leave Types with Leave Balance']");

        this.leaveTypeField = By.xpath("//div[@class='oxd-select-text-input']");
        this.leaveTypeDropdownArrow = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
        this.leaveTypeDropdownList = By.xpath("//div[@role='listbox']");
        this.leaveTypes = By.xpath("//div[@role='option']/span");

        this.fromDate = By.xpath("//label[normalize-space()='From Date']/following::input[@placeholder='yyyy-dd-mm'][1]");
        this.toDate = By.xpath("//label[normalize-space()='To Date']/following::input[@placeholder='yyyy-dd-mm'][1]");

        this.commentsArea = By.xpath("//textarea[@spellcheck='false']");

        this.applyBtn = By.xpath("//button[@type='submit']");
    }

    public Boolean isNoLeaveApplicable() {
        this.isVisible(this.noAvailableLeave, 2);
        return this.isThere(this.noAvailableLeave);
    }

    public void selectLeaveType() {
        if (this.isThere(this.leaveTypeDropdownArrow)) {
            try {
                this.doClick(this.leaveTypeDropdownArrow);
                this.isVisible(this.leaveTypeDropdownList, 5);
                this.clickByText("US - Vacation", this.leaveTypes);
                this.waitTillInvisible(this.leaveTypeDropdownList, 10);
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
        this.clearAndType("2025-11-06", this.fromDate);
    }

    public String getFromDate() {
        return (String) getJS().executeScript("return arguments[0].value;", this.getElement(this.fromDate));
    }

    public void selectToDate() {
        System.out.println("To Date (Before Typing): " + this.getElement(this.toDate).getAttribute("value"));


        this.clearAndType("2025-17-06", this.toDate);

        System.out.println("To Date (After Typing): " + this.getElement(this.toDate).getAttribute("value"));

    }

    public String getToDate() {
        return (String) getJS().executeScript("return arguments[0].value;", this.getElement(this.toDate));
    }

    public void writeComments() {
        this.clearAndType("Demo comment...", this.commentsArea);
    }

    public void clickApply() {
        this.doClick(this.applyBtn);
    }
}
