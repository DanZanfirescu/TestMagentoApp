package com.fast.dan.tests;

import Utils.Constants;
import com.fast.dan.steps.AdminPanelLoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AdminPanelLoginTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }

    @Steps
    private AdminPanelLoginSteps adminPanelLoginSteps;

    @Test
    public void adminPanelLogin(){
        adminPanelLoginSteps.navigateToAdminPanelLoginPage();
        adminPanelLoginSteps.serCredentials(Constants.ADMIN_USER_NAME, Constants.ADMIN_PASSWORD);
        adminPanelLoginSteps.clickLoginBtn();
        adminPanelLoginSteps.succesfulLogin();
    }
}
