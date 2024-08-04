package utils;

import data.Credentials;
import pages.HomePage;

public class PageCreator {
    private final Credentials CREDENTIALS = new Credentials();
    private final String PAGE_URL;

    public PageCreator(String path) {
        this.PAGE_URL = CREDENTIALS.getBASE_URL()+path;
    }

    public HomePage getHomePage() {
        return new HomePage(
                this.PAGE_URL,
                "Home page"
        );
    }
}
