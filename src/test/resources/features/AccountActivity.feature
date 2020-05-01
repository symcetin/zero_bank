@account_activity
Feature: Account Activity


  Background:
    Given The user is logged in

  Scenario: Account Activity Scenarios
    Then User navigates to "Account Activity"
    Then Page title should be "Zero - Account Activity"
    And Default drop down option should be "Savings"
    Then Account drop down should have the following options:
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And Transactions table should have column names "Date", "Description", "Deposit", "Withdrawal"

