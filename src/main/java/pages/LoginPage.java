package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final BaseElement LOGIN_FORM;
    private final BaseElement USERNAME_FIELD;
    private final BaseElement PASSWORD_FIELD;
    private final BaseElement LOGIN_BTN;
    private final BaseElement WRONG_INPUT_ERROR;
    private final BaseElement BANNER_LOGO;
    private final BaseElement FORGOT_PW_LINK;

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
        this.FORGOT_PW_LINK = new BaseElement(
                this.driverTools,
                By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
        );
    }

    @Step("Verify the banner logo is visible")
    public Boolean isBannerLogoVisible() {
        return this.BANNER_LOGO.isVisible(5);
    }

    @Step("Verify that the invalid credentials error is displayed")
    public Boolean isInputWrong() {
        return this.WRONG_INPUT_ERROR.isVisible(2);
    }

    @Step("Enter username")
    public LoginPage enterUsername(String text) {
        this.USERNAME_FIELD.clearAndType(text);
        return this;
    }

    @Step("Enter password")
    public LoginPage enterPassword(String text) {
        this.PASSWORD_FIELD.clearAndType(text);
        return this;
    }

    @Step("Click login button")
    public DashboardPage clickLoginBtn() {
        this.LOGIN_BTN.doClick();
        return this.getPages().getDashboardPage();
    }

    @Step("Login to the application entering credentials")
    public DashboardPage login(String username, String password) {
        if (this.LOGIN_FORM.isVisible(3) && this.USERNAME_FIELD.isActive(2) && this.PASSWORD_FIELD.isActive(2)) {
            this.enterUsername(username);
            this.enterPassword(password);
            return this.clickLoginBtn();
        } else {
            throw new RuntimeException("The login is not successful");
        }
    }

    @Step("Click the forgot password link on the login page")
    public ForgotPasswordPage clickForgotPwLink() {
        this.FORGOT_PW_LINK.doClick();
        return this.getPages().getForgotPasswordPage();
    }

}
