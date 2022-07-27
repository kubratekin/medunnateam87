@team87
Feature: US07_Test Make An Appointment
  Background:
    Given user navigate to medunna page
    And user click on Make An Appointment
    Then verify "Make an Appointment " header created on the page
  @TC01
  Scenario Outline:TC01_Test_Make_An_Appointment_currentDate
    And user send firstName ,lastName ,ssn ,phone ,email,as "<firstname>","<lastname>","<ssn>","<phone>","<email>"
    And user can select current date
    And user click Send an Appointment Request
    Then verify created the Appointment registration saved! We will call you as soon as possible alert message is visible
    And close this application
    Examples: test_user_information
      |firstname|lastname|ssn|phone|email|
      |feyza|aberkbey|123-10-1003|1234567890|aberkbey@gmail.com|
  @TC02
  Scenario Outline:TC02_Test_Make_An_Appointment_futureDate
    And user send firstName ,lastName ,ssn ,phone ,email,as "<firstname>","<lastname>","<ssn>","<phone>","<email>"
    And user can select future date
    And user click Send an Appointment Request
    Then verify created the Appointment registration saved! We will call you as soon as possible alert message is visible
    And close this application
    Examples: test_user_information
      |firstname|lastname|ssn|phone|email|
      |feyzan|aberkbey|123-11-1003|1234567890|aberk@gmail.com|
  @TC03
  Scenario Outline:TC03_Test_Make_An_Appointment_pastDate
    And user send firstName ,lastName ,ssn ,phone ,email,as "<firstname>","<lastname>","<ssn>","<phone>","<email>"
    And user can select past date
    And user click Send an Appointment Request
    Then verify created the message Appointment date can not be past date! is visible
    And close this application
    Examples: test_user_information
      |firstname|lastname|ssn|phone|email|
      |feyzas|aberkbey|123-12-1003|1234567890|berkbey@gmail.com|
