package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    private By userNameField;
    private By passwordField;
    private By loginBtn;

    public LoginPage() {
        this.userNameField = By.xpath("//input[@name='username']");
        this.passwordField = By.xpath("//input[@name='password']");
        this.loginBtn = By.xpath("//button[@type='submit']");
    }

    @Step("I enter Username")
    public LoginPage enterUserame() {
        this.clearAndType("Admin", this.userNameField);
        return this;
    }

    @Step("I enter Password")
    public LoginPage enterPassword() {
        this.clearAndType("admin123", this.passwordField);
        return this;
    }

    @Step("I press the login button")
    public DashboardPage pressLoginBtn() {
        this.doClick(loginBtn);
        return new DashboardPage();
    }

    public DashboardPage login() {
        this.enterUserame();
        this.enterPassword();
        return this.pressLoginBtn();
    }
}
