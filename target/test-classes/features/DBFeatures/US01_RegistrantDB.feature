@team87
Feature: US01_DB_Users_Ssn_DB
  @US01_TC12_DB
  Scenario:Users_Ssn_Test_DB
    Given user sets a connection with database
    And user selects all "ssn" column data
    Then user validates registrant "123-66-5555" ids with database



