package com.fast.dan.steps;

import Utils.Constants;
import com.fast.dan.pages.AdminPanelLoginPage;
import com.fast.dan.pages.DashboardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class AdminPanelLoginSteps extends ScenarioSteps{

    private AdminPanelLoginPage adminPanelLoginPage;
    private DashboardPage dashboardPage;

    @Step
    public void navigateToAdminPanelLoginPage(){
        adminPanelLoginPage.open();
    }
    @Step
    public void serCredentials(String userName, String password){
        adminPanelLoginPage.setAdminUserName(userName);
        adminPanelLoginPage.setAdminPassword(password);
    }
    @Step
    public void clickLoginBtn(){
        adminPanelLoginPage.clickOnLoginBtn();
    }
    @Step
    public void succesfulLogin(){
        Assert.assertTrue(dashboardPage.succesfulLogin());
    }

    @StepGroup
    public void loginToAdminPanel(){
        navigateToAdminPanelLoginPage();
        serCredentials(Constants.ADMIN_USER_NAME, Constants.ADMIN_PASSWORD);
        clickLoginBtn();
        succesfulLogin();
    }
}
