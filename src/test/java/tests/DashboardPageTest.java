package tests;

import framework.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeaveListPage;

public class DashboardPageTest extends BaseTest {
    protected DashboardPage dashboardPage;
    protected LeaveListPage leaveListPage;

    @Test(
            priority = 1,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials",},
            description = "Validate that, the profile item is visible on the page"
    )
    public void validateThatTheProfileItemIsVisibleOnThePage() {
        this.dashboardPage = this.getPages().getDashboardPage();
        this.dashboardPage.isPageOpen(3);
        this.dashboardPage.isPageLoaded(5);
        Assert.assertTrue(this.dashboardPage.isProfileItemVisible(), "The profile item is not visible");
    }

    @Test(
            priority = 2,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Hover on the pivot table under the `Employee Distribution by Sub Unit` module"
    )
    public void hoverOnThePivotTableUnderTheEmployeeDistributionBySubUnitModule() {
        this.dashboardPage = this.getPages().getDashboardPage();
        this.dashboardPage.hoverOnTheEDSUPieChart();
        Assert.assertTrue(this.dashboardPage.isEDSUHeaderVisible(), "The EDSU Header is not visible");
    }

    @Test(
            priority = 3,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Time at Work widget is displayed"
    )
    public void checkIfTheTimeAtWorkWidgetIsDisplayed() {
        // To be done...
    }

    @Test(
            priority = 4,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the My Actions widget is displayed"
    )
    public void checkIfTheMyActionsWidgetIsDisplayed() {
        // To be done...
    }

    @Test(
            priority = 5,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Quick Launch widget is displayed"
    )
    public void checkIfTheQuickLaunchWidgetIsDisplayed() {
        // To be done...
    }

    @Test(
            priority = 6,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Buzz Latest Posts widget is displayed"
    )
    public void checkIfTheBuzzLatestPostsWidgetIsDisplayed() {
        // To be done...
    }

    @Test(
            priority = 7,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Employees on Leave Today widget is displayed"
    )
    public void checkIfTheEmployeesOnLeaveTodayWidgetIsDisplayed() {
        // To be done...
    }

    @Test(
            priority = 8,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Employee Distribution by Sub Unit widget is displayed"
    )
    public void checkIfTheEmployeeDistributionBySubUnitWidgetIsDisplayed() {
        this.dashboardPage = this.getPages().getDashboardPage();
        Assert.assertTrue(this.dashboardPage.isEDSUPieChartVisible(), "The EDSU Pie Chart is not visible");
    }

    @Test(
            priority = 9,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Employee Distribution by Location widget is displayed"
    )
    public void checkIfTheEmployeeDistributionByLocationWidgetIsDisplayed() {
        this.dashboardPage = this.getPages().getDashboardPage();
        Assert.assertTrue(this.dashboardPage.isEDLVisible(), "The EDL is not visible");
    }


    @Test(
            priority = 10,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Open & close the profile menu"
    )
    public void openAndCloseTheProfileMenu() {
        // To be done...
    }
}
