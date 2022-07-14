@US02 @US_002_TC_006 @ui @team87
Feature: email id cannot be created without "@" sign and "." extension
  Scenario: test email for new applicant2
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides the invalid email as "user1905@gmailcom"
    Then user should see "This field is invalid" message
    And user closes the browser