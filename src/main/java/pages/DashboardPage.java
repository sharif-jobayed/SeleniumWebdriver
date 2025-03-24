package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private final BaseElement HEADER_TITLE;
    private final BaseElement LEAVE_MENU_ITEM;
    private final BaseElement PROFILE_ITEM;
    private final BaseElement PROFILE_DROPDOWN_ARROW;
    private final BaseElement PROFILE_DROPDOWN_MENU;
    private final BaseElement LOGOUT_LINK;
    private final BaseElement EDSU_HEADER;
    private final BaseElement EDSU_PIE_CHART;
    private final BaseElement EDL;

    public DashboardPage(DriverTools driverTools, String path, String pageName) {
        super(driverTools, path, pageName);

        this.HEADER_TITLE = new BaseElement(
                this.driverTools,
                By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
        );
        this.LEAVE_MENU_ITEM = new BaseElement(
                this.driverTools,
                By.xpath("//span[normalize-space()='Leave']")
        );
        this.PROFILE_ITEM = new BaseElement(
                this.driverTools,
                By.xpath("//img[@class='oxd-userdropdown-img']")
        );
        this.PROFILE_DROPDOWN_ARROW = new BaseElement(
                this.driverTools,
                By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
        );
        this.PROFILE_DROPDOWN_MENU = new BaseElement(
                this.driverTools,
                By.xpath("//ul[@role='menu']")
        );
        this.LOGOUT_LINK = new BaseElement(
                this.driverTools,
                By.xpath("//a[normalize-space()='Logout']")
        );
        this.EDSU_HEADER = new BaseElement(
                this.driverTools,
                By.xpath("//p[normalize-space()='Employee Distribution by Sub Unit']")
        );
        this.EDSU_PIE_CHART = new BaseElement(
                this.driverTools,
                By.xpath("(//div[@class='oxd-pie-chart'])[1]")
        );
        this.EDL = new BaseElement(
                this.driverTools,
                By.xpath("//p[normalize-space()='Employee Distribution by Location']")
        );
    }

    @Step("Get the application header title")
    public String getApplicationHeaderTitle() {
        this.HEADER_TITLE.waitTillPresence(5);
        return this.HEADER_TITLE.extractText();
    }

    @Step("Verify that the Profile Item visible")
    public Boolean isProfileItemVisible() {
        return this.PROFILE_ITEM.isVisible(10);
    }

    @Step("Click the profile dropdown arrow")
    public DashboardPage clickProfileDropdownArrow() {
        this.PROFILE_DROPDOWN_ARROW.doClick();
        return this;
    }

    @Step("Verify that the profile dropdown menu is visible")
    public Boolean isProfileDropdownMenuVisible() {
        return this.PROFILE_DROPDOWN_MENU.isVisible(3);
    }

    @Step("Click the logout link")
    public LoginPage clickLogoutLink() {
        this.LOGOUT_LINK.doClick();
        return this.getPages().getLoginPage();
    }

    @Step(value = "Logout from the application")
    public LoginPage logout() {
        LoginPage loginPage = this.getPages().getLoginPage();

        if (!loginPage.isPageOpen(3)) {
            this.clickProfileDropdownArrow();
            if (this.isProfileDropdownMenuVisible()) {
                this.clickLogoutLink();
                loginPage.isPageOpen(3);
                return loginPage;
            }
        }

        throw new RuntimeException("Log out wasn't successful");
    }

    @Step("Click the leave menu item on the left-sidebar")
    public LeaveListPage clickLeaveMenuItm() {
        this.LEAVE_MENU_ITEM.doClick();
        return this.getPages().getLeaveListPage();
    }

    @Step("Verify that the EDSU Header is visible")
    public Boolean isEDSUHeaderVisible() {
        return this.EDSU_HEADER.isVisible(3);
    }

    @Step("Verify that the EDSU Pie Chart is visible")
    public Boolean isEDSUPieChartVisible() {
        return this.EDSU_PIE_CHART.isVisible(3);
    }

    @Step("Hover on the EDSU Pie Chart")
    public DashboardPage hoverOnTheEDSUPieChart() {
        if (this.isEDSUPieChartVisible()) {
            try {
                this.EDSU_PIE_CHART.hoverOn();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            this.EDSU_PIE_CHART.scrollIntoView();
            this.EDSU_PIE_CHART.hoverOn();
        }
        return this;
    }

    @Step("Scroll to EDL")
    public Boolean isEDLVisible() {
        this.EDL.scrollIntoView();
        return this.EDL.isVisible(3);
    }

}
