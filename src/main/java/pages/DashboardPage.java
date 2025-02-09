package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final By PROFILE_ITM;
    private final By PAGE_HEADER_TITLE;
    private final By LEAVE_MENU_ITM;

    public DashboardPage(WebDriver driver) {
        super(driver);

        this.PROFILE_ITM = By.xpath("//li[@class='oxd-userdropdown']");
        this.PAGE_HEADER_TITLE = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
        this.LEAVE_MENU_ITM = By.xpath("//span[normalize-space()='Leave']");
    }

    public Boolean isDashboardPageOpen() {
        this.isPageOpen(5);
        return this.isPageLoaded(5);
    }

    public String getPageTitleHeaderText() {
        System.out.println(this.itsText(this.PAGE_HEADER_TITLE));
        return this.itsText(this.PAGE_HEADER_TITLE);
    }

    public ViewLeaveListPage clickViewLeaveList() {
        this.doClick(this.LEAVE_MENU_ITM);
        return this.getPageInstance(ViewLeaveListPage.class);
    }

}
