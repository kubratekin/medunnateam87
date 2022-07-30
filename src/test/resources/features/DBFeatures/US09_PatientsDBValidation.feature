 @team87
@US09DB
Feature: US09_DB Validations
  @US09DB_TC11
  Scenario Outline: TC11_User can validate patients information with DB
    Given User connects to DB
    When User gets information from DB
    Then User verifies that patients exists in DB "<lastname>" "<firstname>" "<email>" "<ssn>"
    And User closes the DB connection

  Examples:
    | lastname         | firstname        | email                      | ssn         |
    | team87           | team87del2       | aa@b.com                   | 872-22-2222 |
    | team87           | team87del        | a@b.com                    | 871-11-1111 |
    | team87patient001 | team87patient001 | team87patient001@gmail.com | 123-10-1009 |
    | team87patient2   | team87patient2   | team87patient2@gmail.com   | 837-64-9827 |
    | team87patient3   | team87patient3   | team87patient3@gmail.com   | 867-12-6666 |
    | patient_87       | team_87          | team87@mail.com            | 123-10-8787 |

  @US09DB_TC12
  Scenario: TC12_User can create new patient with DB
    Given User connects to DB
    When User creates a new patient in the patient table using the DB
    Then User verifies that new patient has been added to the DB
    And User closes the DB connection

  @US09DB_TC13
  Scenario: TC13_User can delete patient from DB
    Given User connects to DB
    When User deletes a patient from patient table
    Then User verifies that patient has been deleted
    And User closes the DB connection