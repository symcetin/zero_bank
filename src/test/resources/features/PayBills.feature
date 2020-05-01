@payBills
Feature: Pay Bills

  Background:
    Given The user is logged in
    Then User navigates to "Pay Bills"
    Then Page title should be "Zero - Pay Bills"

  Scenario: User completes a successful Pay operation
    And User should pay saved payee with following:
      | Payee       | Wells Fargo      |
      | Account     | Savings          |
      | Amount      | 2000             |
      | Date        | 2021-04-17       |
      | Description | This description |
    And User should click pay button
    Then The success "The payment was successfully submitted." should be displayed

  @bug
  Scenario: user tries to make a payment without entering the amount or date
    And User puts following:
      | Payee       | Wells Fargo      |
      | Account     | Savings          |
      | Description | This description |
    And User should click pay button
    Then "Please fill out this field." should be displayed
    #This page doesn't contain this message BUG:)
