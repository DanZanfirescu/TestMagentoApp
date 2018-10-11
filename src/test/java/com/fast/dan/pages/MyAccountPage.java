package com.fast.dan.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa3.fasttrackit.org:8008/?page_id=13")
public class MyAccountPage extends PageObject {

    @FindBy(css = "#username")
    private WebElementFacade userNameField;
    @FindBy(css = "#password")
    private WebElementFacade passwordField;
    @FindBy(css = ".u-column1 .woocommerce-Button")
    private WebElementFacade loginButton;
    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade helloMessage;
    @FindBy(css = "#reg_email")
    private WebElementFacade regEmailField;
    @FindBy(css = "#reg_password")
    private WebElementFacade regPasswordField;
    @FindBy(css = ".u-column2 .woocommerce-Button")
    private WebElementFacade regButton;
    @FindBy(css = "#menu-item-1728")
    private WebElementFacade shopButton;

    public void setUserNameField(String userName){
        typeInto(userNameField, userName);
    }
    public void setPasswordField(String password){
        typeInto(passwordField, password);
    }
    public void clickOnLoginBtn(){
        clickOn(loginButton);
    }
    public boolean succesfulLoginMessage(){
        return helloMessage.containsText("Hello");
    }
    public void setRegEmailField(String email){
        typeInto(regEmailField, email);
    }
    public void setRegPasswordField(String password){
        typeInto(regPasswordField, password);
    }
    public void clickOnRegBtn(){
        clickOn(regButton);
    }
    public void clickOnShopBtn(){
        clickOn(shopButton);
    }
}
