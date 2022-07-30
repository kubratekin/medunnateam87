@US23_Staff_Payment_Proccess
@team87-2
Feature: US23 Payment Invoice by Staff
  @TC01
  Scenario: TC01 Staff can navigate to Payment Invoice process
    Given Staff goes to medunna.com
    When Staff click Sign in Link
    And Provides the username "team87staff001" textbox
    And Provides the password "1234567" textbox
    And Clicks the Sign in button
    And Clicks the My Page and Search Patient
    And Search patient with SSN "417-44-8506"
    And Clicks Show Appointments button
    And Clicks Payment Invoice Proccess button
    Then Verify PAYMENT DETAIL title
    And Close the browser

  @TC02
  Scenario: TC02 The patient should have a status of completed to create an invoice
    Given Staff goes to medunna.com
    When Staff click Sign in Link
    And Provides the username "team87staff001" textbox
    And Provides the password "1234567" textbox
    And Clicks the Sign in button
    And Clicks the My Page and Search Patient
    And Search patient with SSN "417-44-8506"
    And Clicks Show Appointments button
    Then Verify the status as completed
    And Clicks Payment Invoice Proccess button
    Then Verify Create Invoice button is visible
    And Close the browser

  @TC03
  Scenario: TC03 The patient should have a status of cancelled to create an invoice
    Given Staff goes to medunna.com
    When Staff click Sign in Link
    And Provides the username "team87staff001" textbox
    And Provides the password "1234567" textbox
    And Clicks the Sign in button
    And Clicks the My Page and Search Patient
    And Search patient with SSN "417-44-8502"
    And Clicks Show Appointments button
    Then Verify the status as cancelled
    And Clicks Payment Invoice Proccess button
    Then Verify Create Invoice button is visible
    And Close the browser

  @TC04
  Scenario:Staff can view all invoice for the patient
    Given Staff goes to medunna.com
    When Staff click Sign in Link
    And Provides the username "team87staff001" textbox
    And Provides the password "1234567" textbox
    And Clicks the Sign in button
    And Clicks the My Page and Search Patient
    And Search patient with SSN "417-44-8506"
    And Clicks Show Appointments button
    And Clicks Payment Invoice Proccess button
    Then Verify Exam Fee, Test Item Price, Create Invoice button
    And Close the browser

  @TC05
  Scenario:Staff can view the invoice sent to patient
    Given Staff goes to medunna.com
    When Staff click Sign in Link
    And Provides the username "team87staff001" textbox
    And Provides the password "1234567" textbox
    And Clicks the Sign in button
    And Clicks the My Page and Search Patient
    And Search patient with SSN "417-44-8505"
    And Clicks Show Appointments button
    And Clicks Payment Invoice Proccess button
    And Clicks Show Invoice button
    Then Verify INVOICE title is visible
    And Close the browser






