package com.fast.dan.tests;

import com.fast.dan.steps.*;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private SelectRandomProductSteps selectRandomProductSteps;
    @Steps
    private CheckProductInCartSteps checkProductInCartSteps;
    @Steps
    private CheckoutSteps checkoutSteps;
    @Steps
    private AdminPanelLoginSteps adminPanelLoginSteps;

    @Test
    public void checkout(){
        loginSteps.loginSteps();
        selectRandomProductSteps.putRandomProductInCart();
        checkProductInCartSteps.goCart();
        checkoutSteps.clickOnProceedToCheckout();
        checkoutSteps.mandatoryFields();
        checkoutSteps.clickOnPlaceOrder();
        checkoutSteps.getOrderNumber();
        adminPanelLoginSteps.loginToAdminPanel();
        checkoutSteps.checkOrderInAdminPanel();
    }
}
