package com.fast.dan.steps;

import com.fast.dan.pages.DashboardPage;
import com.fast.dan.pages.Homepage;
import com.fast.dan.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class RegisterSteps extends ScenarioSteps {

    private MyAccountPage myAccountPage;
    private Homepage homepage;
    private DashboardPage dashboardPage;

    @Step
    public void navigateToHomePage(){
        homepage.open();
    }
    @Step
    public void navigateToMyAccountPage(){
        homepage.clickMyAccountButton();
    }
    @Step
    public void setRegCredentials(String email, String password){
        myAccountPage.setRegEmailField(email);
        myAccountPage.setRegPasswordField(password);
    }
    @Step
    public void clickRegBtn(){
        myAccountPage.clickOnRegBtn();
    }
    @Step
    public void clickUsersBtn(){
        dashboardPage.clickOnUsers();
    }
    @Step
    public void setSearchField(){
        dashboardPage.setSearchUserField();
    }
    @Step
    public void clickSearchBtn(){
        dashboardPage.clickOnSearchBtn();
    }
    @Step
    public void checkIfUserIsRegistered(){
        Assert.assertTrue(dashboardPage.userFound());
    }
    @Step
    public void moveToUserAndClickOnDelete(){
        dashboardPage.clickOnUserDelete();
    }
    @Step
    public void clickOnConfirmationDelete(){
        dashboardPage.clickConfirmDeleteBtn();
    }
}
