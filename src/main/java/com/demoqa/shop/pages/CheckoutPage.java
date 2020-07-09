package com.demoqa.shop.pages;

import com.demoqa.shop.util.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CheckoutPage extends BasePage {
    @FindBy( css = "form[class*=\"login\"]" )
    private WebElement loginSection;

    @FindBy( css = ".showlogin" )
    private WebElement loginLink;

    @FindBy( id = "username" )
    private WebElement usernameTextField;

    @FindBy( id = "password" )
    private WebElement passwordTextField;

    @FindBy( css = "button[name=\"login\"]" )
    private WebElement loginButton;

    @FindBy( id = "billing_first_name" )
    private WebElement fistNameTextField;

    @FindBy( id = "billing_last_name" )
    private WebElement lastNameTextField;

    @FindBy( css = "input.select2-search__field" )
    private WebElement countryDropdown;

    @FindBy( id = "billing_address_1" )
    private WebElement billingAddressTextField;

    @FindBy( id = "billing_city" )
    private WebElement cityTextField;

    @FindBy( id = "billing_postcode" )
    private WebElement postCodeTextField;

    @FindBy( id = "billing_phone" )
    private WebElement phoneTextField;

    @FindBy( id = "billing_email" )
    private WebElement emailTextField;

    @FindBy( id = "terms" )
    private WebElement termsCheckbox;

    @FindBy( id = "place_order" )
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getUrl() {
        return "http://shop.demoqa.com/checkout/";
    }

    @Override
    public String getTitle() {
        return "Checkout Page";
    }

    public Boolean loginSectionIsDisplayed() {
        return loginSection.isDisplayed();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void insertUsername(String username) {
        usernameTextField.sendKeys(username);
    }

    public void insertPassword(String password) {
        passwordTextField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void insertFistName(String firstName) {
        fistNameTextField.sendKeys(firstName);
    }

    public void insertLastName(String firstName) {
        lastNameTextField.sendKeys(firstName);
    }

    public void selectCountry(String country) {
        WebElement arrow = Browser.getBrowser().findElement(By.cssSelector("span.select2-selection__arrow"));
        arrow.click();
        WebElement textDemo = Browser.getBrowser().findElement(By.xpath("//li[contains(text(),'" + country + "')]"));
        textDemo.click();
    }

    public void insertBillingAddress(String address) {
        billingAddressTextField.sendKeys(address);
    }

    public void insertCity(String city) {
        cityTextField.sendKeys(city);
    }

    public void insertPostCode(String postCode) {
        postCodeTextField.sendKeys(postCode);
    }

    public void insertPhone(String phone) {
        phoneTextField.sendKeys(phone);
    }

    public void insertEmail(String email) {
        emailTextField.sendKeys(email);
    }

    public WebElement getTermsCheckbox() {
        return termsCheckbox;
    }

    public void clickTerms() {
        Actions actions = new Actions(Browser.getBrowser());
        actions.moveToElement(termsCheckbox).click().build().perform();
    }

    public boolean termsIsSelected() {

        return termsCheckbox.isSelected();
    }

    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public void clearFistName() {
        fistNameTextField.clear();
    }

    public void clearLastName() {
        lastNameTextField.clear();
    }

    public void clearBillingAddress() {
        billingAddressTextField.clear();
    }

    public void clearCity() {
        cityTextField.clear();
    }

    public void clearPostCode() {
        postCodeTextField.clear();
    }

    public void clearPhone() {
        phoneTextField.clear();
    }

    public void clearEmail() {
        emailTextField.clear();
    }

    public String getValueFirstname() {
        return fistNameTextField.getAttribute("value");
    }

    public String getValueLastname() {
        return lastNameTextField.getAttribute("value");
    }

    public String getValueCountry() {
        return countryDropdown.getAttribute("value");
    }

    public String getValueBillingAddress() {
        return billingAddressTextField.getAttribute("value");
    }

    public String getValuePostcode() {
        return postCodeTextField.getAttribute("value");
    }

    public String getValueCity() {
        return cityTextField.getAttribute("value");
    }

    public String getValuePhone() {
        return phoneTextField.getAttribute("value");
    }

    public String getValueEmail() {
        return emailTextField.getAttribute("value");
    }

    public WebElement getLoginSection() {
        return loginSection;
    }

    public WebElement getFistNameTextField() {
        return fistNameTextField;
    }

    public WebElement getLastNameTextField() {
        return lastNameTextField;
    }

    public WebElement getCountryDropdown() {
        return countryDropdown;
    }

    public WebElement getBillingAddressTextField() {
        return billingAddressTextField;
    }

    public WebElement getPostCodeTextField() {
        return postCodeTextField;
    }

    public WebElement getPhoneTextField() {
        return phoneTextField;
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public WebElement getCity() {
        return cityTextField;
    }

    public Map<WebElement, String> getAlertMessages() {
        List<WebElement> alertList = Browser.getBrowser().findElements(By.cssSelector("ul.woocommerce-error"));
        Map<WebElement, String> alertMessages = new HashMap<>();
        for (WebElement alert : alertList) {
            alertMessages.put(alert, alert.getText());
        }
        return alertMessages;
    }

    public WebElement getAlerts() {
        return Browser.getBrowser().findElement(By.cssSelector("ul.woocommerce-error"));
    }
}
