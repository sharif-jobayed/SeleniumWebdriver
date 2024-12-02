package wikipedia.stepDefinitions;

import aquality.selenium.elements.interfaces.IElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import wikipedia.pages.MainPage;

public class MainPageSteps {

    private MainPage mainPage=new MainPage();

    @Given("the user is on the Main page")
    public void theUserIsOnTheMainPage() {
        Assert.assertTrue(mainPage.state().isDisplayed());
    }
    @Then("the user inputs {string} in the search field")
    public void theUserInputsInTheSearchFieldAndClicksSubmit(String string) {
        mainPage.typeInTheSearchField(string);
    }
    @Then("the user clicks on the search submit button")
    public void clickOnTheSearchSubmitBtn(){
        mainPage.clickOnSearchSubmitBtn();
    }
    @When("the user changes the search language to {string}")
    public void selectEspanolLanguage(String string){
        mainPage.clickOnTheLanguageSelectorBtn();
        mainPage.setLanguageToEspanol(string);
    }

}
