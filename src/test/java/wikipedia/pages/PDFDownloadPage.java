package wikipedia.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import wikipedia.utils.DriverTools;

public class PDFDownloadPage extends Form {

    public PDFDownloadPage() {
        super(By.xpath("//h1[contains(@class,'mw-first-heading') and text()='Download as PDF']"), "PDF Download page");
    }

    private IElementFactory iElementFactory= AqualityServices.getElementFactory();

    private final ILabel FILE_DOWNLOAD_BOX= iElementFactory.getLabel(By.xpath("//*[contains(@class,'mw-electronpdfservice-selection-label-text')]"),"File download box");
    private final IButton FILE_DOWNLOAD_BTN=iElementFactory.getButton(By.xpath("//*[contains(@class,'oo-ui-labelElement-label')and text()='Download']"),"File download button");




    public ILabel getFILE_DOWNLOAD_BOX(){return FILE_DOWNLOAD_BOX;}
    public String getFileDownloadBoxText(){return getFILE_DOWNLOAD_BOX().getText();}
    public IButton getFILE_DOWNLOAD_BTN(){return FILE_DOWNLOAD_BTN;}
    public void clickOnFileDownloadBtn(){getFILE_DOWNLOAD_BTN().click();}

}
