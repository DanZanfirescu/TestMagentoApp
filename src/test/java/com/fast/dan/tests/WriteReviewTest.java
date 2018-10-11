package com.fast.dan.tests;

import com.fast.dan.steps.AdminPanelLoginSteps;
import com.fast.dan.steps.LoginSteps;
import com.fast.dan.steps.SelectRandomProductSteps;
import com.fast.dan.steps.WriteReviewSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class WriteReviewTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximise(){
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private WriteReviewSteps writeReviewSteps;

    @Steps
    private AdminPanelLoginSteps adminPanelLoginSteps;

    @Steps
    private SelectRandomProductSteps selectRandomProductSteps;

    @Test
    public void writeReview(){
        loginSteps.loginSteps();
        selectRandomProductSteps.goToRandomProductPage();
        writeReviewSteps.writeReview();
        adminPanelLoginSteps.loginToAdminPanel();
        writeReviewSteps.replayAndApproveReview();
        writeReviewSteps.goToProductPage();
        writeReviewSteps.goToReviews();
        writeReviewSteps.checkReview();
        adminPanelLoginSteps.loginToAdminPanel();
        writeReviewSteps.deleteReviewsBeforeExit();
    }

}
