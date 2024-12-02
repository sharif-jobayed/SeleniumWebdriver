package wikipedia.stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import wikipedia.pages.InformationPage;

public class InformationPageSteps {

    private InformationPage informationPage=new InformationPage();




    @Then("the Information page for the {string} article should be displayed")
    public void infoPageIsDisplayed(String string){
        Assert.assertEquals(informationPage.getPAGE_HEADER(), string,"Page informaiton is not correct");
    }

}
