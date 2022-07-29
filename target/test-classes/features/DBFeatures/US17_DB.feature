@US17_DB
Feature: read_the_created_test_item_from_db

  Scenario: verify_name_with_db
    Given  admin connects to the database
    And admin gets the "name" from "c_test_item" table
    Then admin verify "c_test_item" table "name" column contains "87_GLUCOS"
    Then admin closes db connection