package pages;

import framework.BaseElement;
import framework.BasePage;
import org.openqa.selenium.By;

public class DropdownPage extends BasePage {
    private BaseElement dropdownMenu;

    public DropdownPage(String PAGE_URL, By PAGE_IDENTIFIER, String PAGE_NAME) {
        super(PAGE_URL, PAGE_IDENTIFIER, PAGE_NAME);

        this.dropdownMenu = new BaseElement(
                By.xpath("//select[@id='dropdown']"),
                "Dropdown menu"
        );
    }

    public DropdownPage selectOption2() {
        this.dropdownMenu.selectFromDropdown(1);
        return this;
    }
}
