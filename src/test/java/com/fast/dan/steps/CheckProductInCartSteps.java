package com.fast.dan.steps;

import Utils.Variables;
import com.fast.dan.pages.CartPage;
import com.fast.dan.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class CheckProductInCartSteps extends ScenarioSteps{

    private ShopPage shopPage;
    private CartPage cartPage;

    @Step
    public void goCart(){
        shopPage.goToCart();
    }
    @Step
    public void checkProduct(){
        Assert.assertTrue(Variables.getSelectedProductName().equals(cartPage.productNameInCart()));
    }
    @Step
    public void emtyCart(){
        cartPage.emptyCart();
    }
}
