package tests;

import framework.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeaveListPage;

public class LeaveListPageTest extends BaseTest {

    @Test(
            priority = 1,
            description = "Verify that a leave application can not be made as no leave balance is available",
            dependsOnMethods = {"tests.DashboardPageTest.appLanguageIsEnglish"}
    )
    public void isNoLeaveBalanceAvailable() {
        DashboardPage dashboardPage = this.getPages().getDashboardPage();
        LeaveListPage leaveListPage = this.getPages().getLeaveListPage();

        if(dashboardPage.isPageOpen(1)) {
            dashboardPage.isPageLoaded(3);
            dashboardPage.clickLeaveMenuItm();

            leaveListPage.isPageOpen(1);
            leaveListPage.isPageLoaded(3);
        }
    }

}
