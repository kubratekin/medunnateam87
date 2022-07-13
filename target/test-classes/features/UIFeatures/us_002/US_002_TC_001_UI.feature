@US02@US_002_TC_001@ui
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
      | ssn         | firstname | lastname | username                     | email                  | password | passwordconfirm |
      | 281-83-4535 | Mario     | Costa    | abcdefghijklmn111             | 11mariocosta@gmail.com  | 1234     | 1234            |
      | 382-73-4535 | Mario     | Costa    | opqrstuvwxyz111               | 11mariocosta1@gmail.com | 1234     | 1234            |
      | 483-63-4535 | Mario     | Costa    | 1234567890111                 | 11mariocosta2@gmail.com | 1234     | 1234            |
      | 584-53-4535 | Mario     | Costa    | !@#$%^&*()_+-=";':./,\<>{}111 | 11mariocosta3@gmail.com | 1234     | 1234            |
      | 685-43-4535 | Mario     | Costa    | ABCDEFGHIJKLMN111             | 11mariocosta4@gmail.com | 1234     | 1234            |
      | 786-92-4535 | Mario     | Costa    | OPQRSTUVWXYZ111               | 11mariocosta5@gmail.com | 1234     | 1234            |





