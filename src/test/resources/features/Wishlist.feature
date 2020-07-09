#@Run
Feature: Manage 'Wish List' functionality on shop.demoqa.com

  Background:
    Given 'Home' page is displayed

  Scenario: Add product to wishlist from homepage
    When user add item to wishlist from Home page
    And user clicks on My Wishlist link
    Then 'My Wishlist' page is displayed
    And 1 item is displayed


  Scenario: Add item and remove it from wishlist from product page
    Given User select 'first' item from main page
    And 'Product' page is displayed
    When user add item to wishlist
    And user clicks on My Wishlist link
    Then 'My Wishlist' page is displayed
    And 1 item is displayed
    And user go back to product page
    And 'Product' page is displayed
    And Wishlist icon is checked
    When user uncheck wishlist icon
    And icon is unchecked
    And user clicks on My Wishlist link
    And 'My Wishlist' page is displayed
    Then 0 item is displayed


  Scenario: Search a category of items and add two items to wishlist then remove one
    When user click on search input field
    And input form is displayed
    And user searches 'dress' category
    And 'SearchResultPage' page is displayed
    And user add to wishlist two items
    And user clicks on My Wishlist link
    Then 'My Wishlist' page is displayed
    And remove first item
    Then the list immediately renewed itself
    And successfully message is displayed


