package framework.utils;

import org.openqa.selenium.By;
import pages.ABTestingPage;
import pages.AddRemoveElementsPage;
import pages.HomePage;

public class Pages {
    private final String BASE_URL;

    public Pages() {
        this.BASE_URL = new DataProcessor().getURLs().getBaseURL();
    }

    public HomePage getHomePage() {
        return new HomePage(
                this.BASE_URL,
                By.xpath("//h1[@class='heading']"),
                "Home page"
        );
    }

    public ABTestingPage getABTestingPage() {
        return new ABTestingPage(
                this.BASE_URL+"abtest",
                By.xpath("//div[@class='example']"),
                "AB Testing page"
        );
    }

    public AddRemoveElementsPage getAddRemoveElementsPage() {
        return new AddRemoveElementsPage(
                this.BASE_URL+"add_remove_elements/",
                By.xpath("//h3[normalize-space()='Add/Remove Elements']"),
                "Add Remove Elements page"
        );
    }
}
