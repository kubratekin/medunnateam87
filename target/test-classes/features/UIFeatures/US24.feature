@US24
@team87
Feature: US24_Patient can view the test result and the invoice
  Background:User on My Appointment Page
    Given User is on the login page
    Then  User signs in as a patient.
    Then  Patient clicks on My Page
    Then  Patient clicks on My Appointments
  @US24_AC01
  Scenario: AC01 Patient can view the test result
    Then  Patient clicks on one of the Show Tests
    Then  Patient clicks on one of the View Results
    And   Patient verifies test results header is displayed
    And   Patient verifies all test items are displayed.
    And   Patent  closes the browser

  @US24_AC02
  Scenario: AC02 Patient can view the invoice
    Then  Patient clicks on one of the Show Invoice
    And   Patient verifies Invoice header is displayed
    And   Patient verifies all information is displayed  such as SSN, Total Cost …
    And   Patent  closes the browser
