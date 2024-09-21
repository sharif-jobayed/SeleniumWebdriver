package wikipedia;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features={"src/test/java/wikipedia/features"},
        glue={"wikipedia.hooks","wikipedia.stepDefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
    @Override @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}