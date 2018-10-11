package com.fast.dan.steps;


import Utils.Constants;
import com.fast.dan.pages.Homepage;
import com.fast.dan.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class LoginSteps extends ScenarioSteps {

    private MyAccountPage myAccountPage;
    private Homepage homepage;

    @Step
    public void navigateToHomePage(){
        homepage.open();
    }
    @Step
    public void navigateToMyAccountPage(){
        homepage.clickMyAccountButton();
    }
    @Step
    public void setCredentials(String userName, String password){
        myAccountPage.setUserNameField(userName);
        myAccountPage.setPasswordField(password);
    }
    @Step
    public void clickLoginBtn(){
        myAccountPage.clickOnLoginBtn();
    }
    @Step
    public void succesfulLogin(){
        Assert.assertTrue(myAccountPage.succesfulLoginMessage());
    }

   @StepGroup
    public void loginSteps(){
        navigateToHomePage();
        navigateToMyAccountPage();
        setCredentials(Constants.LOGIN_USER_NAME, Constants.LOGIN_PASSWORD);
        clickLoginBtn();
        succesfulLogin();
    }
}
