@US01_API1 @team87
Feature: US01_API_Users_Ssn_Api

  @US01_TC11_API
  Scenario: Users_Ssn_Test_Api
  Given user sends request and gets response
  Then user deserializes data to Java
  And user validates "123-66-5555" in the list

