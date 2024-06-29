package wikipedia.pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import java.util.List;

public class MainPage extends Form {

    public MainPage() {
        super(By.id("www-wikipedia-org"), "Search Page");
    }

    private IElementFactory iElementFactory= AqualityServices.getElementFactory();

    private final ITextBox SEARCH_FIELD=iElementFactory.getTextBox(By.xpath("//*[@id='searchInput']"),"Search field on the search page");
    private final IButton LANGUAGE_SELECITOR_BTN=iElementFactory.getButton(By.xpath("//*[contains(@class,'hide-arrow')]"),"Language selector button");
    private List<IElement> languages;
    private final IButton SEARCH_SUBMIT_BTN=iElementFactory.getButton(By.xpath("//*[@type='submit']"),"Search submit button on the search page");
    private List<IElement> searchResults;





    public ITextBox getSEARCH_FIELD(){return SEARCH_FIELD;}

    public void typeInTheSearchField(String text){getSEARCH_FIELD().clearAndType(text);}

    public IButton getSEARCH_SUBMIT_BTN(){return SEARCH_SUBMIT_BTN;}
    public void clickOnSearchSubmitBtn(){getSEARCH_SUBMIT_BTN().click();}

    public IButton getLANGUAGE_SELECTOR_BTN(){return LANGUAGE_SELECITOR_BTN;}
    public void clickOnTheLanguageSelectorBtn(){getLANGUAGE_SELECTOR_BTN().click();}
    public List<IElement> setLanguages(){
        languages=iElementFactory.findElements(By.xpath("//*[@id='searchLanguage']/option"), "List of languages", ElementType.BUTTON);
        return languages;
    }
    public void setLanguageToEspanol(String text){
        setLanguages();
        for(IElement language:languages){
            if(language.getText().equals(text)){
                language.click();
            }
        }
    }
    public List<IElement> getSearchResults(){
        searchResults=iElementFactory.findElements(By.xpath("//*[@class='suggestion-link']"),"Search results",ElementType.LABEL);
        return searchResults;
    }

}
