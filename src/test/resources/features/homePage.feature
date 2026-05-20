Feature: Home page

  Scenario: Add product to the cart
    Given User is on Home page
    When User adds a product to the cart
    Then Items number bubble should be displayed on the cart icon

  Scenario: Search for a product
    Given User is on Home page
    When User searches for a product
    Then The product name should be displayed

   Scenario: Display products from low to high
     Given User is on Home page
     When User sorts products from low to high
     Then Products should display in the low to high order

    Scenario: Display products from high to low
      Given User is on Home page
      When User sorts products from high to low
      Then Products should display in the high to low order

     Scenario: Display products from top rated to less rated
       Given User is on Home page
       When User sorts products from top rated to less rated
       Then Top rated products should display first