package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private By leaveListLink;

    public DashboardPage() {
        this.leaveListLink = By.xpath("//span[normalize-space()='Leave']");
    }

    public LeaveListPage clickLeaveListLink() {
        this.isVisible(this.leaveListLink, 10);
        this.doClick(this.leaveListLink);
        return new LeaveListPage();
    }
}
