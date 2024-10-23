package framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static framework.DriverTools.*;

public class BasePage {
    private final String PAGE_URL;
    private final By PAGE_IDENTIFIER;
    private final String PAGE_NAME;

    public BasePage(String PAGE_URL, By PAGE_IDENTIFIER, String PAGE_NAME) {
        this.PAGE_URL = PAGE_URL;
        this.PAGE_IDENTIFIER = PAGE_IDENTIFIER;
        this.PAGE_NAME = PAGE_NAME;
    }

    public String getPAGE_URL() {
        return PAGE_URL;
    }

    public By getPAGE_IDENTIFIER() {
        return PAGE_IDENTIFIER;
    }

    public String getPAGE_NAME() {
        return PAGE_NAME;
    }

    public String pageTitle() {
        return getDriver().getTitle();
    }

    public Boolean isPageOpen() {
        return getDriver().getCurrentUrl().equals(getPAGE_URL());
    }

    public Boolean isPageLoaded(Integer timeout) {
        try {
            getXWait(timeout).until(ExpectedConditions.presenceOfElementLocated(getPAGE_IDENTIFIER()));
            return true;
        } catch(NotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public BaseElement getByText(String text) {
        return new BaseElement(
                By.xpath("//a[contains(text(),'"+text+"')]"),
                text+" element"
        );
    }

    public BasePage navigateBack() {
        getDriver().navigate().back();
        return this;
    }

    public Alert selectOpenAlert() {
        Alert alert = getDriver().switchTo().alert();
        return alert;
    }

    public BasePage getIFrame() {
        getDriver().switchTo().frame("mce_0_ifr");
        return this;
    }

    public BasePage returnToDefaultContent() {
        getDriver().switchTo().defaultContent();
        return this;
    }

    public BasePage openInNewTab(By link) {
        String jsNewTab = "window.open(arguments[0], '_blank')";
        getJS().executeScript(jsNewTab, link);
        return this;
    }

    public BasePage scrollBackToTop() {
        String jsToTop = "window.scrollTo(0, 0)";
        getJS().executeScript(jsToTop);
        return this;
    }
}