@US_018_TC_012_DB @db @Sprint2
Feature: US_018_TC012_DB Validating all physicians using DB
  Scenario Outline: US_018_TC012_DB Validating all physicians using DB
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    Then User retrieves the info for all Physicians from the first page
    And user connects to medunna_db with valid credentials
    Then eh User retrieves physician details for each physician retrieved earlier from the UI and verifies the returned information matches with the edited data.
    Examples:
      | username     | password |
      | team87_admin | 1234567  |