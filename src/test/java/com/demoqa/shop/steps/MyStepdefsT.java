package com.demoqa.shop.steps;

import com.demoqa.shop.pages.*;
import com.demoqa.shop.util.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MyStepdefsT {
    Logger log = LoggerFactory.getLogger ( MyStepdefsT.class );

    @When("user add item to wishlist from Home page")
    public void userAddItemToWishlistFromHomePage () {
        HomePage homePage = (HomePage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        homePage.clickWishlistIconOnHomePage ( );
        ScreenshotUtil.takeScreenshot ( "HomePageScreen" );
        List < WebElement > addedProducts = Browser.getBrowser ( ).findElements ( By.cssSelector ( ".exists" ) );
        ATFAssert.assertTrue ( "Item is not added to wishlist from Home Page",addedProducts.size () > 0 , "Item is added to Wishlist" );
    }


    @When("user clicks on My Wishlist link")
    public void userGoToMyWishlistPage ( ) {
        AbstractCommonPage page = (AbstractCommonPage) ScenarioContext.getInstance ().getContext ( Context.CURRENT_PAGE );
        ScreenshotUtil.scrollToTop ();
        page.goToMyWishListPage ();
    }

    @Then("{int} item is displayed")
    public void addedItemIsDisplayed ( int countOfItem ) {
        MyWishlistPage myWishlistPage = (MyWishlistPage) ScenarioContext.getInstance ().getContext ( Context.CURRENT_PAGE );
        int numberofItems = myWishlistPage.countNumberOfItems ();
        log.info ( "actual result is" + numberofItems);
        ScreenshotUtil.takeScreenshot ( "1 item is displayed" );
        ATFAssert.assertEquals ( countOfItem , numberofItems, "The amount of items is incorrect", "The amount of items is correct" );
    }


    @When("user add item to wishlist")
    public void userAddItemToWishlist () {
        ProductPage productPage = (ProductPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        productPage.clickOnWishlistIcon ( );
    }

    @Then("icon is checked")
    public void iconIsChecked () {
        ProductPage productPage = (ProductPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        assertTrue ( productPage.getIconIsChecked ( ) != null , "Item is marked as added to Wishlist" );
    }

    @Then ("user go back to product page")
    public void userGoBackToProductPage () {
        MyWishlistPage myWishlistPage = (MyWishlistPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        myWishlistPage.clickProductLink ( );
        ScenarioContext.getInstance ( ).setContext ( Context.CURRENT_PAGE , new ProductPage ( Browser.getBrowser ( ) ) );
        ProductPage page = (ProductPage) ScenarioContext.getInstance ().getContext ( Context.CURRENT_PAGE );
        ATFAssert.assertEquals ( "Product Page", page.getTitle (), "Product Page is NOT displayed", "Product Page is displayed" );
    }

    @When("user uncheck wishlist icon")
    public void userUncheckWishlistIcon () {
        ProductPage page = (ProductPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        page.clickOnWishlistIcon ( );
    }

    @Then("icon is unchecked")
    public void iconIsUnchecked () {
        ProductPage page = (ProductPage) ScenarioContext.getInstance ().getContext ( Context.CURRENT_PAGE );
        ATFAssert.assertTrue ( "Item is marked as added to Wishlist ", page.getIconUnchecked ().isDisplayed (), "Icon is unchecked");
    }

    @When("user click on search input field")
    public void userClickOnSearchInputField () {
        HomePage homePage = (HomePage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        homePage.openSearchField ( );
        ATFAssert.assertNotNull ( homePage.getSearchIcon(), "", "" );
    }

    @When("user searches {string} category")
    public void userEnterTheDressCategory ( String string ) {
        HomePage homePage = (HomePage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        homePage.setSearchField ( string );
        ScenarioContext.getInstance ( ).setContext ( Context.CURRENT_PAGE , new SearchResultPage ( Browser.getBrowser ( ) ) );
        SearchResultPage page = (SearchResultPage) ScenarioContext.getInstance ().getContext ( Context.CURRENT_PAGE );
        ATFAssert.assertEquals ( "Search Result Page", page.getTitle (), "Search Result Page IS NOT displayed", "Search Result Page IS displayed" );
    }

    @When("user add to wishlist two items")
    public void userAddToWishlistTwoItems () throws InterruptedException {
        SearchResultPage searchResultPage = (SearchResultPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        searchResultPage.addFirstCategoryItemToWL ( );
        Thread.sleep(1000);
        searchResultPage.addSecondCategoryItemToWL ( );
        Thread.sleep(1000);
        Integer actual = searchResultPage.addedToWishlistItemsCount ();
        ATFAssert.assertEquals ( 2, actual, "Two items are NOT added ", "Two items are added" );
    }

    @When("remove first item")
    public void removeOneItem () throws InterruptedException {
        MyWishlistPage myWishlistPage = (MyWishlistPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        myWishlistPage.clickRemoveButtonFromWishlistPage ( );
        Thread.sleep(1000);
        ATFAssert.assertEquals ( 1, myWishlistPage.countNumberOfItems(), "Items IS NOT removed ", "Items IS removed" );
    }

    @Then("the list immediately renewed itself")
    public void theListImmediatelyRenewedItself () {
        Browser.getBrowser ( ).navigate ( ).refresh ( );
        MyWishlistPage myWishlistPage = (MyWishlistPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        ATFAssert.assertEquals ( 1, myWishlistPage.countNumberOfItems(), "Items IS NOT removed ", "Items IS removed" );
    }

    @Then("successfully message is displayed")
    public void successfullyMessageIsDisplayed () {
        MyWishlistPage myWishlistPage = (MyWishlistPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        ATFAssert.assertNotNull ( myWishlistPage.getSuccessfullMessageOfRemoveFromWishlist ( ) , "Success Message is NOT Displayed", "Success Message is Displayed" );
    }

    @When("Wishlist icon is checked")
    public void wishlistIconIsChecked () {
        ProductPage productPage = (ProductPage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        ATFAssert.assertNotNull ( productPage.getIconIsChecked ( ) , "Item is unchecked",  "Item is checked" );
    }

    @Then("input form is displayed")
    public void inputFormIsDisplayed () {
        HomePage homePage = (HomePage) ScenarioContext.getInstance ( ).getContext ( Context.CURRENT_PAGE );
        ATFAssert.assertTrue ( "Search field IS NOT displayed", homePage.searchFieldIsDisplayed ( ) , "Search field is displayed" );
    }
}
