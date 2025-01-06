package com.opensourceDemo.orangehrmlive.tests;

import com.opensourceDemo.orangehrmlive.framework.BaseTest;
import com.opensourceDemo.orangehrmlive.pages.ApplyLeavePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyLeavePageTest extends BaseTest {
    private ApplyLeavePage applyLeavePage;

    @Test
    public void applyForALeave() {
        applyLeavePage = new ApplyLeavePage();

        if (this.applyLeavePage.isPageLoaded()) {
            try {
                this.applyLeavePage.selectLeaveType();
                Assert.assertEquals(this.applyLeavePage.getSelectedLeaveType(), "CAN - Vacation", "Selected leave type does't match");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
