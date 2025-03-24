package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import org.openqa.selenium.By;

public class SentPWResetPage extends BasePage {
    private final BaseElement SENT_LINK_CONFIRMATION;

    public SentPWResetPage(DriverTools driverTools, String path, String pageName) {
        super(driverTools, path, pageName);

        this.SENT_LINK_CONFIRMATION = new BaseElement(
                this.driverTools,
                By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']")
        );
    }

    public String getSentLinkConfirmationText() {
        return this.SENT_LINK_CONFIRMATION.extractText();
    }
}
