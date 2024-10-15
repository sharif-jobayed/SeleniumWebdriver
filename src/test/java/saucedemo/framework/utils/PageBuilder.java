package saucedemo.framework.utils;

import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;

import java.util.Locale;

public class PageBuilder {
    private DataConverter dataConverter = new DataConverter();

    public <T> T getPage(String pageName) {
        if (pageName.toLowerCase(Locale.ROOT).contains("login")) {
            return (T) new LoginPage(
                    dataConverter.getAppData().getBaseURL(),
                    "Login page"
            );
        } else if(pageName.toLowerCase(Locale.ROOT).contains("inventory")) {
            return (T) new InventoryPage(
                    dataConverter.getAppData().getBaseURL()+"inventory.html",
                    "Inventory page"
            );
        }

        return null;
    }
}
