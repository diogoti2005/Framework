Feature: Checkout page

  Background:
    Given 'Home' page is displayed
    When User select 'first' item from main page
    Then 'Product' page is displayed
    When User select 'Color'
      | pink |
    And User select 'Size'
      | 36 |
    And User click on 'Add to cart' button
    And User click on 'view cart' button
    Then 'Cart' page is displayed
    When User click on 'Proceed checkout' button
    Then 'Checkout' page is displayed

#  @Run
  Scenario: User can place an order without being logged in
    Given Mandatory fields are filled with valid data
      | First name     | Jim                   |
      | Last name      | Carrey                |
      | Country        | United Kingdom        |
      | Street address | South Abbey Road, 56B |
      | City           | London                |
      | Postcode       | LN 345AB              |
      | Phone          | 07989342421           |
      | Email          | guest_user1@soa.en    |
    And user clicks Terms checkbox
    When Terms checkbox is checked
    And User click on 'Place order' button
    Then 'Order Received' page is displayed

  Scenario: Mandatory fields are auto-filled when user logs in on Checkout page
    When user clicks on "Click here to login" link
    Then "Login" section is displayed
    When user inserts valid credentials
      | Username | test_user709     |
      | Password | test_user@soa.en |
    And User click on 'Login' button
    Then 'Checkout' page is displayed
    And all fields are auto-filled correctly
      | First name     | Tom                 |
      | Last name      | Hanks               |
      | Street address | Rue Jean Jaures 106 |
      | City           | Vichy               |
      | Postcode       | 03200               |
      | Phone          | 1-877-378-4249      |
      | Email          | test_user@soa.en    |

  Scenario Outline: User is not able to place an order with any of the mandatory fields being empty
    Given Mandatory fields are filled with valid data
      | First name     | Angelina           |
      | Last name      | Jolie              |
      | Country        | Germany            |
      | Street address | Flotowstrasse 6    |
      | City           | Berlin             |
      | Postcode       | 10555              |
      | Phone          | 07989342421        |
      | Email          | guest_user2@soa.en |
    And user clicks Terms checkbox
    When Terms checkbox is checked
    And user clears '<Field>' field
    And User click on 'Place order' button
    Then 'Checkout' page is displayed
    And Single alert message is displayed
    And '<Message>' is displayed
    Examples:
      | Field          | Message                                     |
      | First name     | Billing First name is a required field.     |
      | Last name      | Billing Last name is a required field.      |
      | Street Address | Billing Street address is a required field. |
      | City           | Billing Town / City is a required field.    |
      | Postcode       | Billing Postcode / ZIP is a required field. |
      | Phone          | Billing Phone is a required field.          |
      | Email          | Billing Email address is a required field.  |
