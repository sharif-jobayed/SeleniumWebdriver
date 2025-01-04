package com.opensourceDemo.orangehrmlive.tests;

import com.opensourceDemo.orangehrmlive.framework.BaseTest;
import com.opensourceDemo.orangehrmlive.pages.DashboardPage;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {
    @Test
    public void navigateToLeavePage() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.clickLeaveListLink()
                .isPageOpen(this.BASE_URL+"leave/viewLeaveList", 5)
        ;
    }
}
