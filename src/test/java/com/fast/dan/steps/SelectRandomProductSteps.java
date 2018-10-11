package com.fast.dan.steps;

import com.fast.dan.pages.MyAccountPage;
import com.fast.dan.pages.ShopPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

public class SelectRandomProductSteps extends ScenarioSteps {
    private ShopPage shopPage;
    private MyAccountPage myAccountPage;

    @Step
    public void clickOnShopBtn(){
        myAccountPage.clickOnShopBtn();
    }
    @Step
    public void readNumberOfProductsDisplayed(){
        shopPage.readNumberOfProductsDisplayedOnPage();
    }
    @Step
    public void readNumberOfProducts(){
        shopPage.readTotalNumberOfProducts();
    }
    @Step
    public void calculateTotalNumberOfPages(){
        shopPage.totalNumberOfPages();
    }
    @Step
    public void generateRandomPageNumber(){
        shopPage.randomPageNumber();
    }
    @Step
    public void navigateToRandomPage(){
        shopPage.navigateToRandomPage();
    }
    @Step
    public void generateRandomProduct(){
        shopPage.randomProduct();
    }
    @Step
    public void navigateToRandomProductPage(){
        shopPage.moveToProductAndClick();
    }
    @Step
    public void checkThatIsAtLeastOneProductInStockOnPage(){
        shopPage.checkThatIsAtLeastOneProductInStockOnPage();
    }
    @Step
    public void selectAndAddToCart(){
        shopPage.selectAndAddToCart();
    }

    @StepGroup
    public void goToRandomProductPage(){
        clickOnShopBtn();
        readNumberOfProductsDisplayed();
        readNumberOfProducts();
        calculateTotalNumberOfPages();
        generateRandomPageNumber();
        navigateToRandomPage();
        generateRandomProduct();
        navigateToRandomProductPage();
    }

    @StepGroup
    public void putRandomProductInCart(){
        clickOnShopBtn();
        readNumberOfProductsDisplayed();
        readNumberOfProducts();
        calculateTotalNumberOfPages();
        generateRandomPageNumber();
        navigateToRandomPage();
        checkThatIsAtLeastOneProductInStockOnPage();
        generateRandomProduct();
        selectAndAddToCart();
    }
}
