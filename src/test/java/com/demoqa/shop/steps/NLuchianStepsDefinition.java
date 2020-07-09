package com.demoqa.shop.steps;

import com.demoqa.shop.pages.*;
import com.demoqa.shop.util.ATFAssert;
import com.demoqa.shop.util.Context;
import com.demoqa.shop.util.ScenarioContext;
import com.demoqa.shop.util.ScreenshotUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NLuchianStepsDefinition {
    Logger log = LoggerFactory.getLogger(NLuchianStepsDefinition.class);

    @When( "User select {string} item from main page" )
    public void userSelectAnItemFromMainPage(String string) {
        HomePage homePage = (HomePage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        if (string.toLowerCase().equals("first")) {
            homePage.clickFirstItem();
        } else if (string.toLowerCase().equals("last")) {
            homePage.clickSecondItem();
        } else {
            throw new IllegalStateException("Unexpected value for page name: " + string.toLowerCase());
        }
        log.info("user has selected {} item", string);
    }

    @When( "User select {string}" )
    public void userSelectOption(String string, String value) {
        ProductPage productpage = (ProductPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        switch (string.toLowerCase()) {
            case "color": {
                productpage.selectColor(value);
                break;
            }
            case "size": {
                productpage.selectSize(value);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value for dropdown: " + string.toLowerCase());
        }
        log.info("user has selected {} option", string);
    }

    @When( "User click on {string} button" )
    public void userClickButton(String string) throws InterruptedException {
        BasePage page = (BasePage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        switch (string.toLowerCase()) {
            case "add to cart": {
                ((ProductPage) page).addToCart();
                break;
            }
            case "view cart": {
                ((ProductPage) page).clickViewCart();
                break;
            }
            case "logo": {
                ((CartPage) page).clickLogo();
                break;
            }
            case "+": {
                ((CartPage) page).increaseQty();
                ScenarioContext.getInstance().setContext(Context.QUANTITY, ((CartPage) page).readQtyOFItem());
                break;
            }
            case "update shopping cart": {
                ((CartPage) page).updateCart();
                break;
            }
            case "clear cart": {
                ((CartPage) page).clearCart();
                break;
            }
            case "place order": {
                ((CheckoutPage) page).clickPlaceOrderButton();
                Thread.sleep(2000);
                break;
            }
            case "login": {
                ((CheckoutPage) page).clickLoginButton();
                break;
            }
            case "proceed checkout": {
                ((CartPage) page).clickProceedCheckout();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value for button name: " + string.toLowerCase());
        }
        log.info("user has clicked {} button", string );
        Thread.sleep(2000);
    }

    @Then( "Cart page is updated with right quantity of product" )
    public void cartPageIsUpdatedWithRightQuantityOfProduct() {
        CartPage page = (CartPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        int expectedQty = (int) ScenarioContext.getInstance().getContext(Context.QUANTITY);
        ScreenshotUtil.highLight(page.getIncreaseQTYInput());
        ScreenshotUtil.takeScreenshot("Increased qty of item");
       ATFAssert.assertEquals(expectedQty,page.readQtyOFItem(),"qty is wrong", "qty is displayed properly");
    }

    @Then( "Items are removed from Cart" )
    public void itemsAreRemovedFromCart() {
        CartPage page = (CartPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        ScreenshotUtil.scrollToTop();
        ScreenshotUtil.highLight(page.getEmptyCartMsg());
        ScreenshotUtil.takeScreenshot("empty cart message");
        ATFAssert.assertEquals("Your cart is currently empty.", page.getEmptyCartMsg().getText()
                ,"Empty cart message is not displayed", "message match the clear cart notification");

    }

    @Then( "Both items are added" )
    public void bothItemsAreAdded() {
        CartPage page = (CartPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        int countOfItems = page.countCartItems();
        log.info("actual result is " + countOfItems);
        ScreenshotUtil.scrollToElement(page.getCartItems());
        ScreenshotUtil.highLight(page.getCartItems());
        ScreenshotUtil.takeScreenshot("2 items in cart ");
        assertEquals(2, countOfItems);
        ATFAssert.assertEquals(2,countOfItems, "there are more or less than 2 items",
                "2 items are displayed in the cart");
    }
}