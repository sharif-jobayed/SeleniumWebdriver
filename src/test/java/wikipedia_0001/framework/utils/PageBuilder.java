package wikipedia_0001.framework.utils;

import org.openqa.selenium.WebDriver;
import wikipedia_0001.framework.BasePage;
import wikipedia_0001.pages.SearchPage;
import wikipedia_0001.runners.Hooks;

import java.util.Locale;

public class PageBuilder {
    private WebDriver driver;

    public PageBuilder() {
        this.driver = new Hooks().getDriver();
    }

    public <P extends BasePage> P buildPage(String pageName) {
        String page = pageName.toLowerCase(Locale.ROOT);

        if (page.contains("search")) {
            return (P) new SearchPage(
                    this.driver,
                    "https://www.wikipedia.org/",
                    "Search page"
            );
        }
        throw new IllegalArgumentException("Unknown page name: " + pageName);
    }
}
