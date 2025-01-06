package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.opensourceDemo.orangehrmlive.framework.utils.DriverTools.getXWait;

public class LeaveListPage extends BasePage {
    private By applyBtn;

    public LeaveListPage() {
        this.applyBtn = By.xpath("//a[normalize-space()='Apply']");
    }

    public ApplyLeavePage clickApplyBtn() {
        getXWait(5).until(ExpectedConditions.visibilityOfElementLocated(this.applyBtn));
        this.doClick(this.applyBtn);
        return new ApplyLeavePage();
    }
}
