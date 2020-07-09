package com.demoqa.shop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//input[@id='user_login']")
    private WebElement field_username_login_page;
    @FindBy(how = How.XPATH, using = "//input[@id='user_pass']")
    private WebElement field_password_login_page;
    @FindBy(how = How.XPATH, using = "//input[@id='wp-submit']")
    private WebElement button_register_login_page;
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Your session has expired because it has been over')]")
    private WebElement message_login_page;
    @FindBy(how = How.XPATH, using = "//p[@id='backtoblog']//a[contains(text(),'Back to ToolsQA Demo Site')]")
    private WebElement button_back_to_account;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getField_username_login_page() {
        return field_username_login_page;
    }

    public WebElement getMessage_login_page() {
        return message_login_page;
    }

    public WebElement getField_password_login_page() {
        return field_password_login_page;
    }

    public WebElement getButton_register_login_page() {
        return button_register_login_page;
    }

    public WebElement getButton_back_to_account() {
        return button_back_to_account;
    }


    @Override
    public String getUrl() {
        return "http://shop.demoqa.com/shop-demoqa?redirect_to=http%3A%2F%2Fshop.demoqa.com%2Fmy-account%2F&aiowps_login_msg_id=session_expired";
    }

    @Override
    public String getTitle() {
        return "Log In ‹ ToolsQA Demo Site — WordPress";
    }

}
