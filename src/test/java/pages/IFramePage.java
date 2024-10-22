package pages;

import framework.BaseElement;
import framework.BasePage;
import org.openqa.selenium.By;

public class IFramePage extends BasePage {
    private BaseElement iFrameTextbox;

    public IFramePage(String PAGE_URL, By PAGE_IDENTIFIER, String PAGE_NAME) {
        super(PAGE_URL, PAGE_IDENTIFIER, PAGE_NAME);

        this.iFrameTextbox = new BaseElement(
                By.xpath("//body[@id=\"tinymce\"]/p"),
                ""
        );
    }

    public BaseElement getiFrameTextbox() {
        return this.iFrameTextbox;
    }
}
