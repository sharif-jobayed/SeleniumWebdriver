package com.theInternetHerokuApp.pages;

import com.theInternetHerokuApp.framework.BasePage;

import static com.theInternetHerokuApp.data.Constants.getBaseURL;

public class HomePage extends BasePage {
    public HomePage() {
        super(getBaseURL(), "Home page");
    }
}
