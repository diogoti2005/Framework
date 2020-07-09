package com.demoqa.shop.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class AccountPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@id='reg_username']")
    private WebElement field_username;
    @FindBy(how = How.XPATH, using = "//input[@id='reg_email']")
    private WebElement field_email;
    @FindBy(how = How.XPATH, using = "//input[@id='reg_password']")
    private WebElement field_password;
    @FindBy(how = How.XPATH, using = "//button[@name='register']")
    private WebElement button_register;
    @FindBy(how = How.XPATH, using = "//p[@class='login message']")
    private WebElement message_login;
    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    private WebElement field_username_login;
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement field_password_login;
    @FindBy(how = How.XPATH, using = "//div[@id='primary']//*//p[contains(text(),'Hello ')]")
    private WebElement message_username;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Log in')]")
    private WebElement button_login_account_page;
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Account details')]")
    private WebElement navigation_link_account_details;
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'woocommerce-message')]")
    private WebElement message_account_updated;

    public WebElement getMessage_account_updated() {
        return message_account_updated;
    }

    public WebElement getNavigation_link_account_details() {
        return navigation_link_account_details;
    }

    public WebElement getField_username() {

        return field_username;
    }

    public WebElement getField_email() {
        return field_email;
    }

    public WebElement getField_password() {
        return field_password;
    }

    public WebElement getButton_register() {
        return button_register;
    }

    public WebElement getMessage_login() {
        return message_login;
    }

    public WebElement getField_username_login() {
        return field_username_login;
    }

    public WebElement getField_password_login() {
        return field_password_login;
    }

    public WebElement getButton_login_account_page() {
        return button_login_account_page;
    }

    public WebElement getMessage_username() { return message_username; }

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUrl() {
        return "http://shop.demoqa.com/my-account/";
    }

    @Override
    public String getTitle() {
        return "My Account – ToolsQA Demo Site";
    }
}
