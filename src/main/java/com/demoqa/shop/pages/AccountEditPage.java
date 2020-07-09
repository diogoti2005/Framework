package com.demoqa.shop.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AccountEditPage extends BasePage {


    @FindBy(how = How.XPATH, using = "//input[@id='account_first_name']")
    private WebElement field_first_name;
    @FindBy(how = How.XPATH, using = "//input[@id='account_last_name']")
    private WebElement field_last_name;
    @FindBy(how = How.XPATH, using = "//input[@id='password_current']")
    private WebElement field_password_current;
    @FindBy(how = How.XPATH, using = "//input[@id='password_1']")
    private WebElement field_password_new1;
    @FindBy(how = How.XPATH, using = "//input[@id='password_2']")
    private WebElement field_password_new2;
    @FindBy(how = How.XPATH, using = "//li[contains(text(),'Your current password is incorrect.')]")
    private WebElement message_current_passwords_is_incorrect;
    @FindBy(how = How.XPATH, using = "//input[@id='account_display_name']")
    private WebElement field_display_name;
    @FindBy(how = How.XPATH, using = "//input[@id='account_email']")
    private WebElement field_account_email;
    @FindBy(how = How.XPATH, using = "//button[contains(@name,'save_account_details')]")
    private WebElement button_save_account;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Log in')]")
    private WebElement button_login_account_page;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'woocommerce-message')]")
    private WebElement message_account_updated;

    public WebElement getField_first_name() {
        return field_first_name;
    }

    public WebElement getField_last_name() {
        return field_last_name;
    }

    public WebElement getField_password_current() {
        return field_password_current;
    }

    public WebElement getField_password_new1() {
        return field_password_new1;
    }

    public WebElement getField_password_new2() {
        return field_password_new2;
    }

    public WebElement getMessage_current_passwords_is_incorrect() {
        return message_current_passwords_is_incorrect;
    }

    public WebElement getField_display_name() {
        return field_display_name;
    }

    public WebElement getButton_login_account_page() {
        return button_login_account_page;
    }

    public WebElement getButton_save_account() {
        return button_save_account;
    }

    public WebElement getMessage_account_updated() {
        return message_account_updated;
    }

    public AccountEditPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getField_account_email() {
        return field_account_email;
    }

    @Override
    public String getUrl() {
        return "http://shop.demoqa.com/my-account/edit-account/";
    }

    @Override
    public String getTitle() {
        return "My Account – ToolsQA Demo Site";
    }


}
