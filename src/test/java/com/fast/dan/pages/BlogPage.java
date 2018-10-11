package com.fast.dan.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("http://qa3.fasttrackit.org:8008/?page_id=703")
public class BlogPage {

    @FindBy(css = "#commentform #comment")
    private WebElementFacade commentForm;
    @FindBy(css = "#author")
    private WebElementFacade authorName;
    @FindBy(css = "#email")
    private WebElementFacade authorEmail;
    @FindBy(css = "#submit")
    private WebElementFacade submitButton;

}
