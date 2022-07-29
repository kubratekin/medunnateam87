@US_018_TC_011_API @api
Feature: US_018_TC011_API Validating all physicians using API
  Scenario Outline: US_018_TC011_API Validating all physicians using API
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    Then User retrieves the info for all Physicians from the first page
    When user sends POST request to get Bearer Token
    Then user verifies that response status code is 200
    When eh User sends a GET request to get physician details foe each Physician with ID and verifies the returned info matches
    Examples:
      | username     | password |
      | team87_admin | 1234567  |