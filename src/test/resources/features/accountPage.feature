Feature: Account Page

  Scenario: User successfully signs out
    Given User is on Account page
    When User signs out
    Then User should be successfully sign out