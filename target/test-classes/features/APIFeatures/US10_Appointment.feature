@team87
Feature: US10_validation API

 @US10_API
  Scenario: Appointments validation with Api

    Given  Physician sends a request to get response
   Then    Physician does deserializetion appointment info
    And   Physician validates "PENDING" appoinment status






