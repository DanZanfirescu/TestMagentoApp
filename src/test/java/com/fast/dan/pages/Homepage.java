package com.fast.dan.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa3.fasttrackit.org:8008/")
public class Homepage extends PageObject {

    @FindBy(css = ".search-btn")
    private WebElementFacade searchButton;
    @FindBy(css = ".search-field")
    private WebElementFacade searchField;
    @FindBy(css = ".search-submit")
    private WebElementFacade searchSubmit;
    @FindBy(css = "#menu-item-1730")
    private WebElementFacade myAccountButton;
    @FindBy(css = "#menu-item-1643")
    private WebElementFacade blogButton;
    @FindBy(css = "#menu-item-1728")
    private WebElementFacade shopButton;
    @FindBy(css = "#menu-item-1729")
    private WebElementFacade checkoutButton;

    public void clickMyAccountButton(){
        waitFor(myAccountButton);
        clickOn(myAccountButton);
    }
}
