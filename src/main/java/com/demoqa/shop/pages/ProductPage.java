package com.demoqa.shop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage extends AbstractCommonPage {

    public ProductPage ( WebDriver driver ) {
        super ( driver );
    }

    @FindBy (xpath = "//span[normalize-space() = \"Product added!\"]" )
    private WebElement iconUnchecked;

    @FindBy(xpath = "//select[@id='pa_size']")
    private WebElement sizeDropdown;

    @FindBy(xpath = "//select[@id='pa_color']")
    private WebElement colorDropdown;

    @FindBy(xpath = "//button[@class='single_add_to_cart_button button alt']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//li[@id='nav-menu-item-cart']//a//span//i")
    private WebElement viewCart;

    @FindBy(css = ".add_to_wishlist.single_add_to_wishlist")
    private List < WebElement > wishlistIconOnProductPage;

    @FindBy(xpath = "//a[contains(text(),\"My Wishlist\")]")
    private WebElement myWishListLink;

    @FindBy(css = ".yith-wcwl-wishlistaddedbrowse")
    private WebElement iconIsChecked;

    @FindBy(xpath = "//span[contains(text(),'Products')]")
    private WebElement productsButton;


    @Override
    public String getUrl () {
        return "http://shop.demoqa.com/product/";
    }

    @Override
    public String getTitle () {
        return "Product Page";
    }

    public WebElement getIconUnchecked (){ return iconUnchecked; }

    public void selectColor ( String color ) {
        new Select ( colorDropdown ).selectByValue ( color );
    }

    public void selectSize ( String size ) {
        new Select ( sizeDropdown ).selectByValue ( size );
    }

    public void addToCart () {
        addToCartButton.click ( );
    }

    public void clickViewCart () {
        viewCart.click ( );
    }

    public void clickOnWishlistIcon () {
        wishlistIconOnProductPage.get ( 0 ).click ( );
    }

    public void goToMyWishListPage () {
        myWishListLink.click ( );
    }

    public List < WebElement > getWishlistIconOnProductPage () {
        return wishlistIconOnProductPage;
    }

    public WebElement getMyWishListLink () {
        return myWishListLink;
    }

    public WebElement getIconIsChecked () {
        return iconIsChecked;
    }

    public void clickProductsButton () {
        productsButton.click ( );
    }

}