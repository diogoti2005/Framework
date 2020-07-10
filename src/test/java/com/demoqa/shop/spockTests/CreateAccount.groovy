package com.demoqa.shop.spockTests

import com.demoqa.shop.pages.AccountPage
import com.demoqa.shop.pages.HomePage
import com.demoqa.shop.pages.LoginPage
import com.demoqa.shop.util.Browser
import com.demoqa.shop.util.Context
import com.demoqa.shop.util.RandomString
import com.demoqa.shop.util.ScenarioContext
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import spock.lang.Specification

class CreateAccount extends Specification {
    WebDriver driver = Browser.getBrowser()

    def "create an  account"() {
        setup:
        WebDriver browser = Browser.getBrowser()
        def homePage = new HomePage(browser)
        homePage.clickDismiss()
        ScenarioContext.getInstance().setContext(Context.CURRENT_PAGE, homePage)
        and:
        homePage.getLnk_MyAccount().click()
        ScenarioContext.getInstance().setContext(Context.CURRENT_PAGE, new AccountPage(driver))
        when:
        def accountPage = (AccountPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE)
        ScenarioContext.getInstance().setContext(Context.NEW_LOGINNAME, RandomString.getAlphaNumericString(8))
        String name = ScenarioContext.getInstance().getContext(Context.NEW_LOGINNAME).toString()
        ScenarioContext.getInstance().setContext(Context.NEW_EMAIL, RandomString.getAlphaNumericString(5) + "@mail.ru")
        String email = ScenarioContext.getInstance().getContext(Context.NEW_EMAIL).toString()
        ScenarioContext.getInstance().setContext(Context.NEW_PASSWORD, RandomString.getAlphaNumericString(12) + "@#12")
        String password = ScenarioContext.getInstance().getContext(Context.NEW_PASSWORD).toString()
        accountPage.getField_username().sendKeys(name)
        accountPage.getField_email().sendKeys(email)
        accountPage.getField_password().sendKeys(password)
        and:
        accountPage.getButton_register().isSelected()
        accountPage.getButton_register().sendKeys(Keys.ENTER)
        ScenarioContext.getInstance().setContext(Context.CURRENT_PAGE, new LoginPage(driver))
        def loginPage = (LoginPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE)

        then:
        loginPage.getUrl() == driver.getCurrentUrl()

        cleanup:
        Browser.closeBrowser ( )

    }

    def "Login with created an  account"() {
        setup:
        WebDriver browser = Browser.getBrowser()
        def homePage = new HomePage(browser)
        homePage.clickDismiss()
        ScenarioContext.getInstance().setContext(Context.CURRENT_PAGE, homePage)
        and:
        homePage.getLnk_MyAccount().click()
        ScenarioContext.getInstance().setContext(Context.CURRENT_PAGE, new AccountPage(driver))
        when:
        def accountPage = (AccountPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE)
        String name = ScenarioContext.getInstance().getContext(Context.NEW_LOGINNAME).toString()
        String password = ScenarioContext.getInstance().getContext(Context.NEW_PASSWORD).toString()
        accountPage.getField_username_login().sendKeys(name)
        accountPage.getField_password_login().sendKeys(password)
        accountPage.getButton_login_account_page().click()
        then:
        accountPage.getUrl() == driver.getCurrentUrl()
        accountPage.getMessage_username().getText() == "Hello " + name + " (not " + name + "? Log out)"
        cleanup:
        Browser.closeBrowser ( )
    }


}
/*
Background:
    Given Demoqa shop homepage is opened
    And user clicks account link menu
    And my-account page is opened

  Scenario: 01 Make sign up form creates account
    Given customer enters his new username, email and password in registry form
    And submits his request in registry form
    And Demoqa shop login page is opened
    When user clicks back to home
    And user clicks account link menu
    When user enters his username and password in login form
    And user submits Login request
    Then account name is set as entered username
 */