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

  Scenario: Email inline Error is displayed when user signs in with empty email field
    Given User is on Login page
    When User signs in with empty email field
    Then Email Inline Error is displayed

  Scenario Outline: Invalid emails in Sign in form
    Given User is on Login page
    When User enters invalid "<email>" email
    Then Email Inline Error "<errorMessage>" message should be displayed
    Examples:
      | email           | errorMessage                 |
      | olga @gmail.com | Enter a valid email address. |
      | olga gmail.com  | Enter a valid email address. |
      | olga@gmailcom   | Enter a valid email address. |

  Scenario Outline: Invalid passports in Sign in form
    Given User is on Login page
    When User enters invalid "<password>" password
    Then Password Inline Error "<errorMessage>" message should be displayed
    Examples:
      | password              | errorMessage              |
      | Olga 123!             | Invalid email or password |
      | olga123!              | Invalid email or password |
      | OLGA123!              | Invalid email or password |
      | Olga123               | Invalid email or password |
      | Olga!                 | Invalid email or password |
      | Ol1!                  | Invalid email or password |
      | Olga123!OlgaOlgaOlgaO | Invalid email or password |

