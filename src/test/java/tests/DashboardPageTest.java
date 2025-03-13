package tests;

import framework.BaseTest;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeaveListPage;

public class DashboardPageTest extends BaseTest {
    protected DashboardPage dashboardPage;
    protected LeaveListPage leaveListPage;

    @Test(
            priority = 1,
            description = "Validate that, the profile item is visible on the page"
    )
    public void validateThatTheProfileItemIsVisibleOnThePage() {}

    @Test(
            priority = 2,
            description = "Hover on the pivot table under the `Employee Distribution by Sub Unit` module"
    )
    public void hoverOnThePivotTableUnderTheEmployeeDistributionBySubUnitModule() {}

    @Test(
            priority = 3,
            description = "Check if the Time at Work widget is displayed"
    )
    public void checkIfTheTimeAtWorkWidgetIsDisplayed() {}

    @Test(
            priority = 4,
            description = "Check if the My Actions widget is displayed"
    )
    public void checkIfTheMyActionsWidgetIsDisplayed() {}

    @Test(
            priority = 5,
            description = "Check if the Quick Launch widget is displayed"
    )
    public void checkIfTheQuickLaunchWidgetIsDisplayed() {}

    @Test(
            priority = 6,
            description = "Check if the Buzz Latest Posts widget is displayed"
    )
    public void checkIfTheBuzzLatestPostsWidgetIsDisplayed() {}

    @Test(
            priority = 7,
            description = "Check if the Employees on Leave Today widget is displayed"
    )
    public void checkIfTheEmployeesOnLeaveTodayWidgetIsDisplayed() {}

    @Test(
            priority = 8,
            description = "Check if the Employee Distribution by Sub Unit widget is displayed"
    )
    public void checkIfTheEmployeeDistributionBySubUnitWidgetIsDisplayed() {}

    @Test(
            priority = 9,
            description = "Check if the Employee Distribution by Location widget is displayed"
    )
    public void checkIfTheEmployeeDistributionByLocationWidgetIsDisplayed() {}


    @Test(
            priority = 10,
            description = "Open & close the profile menu"
    )
    public void openAndCloseTheProfileMenu() {}
}
