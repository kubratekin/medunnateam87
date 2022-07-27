@team87
  Feature: US10_DB validation

    @US10_DB
    Scenario: User tests Appointment DB
      Given User connects to database
      Then User gets appointment "status"
      And User verifies the "PENDING" by DB