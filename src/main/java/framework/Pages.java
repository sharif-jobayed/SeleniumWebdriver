package framework;

import pages.ApplyLeavePage;
import pages.DashboardPage;
import pages.LeaveListPage;
import pages.LoginPage;

public class Pages {
    DriverTools driverTools;

    public Pages(DriverTools driverTools) {
        this.driverTools = driverTools;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(
                this.driverTools,
                "/auth/login",
                "Login page"
        );
    }

    public DashboardPage getDashboardPage() {
        return new DashboardPage(
                this.driverTools,
                "/dashboard/index",
                "Dashboard page"
        );
    }

    public LeaveListPage getLeaveListPage() {
        return new LeaveListPage(
                this.driverTools,
                "/leave/viewLeaveList",
                "Leave list page"
        );
    }

    public ApplyLeavePage getApplyLeavePage() {
        return new ApplyLeavePage(
                this.driverTools,
                "/leave/applyLeave",
                "Apply leave page"
        );
    }

}
