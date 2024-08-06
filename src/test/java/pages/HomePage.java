package pages;

import framework.BaseElement;
import framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Locale;

import static data.Constants.*;

public class HomePage extends BasePage {
    private BaseElement gameNames;
    private BaseElement gameServiceStatuses;


    public HomePage(String pageURL, String pageName) {
        super(pageURL, pageName);

        this.gameNames = new BaseElement(
                By.xpath("//div[contains(@class,'component-inner-container')]//span[@class='name']/span[2]"),
                "Game names"
        );
        this.gameServiceStatuses = new BaseElement(
                By.xpath("//div[contains(@class,'component-container')]//div[@class='child-components-container ']//div[2]/span[2]"),
                "Game service statuses"
        );
    }

    public HomePage openGameBox(String gameName) {
        this.gameNames.getEL_LOCATORS().forEach(gn -> {
            if(gn.getText().equals(gameName)) {
                gn.click();
            }
            Assert.assertTrue(getGameDetailsGroup(1).isVisible(getMinTimeOut()), "The game details aren't displayed");
        });
        return this;
    }

    public BaseElement getGameDetailsGroup(int index) {
        return new BaseElement(
                By.xpath("//div[contains(@class,'component-container')]["+index+"]"),
                "Game details group"
        );
    }

    public Boolean isGameServiceOperational(int index) {
        System.out.println(this.gameServiceStatuses.getEL_LOCATORS().get(1));
        WebElement fortniteGameService = this.gameServiceStatuses.getEL_LOCATORS().get(index);
        if(fortniteGameService.getText().toLowerCase(Locale.ROOT).equals("operational")) {
            return true;
        } else {
            return false;
        }
    }
}
