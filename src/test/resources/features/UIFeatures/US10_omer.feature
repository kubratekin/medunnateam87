Feature: US10

  @US10appointment
  Scenario Outline: Physician checks and edit appoinment list

    Given Physician goes to Medunna page
    Then  Physician reaches Medunna pages to login
    Then Physician does Sign in page
    Then Physician types "<username>"
    Then Physician types "<password>"
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

    Given Physician goes to Medunna page
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