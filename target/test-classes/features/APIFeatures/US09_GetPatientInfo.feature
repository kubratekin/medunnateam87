@US09_API
Feature: US09 Validating Info USing API

  Scenario: TC10_User should validate all patient info using API
    Given User sets the path params to read patient info
    And User sets expected data
    When User send get request for patient info and get response
    Then User validates patient info.