#@Run
Feature: Scenarios for Cart functionality

  Background:
    Given 'Home' page is displayed
    When User select 'first' item from main page
    And 'Product' page is displayed
    And User select 'Color'
      | pink |
    And User select 'Size'
      | 36 |
    And User click on 'Add to cart' button
    And User click on 'view cart' button
    And 'Cart' page is displayed

  Scenario: User increase quantity of an item
    And User click on '+' button
    And User click on 'Update Shopping Cart' button
    Then Cart page is updated with right quantity of product

  Scenario: User remove item from Cart
    And User click on 'Clear cart' button
    Then Items are removed from Cart

  Scenario: User add another items to Cart
    Given User click on 'Logo' button
    And 'Home' page is displayed
    When User select 'last' item from main page
    Then 'Product' page is displayed
    When User select 'Color'
      | black |
    And User select 'Size'
      | 32 |
    And User click on 'Add to cart' button
    And User click on 'view cart' button
    And 'Cart' page is displayed
    Then Both items are added