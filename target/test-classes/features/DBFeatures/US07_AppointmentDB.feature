@team87
Feature: appointment database validation

  @AppointmentDatabaseValidation
  Scenario Outline: Validate appointments by id with database
    Given user set a connection with database
    And user select all "email" column data
    Then user validates appointment "<email>" with the database

    Examples: test data
      | email   |
      |berkbey@gamil.com|
