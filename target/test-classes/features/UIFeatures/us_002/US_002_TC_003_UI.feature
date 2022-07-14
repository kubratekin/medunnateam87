@US02 @US_002_TC_003 @ui @team87
Feature:email id cannot be created without "@" sign and "." extension

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