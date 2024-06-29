package wikipedia.utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.waitings.IConditionalWait;
import aquality.selenium.elements.interfaces.IElementFactory;

public class DriverTools {

    private static final Browser BROWSER= AqualityServices.getBrowser();
    private static final IElementFactory iEL_FACTORY=AqualityServices.getElementFactory();
    private static final IConditionalWait iCON_WAIT=AqualityServices.getConditionalWait();




    public static Browser getBrowser(){return BROWSER;}
    public static IElementFactory getiElementFactory(){return iEL_FACTORY;}
    public static IConditionalWait getiConWait(){return iCON_WAIT;}

}
