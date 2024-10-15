package saucedemo.pages;

import org.openqa.selenium.By;
import saucedemo.framework.BaseElement;
import saucedemo.framework.BasePage;
import saucedemo.framework.utils.DataConverter;

public class LoginPage extends BasePage {
    private DataConverter dataConverter = new DataConverter();

    public LoginPage(String pageURL, String pageName) {
        super(pageURL, pageName);
    }

    public Boolean isLoginPageOpen() {
        return this.isPageOpen();
    }

    public Boolean isLoginPageLoaded() {
        return this.isPageLoaded(dataConverter.getTimeouts().getMAXTimeout(), By.xpath("//div[@id='login_credentials']"));
    }

    public LoginPage enterUserName() {
        BaseElement userNameField = new BaseElement(
                By.xpath("//input[@id='user-name']"),
                "Username input field"
        );
        userNameField.clearAndType(dataConverter.getUserCreds().getStandardUser().getUserName());
        return this;
    }

    public LoginPage enterPassword() {
        BaseElement userPasswordField = new BaseElement(
                By.xpath("//input[@id='password']"),
                "User password input field"
        );
        userPasswordField.clearAndType(dataConverter.getUserCreds().getStandardUser().getPassword());
        return this;
    }

    public LoginPage clickLogin() {
        BaseElement loginSubmitButton = new BaseElement(
                By.xpath("//input[@id='login-button']"),
                "User login submission button"
        );
        loginSubmitButton.doClick();
        return this;
    }
}
