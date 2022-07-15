@team87
Feature: appointment database validation

  @AppointmentDatabaseValidation
  Scenario Outline: Validate appointments by id with database
<<<<<<< HEAD
    Given user sets a connection with database
    And user selects all "email" column data
=======
    Given user set a connection with database
    And user select all "email" column data
>>>>>>> 4283bdcd1b414d88986f9503ce11174d4cff2499
    Then user validates appointment "<email>" with the database

    Examples: test data
      | email   |
      |berkbey@gamil.com|

