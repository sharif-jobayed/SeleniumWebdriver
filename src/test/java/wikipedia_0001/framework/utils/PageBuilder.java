package wikipedia_0001.framework.utils;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import wikipedia_0001.framework.BasePage;
import wikipedia_0001.pages.SearchPage;
import wikipedia_0001.runners.Hooks;

import java.util.Locale;
import java.util.Map;

public class PageBuilder {
    private WebDriver driver;
    private Map<String, BasePage> pageList;

    public PageBuilder() {
        this.driver = new Hooks().getDriver();

        this.pageList.put("Search page", new SearchPage(
                this.driver,
                "https://www.wikipedia.org/",
                "Search page"
        ));
    }

//    public <P extends BasePage> P buildPage(String pageName) {
//        String page = pageName.toLowerCase(Locale.ROOT);
//
//        if (page.contains("search")) {
//            return (P) new SearchPage(
//                    this.driver,
//                    "https://www.wikipedia.org/",
//                    "Search page"
//            );
//        }
//        throw new IllegalArgumentException("Unknown page name: " + pageName);
//    }

    public BasePage getPage(String pageTitle) {
        String pt = pageTitle.toLowerCase(Locale.ROOT);

        if(pt.equals("search")) {
            return this.pageList.get("Search page");
        }
        throw new InvalidArgumentException("Invalid page request");
    }
}
