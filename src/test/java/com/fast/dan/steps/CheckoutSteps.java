package com.fast.dan.steps;

import Utils.Variables;
import com.fast.dan.pages.CartPage;
import com.fast.dan.pages.CheckoutPage;
import com.fast.dan.pages.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class CheckoutSteps extends ScenarioSteps {

    private CheckoutPage checkoutPage;
    private CartPage cartPage;
    private DashboardPage dashboardPage;

    @Step
    public void clickOnProceedToCheckout(){
        cartPage.clickOnProceedToCheckout();
    }
    @Step
    public void typeFirsteName(){
        checkoutPage.setFirtsNameField();
    }
    @Step
    public void typeLastName(){
        checkoutPage.setLastNameField();
    }
    @Step
    public void typeAddress(){
        checkoutPage.setFirstAddressField();
    }
    @Step
    public void typeCity(){
        checkoutPage.setCityField();
    }
    @Step
    public void typeZipCode(){
        checkoutPage.setZipCodeField();
    }
    @Step
    public void typePhone(){
        checkoutPage.setPhoneField();
    }
    @Step
    public void clickOnPlaceOrder(){
        checkoutPage.clickOnPlaceOrder();
    }
    @Step
    public void getOrderNumber(){
        checkoutPage.getOrderNumber();
    }

    @StepGroup
    public void mandatoryFields(){
        typeFirsteName();
        typeLastName();
        typeAddress();
        typeCity();
        typeZipCode();
        typePhone();
    }

    @Step
    public void goToCommerce(){
        dashboardPage.clickOnCommerce();
    }
    @Step
    public void typeOrderNumber(){
        dashboardPage.setOrderSearchField();
    }
    @Step
    public void clickOnSearchBtn(){
        dashboardPage.clickOnSearchBtnOrder();
    }
    @Step
    public void clickOnOrderLink(){
        dashboardPage.clickOnOrderLink();
    }
    @Step
    public void checkOrderNumber(){
        Assert.assertTrue(dashboardPage.getOrderDetails().contains(Variables.getOrderNo()));
    }
    @Step
    public void moveOrderToTrash(){
        dashboardPage.moveOrderToTrash();
    }
    @Step
    public void clickOnTrashLink(){
        dashboardPage.clickOnTrashLink();
    }
    @Step
    public void deleteOrder(){
        dashboardPage.deleteComments();
    }

    @StepGroup
    public void checkOrderInAdminPanel(){
        goToCommerce();
        typeOrderNumber();
        clickOnSearchBtn();
        clickOnOrderLink();
        checkOrderNumber();
        moveOrderToTrash();
        clickOnTrashLink();
        deleteOrder();
    }






}
