@US_06
Feature: Test Settings data
Background:
  Given user goes to Medunna page
  When  user navigate to sign in page
  Then  user Verify that sign in page is displayed

  @US06_TC01
  Scenario Outline: TC01_Test_
    When User enters "<username>" and "<password>"
    And User navigate to settings page
    Then Verify that settings page is displayed
    And Verify that there is user "<firstname>" in the First Name box
    And Verify that there is user "<lastname>" in the Last Name box
    And Verify that there is user "<email>" in the email
    When close the application

    Examples:
      |username      | password | firstname   | lastname     | email                  |
      |team87_patient| 1234567  |team87patient|team87patient |team87patient@gmail.com |
      |team87_doctor | 1234567  |team87doctor |team87doctor  |team87doctor@gmail.com  |
      |team87_staff  | 1234567  |team87staff  |team87staff   |team87staff@gmail.com |
      |team87_admin  | 1234567  |team87admin  |team87admin   |team87admin@gmail.com   |

  @US06_TC02
  Scenario Outline: TC02_Test_
    When User enters "<username>" and "<password>"
    And User navigate to settings page
    Then Verify that settings page is displayed
    And User enters new firstname "<new firstname>"
    And Verify saved user new firstname
    Then User enters previous firstname "<previous firstname>"
    When close the application
    Examples:
      |username      | password | new firstname   | previous firstname |
      |team87_patient| 1234567  |team87patientabc |team87patient  |
      |team87_doctor | 1234567  |team87doctorabc  |team87doctor   |
      |team87_staff  | 1234567  |team87staffabc   |team87staff    |
      |team87_admin  | 1234567  |team87adminabc   |team87admin    |

  @US06_TC03
  Scenario Outline: TC03_Test_
    When User enters "<username>" and "<password>"
    And User navigate to settings page
    Then Verify that settings page is displayed
    And User enters new lastname "<new lastname>"
    And  Verify saved user new lastname
    Then User enters previous lastname "<previous lastname>"
    When close the application
    Examples:
      |username      | password |new lastname    |previous lastname |
      |team87_patient| 1234567  |team87patientabc| team87patient    |
      |team87_doctor | 1234567  |team87doctorabc | team87doctor     |
      |team87_staff  | 1234567  |team87staffabc  | team87staff      |
      |team87_admin  | 1234567  |team87adminabc  | team87admin      |
