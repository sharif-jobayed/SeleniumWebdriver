package saucedemo.pages;

import org.openqa.selenium.By;
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
}
