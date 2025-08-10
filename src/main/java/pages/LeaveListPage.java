package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import io.qameta.allure.Step;
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

    @Step("Verify that the leave records are visible")
    public Boolean areLeaveRecordsVisible() {
        return this.LEAVE_RECORDS.isVisible(2);
    }

    @Step(value = "Click the apply tab")
    public ApplyLeavePage clickApplyTab() {
        this.APPLY_TAB.doClick();
        return this.getPages().getApplyLeavePage();
    }

}
