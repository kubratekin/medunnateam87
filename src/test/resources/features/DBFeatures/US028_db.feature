@US28_DB
Feature: read_the_created_country

  Scenario: verify_country_name_with_db
    Given  admin connects to the database
    And admin gets the "name" from "country" table
    Then admin verify "country" table "name" column contains "umustistan3"
    Then admin closes db connection