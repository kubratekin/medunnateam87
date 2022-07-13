@US02@US_002_TC_002@ui
  Feature:Choose a username that can contain any chars, but it cannot be blank
    Scenario:test username for new applicant
      Given user goes to webpage
      When user navigates to registration page
      And user verifies Registration is displayed
      And user provides username as ""
      Then user should see "Your username is required." message
      And user closes the browser