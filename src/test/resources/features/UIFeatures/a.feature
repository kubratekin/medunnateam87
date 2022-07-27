@team87
Feature: US22wer
   @tag
  Scenario Outline: User can search patients by SSN
    Given User staff goes to Medunna HomePage
    Then User staff logs on
    And User staff sign in page
    Then User staff types "<username>"
    And User staff types  the "<password>"
    Then User submit user info
    Then User staff clicks on My page tab
    And User staff clicks on Search Patient
    Then User staff types patient SSN in blanks
    And User staff clicks on Show Appointments
    Then User staff clicks on Show Tests
    Then User staff clicks on View Results
    And user staff closes the browser

    Examples: User

      |username|password|
      |NoEraseStaff|1staff1|
  @tag
  Scenario Outline: User can check and describe results
    Given User staff goes to Medunna HomePage
    Then User staff logs on
    And User staff sign in page
    Then User staff types "<username>"
    And User staff types  the "<password>"
    Then User submit user info
    Then User staff clicks on My page tab
    And User staff clicks on Search Patient
    Then User staff types patient SSN in blanks
    And User staff clicks on Show Appointments
    Then User staff clicks on Show Tests
    Then User staff clicks on View Results
    And User staff clicks on Edit button
    Then User staff types result value
    And User staff types result description
    Then User staff save the records
    And user staff closes the browser

    Examples: User

      |username|password|
      |NoEraseStaff|1staff1|