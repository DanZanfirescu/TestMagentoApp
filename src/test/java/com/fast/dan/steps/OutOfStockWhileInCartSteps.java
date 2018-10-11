package com.fast.dan.steps;

import Utils.Constants;
import com.fast.dan.pages.CartPage;
import com.fast.dan.pages.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import org.junit.Assert;

public class OutOfStockWhileInCartSteps {

    private DashboardPage dashboardPage;
    private CartPage cartPage;

    @Step
    public void goToProducts(){
        dashboardPage.clickOnProductsBtn();
    }
    @Step
    public void typeProductName(){
        dashboardPage.setProductSearchField();
    }
    @Step
    public void clickSearch(){
        dashboardPage.clickOnProductSearch();
    }
    @Step
    public void goToSearchedProduct(){
        dashboardPage.clickOnProductTitle();
    }
    @Step
    public void goToInventory(){
        dashboardPage.clickOnInventoryLink();
    }
    @Step
    public void goToStock(){
        dashboardPage.clickStockStatus();
    }
    @Step
    public void selectOption(){
        dashboardPage.selectOutOfStockOption();
    }
    @Step
    public void publish(){
        dashboardPage.clickOnPublishBtn();
    }
    @Step
    public void selectInStockOption(){
        dashboardPage.selectInStockOption();
    }
    @Step
    public void goToAdminLogout(){
        dashboardPage.moveToAdminLogout();
    }
    @Step
    public void clickOnLogout(){
        dashboardPage.clickOnLogout();
    }
    @Step
    public void proceedToCheckout(){
        cartPage.clickOnProceedToCheckout();
    }
    @Step
    public void check(){
        Assert.assertTrue(cartPage.getTextMessage().contains(Constants.OUT_OF_STOCK));
    }
    @Step
    public void goBack(){
        cartPage.clickOnbackButton();
    }

    @StepGroup
    public void putProductOutOfStock(){
        goToProducts();
        typeProductName();
        clickSearch();
        goToSearchedProduct();
        goToInventory();
        goToStock();
        selectOption();
        publish();
        goToAdminLogout();
        clickOnLogout();

    }

    @StepGroup
    public void putProductBackInStock(){
        goToProducts();
        typeProductName();
        clickSearch();
        goToSearchedProduct();
        goToInventory();
        goToStock();
        selectInStockOption();
        publish();
    }






}
