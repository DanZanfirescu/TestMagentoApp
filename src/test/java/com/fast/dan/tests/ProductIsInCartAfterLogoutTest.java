package com.fast.dan.tests;

import com.fast.dan.steps.CheckProductInCartSteps;
import com.fast.dan.steps.LoginSteps;
import com.fast.dan.steps.ProductIsInCartAfterLogoutSteps;
import com.fast.dan.steps.SelectRandomProductSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class ProductIsInCartAfterLogoutTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }

    @Steps
    private SelectRandomProductSteps selectRandomProductSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CheckProductInCartSteps checkProductInCartSteps;

    @Steps
    private ProductIsInCartAfterLogoutSteps productIsInCartAfterLogoutSteps;

    @Test
    public void productRemainInCartAfterLogout(){
        loginSteps.loginSteps();
        selectRandomProductSteps.putRandomProductInCart();
        checkProductInCartSteps.goCart();
        checkProductInCartSteps.checkProduct();
        productIsInCartAfterLogoutSteps.goToMyAccount();
        productIsInCartAfterLogoutSteps.logout();
        loginSteps.loginSteps();
        checkProductInCartSteps.goCart();
        checkProductInCartSteps.checkProduct();
        checkProductInCartSteps.emtyCart();
    }



}
