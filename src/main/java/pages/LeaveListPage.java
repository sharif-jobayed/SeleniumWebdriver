package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import org.openqa.selenium.By;

public class LeaveListPage extends BasePage {
    private final BaseElement LEAVE_RECORD_HEADER;
    private final BaseElement APPLY_BTN;

    public LeaveListPage(DriverTools driverTools, String path) {
        super(driverTools, path);

        this.LEAVE_RECORD_HEADER = new BaseElement(
                this.driverTools,
                By.xpath("//span[@class='oxd-text oxd-text--span']")
        );
        this.APPLY_BTN = new BaseElement(
                this.driverTools,
                By.xpath("//a[normalize-space()='Apply']")
        );
    }

}
