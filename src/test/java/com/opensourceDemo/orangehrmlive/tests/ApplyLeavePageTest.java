package com.opensourceDemo.orangehrmlive.tests;

import com.opensourceDemo.orangehrmlive.framework.BaseTest;
import com.opensourceDemo.orangehrmlive.pages.ApplyLeavePage;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class ApplyLeavePageTest extends BaseTest {
    private ApplyLeavePage applyLeavePage;

    @Test
    public void applyForALeave() {
        applyLeavePage = new ApplyLeavePage();

        if (this.applyLeavePage.isPageLoaded() && !this.applyLeavePage.isNoLeaveApplicable()) {
            try {
                this.applyLeavePage.selectLeaveType();
                Assert.assertEquals(this.applyLeavePage.getSelectedLeaveType(), "US - Vacation", "Selected leave type does't match");

                this.applyLeavePage.selectFromDate();
                Assert.assertEquals(this.applyLeavePage.getFromDateFld(), "2025-11-02", "From date does not match");

                this.applyLeavePage.selectToDate();
                Assert.assertEquals(this.applyLeavePage.getToDateFld(), "2025-17-02", "To date does not match");

                this.applyLeavePage.writeComments();

                this.applyLeavePage.clickApply();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new SkipException("Test ignored due to no available leave");
        }
    }
}
