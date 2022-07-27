@US26_Contact @team87
Feature: Test Registrant data

  Background:
    Given user goes to Medunna page
    When  User navigate to contact page
    Then  Verify that contact page is displayed

  @US26_TC01
  Scenario: US26_TC01_
    Then Verify that the Name box exists
    And Verify that the E-mail box exists
    And Verify that the Subject box exists
    And Verify that the Message box exists
    And  close the application

  @US26_TC02
  Scenario: US26_TC02_Test_name_left_blank
    When User enter name blank
    Then User should see error message Name is required.
    And  close the application

  @US26_TC03
  Scenario: US26_TC03_Test_subject_left_blank
    When User enter subject blank
    Then User should see error message This field is required.
    And  close the application

  @US26_TC04
  Scenario: US26_TC04_Test_email_left_blank
    When User enter email blank
    Then User should see error message Your email is required.
    And  close the application


  @US26_TC05
 Scenario Outline: US26_TC05_Test_invalid_email
    When User enter inValidEmail '<inValidEmail>'
    Then User should see error message This field is invalid.
    And  close the application

    Examples: name Blank
      | inValidEmail  |
      | invalidEmail  |

  @US26_TC06
  Scenario Outline: US26_TC06_Test_sends_message
    When User enter Name '<name>'
    And User enter valid email '<validEmail>'
    And User enter Subject '<subject>'
    And User enter Message '<message>'
    And User sends message
    Then User should see message Your message has been received
    And  close the application

    Examples: name Blank
      | name |validEmail|subject|message|
      | team87_patient    | team87patient@gmail.com          | abcdefg      | abcdefgh      |


