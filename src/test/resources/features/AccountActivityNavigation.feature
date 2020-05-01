@account_summary_navigation
Feature: Navigating to specific accounts in Accounts Activity

  Background: login
    Given The user is logged in

  Scenario: Savings account redirect
    When The user clicks on "Savings" link on the Account Summary page
    Then The "Account Activity" page should be displayed
    And Account drop down should have "Savings" selected

  Scenario: Brokerage account redirect
    When The user clicks on "Brokerage" link on the Account Summary page
    Then The "Account Activity" page should be displayed
    And Account drop down should have "Brokerage" selected

  Scenario: Checking account redirect
    When The user clicks on "Checking" link on the Account Summary page
    Then The "Account Activity" page should be displayed
    And Account drop down should have "Checking" selected

  Scenario: Credit Card account redirect
    When The user clicks on "Credit Card" link on the Account Summary page
    Then The "Account Activity" page should be displayed
    And Account drop down should have "Credit Card" selected

  Scenario: Loan account redirect
    When The user clicks on "Loan" link on the Account Summary page
    Then The "Account Activity" page should be displayed
    And Account drop down should have "Loan" selected