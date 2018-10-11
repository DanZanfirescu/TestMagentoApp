package com.fast.dan.pages;

import Utils.Constants;
import Utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class CheckoutPage extends PageObject {

    @FindBy(css = "#billing_first_name")
    private WebElementFacade firtsNameField;
    @FindBy(css = "#billing_last_name")
    private WebElementFacade lastNameField;
    @FindBy(css ="#billing_address_1_field #billing_address_1")
    private WebElementFacade firstAddressField;
    @FindBy(css = "#billing_address_2")
    private WebElementFacade secondAddressField;
    @FindBy(css = "#billing_city_field #billing_city")
    private WebElementFacade cityField;
    @FindBy(css = "#billing_postcode_field #billing_postcode")
    private WebElementFacade zipCodeField;
    @FindBy(css = "#billing_phone")
    private WebElementFacade phoneField;
    @FindBy(css = "#billing_email")
    private WebElementFacade emailField;
    @FindBy(css = "#place_order")
    private WebElementFacade placeOrderButton;
    @FindBy(css = ".woocommerce-order-overview li:first-child strong")
    private WebElementFacade orderNumber;
    public Variables orderNo = new Variables();

    public void setFirtsNameField(){
        moveTo("#billing_first_name");
        typeInto(firtsNameField, Constants.FIRST_NAME);
    }
    public void setLastNameField(){
        moveTo("#billing_last_name");
        typeInto(lastNameField, Constants.LAST_NAME);
    }
    public void setFirstAddressField(){
        moveTo("#billing_address_1_field #billing_address_1");
        typeInto(firstAddressField, Constants.FIRST_ADDRESS_FIELD);
    }
    public void setCityField(){
        moveTo("#billing_city_field #billing_city");
        typeInto(cityField, Constants.CITY);
    }
    public void setZipCodeField(){
        moveTo("#billing_postcode_field #billing_postcode");
        typeInto(zipCodeField, Constants.ZIP_CODE);
    }
    public void setPhoneField(){
        moveTo("#billing_phone");
        typeInto(phoneField, Constants.PHONE);
    }
    public void clickOnPlaceOrder(){
        moveTo("#place_order");
        clickOn(placeOrderButton);
    }
    public void getOrderNumber(){
        orderNo.setOrderNo(orderNumber.getText());
    }
}
