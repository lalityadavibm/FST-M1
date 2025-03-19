Feature: Login functionality with multiple users

  Scenario: Login with valid users
    Given I am on the login page
    When I enter the following user credentials:
      | username  | password |
      | admin1     | password1    |
      | admin2     | password2    |
      | admin3     | password3    |
    Then I should be logged in successfully
