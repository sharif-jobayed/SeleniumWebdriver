package tests;

import org.testng.annotations.Test;

public class DropdownPageTest extends HomePageTest {

    @Test(
            description = "Click an option from the dropdown menu",
            groups = "DropdownPage",
            dependsOnMethods = "testOpenDropdownPage",
            priority = 1
    )
    void testClickAnOption() {
        getPages().getDropdownPage().selectOption2();
    }
}
