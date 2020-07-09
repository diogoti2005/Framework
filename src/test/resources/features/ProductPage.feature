#@Run
Feature: Product page filters

  Background:
    Given the user is on the Product page
    And the filter is on the default values

  Scenario: Filter by color and size
    Then all the items are displayed
    When user selects the following filter:
      | color | 59 |
    Then only the items with that 'color' are displayed
    When user selects the following filter:
      | size | 108 |
    Then only the items with that 'size' are displayed
    When the user selects a option for both filters
    Then only the items matching both parameters are displayed


 Scenario: Displaying the results in Grid view and List view
   Then the items on the page are displayed by default in a grid format
   When the user changes the default sorting to 'List'
   Then all the elements are displayed in List style
   And the following information is displayed for all the items:
    |Title         |
    |Category      |
    |Price         |
    |Description   |
    |Action options|
   When the users changes the style back to 'Grid'
   Then all the items are displayed in Grid style

 Scenario: Sorting the results by different criteria
   Then the products are ordered in a default order
   When the user selects a specific sorting criteria
   Then all the items are ordered according to the selected criterion
   When the user selects a filter value for 'filter color', 'filter size' and 'default sorting'
   Then only the items with that color and size will be displayed
   And it will be sorted according to the selected criteria
