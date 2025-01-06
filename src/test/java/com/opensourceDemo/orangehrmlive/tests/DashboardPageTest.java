package com.opensourceDemo.orangehrmlive.tests;

import com.opensourceDemo.orangehrmlive.framework.BaseTest;
import com.opensourceDemo.orangehrmlive.pages.DashboardPage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {
    @Test
    @Step("I am on the 'Leave List' page")
    public void navigateToLeavePage() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage
                .clickLeaveListLink()
                .isPageOpen(this.BASE_URL + "leave/viewLeaveList")
        ;
    }
}
