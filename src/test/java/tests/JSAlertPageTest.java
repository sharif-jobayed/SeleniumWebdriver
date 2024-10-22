package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JSAlertPageTest extends HomePageTest{
    @Test(
            description = "Click & accept JS Alert",
            groups = "JSAlertPage",
            dependsOnMethods = "testOpenJSAlertPage",
            priority = 1
    )
    void testAcceptAlert() {
        getPages().getJSAlertPage().clickJSAlertBtn();
        getPages().getJSAlertPage().selectOpenAlert().accept();
        Assert.assertEquals(getPages().getJSAlertPage().getActionResultText(), "You successfully clicked an alert", "The alert is not accepted");
    }
}
