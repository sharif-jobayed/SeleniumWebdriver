package pages;

import framework.BaseElement;
import framework.BasePage;
import org.openqa.selenium.By;

public class FramesPage extends BasePage {
    private BaseElement iFrameLink;

    public FramesPage(String PAGE_URL, By PAGE_IDENTIFIER, String PAGE_NAME) {
        super(PAGE_URL, PAGE_IDENTIFIER, PAGE_NAME);

        this.iFrameLink = new BaseElement(
                By.cssSelector("a[href='/iframe']"),
                "IFrame link"
        );
    }

    public FramesPage clickIFrameLink() {
        this.iFrameLink.doClick();
        return this;
    }
}
