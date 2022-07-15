@US02 @US_002_TC_001 @ui @team87
Feature: Choose a username that can contain any chars, but it cannot be blank

  Scenario Outline: test username for new applicant
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides ssn id as "<ssn>"
    And user provides firstname as "<firstname>"
    And user provides lastname as "<lastname>"
    And user provides username as "<username>"
    And user provides email as "<email>"
    When user types password as "<password>"
    And user types password confirmation as "<passwordconfirm>"
    And user clicks on Register button
    Then user should see Registration saved message
    And user closes the browser

    Examples: test data for applicants
      | ssn         | firstname | lastname | username                         | email                      | password | passwordconfirm |
      | 281-13-5239 | Mario     | Costa    | abcdefghijklmn111213             | 31211mariocosta@gmail.com  | 1234     | 1234            |
      | 382-13-5239 | Mario     | Costa    | opqrstuvwxyz111213               | 31211mariocosta1@gmail.com | 1234     | 1234            |
      | 483-13-5239 | Mario     | Costa    | 1234567890111213                 | 31211mariocosta2@gmail.com | 1234     | 1234            |
      | 584-13-5239 | Mario     | Costa    | !@#$%^&*()_+-=";':./,\<>{}111213 | 31211mariocosta3@gmail.com | 1234     | 1234            |
      | 685-13-5239 | Mario     | Costa    | ABCDEFGHIJKLMN111213             | 31211mariocosta4@gmail.com | 1234     | 1234            |
      | 786-12-5239 | Mario     | Costa    | OPQRSTUVWXYZ111213               | 31211mariocosta5@gmail.com | 1234     | 1234            |


  @US02 @US_002_TC_002 @ui @team87
 # Feature:Choose a username that can contain any chars, but it cannot be blank
  Scenario:test username for new applicant
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides username as ""
    Then user should see "Your username is required." message
    And user closes the browser


  @US02 @US_002_TC_003 @ui @team87
 # Feature:email id cannot be created without "@" sign and "." extension

  Scenario Outline: test email for new applicant
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides ssn id as "<ssn>"
    And user provides firstname as "<firstname>"
    And user provides lastname as "<lastname>"
    And user provides username as "<username>"
    And user provides email as "<email>"
    When user types password as "<password>"
    And user types password confirmation as "<passwordconfirm>"
    And user clicks on Register button
    Then user should see Registration saved message
    And user closes the browser

    Examples: test data for applicants
      | ssn         | firstname | lastname  | username      | email                      | password | passwordconfirm |
      | 358-74-4225 | Stefan    | Soluchkov | kurrupt818217 | soluchkow1221217@gmail.com | 369369   | 369369          |


  @US02 @US_002_TC_004 @ui @team87
 # Feature: email id cannot be created without "@" sign and "." extension
  Scenario:test email for new applicant
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides the invalid email as ""
    Then user should see "Your email is required." message
    And user closes the browser

  @US02 @US_002_TC_005 @ui @team87
#  Feature: email id cannot be created without "@" sign and "." extension
  Scenario: test email for new applicant
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides the invalid email as "user"
    Then user should see "Your email is required to be at least 5 characters." message
    And user closes the browser


  @US02 @US_002_TC_006 @ui @team87
#  Feature: email id cannot be created without "@" sign and "." extension
  Scenario: test email for new applicant2
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides the invalid email as "user1905@gmailcom"
    Then user should see "This field is invalid" message
    And user closes the browser


  @US02 @US_002_TC_007 @ui @team87
 # Feature:email cannot be left blank

  Scenario: test email for new applicant3
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides email as "@gmail.com"
    Then user should see "This field is invalid" message
    And user closes the browser






