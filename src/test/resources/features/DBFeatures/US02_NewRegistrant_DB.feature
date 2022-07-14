@US02 @US_002_TC_013 @db @team87
Feature: email should be validated with DB

  Scenario: email should be validated with DB
    Given user connects to medunna_db with valid credentials
    When user sends a requests to get the user details with a specific valid email address
    Then user confirmes the request with the email address returns information
    Then user closes database connection

