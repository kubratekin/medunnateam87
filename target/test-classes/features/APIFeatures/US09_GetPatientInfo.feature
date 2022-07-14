@team87
@US09_API
Feature: US09 Validating Info USing API
  @US09_TC10
  Scenario Outline: TC10_User should validate all patient info using API
    Given User sets the path params to read patient info
    And User sets expected data
    When User send get request for patient info and get response
    Then User validates patient info "<firstname>" "<lastname>" "<email>" "<ssn>" .

    Examples:
      | firstname        | lastname         | email                      | ssn         |
      | team87del2       | team87           | aa@b.com                   | 872-22-2222 |
      | team87del        | team87           | a@b.com                    | 871-11-1111 |
      | team87patient001 | team87patient001 | team87patient001@gmail.com | 123-10-1009 |
      | team87patient2   | team87patient2   | team87patient2@gmail.com   | 837-64-9827 |
      | team87patient3   | team87patient3   | team87patient3@gmail.com   | 867-12-6666 |
      | team_87          | patient_87       | team87@mail.com            | 123-10-8787 |



#  @US09_TC11
#  Scenario: TC11_User can update patient information.
#    Given User sets the path params to create and update patient info
#    When User creates new patient using Post request firstname "team87apiPatient" lastname "team87" email "te@m87.com" ssn "878-87-8787"
#    And User sends Put request to update patient info firstname "team87newApi" lastname "87team" email "team@87.com" ssn "877-78-7878"
#    Then User validates patient new info firstname "team87newApi" lastname "87team" email "team@87.com" ssn "877-78-7878"