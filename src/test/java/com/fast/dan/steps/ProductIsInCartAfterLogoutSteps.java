package com.fast.dan.steps;

import com.fast.dan.pages.CartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductIsInCartAfterLogoutSteps extends ScenarioSteps {

    private CartPage cartPage;

    @Step
    public void goToMyAccount(){
        cartPage.clickOnMyAccountBtn();
    }
    @Step
    public void logout(){
        cartPage.clickOnLogout();
    }
}
