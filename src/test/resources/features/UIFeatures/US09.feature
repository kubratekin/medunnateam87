@US09 @team87

Feature: US_09
  Background: US_09
    Given user goes to URL
    And User navigates to Sign in page

  @US09_TC01
  Scenario: TC_0001_Admin can view patient information by navigating view portal
    And User enters username "team87_admin" and password "1234567" with Admin credentials and clicks Sign in button
    Then User verifies that landed at Admin page
    When User navigate to Patients information page
    Then User verifies that landed at Patients information page
    And User verifies that can see patient information
    And User closes the browser

  @US09_TC02
  Scenario: TC_0002_Staff can view patient information by navigating view portal
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    Then User verifies that landed at Staff page
    When User navigate to Patients information page from Staff page
    Then User verifies that landed at Patients information page
    And User verifies that can see patient information
    And User closes the browser

  @US09_TC03
  Scenario: TC_03 Admin can edit all patient information with using ID
    And User enters username "team87_admin" and password "1234567" with Admin credentials and clicks Sign in button
    Then User verifies that landed at Admin page
    When User navigate to Patients information page
    Then User verifies that landed at Patients information page
    And User clicks on ID of patient to go to Patient detail page
    |team87-patient2|879-99-9998|
    And User clicks on Edit button
    Then User verifies Create or edit a Patient page is opened
    And User writes new informations in each information boxes
      |Sarah1|Watts1|01.01.1987|01:01|1234567891|change87-1|25|Adana|
    Then User verifies that all informations are changed
    And User closes the browser

  @US09_TC04
  Scenario: TC_04 Admin can edit all patient information with using Edit button
    And User enters username "team87_admin" and password "1234567" with Admin credentials and clicks Sign in button
    Then User verifies that landed at Admin page
    When User navigate to Patients information page
    Then User verifies that landed at Patients information page
    And User clicks Edit button
      |Sarah1|879-99-9998|
    Then User verifies Create or edit a Patient page is opened
    And User writes new informations in each information boxes
      |Sarah2|Watts2|02.02.1987|01:01|1234567892|change87-2|25|Adıyaman|
    Then User verifies that all informations are changed
    And User closes the browser

  @US09_TC05
  Scenario: TC_05 Admin can edit all patient information with using view button
    And User enters username "team87_admin" and password "1234567" with Admin credentials and clicks Sign in button
    Then User verifies that landed at Admin page
    When User navigate to Patients information page
    Then User verifies that landed at Patients information page
    And User clicks view button
      |Sarah2|879-99-9998|
    And User clicks on Edit button
    Then User verifies Create or edit a Patient page is opened
    And User writes new informations in each information boxes
      |Sarah3|Watts3|03.03.1987|01:01|1234567893|change87-3|25|Afyonkarahisar|
    Then User verifies that all informations are changed
    And User closes the browser

  @US09_TC06
  Scenario: TC_06 Staff can edit all patient information with using Edit button
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    Then User verifies that landed at Staff page
    When User navigate to Patients information page from Staff page
    Then User verifies that landed at Patients information page
    And User clicks Edit button Staff
      |Sarah3|879-99-9998|
    Then User verifies Create or edit a Patient page is opened
    And User writes new informations in each information boxes
      |Sarah4|Watts4|04.04.1987|01:01|1234567894|change87-4|25|Ağrı|
    Then User verifies that all informations are changed
    And User closes the browser

  @US09_TC07
  Scenario: TC_07 Staff can edit all patient information with using view button
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    Then User verifies that landed at Staff page
    When User navigate to Patients information page from Staff page
    Then User verifies that landed at Patients information page
    And User clicks view button Staff
      |Sarah4|879-99-9998|
    And User clicks on Edit button
    Then User verifies Create or edit a Patient page is opened
    And User writes new informations in each information boxes
      |team87-patient2|team87|05.05.1987|01:01|1234567895|change87-5|25|Amasya|
    Then User verifies that all informations are changed
    And User closes the browser

  @US09_TC08
  Scenario: TC_08 Staff can search for a new applicant by their SSN and see all their registration info populated
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    Then User verifies that landed at Staff page
    When User navigate to Patients information page from Staff page
    Then User verifies that landed at Patients information page
    When User enters patient SSN "123-10-8787" into search box
    Then User verifies that can see patient registration information populated
    And User closes the browser

  @US09_TC09
  Scenario: TC_09 Admin can delete any patient info
    And User enters username "team87_admin" and password "1234567" with Admin credentials and clicks Sign in button
    Then User verifies that landed at Admin page
    When User navigate to Patients information page
    And User finds patient and clicks Delete button
    Then User verifies all informations are deleted
    And User closes the browser
















