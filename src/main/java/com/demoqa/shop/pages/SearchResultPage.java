package com.demoqa.shop.pages;

import com.demoqa.shop.util.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends AbstractCommonPage {
    @FindBy(css = ".exists")
    private List < WebElement > addedToWishlistItems;

    @FindBy(css = ".noo-container-shop.noo-shop-wrap")
    private List < WebElement > listOfProducts;

    @FindBy(css = "a[data-product-id='1473']")
    private WebElement firstCategoryItem;

    @FindBy(css = "a[data-product-id='1467']")
    private WebElement secondCategoryItem;


    public SearchResultPage ( WebDriver driver ) {
        super ( driver ); }

    public final String searchResultPageURL = "http://shop.demoqa.com/?s=";

    @Override
    public String getUrl () {
        return searchResultPageURL;
    }

    @Override
    public String getTitle () {
        return "Search Result Page";
    }

    public int addedToWishlistItemsCount () { return addedToWishlistItems.size (); }

    public void addFirstCategoryItemToWL () {
        firstCategoryItem.click ( );
    }

    public void addSecondCategoryItemToWL () {
        secondCategoryItem.click ( );
    }

    public List < WebElement > getListOfProducts () {
        return listOfProducts;
    }

    public int test(){
        List <WebElement> list= Browser.getBrowser().findElements( By.cssSelector ( ".exists"));
        return list.size ();
    }
}

