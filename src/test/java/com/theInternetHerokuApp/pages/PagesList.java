package com.theInternetHerokuApp.pages;

import static com.theInternetHerokuApp.data.Constants.getBaseURL;

public class PagesList {
    public HomePage getHomePage() {
        return new HomePage(
                getBaseURL(),
                "Home page"
        );
    }

    public ABTestingPage getABTestingPage() {
        return new ABTestingPage(
                getBaseURL() + "abtest",
                "A/B Testing page"
        );
    }

    public static PagesList getPagesList() {
        return new PagesList();
    }
}
