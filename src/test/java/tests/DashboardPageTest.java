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
        Assert.assertTrue(this.dashboardPage.isProfileItemVisible(), "The profile item is not visible");

        this.dashboardPage.logout();
        Assert.assertTrue(this.getPages().getLoginPage().isPageOpen(3), "The login page is not open");
    }

    @Test(
            priority = 2,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Hover on the pivot table under the `Employee Distribution by Sub Unit` module"
    )
    public void hoverOnThePivotTableUnderTheEmployeeDistributionBySubUnitModule() {
        this.dashboardPage = this.getPages().getDashboardPage();

    }

    @Test(
            priority = 3,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Time at Work widget is displayed"
    )
    public void checkIfTheTimeAtWorkWidgetIsDisplayed() {
    }

    @Test(
            priority = 4,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the My Actions widget is displayed"
    )
    public void checkIfTheMyActionsWidgetIsDisplayed() {
    }

    @Test(
            priority = 5,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Quick Launch widget is displayed"
    )
    public void checkIfTheQuickLaunchWidgetIsDisplayed() {
    }

    @Test(
            priority = 6,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Buzz Latest Posts widget is displayed"
    )
    public void checkIfTheBuzzLatestPostsWidgetIsDisplayed() {
    }

    @Test(
            priority = 7,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Employees on Leave Today widget is displayed"
    )
    public void checkIfTheEmployeesOnLeaveTodayWidgetIsDisplayed() {
    }

    @Test(
            priority = 8,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Employee Distribution by Sub Unit widget is displayed"
    )
    public void checkIfTheEmployeeDistributionBySubUnitWidgetIsDisplayed() {
    }

    @Test(
            priority = 9,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Check if the Employee Distribution by Location widget is displayed"
    )
    public void checkIfTheEmployeeDistributionByLocationWidgetIsDisplayed() {
    }


    @Test(
            priority = 10,
            dependsOnMethods = {"tests.LoginPageTest.loginUsingValidCredentials"},
            description = "Open & close the profile menu"
    )
    public void openAndCloseTheProfileMenu() {
    }
}
