package pages;

import framework.BaseElement;
import framework.BasePage;
import org.openqa.selenium.By;

public class JSAlertPage extends BasePage {
    private BaseElement jsAlertBtn;
    private BaseElement resultElement;

    public JSAlertPage(String PAGE_URL, By PAGE_IDENTIFIER, String PAGE_NAME) {
        super(PAGE_URL, PAGE_IDENTIFIER, PAGE_NAME);

        this.jsAlertBtn = new BaseElement(
                By.xpath("//button[@onclick='jsAlert()']"),
                "JS Alert button"
        );
        this.resultElement = new BaseElement(
                By.xpath("//p[@id='result']"),
                "Action result paragraph"
        );
    }

    public JSAlertPage clickJSAlertBtn() {
        this.jsAlertBtn.doClick();
        return this;
    }

    public String getActionResultText() {
        return this.resultElement.elementText();
    }
}
