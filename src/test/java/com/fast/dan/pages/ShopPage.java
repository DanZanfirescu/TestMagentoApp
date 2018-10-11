package com.fast.dan.pages;

import Utils.Variables;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@DefaultUrl("http://qa3.fasttrackit.org:8008/?post_type=product")
public class ShopPage extends PageObject {


    @FindBy(css = ".woocommerce-result-count")
    private WebElementFacade numberOfProductsAndProductOnPage;
    @FindBy(css = ".products li")
    private List<WebElementFacade> productList;
    @FindBy(css = ".fa-shopping-cart")
    private WebElementFacade cartButton;

    private int numberOfProductsDisplayedOnPage;
    private int numberOfProducts;
    private int totalNumberOfPages;
    private int productsOnLastPage;
    private int randomPageNumber;
    private int randomIndexOfProduct;
    public String selectedProductName;
    public Variables selectedProduct = new Variables();

    //Afla cate produse se afla pe pagina
    public void readNumberOfProductsDisplayedOnPage(){
        String textFromElement = numberOfProductsAndProductOnPage.getText().trim();
        String[] splitedText = textFromElement.split(" of ");
        String[] productsDisplayed = splitedText[0].split(" ");
        String[]numberOfProductsOnPage = productsDisplayed[1].split("–");
        String numberOfProductsDisplayed = numberOfProductsOnPage[1];
        numberOfProductsDisplayedOnPage = Integer.valueOf(numberOfProductsDisplayed);
    }

    //Afla numarul total de produse
    public void readTotalNumberOfProducts(){
        String textFromElement = numberOfProductsAndProductOnPage.getText().trim();
        String[] splitedText = textFromElement.split(" of ");
        String[] products = splitedText[1].split(" ");
        String totalProducts = products[0];
        numberOfProducts = Integer.valueOf(totalProducts);
    }

    //Calculeaza cate pagini de produse sunt si salveaza valoarea ca int. Daca pe ultima pagina sunt mai putine produse salveaza acel numar.
    public void totalNumberOfPages(){
        if(numberOfProducts % numberOfProductsDisplayedOnPage == 0){
            totalNumberOfPages = numberOfProducts / numberOfProductsDisplayedOnPage;
        }
        else{
            totalNumberOfPages = numberOfProducts / numberOfProductsDisplayedOnPage + 1;
            productsOnLastPage = numberOfProducts % numberOfProductsDisplayedOnPage;
        }
    }

    //Genereaza un numar random in intervalul inchis [1-numarul de pagini de produse].
    public void randomPageNumber() {
        int min = 1;
        int max = totalNumberOfPages;
        randomPageNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
        System.out.println("Numarul paginii generat Random: "+randomPageNumber);
    }

    //Navigheaza la randomPage by URL
    public void navigateToRandomPage() {
        String urlRandom = "http://qa3.fasttrackit.org:8008/?post_type=product&paged=" + randomPageNumber ;
        getDriver().navigate().to(urlRandom);
    }

    //Navigheza la pagina unui produs specificat
    public void navigateToSpecifiedProduct(){
        String urlProduct = "http://qa3.fasttrackit.org:8008/?product=" + Variables.getSelectedProductName();
        getDriver().navigate().to(urlProduct);
    }

    //Genereaza un numar random in intervalul [0, numarul de produse afisate/pagina), indexul elementului produs.
    public void randomProduct(){
        int min = 0;
        int max;
        if(randomPageNumber == totalNumberOfPages && productsOnLastPage != 0) {
            max = productsOnLastPage;
        }else {
            max = numberOfProductsDisplayedOnPage;
        }
        randomIndexOfProduct = ThreadLocalRandom.current().nextInt(min, max);
        System.out.println("Indexul produsului generat random: " + randomIndexOfProduct);
    }

    //Verifica daca exista cel putin un produs pe pagina care poate fi bagat in cos. Daca nu genereaza alta pagina
    public void checkThatIsAtLeastOneProductInStockOnPage() {
        boolean repeat = true;
        boolean inStockProductIsDisplayedOnRandomPage = false;
        WebElementFacade element;
        do{
            for (int i = 0; i < productList.size(); i++) {
                element = productList.get(i);
                if(element.containsElements(".add_to_cart_button")) {
                    inStockProductIsDisplayedOnRandomPage = true;
                    repeat = false;
                    break;
                }
            }
            if(inStockProductIsDisplayedOnRandomPage == false) {
                randomPageNumber();
                navigateToRandomPage();
            }
        }while (repeat) ;
    }

    //Verifica daca produsul corespunzator indexului generat este in stoc(are pe el buton ""Add to cart"). Daca da, du-te la el si da click pe el. Daca nu genereaza alt index si repeta operatia.
    public void selectAndAddToCart() {
        boolean repeat = true;
        do {
            if(productList.get(randomIndexOfProduct).containsElements(".add_to_cart_button")){
                productList.get(randomIndexOfProduct).then().findBy(".add_to_cart_button").then().getCoordinates().inViewPort().getX();
                productList.get(randomIndexOfProduct).then().findBy(".add_to_cart_button").then().click();
                selectedProductName = productList.get(randomIndexOfProduct).findBy(".woocommerce-loop-product__title").getText();
                selectedProduct.setSelectedProductName(selectedProductName);
                System.out.println("Numele produsului selectat random: " + selectedProductName);
                repeat = false;
                break;
            }
            else {
                randomProduct();
            }
        } while (repeat);
    }

    //Navigheaza la pagina produsului.
    public void moveToProductAndClick(){
        WebElementFacade product = productList.get(randomIndexOfProduct);
        product.getCoordinates().inViewPort().getX();
        selectedProductName = product.findBy(".woocommerce-loop-product__title").getText();
        selectedProduct.setSelectedProductName(selectedProductName);
        System.out.println("Numele produsului selectat random: " + selectedProductName);
        product.findBy(".woocommerce-loop-product__title").click();
    }

    //Du-te in cos
    public void goToCart(){
        moveTo(".fa-shopping-cart");
        clickOn(cartButton);
    }
}
