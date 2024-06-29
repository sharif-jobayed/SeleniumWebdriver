package wikipedia.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import wikipedia.utils.DriverTools;

public class ArticlePage extends Form {

    public ArticlePage() {
        super(By.xpath("//*[contains(@class,'mw-page-title-main')]"),"Result page header");
    }

    private IElementFactory iElementFactory=AqualityServices.getElementFactory();

    private final ILabel PAGE_HEADER= iElementFactory.getLabel(By.cssSelector("#firstHeading .mw-page-title-main"),"Page Header");
    private final ILink PAGE_INFORMATION_LINK=iElementFactory.getLink(By.cssSelector("a[title='More information about this page'] span"),"Page information link");
    private final IButton TOOLS_DROPDOWN_BTN=iElementFactory.getButton(By.cssSelector(".vector-page-tools-landmark #vector-page-tools-dropdown"),"Tools Dropdown button");
    private final ILink PDF_DOWNLOAD_LINK=iElementFactory.getLink(By.xpath("//*[text()='Download as PDF']"),"PDF Download link");




    public ILabel getPAGE_HEADER(){return PAGE_HEADER;}
    public String getPageHeaderText(){return getPAGE_HEADER().getText();}
    public ILink getPAGE_INFORMATION_LINK(){return PAGE_INFORMATION_LINK;}
    public void clickOnPageInformationLink(){getPAGE_INFORMATION_LINK().click();}
    public IButton getTOOLS_DROPDOWN_BTN(){return TOOLS_DROPDOWN_BTN;}
    public void clickOnToolsDropdownBtn(){getTOOLS_DROPDOWN_BTN().click();}
    public ILink getPDF_DOWNLOAD_LINK(){return PDF_DOWNLOAD_LINK;}
    public void clickOnPdfDownloadLink(){getPDF_DOWNLOAD_LINK().click();}
}
