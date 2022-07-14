@US02 @US_002_TC_007 @ui @team87
Feature:email cannot be left blank

    Scenario: test email for new applicant3
    Given user goes to webpage
    When user navigates to registration page
    And user verifies Registration is displayed
    And user provides email as "@gmail.com"
    Then user should see "This field is invalid" message
    And user closes the browser