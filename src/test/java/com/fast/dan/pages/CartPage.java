package com.fast.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CartPage extends PageObject {

    @FindBy(css = ".product-name a")
    private WebElementFacade productNameInCart;
    @FindBy(css = ".product-remove .remove")
    private WebElementFacade removeProduct;
    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade outOfStockMessage;
    @FindBy(css = ".wc-proceed-to-checkout")
    private WebElementFacade proceedToCheckoutButton;
    @FindBy(css = ".wc-backward")
    private WebElementFacade backButton;
    @FindBy(css = "#menu-item-1730")
    private WebElementFacade myAccountButton;
    @FindBy(css = ".woocommerce-MyAccount-content p:first-child a")
    private WebElementFacade logoutLink;

    public String productNameInCart(){
        System.out.println("Numele produsului din cos: "+productNameInCart.getText());
        return productNameInCart.getText();
    }
    public void emptyCart(){
        moveTo(".product-remove .remove");
        clickOn(removeProduct);
    }
    public void clickOnProceedToCheckout(){
        clickOn(proceedToCheckoutButton);
    }
    public String getTextMessage(){
        return outOfStockMessage.getText();
    }
    public void clickOnbackButton(){
        clickOn(backButton);
    }
    public void clickOnMyAccountBtn(){
        clickOn(myAccountButton);
    }
    public void clickOnLogout(){
        clickOn(logoutLink);
    }


}
