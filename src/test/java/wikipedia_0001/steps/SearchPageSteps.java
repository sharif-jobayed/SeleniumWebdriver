package wikipedia_0001.steps;

import io.cucumber.java.en.*;
import wikipedia_0001.framework.BaseTest;

public class SearchPageSteps extends BaseTest {
    @Given("I'm on the {string} page")
    public void iAmOnPage(String pageName) {
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
}
