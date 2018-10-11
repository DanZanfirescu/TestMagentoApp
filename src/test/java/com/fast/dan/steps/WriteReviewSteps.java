package com.fast.dan.steps;

import Utils.Constants;
import com.fast.dan.pages.DashboardPage;
import com.fast.dan.pages.ProductPage;
import com.fast.dan.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class WriteReviewSteps extends ScenarioSteps {

    private ShopPage shopPage;
    private DashboardPage dashboardPage;
    private ProductPage productPage;

    @Step
    public void goToReviews(){
        productPage.clickOnReviewsLink();
    }
    @Step
    public void setRating(){
        productPage.clickOnRating();
    }
    @Step
    public void setReviewText(){
        productPage.setReview();
    }
    @Step
    public void submitReview(){
        productPage.clickReviewBtn();
    }

    @StepGroup
    public void writeReview(){
        goToReviews();
        setRating();
        setReviewText();
        submitReview();
    }

    @Step
    public void clickCommentsBtn(){
        dashboardPage.clickOnComments();
    }
    @Step
    public void setSearchField(){
        dashboardPage.setSearchCommentField(Constants.COMMENT);
    }
    @Step
    public void clickOnSearchSunmit(){
        dashboardPage.clickOnSearchSubmit();
    }
    @Step
    public void clickOnReplay(){
        dashboardPage.clickOnReplayLink();
    }
    @Step
    public void setReplayText(){
        dashboardPage.setReplayTextField();
    }
    @Step
    public void clickOnReplayBtn(){
        dashboardPage.clickOnReplayBtn();
    }
    @Step
    public void clickOnTrash(){
        dashboardPage.clickOnTrash();
    }
    public void clickOnTrashBtn(){
        dashboardPage.clickOnTrashBtn();
    }
    public void deleteComments(){
        dashboardPage.deleteComments();
    }
    public void setSearchAdmin(){
        dashboardPage.setSearchAdminComment();
    }

    @StepGroup
    public void replayAndApproveReview(){
        clickCommentsBtn();
        setSearchField();
        clickOnSearchSunmit();
        clickOnReplay();
        setReplayText();
        clickOnReplayBtn();
    }

    @Step
    public void goToProductPage(){
        shopPage.navigateToSpecifiedProduct();
    }
    @Step
    public void checkReview(){
        Assert.assertTrue(productPage.checkReviewIsDisplayed());
    }

    @StepGroup
    public void deleteReviewsBeforeExit(){
        clickCommentsBtn();
        setSearchField();
        clickOnSearchSunmit();
        clickOnTrash();
        setSearchAdmin();
        clickOnSearchSunmit();
        clickOnTrash();
        clickOnTrashBtn();
        deleteComments();
    }
}
