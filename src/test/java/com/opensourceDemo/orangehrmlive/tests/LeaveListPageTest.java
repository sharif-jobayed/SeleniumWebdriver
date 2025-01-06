package com.opensourceDemo.orangehrmlive.tests;

import com.opensourceDemo.orangehrmlive.framework.BaseTest;
import com.opensourceDemo.orangehrmlive.pages.LeaveListPage;
import org.testng.annotations.Test;

public class LeaveListPageTest extends BaseTest {
    @Test
    public void goToApplyForLeavePage() {
        if (new LeaveListPage().isPageOpen(this.BASE_URL + "leave/viewLeaveList")) {
            new LeaveListPage()
                    .clickApplyBtn()
                    .isPageOpen(this.BASE_URL + "leave/applyLeave")
            ;
        }
    }
}
