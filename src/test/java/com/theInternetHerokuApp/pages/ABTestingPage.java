package com.theInternetHerokuApp.pages;

import com.theInternetHerokuApp.framework.BaseElement;
import com.theInternetHerokuApp.framework.BasePage;
import org.openqa.selenium.By;

public class ABTestingPage extends BasePage {
    public ABTestingPage(String pageURL, String pageName) {
        super(pageURL, pageName);
    }

    public BaseElement getParagraphHeading() {
        return new BaseElement(
                By.xpath("//div[@class='example']/h3[text()='A/B Test Control']"),
                "Paragraph heading"
        );
    }
}
