package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {
    private final BaseElement HEADER_TITLE;
    private final BaseElement LEAVE_MENU_ITEM;

    public DashboardPage(DriverTools driverTools) {
        super(driverTools);

        this.HEADER_TITLE = new BaseElement(
                this.driverTools,
                By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
        );
        this.LEAVE_MENU_ITEM = new BaseElement(
                this.driverTools,
                By.xpath("//span[normalize-space()='Leave']")
        );
    }

}
