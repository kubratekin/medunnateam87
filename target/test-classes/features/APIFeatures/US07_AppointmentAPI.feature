@team87
Feature: US07_API_test api appointment data
  @Api
  @GetApiAppointment
  Scenario: test_appointment
    Given user sends a get request for appointment data
    And user deserializes the appointment data to java
    Then user saves the appointment' data to correspondent files and validates