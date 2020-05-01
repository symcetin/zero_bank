@account_summary
Feature: Account Summary

  Background:
    Given The user is logged in

  Scenario: Account Summary Scenarios
    And page title should be "Zero - Account Summary"
    And page should have to following:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    Then Credit accounts table must have "Account", "Credit Card", "Balance"
