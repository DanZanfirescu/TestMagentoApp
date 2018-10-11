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
public class OutOfStockWhileInCartTest {

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
    private AdminPanelLoginSteps adminPanelLoginSteps;
    @Steps
    private OutOfStockWhileInCartSteps outOfStockWhileInCartSteps;
    @Steps
    private CheckProductInCartSteps checkProductInCartSteps;

    @Test
    public void outOfStockInCart(){
        loginSteps.loginSteps();
        selectRandomProductSteps.putRandomProductInCart();
        adminPanelLoginSteps.loginToAdminPanel();
        outOfStockWhileInCartSteps.putProductOutOfStock();
        loginSteps.loginSteps();
        checkProductInCartSteps.goCart();
        outOfStockWhileInCartSteps.proceedToCheckout();
        outOfStockWhileInCartSteps.check();
        outOfStockWhileInCartSteps.goBack();
        checkProductInCartSteps.emtyCart();
        adminPanelLoginSteps.loginToAdminPanel();
        outOfStockWhileInCartSteps.putProductBackInStock();
    }
}
