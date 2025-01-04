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

    public DashboardPage login() {
        this.clearAndType("Admin", this.userNameField);
        this.clearAndType("admin123", this.passwordField);
        this.doClick(loginBtn);
        return new DashboardPage();
    }
}
