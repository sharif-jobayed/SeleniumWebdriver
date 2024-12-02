package wikipedia.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import wikipedia.pages.ArticlePage;
import wikipedia.utils.DataProcessor;

public class ArticlePageSteps {

    private ArticlePage articlePage=new ArticlePage();

    @And("the user clicks the Tool menu button on the Article page")
    public void theUserClicksTheToolMenuButtonOnTheArticlePage() {
        articlePage.clickOnToolsDropdownBtn();
    }
    @And("the user clicks the Download as PDF button on the Article page")
    public void theUserClicksTheDownloadAsPDFBtn(){
        articlePage.clickOnPdfDownloadLink();
    }
    @And("the user clicks the Page information button on the Article page")
    public void theUserClicksThePageInformationButtonOnTheArticlePage() {
        articlePage.clickOnPageInformationLink();
    }
    @Then("the Article page for {string} in Spanish should be open")
    public void checkPageHeader(String string){
        Assert.assertEquals(articlePage.getPageHeaderText(),string,"Page header does not match");
    }
}
