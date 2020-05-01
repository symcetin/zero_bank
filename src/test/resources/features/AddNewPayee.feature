@add_new_payee
Feature: Add new payee under pay bills

  Background: login and navigate
    Given The user is logged in
    Given User navigates to "Pay Bills"
    Given User navigates to "Add New Payee"

  Scenario: Add a new payee
    And creates new payee using following information
      | Payee Name    | The Law Offices of Hyde, Price & Scharks |
      | Payee Address | 100 Same st, Anytown, USA, 10001         |
      | Account       | Checking                                 |
      | Payee Details | XYZ account                              |
    Then message "The new payee The Law Offices of Hyde, Price & Scharks was successfully created." should be displayed