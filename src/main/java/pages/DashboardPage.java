package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private final BaseElement HEADER_TITLE;
    private final BaseElement LEAVE_MENU_ITEM;
    private final BaseElement PROFILE_DROPDOWN_ARROW;
    private final BaseElement PROFILE_DROPDOWN_MENU;
    private final BaseElement LOGOUT_LINK;


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
    }

    public String getApplicationHeaderTitle() {
        this.HEADER_TITLE.waitTillPresence(5);
        return this.HEADER_TITLE.text();
    }

    public DashboardPage clickProfileDropdownArrow() {
        this.PROFILE_DROPDOWN_ARROW.doClick();
        return this;
    }

    public Boolean isProfileDropdownMenuVisible() {
        return this.PROFILE_DROPDOWN_MENU.isVisible(3);
    }

    public LoginPage clickLogoutLink() {
        this.LOGOUT_LINK.doClick();
        return this.getPages().getLoginPage();
    }

    public LoginPage logout() {
        LoginPage loginPage = this.getPages().getLoginPage();

        if (!loginPage.isPageOpen(3)) {
            this.clickProfileDropdownArrow();
            if (this.isProfileDropdownMenuVisible()) {
                this.clickLogoutLink();
            }
        }

        return null;
    }

    public LeaveListPage clickLeaveMenuItm() {
        this.LEAVE_MENU_ITEM.doClick();
        return this.getPages().getLeaveListPage();
    }

}
