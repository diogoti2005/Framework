package com.demoqa.shop.pages;

import com.demoqa.shop.util.ScreenshotUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class AbstractCommonPage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),\"My Wishlist\")]")
    private WebElement myWishListPage;
    @FindBy(css = ".noo-header.fixed_top.header-2")
    private WebElement header;

    AbstractCommonPage ( WebDriver driver ) {
        super ( driver );
    }

    public WebElement getHeader () {
        return header;
    }

    public void goToMyWishListPage () {
        ScreenshotUtil.scrollToTop ();
        myWishListPage.click ( );
    }

    public WebElement getMyWishListPage () {
        return myWishListPage;
    }
}
