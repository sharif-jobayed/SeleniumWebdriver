package pages;

import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By LOGIN_FORM;
    private final By USERNAME_FIELD;
    private final By PASSWORD_FIELD;
    private final By LOGIN_BTN;
    private final By WRONG_INPUT_ALERT;

    public LoginPage(WebDriver driver) {
        super(driver);

        this.LOGIN_FORM = By.xpath("//form[@method='post']");
        this.USERNAME_FIELD = By.xpath("//input[@name='username']");
        this.PASSWORD_FIELD = By.xpath("//input[@name='password']");
        this.LOGIN_BTN = By.xpath("//button[@type='submit']");
        this.WRONG_INPUT_ALERT = By.xpath("//div[@role='alert']//p[normalize-space()='Invalid credentials']");
    }

    public LoginPage inputUsername(String text) {
        if(this.doesItExist(this.LOGIN_FORM, 5)) {
            this.clearAndType(5, text, this.USERNAME_FIELD);
        }
        return this;
    }

    public LoginPage inputPassword(String text) {
        if(this.doesItExist(this.PASSWORD_FIELD, 5)) {
            this.clearAndType(5, text, this.PASSWORD_FIELD);
        }
        return this;
    }

    public DashboardPage clickLoginBtn() {
        this.doClick(this.LOGIN_BTN);
        return this.getPageInstance(DashboardPage.class);
    }

    public Boolean isInputWrong() {
        this.waitTillExist(5, this.WRONG_INPUT_ALERT);
        return this.isItVisible(this.WRONG_INPUT_ALERT, 10);
    }
}
