@US14 @team87
Feature: US14_inpatient_info

  Background: opening_medunna_page
    Given doctor is on the medunna website
    When navigates the Sign in page
    And doctor sends "<username>" and "<password>"
    And doctor clicks on Sign in button
    And doctor clicks on MY PAGES dropdown menu and selects My Inpatients section

  @TC01
  Scenario: all_inpatient_info
    Then doctor verifies all inpatient info
    Then doctor closes the application

  @TC02
  Scenario: description_field
    And doctor click on Edit button on a "<inpatient>"
    And doctor updates the Description field as "<description>"
    Then doctor verifies Description field is updatable

  @TC03
  Scenario: created date_field
    And doctor clicks on Edit button on a "<inpatient>"
    And doctor updates the Created Date field as "<created date>"
    Then doctor verifies Created Date field is updatable


  @TC04
  Scenario: status_field
    And doctor clicks on Edit button on a "<inpatient>"
    And doctor updates the Status field as "<status>"
    Then doctor verifies Status field is updatable
    Then doctor closes the application


  @TC05
  Scenario: unapproved_option
    And doctor clicks on Edit button
    And doctor updates status of the inpatient as UNAPPROVED
    Then doctor verifies Status field is updatable of the inpatient
    Then doctor closes the application

  @TC06
  Scenario: staying_option
    And doctor clicks on Edit button
    And doctor updates status of the inpatient as STAYING
    Then doctor verifies Status field is updatable of the inpatient
    Then doctor closes the application

  @TC07
  Scenario: cancelled_option
    And doctor clicks on Edit button
    And doctor updates status of the inpatient as CANCELLED
    Then doctor verifies Status field is updatable of the inpatient
    Then doctor closes the application


  @TC08
  Scenario: reserved_room
    And doctor clicks on Edit button on a "<inpatient>"
    And doctor selects a room that is available
    Then doctor verifies the Room "<room>" can be updatable
    Then doctor closes the application



