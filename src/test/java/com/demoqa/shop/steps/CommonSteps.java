package com.demoqa.shop.steps;

import com.demoqa.shop.pages.*;
import com.demoqa.shop.util.*;
import io.cucumber.java.en.Given;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommonSteps {
    Logger log = LoggerFactory.getLogger(CommonSteps.class);

    @Given( "{string} page is displayed" )
    public void validatePage(String string) {

        String currentURL = Browser.getBrowser().getCurrentUrl();
        BasePage page;
        switch (string.toLowerCase()) {
            case "home": {
                page = new HomePage(Browser.getBrowser());
                break;
            }
            case "cart": {
                page = new CartPage(Browser.getBrowser());
                break;
            }
            case "product": {
                page = new ProductPage(Browser.getBrowser());
                break;
            }
            case "checkout": {
                page = new CheckoutPage(Browser.getBrowser());
                break;
            }
            case "order received": {
                page = new OrderReceivedPage(Browser.getBrowser());
                break;
            }
            case "my wishlist": {
                page = new MyWishlistPage(Browser.getBrowser());
                break;
            }
            case "searchresultpage": {
                page = new SearchResultPage(Browser.getBrowser());
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value for page name: " + string.toLowerCase());
        }
        ATFAssert.assertTrue("Wrong page is displayed",currentURL.contains(page.getUrl()),string.concat(" is displayed"));
        ScreenshotUtil.takeScreenshot ( string );
        ScenarioContext.getInstance().setContext(Context.CURRENT_PAGE, page);
    }
}
