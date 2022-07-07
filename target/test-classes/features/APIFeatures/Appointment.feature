Feature: test api appointment data
  @Api
  @GetApiAppointment
  Scenario:TC01
    Given user sends a get request for users' data
    And user deserializes the users' data to java
    Then user saves the users' data to correspondent files and validates