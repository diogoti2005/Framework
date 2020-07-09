package com.demoqa.shop.pages;

import com.demoqa.shop.util.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(css = "a.empty-cart")
    private WebElement clearCartButton;

    @FindBy(css = "input.button[name=\"update_cart\"]")
    private WebElement updateShoppingCartButton;

    @FindBy(css = "button.qty-increase")
    private WebElement qtyIncrease;

    @FindBy(css = "a[property = \"item\"]")
    private WebElement logoButton;

    @FindBy(css = "a[class$='forward']")
    private WebElement proceedCheckoutButton;

    @FindBy (xpath = "//tr[@class='cart_item']")
    private List<WebElement> cartItems;
//
    @FindBy(css = ".cart-empty")
    private WebElement emptyCartMsg;

    @FindBy(css = "input[id^=\"noo-quantity\"]")
    private WebElement increaseQTYInput;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://shop.demoqa.com/cart/";
    }

    @Override
    public String getTitle() {
        return "Cart Page";
    }

    public void clearCart() {
        clearCartButton.click();
    }

    public void updateCart() {
        updateShoppingCartButton.click();
    }

    public void increaseQty() {
        qtyIncrease.click();
    }

    public void clickLogo() {
        logoButton.click();
    }

    public int countCartItems (){
        return cartItems.size();
    };

    public void clickProceedCheckout() {
        proceedCheckoutButton.click();
    }

    public WebElement getEmptyCartMsg(){
        return emptyCartMsg;
    }

    public WebElement getCartItems() {
        return Browser.getBrowser().findElement(By.xpath("//article[@id='post-6']//div//div//form//table"));
    }

    public int readQtyOFItem (){
        String qtyInputField = increaseQTYInput.getAttribute("value");
        return Integer.parseInt(qtyInputField);
    }

    public WebElement getIncreaseQTYInput() {
        return increaseQTYInput;
    }
}