@US28_DB
Feature: read_the_created_country

  Scenario: verify_country_name_with_db
    Given  admin connect to the database
    And admin get the "name" from "country" table
    Then admin verify "country" table "name" column contain "umustistan3"
    Then admin close db connection