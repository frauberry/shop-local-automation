Feature: Login Page

  Scenario: User successfully creates a new account
    Given User is on Login page
    When User fills out fields
    And User creates a new account
    Then A new account should be created

  Scenario: User successfully signs in
    Given User is on Login page
    When User signs in
    Then User should be successfully signed in

  Scenario: User can continue shopping without an account
    Given User is on Login page
    When User continues shopping without an account
    Then User should land on Home Page

  Scenario: Sign in Errors are displayed when user signs in with empty fields
    Given User is on Login page
    When User signs in with empty fields
    Then Error is displayed

  Scenario: Password Inline Error is displayed when user signs in with empty password field
    Given User is on Login page
    When User signs in with empty password field
    Then Password Inline Error is displayed
