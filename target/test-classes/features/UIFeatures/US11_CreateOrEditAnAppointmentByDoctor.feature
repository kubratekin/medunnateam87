  @team87
    @US11
  Feature: US11_Update an appointment by doctor

    Background:Common steps
      Given user is on the login page
      When user clicks on login dropdown icon
      And user clicks on sign in dropdown
      And user sends username "<username>"
      And user sends password "<password>"
      Then user clicks on the sign in dropdown
      Then user verifies the login is successful
      And user clicks on login dropdown icon
      And Doctor navigates to My Pages Dropdown
      And Doctor clicks on My Appointments Button
      And Doctor selects Appointment date from and to boxes
      And Doctor clicks on Edit Button


    @Positive
    Scenario: Update My Appointments by doctor
        Given Doctor verifies patient's info id, start and end date, status, physician are visible
        And Doctor should fills in required fields, anemnesis, treatment, diagnosis which as required fields
        And Doctor should fills in optional fields precription and description Which as optional fields
        And Doctor can be select as PENDING, COMPLETED or CANCELLED at Status Dropdown
        And Doctor ckicks on Save Button
        And Doctor verifies Appointment is updated succesfully
        Then Doctor clicks Sign Out Button
        Then Doctor close the application

    @Negative
    Scenario: Update My Appointments by doctor
        Given Doctor leaves anamesis field blank
        And Doctor verifies anamesis field is required
        And Doctor leaves treatment field blank
        And Doctor verifies treatment field required
        And Doctor doctor leaves diagnosis field blank
        And Doctor verifies diagnosis field required
        And Doctor selects UNAPPROVED from status field
        And Doctor verifies UNAPPROVED can not selecteble
        Then Doctor clicks Sign Out Button
        Then Doctor close the application






