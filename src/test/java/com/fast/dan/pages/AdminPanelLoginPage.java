package com.fast.dan.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;


@DefaultUrl("http://qa3.fasttrackit.org:8008/wp-login.php")
public class AdminPanelLoginPage extends PageObject {

    @FindBy(css = "#user_login")
    private WebElementFacade adminUserName;
    @FindBy(css = "#user_pass")
    private WebElementFacade adminPassword;
    @FindBy(css = "#wp-submit")
    private WebElementFacade adminSubmitButton;

    public void setAdminUserName(String userName){
        typeInto(adminUserName, userName);
    }
    public void setAdminPassword(String password){
        typeInto(adminPassword, password);
    }
    public void clickOnLoginBtn(){
        clickOn(adminSubmitButton);
    }
}
