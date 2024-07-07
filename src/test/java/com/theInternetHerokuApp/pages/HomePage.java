package com.theInternetHerokuApp.pages;

import com.theInternetHerokuApp.framework.BaseElement;
import com.theInternetHerokuApp.framework.BasePage;
import org.openqa.selenium.By;

import static com.theInternetHerokuApp.data.Constants.getBaseURL;

public class HomePage extends BasePage {
    private String abTestLink;

    public HomePage(String pageURL, String pageName) {
        super(pageURL, pageName);
    }
}
