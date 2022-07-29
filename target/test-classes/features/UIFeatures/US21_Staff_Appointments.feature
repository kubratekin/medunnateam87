@team87
@US21
Feature: US_21

  @US21_TC01
  Scenario: TC_0001 They can select the current doctor that needs to be selected for the patient
    Given user goes to Medunna URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks edit and selects the appropriate doctor "team87doctor002" for the patient
    Then User clicks save button and verifies that successfully saved message.
    And User closes the browser

  @US21_TC02
  Scenario: TC_0002 Staff does not need to provide Anamnesis, Treatment or Diagnosis as required fields
    Given user goes to URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks edit and leaves the anamnesis, treatment and diagnosis boxes blank
    Then User verifies that "The Appointment is updated with identifier" message is shown after clicks save button
    And User closes the browser

  @US21_TC03
  Scenario: TC_0003 Staff can make the status PENDING
    Given user goes to URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks edit and changes status to PENDING
    Then User verifies that "The Appointment is updated with identifier" message is shown after clicks save button
    And User closes the browser

  @US21_TC04
  Scenario: TC_0004 Staff can make the status UNAPPROVED
    Given user goes to URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks edit and changes status to UNAPPROVED
    Then User verifies that "The Appointment is updated with identifier" message is shown after clicks save button
    And User closes the browser

  @US21_TC05
  Scenario: TC_0005 Staff can make the status CANCELLED
    Given user goes to URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks edit and changes status to CANCELLED
    Then User verifies that "The Appointment is updated with identifier" message is shown after clicks save button
    And User closes the browser

  @US21_TC06
  Scenario: TC_0006 Staff cannot make the status COMPLETED
    Given user goes to URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks edit and changes status to COMPLETED
    Then User verifies that COMPLETED cannot be selected
    And User closes the browser

  @US21_TC07
  Scenario: TC_0007 They can view the patients test results
    Given user goes to URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks Show tests button
    Then User verifies that can see "No Tests found" text if the doctor has not requested the test for the patient
    And User closes the browser

  @US21_TC08
  Scenario: TC_0008 They can view the patients test results
    Given user goes to URL
    And User navigates to Sign in page
    And User enters username "team87_staff" and password "1234567" with Staff credentials and clicks Sign in button
    And User navigate to Patients information page from Staff page
    When User enters patient SSN "879-99-9999" in the search box
    And User clicks Show Appointments
    When User clicks Show tests button
    And User clicks View Results button if the doctor has requested the test for the patient
    Then User verifies that can see the test results if the doctor has requested the test for the patient and the requested test has been completed
    And User closes the browser


