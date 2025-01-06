package com.opensourceDemo.orangehrmlive.pages;

import com.opensourceDemo.orangehrmlive.framework.BasePage;
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

    public LoginPage enterUserame() {
        this.clearAndType("Admin", this.userNameField);
        return this;
    }

    public LoginPage enterPassword() {
        this.clearAndType("admin123", this.passwordField);
        return this;
    }

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
