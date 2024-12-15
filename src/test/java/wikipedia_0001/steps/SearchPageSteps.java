package wikipedia_0001.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchPageSteps {
    @Given("I'm on the {string} page")
    public void onPage(String pageName) {
        System.out.println("Step executed!");
    }

    @Then("The {string} page is open")
    public void pageIsOpen(String pageName) {
        System.out.println("Step executed!");
    }

    @Then("The {string} page is loaded")
    public void pageIsLoaded(String pageName) {
        System.out.println("Step executed!");
    }

    @When("I type {string} in the {string} field")
    public void enterContext(String searchContext, String elementName) {
        System.out.println("Step executed!");
    }

    @Then("The {string} dropdown list is displayed")
    public void elementIsDisplayed(String elementName) {
        System.out.println("Step executed!");
    }

    @When("I click the first result from the search dropdown")
    public void clickFirstResult() {
        System.out.println("Step executed!");
    }

    @Then("The {string} page opens up")
    public void opensPage(String pageName) {
        System.out.println("Step executed!");
    }
}
