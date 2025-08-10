package framework;

import pages.*;

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

    public ForgotPasswordPage getForgotPasswordPage() {
        return new ForgotPasswordPage(
                this.driverTools,
                "/auth/requestPasswordResetCode",
                "Forgot password page"
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

    public SentPWResetPage getSentPWResetPage() {
        return new SentPWResetPage(
                this.driverTools,
                "/auth/sendPasswordReset",
                "Sent password reset page"
        );
    }
}
