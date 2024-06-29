package wikipedia.stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import wikipedia.pages.PDFDownloadPage;
import wikipedia.utils.FileActions;

public class PDFDOwnloadPageSteps {

    private PDFDownloadPage pdfDownloadPage=new PDFDownloadPage();

    @Then("the file with the provided name on the Download as PDF page should be downloaded")
    public void theFileIsDownloadedFromThePDFDownloadPage(){
        pdfDownloadPage.clickOnFileDownloadBtn();
        Assert.assertTrue(FileActions.doesFileExists(FileActions.getDOWNLOADED_FILE()),"File not found at the location");
        FileActions.deleteFile(FileActions.doesFileExists(FileActions.getDOWNLOADED_FILE()));
    }
}
