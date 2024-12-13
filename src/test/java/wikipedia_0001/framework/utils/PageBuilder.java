package wikipedia_0001.framework.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import wikipedia_0001.framework.BaseTest;
import wikipedia_0001.pages.SearchPage;

import java.util.Locale;

public class PageBuilder {
    private WebDriver driver;
    private String pageName;

    public PageBuilder(String pageName) {
        this.driver = new BaseTest().getDriverTools().getDriver();
        getPage(pageName);
    }

    private <P> P getPage(String pageName) {
        String page = pageName.toLowerCase(Locale.ROOT);

        if(page.contains("search")) {
            return (P) new SearchPage(
                    this.driver,
                    "https://www.wikipedia.org/",
                    "Search page"
            );
        } else {
            throw new InvalidArgumentException("Invalid Page Request");
        }
    }
}
