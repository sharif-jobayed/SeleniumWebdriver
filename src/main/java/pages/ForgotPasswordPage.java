package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import org.openqa.selenium.By;

public class ForgotPasswordPage extends BasePage {
    private final BaseElement USERNAME_INPUT_FIELD;
    private final BaseElement RESET_PW_BTN;

    public ForgotPasswordPage(DriverTools driverTools, String path, String pageName) {
        super(driverTools, path, pageName);

        this.USERNAME_INPUT_FIELD = new BaseElement(
                this.driverTools,
                By.xpath("//input[@placeholder='Username']")
        );
        this.RESET_PW_BTN = new BaseElement(
                this.driverTools,
                By.xpath("//button[@type='submit']")
        );

    }

    public ForgotPasswordPage enterUsername() {
        this.USERNAME_INPUT_FIELD.clearAndType("Admin");
        return this;
    }

    public SentPWResetPage clickResetPwBtn() {
        this.RESET_PW_BTN.doClick();
        return this.getPages().getSentPWResetPage();
    }
}
