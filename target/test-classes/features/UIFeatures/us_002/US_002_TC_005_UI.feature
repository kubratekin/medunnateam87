@US02 @US_002_TC_005 @ui
  Feature: email id cannot be created without "@" sign and "." extension
    Scenario: test email for new applicant
      Given user goes to webpage
      When user navigates to registration page
      And user verifies Registration is displayed
      And user provides the invalid email as "user"
      Then user should see "Your email is required to be at least 5 characters." message
      And user closes the browser