package pages;

import framework.BaseElement;
import framework.BasePage;
import org.openqa.selenium.By;

public class ABTestingPage extends BasePage {
    private final BaseElement PARAGRAPH;

    public ABTestingPage(String PAGE_URL, By PAGE_IDENTIFIER, String PAGE_NAME) {
        super(PAGE_URL, PAGE_IDENTIFIER, PAGE_NAME);
        this.PARAGRAPH = new BaseElement(
                By.xpath("//div[@class='example']/p"),
                "Paragraph element"
        );
    }

    public Boolean hasTargetText() {
        String paragraphText = this.PARAGRAPH.elementText();
        return paragraphText.contains("split testing");
    }
}
