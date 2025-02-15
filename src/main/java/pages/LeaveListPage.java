package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import org.openqa.selenium.By;

public class LeaveListPage extends BasePage {
    private final BaseElement LEAVE_RECORDS;
    private final BaseElement APPLY_TAB;

    public LeaveListPage(DriverTools driverTools, String path, String pageName) {
        super(driverTools, path, pageName);

        this.LEAVE_RECORDS = new BaseElement(
                this.driverTools,
                By.xpath("//div[@class='orangehrm-paper-container']")
        );
        this.APPLY_TAB = new BaseElement(
                this.driverTools,
                By.xpath("//a[normalize-space()='Apply']")
        );
    }

    public Boolean areLeaveRecordsVisible() {
        return this.LEAVE_RECORDS.isVisible(2);
    }

    public ApplyLeavePage clickApplyTab() {
        this.APPLY_TAB.doClick();
        return this.getPages().getApplyLeavePage();
    }

}
