@Run
Feature: Modify account

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


  Scenario: 02 New user creates account and modifies account name

    Given customer enters his new username, email and password in registry form
    And submits his request in registry form
    And Demoqa shop login page is opened
    When user clicks back to home
    And user clicks account link menu
    When user enters his username and password in login form
    And user submits Login request
    When user click Account settings
    And user enters his First Name
    And user enters his Second Name
    And user enters his new account name
    And submits save request
    Then account name is set as entered username

  Scenario: 03 Existed user modifies email on account details

    Given Customer enters his username 'atftester' and password 'CSQ@csq123$' in login form
    And user submits Login request
    When user click Account settings
    And user enters his new email
    And submits save request
    Then message email was changed is displayed

  Scenario: 04 Existed user modifies password with wrong value on account details

    Given Customer enters his username 'atftester' and password 'CSQ@csq123$' in login form
    And user submits Login request
    When user click Account settings
    And user enters not valid current password
    And user enters new password
    And user reenters new password
    And user submits save request with wrong data
    Then message not valid current password is displayed