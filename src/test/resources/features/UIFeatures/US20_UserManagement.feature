@userManagementU20
Feature: Test_User_Management
  Scenario Outline:test
    Given Admin goes to Medunna url
    And Admin clicks on Login Dropdown Icon
    And Admin clicks on SignIn
    And Admin fills username and password as "<username>","<password>"
    And Admin clicks on SignIn Button
    And Admin clicks Administration button.
    And Admin clicks User Management button
    Then Admin clicks verifies User text is visible.
    And Admin clicks Create a new user button
    And Admin fills login name, first name, last name,ssn, email boxes as "<login>","<firstname>","<lastname>","<ssn>","<email>"
    And Admin clicks Save user button
    Then Admin verifies new registrant saved message successfully
    And Admin clicks on modified date
    And Admin clicks on edit button
    And Admin can view firstName,lastName, email are visible.
    And Admin selects select box deactivated button.
    When Admin clicks on save changes button
    Then Admin verifies new registrant saved message successfully
    And Admin clicks on modified date
    And Admin clicks on edit button
    And Admin selects select box activated button
    And Admin provides a role from profiles as Staff
    And Admin clicks on save changes button
    Then Admin verifies new registrant saved message succesfully
    And Admin clicks on modified date
    And Admin clicks on delete button
    And Admin confirms delete
    Then Admin verifies success deleted message
    And close this application
    Examples: signIn_information
      |username|password| login|firstname|lastname|ssn| email|
      |vusalgasimov|vusalgasimov|main|fyz|byz|429-10-1043|abdbrkbyzfyz@gmail.com|
