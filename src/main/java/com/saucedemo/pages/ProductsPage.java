package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private By pageHeader;

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.pageHeader = By.xpath("//span[@class='title'][normalize-space()='Products']");
    }

    public boolean isProductHeaderVisible() {
        return find(this.pageHeader).isDisplayed();
    }
}
