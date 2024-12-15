package wikipedia_0001.pages;

import org.openqa.selenium.WebDriver;
import wikipedia_0001.framework.BasePage;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver, String pageURL, String pageName) {
        super(driver, pageURL, pageName);
    }

    public void testPage() {
        System.out.println("This is " + this.pageName);
    }
}
