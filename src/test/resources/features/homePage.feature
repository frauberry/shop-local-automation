Feature: Home page

  Scenario: Add product to the cart
    Given User is on Home page
    When User adds a product to the cart
    Then Items number bubble should be displayed on the cart icon

  Scenario: Search for a product
    Given User is on Home page
    When User searches for a product
    Then The product name should be displayed