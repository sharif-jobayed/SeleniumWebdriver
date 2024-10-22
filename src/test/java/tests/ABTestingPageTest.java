package tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class ABTestingPageTest extends HomePageTest {
    @Test(
            description = "Check if the word 'split testing' exists in the paragraph",
            groups = {"ABTestingPage"},
            dependsOnMethods = {"testOpenABTestingPage"},
            priority = 1
    )
    void testTargetTextExistence() {
        Assert.assertTrue(getPages().getABTestingPage().hasTargetText());
    }
}
