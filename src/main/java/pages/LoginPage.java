package pages;

import framework.BaseElement;
import framework.BasePage;
import framework.DriverTools;
import framework.PageBuilder;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private final BaseElement LOGIN_FORM;
    private final BaseElement USERNAME_FIELD;
    private final BaseElement PASSWORD_FIELD;
    private final BaseElement LOGIN_BTN;
    private final BaseElement WRONG_INPUT_ERROR;
    private final BaseElement BANNER_LOGO;

    public LoginPage(DriverTools driverTools, String path) {
        super(driverTools, path);


        this.LOGIN_FORM = new BaseElement(
                this.driverTools,
                By.xpath("//form[@method='post']"),
                "Login form"
        );
        this.USERNAME_FIELD = new BaseElement(
                this.driverTools,
                By.xpath("//input[@name='username']"),
                "Username field"
        );
        this.PASSWORD_FIELD = new BaseElement(
                this.driverTools,
                By.xpath("//input[@name='password']"),
                "Password field"
        );
        this.LOGIN_BTN = new BaseElement(
                this.driverTools,
                By.xpath("//button[@type='submit']"),
                "Login button"
        );
        this.WRONG_INPUT_ERROR = new BaseElement(
                this.driverTools,
                By.xpath("//div[@role='alert']//p[normalize-space()='Invalid credentials']"),
                "Wrong Input error"
        );
        this.BANNER_LOGO = new BaseElement(
                this.driverTools,
                By.xpath("//img[@alt='company-branding']"),
                "Banner logo"
        );
    }

    public Boolean isBannerLogoVisible() {
        return this.BANNER_LOGO.isVisible(5);
    }

    public Boolean isInputWrong() {
        return this.WRONG_INPUT_ERROR.isVisible(2);
    }

    public DashboardPage login(String username, String password) {
        if (this.LOGIN_FORM.isVisible(3)) {
            this.USERNAME_FIELD.clearAndType(username);
            this.PASSWORD_FIELD.clearAndType(password);
            this.LOGIN_BTN.doClick();
            return new PageBuilder(this.driverTools).getPage("Dashboard");
        } else {
            throw new RuntimeException("The login form is not present");
        }
    }

}
