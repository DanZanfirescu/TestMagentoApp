package com.fast.dan.pages;

import Utils.Constants;
import Utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://qa3.fasttrackit.org:8008/wp-admin/")
public class DashboardPage extends PageObject {

    @FindBy(css = ".wrap h1")
    private WebElementFacade dashboardText;
    @FindBy(css = "#menu-users")
    private WebElementFacade users;
    @FindBy(css = "#user-search-input")
    private WebElementFacade searchUserField;
    @FindBy(css = "#search-submit")
    private WebElementFacade searchButton;
    @FindBy(css = ".username strong a")
    private WebElementFacade userNameReturnedFromSearch;
    @FindBy(css = ".submitdelete")
    private WebElementFacade userDelete;
    @FindBy(css = "#submit")
    private WebElementFacade confirmDeleteButton;
    @FindBy(css = "#menu-comments")
    private WebElementFacade comments;
    @FindBy(css = "#comment-search-input")
    private WebElementFacade searchCommentField;
    @FindBy(css = ".comment .column-comment")
    private WebElementFacade searchedComment;
    @FindBy(css = ".vim-r ")
    private WebElementFacade replayLink;
    @FindBy(css = "#replycontent")
    private WebElementFacade replayTextField;
    @FindBy(css = "#replybtn")
    private WebElementFacade replayButton;
    @FindBy(css = ".vim-d")
    private WebElementFacade trashLink;
    @FindBy(css = ".subsubsub .trash")
    private WebElementFacade trashButton;
    @FindBy(css = ".top #delete_all")
    private WebElementFacade deleteAllBtn;
    @FindBy(css = "#menu-posts-product")
    private WebElementFacade productsButton;
    @FindBy(css = "#post-search-input")
    private WebElementFacade productSearchField;
    @FindBy(css = ".row-title")
    private WebElementFacade productTitle;
    @FindBy(css = ".inventory_options")
    private WebElementFacade inventoryLink;
    @FindBy(css = "#_stock_status")
    private WebElementFacade stockStatus;
    @FindBy(css = "#_stock_status option:nth-child(2)")
    private WebElementFacade outOfStockOption;
    @FindBy(css = "#publish")
    private WebElementFacade publishButton;
    @FindBy(css = "#_stock_status option:nth-child(1)")
    private WebElementFacade inStockOption;
    @FindBy(css = "#wp-admin-bar-my-account")
    private WebElementFacade adminLogout;
    @FindBy(css = "#wp-admin-bar-logout .ab-item")
    private WebElementFacade logoutLink;
    @FindBy(css = "#toplevel_page_woocommerce")
    private WebElementFacade commerceButton;
    @FindBy(css = ".order_number a:nth-child(2)")
    private WebElementFacade orderLink;
    @FindBy(css = ".woocommerce-order-data__heading")
    private WebElementFacade orderDetails;
    @FindBy(css = "#delete-action")
    private WebElementFacade orderToTrash;
    @FindBy(css = ".trash")
    private WebElementFacade trash;

    public boolean succesfulLogin(){
        return dashboardText.getText().equals("Dashboard");
    }
    public void clickOnUsers(){
        clickOn(users);
    }
    public void setSearchUserField(){
        typeInto(searchUserField, Constants.USER_NAME);
    }
    public void clickOnSearchBtn(){
        clickOn(searchButton);
    }
    public boolean userFound(){
        System.out.println(userNameReturnedFromSearch.getText());
        return Constants.USER_NAME.equals(userNameReturnedFromSearch.getText());
    }
    public void clickOnUserDelete(){
        moveTo(".username strong a");
        clickOn(userDelete);
    }
    public void clickConfirmDeleteBtn(){
        clickOn(confirmDeleteButton);
    }
    public void clickOnComments(){
        clickOn(comments);
    }
    public void setSearchCommentField(String comment){
        typeInto(searchCommentField, comment);
    }
    public void clickOnSearchSubmit(){
        clickOn(searchButton);
    }
    public void clickOnReplayLink(){
        moveTo(".comment .column-comment");
        clickOn(replayLink);
    }
    public void clickOnTrash(){
        moveTo(".comment .column-comment");
        clickOn(trashLink);
    }
    public void setReplayTextField(){
        typeInto(replayTextField, Constants.COMMENT_REPLAY);
    }
    public void clickOnReplayBtn(){
        clickOn(replayButton);
    }
    public void clickOnTrashBtn(){
        clickOn(trashButton);
    }
    public void deleteComments(){
        clickOn(deleteAllBtn);
    }
    public void setSearchAdminComment(){
        typeInto(searchCommentField, Constants.COMMENT_REPLAY);
    }
    public void clickOnProductsBtn(){
        clickOn(productsButton);
    }
    public void setProductSearchField(){
        typeInto(productSearchField, Variables.getSelectedProductName());
    }
    public void clickOnProductSearch(){
        clickOn(searchButton);
    }
    public void clickOnProductTitle(){
        clickOn(productTitle);
    }
    public void clickOnInventoryLink(){
        clickOn(inventoryLink);
    }
    public void clickStockStatus(){
        clickOn(stockStatus);
    }
    public void selectOutOfStockOption(){
        clickOn(outOfStockOption);
    }
    public void clickOnPublishBtn(){
        moveTo("#publish");
        clickOn(publishButton);
    }
    public void selectInStockOption(){
        clickOn(inStockOption);
    }
    public void moveToAdminLogout(){
        moveTo("#wp-admin-bar-my-account");
    }
    public void clickOnLogout(){
        clickOn(logoutLink);
    }

    public void clickOnCommerce(){
        clickOn(commerceButton);
    }
    public void setOrderSearchField(){
        typeInto(productSearchField, Variables.getOrderNo());
    }
    public void clickOnSearchBtnOrder(){
        clickOn(searchButton);
    }
    public void clickOnOrderLink(){
        clickOn(orderLink);
    }
    public String getOrderDetails(){
        return orderDetails.getText();
    }
    public void moveOrderToTrash(){
        clickOn(orderToTrash);
    }
    public void clickOnTrashLink(){
        clickOn(trash);
    }


}
