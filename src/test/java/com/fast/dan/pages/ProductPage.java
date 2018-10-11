package com.fast.dan.pages;

import Utils.Constants;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

    @FindBy(css = "#tab-title-reviews")
    private WebElementFacade reviewsLink;
    @FindBy(css = ".star-5")
    private WebElementFacade fiveStarRating;
    @FindBy(css = "#comment")
    private WebElementFacade reviewTextField;
    @FindBy(css = "#submit")
    private WebElementFacade submitReviewButton;
    @FindBy(css = ".comment-text .description")
    private WebElementFacade reviewDisplayed;
    @FindBy(css = ".cart .single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    public void clickOnReviewsLink(){
        clickOn(reviewsLink);
    }
    public void clickOnRating(){
        clickOn(fiveStarRating);
    }
    public void setReview(){
        typeInto(reviewTextField, Constants.COMMENT);
    }
    public void clickReviewBtn(){
        clickOn(submitReviewButton);
    }
    public boolean checkReviewIsDisplayed(){
        return reviewDisplayed.getText().equals(Constants.COMMENT);
    }
}
