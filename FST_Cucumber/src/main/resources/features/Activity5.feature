@activity5
Feature: Login Test

  @invalidLogin
  Scenario Outline: Invalid Login test with multiple parameters
    Given the user is on the login page
    When the user enters "<Usernames>" and "<Passwords>"
    And clicks the submit button
    Then the "Invalid credentials" message is displayed

    Examples:
      | Usernames  | Passwords     |
      | admin      | wrongPassword |
      | wrongAdmin | password      |
      | wrongAdmin | wrongPassword |
