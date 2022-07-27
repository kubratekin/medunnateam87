@team87
Feature: US10

  Scenario Outline: User can search patients by SSN and show appointments

    Given User staff goes to Medunna HomePage
    Then User staff logs on
    And User staff sign in page
    Then User staff types "<username>"
    And User staff types  the "<password>"
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

  @US10appointment
  Scenario Outline: Physician checks and edit appoinment list

    Given Physician on the Medunna page
    Then  Physician reaches Medunna pages to login
    Then Physician does Sign in page
    Then Physician types "<username>"
    Then Physician type "<password>"
    Then Physician clicks submit
    And  Physicians goes own pages from MY PAGES tab
    And Physician clicks My appoitment button
    And Physician can see appoitment list
    Then Physician can check startdate
    And  Physician can check enddate
    And Physician can clicks Edit button
    Then Physician can edit the any appointment
    Then Physician can save it
    Then Physician can close the browser

    Examples: user information
      |username|password|
      |Elharezmi|1elharezmi1|

  @US10patient
  Scenario Outline: Physician checks patient list

    Given Physician on the Medunna page
    Then  Physician reaches to login
    Then Physician  click Sign in page
    Then Physician inputs "<username>"
    Then Physician enters "<password>"
    Then Physician click submit
    And  Physicians reaches  MY PAGES tab
    And Physician clicks My patients
    And Physician checks patient list
    Then Physician close the browser


    Examples: user information
      |username|password|
      |Elharezmi|1elharezmi1|