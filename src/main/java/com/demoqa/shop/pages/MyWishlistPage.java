package com.demoqa.shop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyWishlistPage extends AbstractCommonPage {

    public MyWishlistPage ( WebDriver driver ) {
        super ( driver );
    }

    @FindBy(css = "tbody.wishlist-items-wrapper tr")
    private List < WebElement > numberOfItems;

    @FindBy(css = ".remove.remove_from_wishlist")
    private List < WebElement > removeFromWishlistButton;

    @FindBy(css = "td.product-name a")
    private WebElement productLink;

    @FindBy(css = ".woocommerce-message")
    private WebElement successfullMessageOfRemoveFromWishlist;


    @Override
    public String getUrl () {
        return "http://shop.demoqa.com/wishlist/";
    }

    @Override
    public String getTitle () {
        return "My Wishlist Page";
    }


    public void clickProductLink () { productLink.click ( ); }

    public void clickRemoveButtonFromWishlistPage () { getFirstRemoveButtonFromWL ( ).click ( ); }

    public int countNumberOfItems () { return numberOfItems.size ( ); }

    public WebElement getFirstRemoveButtonFromWL () { return removeFromWishlistButton.get ( 0 ); }

    public WebElement getSuccessfullMessageOfRemoveFromWishlist () { return successfullMessageOfRemoveFromWishlist; }
}
