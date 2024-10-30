package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameField;
    private By passwordField;
    private By loginBtn;
    private By errorField;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.usernameField = By.xpath("//input[@id='user-name']");
        this.passwordField = By.xpath("//input[@id='password']");
        this.loginBtn = By.xpath("//input[@id='login-button']");
        this.errorField = By.xpath("//h3[@data-test='error']");
    }

    public void setUsername(String username) {
        clearAndType(this.usernameField, username);
    }

    public void setPassword(String password) {
        clearAndType(this.passwordField, password);
    }

    public ProductsPage clickLoginBtn() {
        doClick(this.loginBtn);
        return new ProductsPage(driver);
    }

    public ProductsPage loginToApplication(String username, String password) {
        setUsername(username);
        setPassword(password);
        return clickLoginBtn();
    }

    public String getErrorText() {
        return find(this.errorField).getText();
    }
}
