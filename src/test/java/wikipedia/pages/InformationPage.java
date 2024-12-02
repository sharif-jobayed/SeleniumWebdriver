package wikipedia.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IElementFactory;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InformationPage extends Form {
    public InformationPage() {
        super(By.xpath("//*[@role='main']"), "Information page");
    }

    private IElementFactory iElementFactory= AqualityServices.getElementFactory();
    
    private final ILabel PAGE_HEADER=iElementFactory.getLabel(By.xpath("//*[@id='firstHeading']"),",Page header");




    public String getPAGE_HEADER(){
        Pattern pattern = Pattern.compile("\"(.*?)\"");
        Matcher matcher = pattern.matcher(PAGE_HEADER.getText());
        String lastMatchedValue = "";
        while (matcher.find()) {
            lastMatchedValue = matcher.group(1).trim();
        }
        return lastMatchedValue;
    }

}
