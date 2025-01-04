package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private By activePageLink;
    private By leaveListLink;

    public DashboardPage() {
        this.activePageLink = By.xpath("//span[normalize-space()='Dashboard']");
        this.leaveListLink = By.xpath("//span[normalize-space()='Leave']");
    }

    public String getActivePageName() {
        return this.getText(this.activePageLink);
    }

    public LeaveListPage clickLeaveListLink() {
        this.isVisible(this.leaveListLink, 10);
        this.doClick(this.leaveListLink);
        return new LeaveListPage();
    }
}
