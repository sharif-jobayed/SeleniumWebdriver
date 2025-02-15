package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final BaseElement LOGIN_FORM;
    private final BaseElement USERNAME_FIELD;
    private final BaseElement PASSWORD_FIELD;
    private final BaseElement LOGIN_BTN;
    private final BaseElement WRONG_INPUT_ERROR;
    private final BaseElement BANNER_LOGO;

    public LoginPage(DriverTools driverTools, String path, String pageName) {
        super(driverTools, path, pageName);


        this.LOGIN_FORM = new BaseElement(
                this.driverTools,
                By.xpath("//form[@method='post']")
        );
        this.USERNAME_FIELD = new BaseElement(
                this.driverTools,
                By.xpath("//input[@name='username']")
        );
        this.PASSWORD_FIELD = new BaseElement(
                this.driverTools,
                By.xpath("//input[@name='password']")
        );
        this.LOGIN_BTN = new BaseElement(
                this.driverTools,
                By.xpath("//button[@type='submit']")
        );
        this.WRONG_INPUT_ERROR = new BaseElement(
                this.driverTools,
                By.xpath("//div[@role='alert']//p[normalize-space()='Invalid credentials']")
        );
        this.BANNER_LOGO = new BaseElement(
                this.driverTools,
                By.xpath("//img[@alt='company-branding']")
        );
    }

    public Boolean isBannerLogoVisible() {
        return this.BANNER_LOGO.isVisible(5);
    }

    public Boolean isInputWrong() {
        return this.WRONG_INPUT_ERROR.isVisible(2);
    }

    public LoginPage enterUsername(String text) {
        this.USERNAME_FIELD.clearAndType(text);
        return this;
    }

    public LoginPage enterPassword(String text) {
        this.PASSWORD_FIELD.clearAndType(text);
        return this;
    }

    public DashboardPage clickLoginBtn() {
        this.LOGIN_BTN.doClick();
        return this.getPages().getDashboardPage();
    }

    public DashboardPage login(String username, String password) {
        if (this.LOGIN_FORM.isVisible(3) && this.USERNAME_FIELD.isActive(2) && this.PASSWORD_FIELD.isActive(2)) {
            this.enterUsername(username);
            this.enterPassword(password);
            return this.clickLoginBtn();
        } else {
            throw new RuntimeException("The login is not successful");
        }
    }

}
