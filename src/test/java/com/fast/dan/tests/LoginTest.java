package com.fast.dan.tests;


import Utils.Constants;
import com.fast.dan.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void checkLoginWithValidCredentials(){
        loginSteps.navigateToHomePage();
        loginSteps.navigateToMyAccountPage();
        loginSteps.setCredentials(Constants.LOGIN_USER_NAME, Constants.LOGIN_PASSWORD);
        loginSteps.clickLoginBtn();
        loginSteps.succesfulLogin();
    }


}
