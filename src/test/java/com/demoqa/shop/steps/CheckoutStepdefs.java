package com.demoqa.shop.steps;

import com.demoqa.shop.pages.BasePage;
import com.demoqa.shop.pages.CheckoutPage;
import com.demoqa.shop.util.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.awt.*;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutStepdefs {
    Logger log = LoggerFactory.getLogger(CheckoutStepdefs.class);
    WebDriverWait wait = new WebDriverWait(Browser.getBrowser(), 20);

    @Given( "user clicks Terms checkbox" )
    public void clickCheckbox() {
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        wait.until(ExpectedConditions.elementToBeClickable(page.getTermsCheckbox()));
        page.clickTerms();
        log.info("user clicked Terms checkbox");
    }

    @Then( "\"Login\" section is displayed" )
    public void validateLoginSection() {
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        WebElement loginSection = page.getLoginSection();
        ScreenshotUtil.highLight(loginSection);
        ScreenshotUtil.scrollToElement(loginSection);
        ScreenshotUtil.takeScreenshot("Login section");
        ATFAssert.assertTrue("\"Login\" sections was not displayed on checkout page", page.loginSectionIsDisplayed(), "\"Login\" section isDispalayed()");
    }

    @When( "user clears {string} field" )
    public void clearField(String string) {
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        switch (string.toLowerCase()) {
            case "first name": {
                page.clearFistName();
                break;
            }
            case "last name": {
                page.clearLastName();
                break;
            }
            case "street address": {
                page.clearBillingAddress();
                break;
            }
            case "city": {
                page.clearCity();
                break;
            }
            case "postcode": {
                page.clearPostCode();
                break;
            }
            case "phone": {
                page.clearPhone();
                break;
            }
            case "email": {
                page.clearEmail();
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value for field : " + string.toLowerCase());
        }
        log.info("user cleared {} field", string);
    }

    @Then( "{string} is displayed" )
    public void messageIsDisplayed(String string) {
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        WebElement alert = page.getAlerts();
        ScreenshotUtil.highLight(alert);
        ScreenshotUtil.scrollToElement(alert);
        ScreenshotUtil.takeScreenshot("Alert");
        ATFAssert.assertTrue("Wrong message is displayed", page.getAlertMessages().containsValue(string), "corresponding alert message is displayed");
    }

    @Given( "Mandatory fields are filled with valid data" )
    public void mandatoryFieldsAreFilledWithValidData(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "first name": {
                    page.insertFistName(entry.getValue());
                    break;
                }
                case "last name": {
                    page.insertLastName(entry.getValue());
                    break;
                }
                case "country": {
                    page.selectCountry(entry.getValue());
                    break;
                }
                case "street address": {
                    page.insertBillingAddress(entry.getValue());
                    break;
                }
                case "city": {
                    page.insertCity(entry.getValue());
                    break;
                }
                case "postcode": {
                    page.insertPostCode(entry.getValue());
                    break;
                }
                case "phone": {
                    page.insertPhone(entry.getValue());
                    break;
                }
                case "email": {
                    page.insertEmail(entry.getValue());
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected key for billing details of the customer: " + entry.getKey().toLowerCase());
            }
            log.info("{} was inserted", entry.getKey());
        }
    }

    @When( "user clicks on \"Click here to login\" link" )
    public void clickLoginLink() {
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        page.clickLoginLink();
        log.info("User clicked on \"Click here to login\" link");
    }

    @Then( "all fields are auto-filled correctly" )
    public void allFieldsAreAutoFilledCorrectly(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        String actual;
        WebElement actualElement;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "first name": {
                    actual = page.getValueFirstname();
                    actualElement = page.getFistNameTextField();
                    break;
                }
                case "last name": {
                    actual = page.getValueLastname();
                    actualElement = page.getLastNameTextField();
                    break;
                }
                case "country": {
                    actual = page.getValueCountry();
                    actualElement = page.getCountryDropdown();
                    break;
                }
                case "street address": {
                    actual = page.getValueBillingAddress();
                    actualElement = page.getBillingAddressTextField();
                    break;
                }
                case "city": {
                    actual = page.getValueCity();
                    actualElement = page.getCity();
                    break;
                }
                case "postcode": {
                    actual = page.getValuePostcode();
                    actualElement = page.getPostCodeTextField();
                    break;
                }
                case "phone": {
                    actual = page.getValuePhone();
                    actualElement = page.getPhoneTextField();
                    break;
                }
                case "email": {
                    actual = page.getValueEmail();
                    actualElement = page.getEmailTextField();
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected key for billing details of the customer: " + entry.getKey().toLowerCase());
            }
            ScreenshotUtil.highLight(actualElement);
            ScreenshotUtil.scrollToElement(actualElement);
            ScreenshotUtil.takeScreenshot("Auto-fill of " + entry.getKey());
            ATFAssert.assertEquals(entry.getValue(), actual, "Field " + entry.getKey() + "did not fill correctly", "Field " + entry.getKey() + " was filled with correct data: " + entry.getValue());
        }
    }

    @Given( "user inserts valid credentials" )
    public void userLogsInWithValidData(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            switch (entry.getKey().toLowerCase()) {
                case "username": {
                    page.insertUsername(entry.getValue());
                    break;
                }
                case "password": {
                    page.insertPassword(entry.getValue());
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected key for credentials: " + entry.getKey().toLowerCase());
            }
            log.info("User has entered a valid {}", entry.getKey());
        }
    }

    @When( "Terms checkbox is checked" )
    public void termsCheckboxIsChecked() {
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        ScreenshotUtil.highLight(page.getTermsCheckbox());
        ScreenshotUtil.scrollToElement(page.getTermsCheckbox());
        ScreenshotUtil.takeScreenshot("Terms");
        ATFAssert.assertTrue("\'Terms\' checkbox is not selected", page.termsIsSelected(), "Terms checkbox is selected");
    }

    @Then( "Single alert message is displayed" )
    public void alertMessageIsDisplayed() {
        CheckoutPage page = (CheckoutPage) ScenarioContext.getInstance().getContext(Context.CURRENT_PAGE);
        int alerts = page.getAlertMessages().size();
        ATFAssert.assertEquals(1, alerts, "Not only one alert message is displayed", "only one alert notification is displayed");
    }
}