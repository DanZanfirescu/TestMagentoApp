package com.fast.dan.tests;

import Utils.Constants;
import com.fast.dan.steps.AdminPanelLoginSteps;
import com.fast.dan.steps.RegisterSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }

    @Steps
    private RegisterSteps registerSteps;
    @Steps
    private AdminPanelLoginSteps adminPanelLoginSteps;

    @Test
    public void registration(){
        registerSteps.navigateToHomePage();
        registerSteps.navigateToMyAccountPage();
        registerSteps.setRegCredentials(Constants.REG_EMAIL, Constants.REG_PASSWORD);
        registerSteps.clickRegBtn();
        adminPanelLoginSteps.loginToAdminPanel();
        registerSteps.clickUsersBtn();
        registerSteps.setSearchField();
        registerSteps.clickSearchBtn();
        registerSteps.checkIfUserIsRegistered();
        registerSteps.moveToUserAndClickOnDelete();
        registerSteps.clickOnConfirmationDelete();
    }
}
