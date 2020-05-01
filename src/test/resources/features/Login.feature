Feature: Login to Application

  #Only authorized users should be able to login to the application. When user logs in with valid credentials, Account summary page should be displayed.
  #Users with wrong username or wrong password should not be able to login. Users with blank username or password should also not be able to login. When user tries to login with invalid information, error message Login and/or password are wrong. should be displayed.

  Background:
    Given User is on the login page

  Scenario:
    When User logs in with valid credentials
    Then Page title should be "Zero - Account Summary"

  Scenario:
    When User logs in with invalid credentials
    Then User should see error message