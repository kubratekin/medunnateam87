@US12_doctor_can_request_test
Feature:doctor_can_request_test
  Background: doctor-goes-to-appointment-page
    Given User is on the login page
    When  User clicks on account menu
    Then  User clicks on signin
    And   User enters username
    And   User enters password
    And   User clicks on signin button
    And   Doctor verifies that his page is displayed
    And   Doctor clicks on mypage
    And   Doctor clicks on myaccountement
    And   Doctor verifies Appointement page is displayed
    And   Doctor clicks on Edit button
    And   Doctor verifies that the Create or Edit an Appointment page is displayed
    And   Doctor clicks on the Request A Test button.
  @US12_01
  Scenario: TC01
    Then Doctor verifies that the Test Items page is displayed
    And  Doctor can choose the test item:Sodium
    And  Doctor can choose the test item:Hemoglobin
    And  Doctor can choose the test item:Urea
    And  Doctor clicks on save tests button
    And  Doctor verifies A new Test  is cereated with identifier message  is displayed
    And  Doctor closes the browser

  @US12_02
  Scenario: TC02
    And  Doctor clicks on save tests button
    And  Doctor verifies Test item list can not be empty message  is displayed
    And  Doctor closes the browser