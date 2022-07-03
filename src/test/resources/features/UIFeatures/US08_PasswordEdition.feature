
Feature:US08_Password_Edition

  Background: go to url,sign in,fill in the text boxes
    Given User goes to "<app_url>"
    And User navigates to Sign in page and verifies sign in  page is displayed
    When User enters "<username>" and "<password>" with credentials and clicks Sign in button
    And User navigates to username button and clicks
    And User clicks on Password and verifies password  for[user] page is displayed
    When User enters the current "<password>"

  @US008_TC001
  Scenario Outline: TC001_test_password_editable
    Given User goes to "<app_url>"
    And User navigates to Sign in page and verifies sign in  page is displayed
    When User enters "<username>" and "<password>" with credentials and clicks Sign in button
    And User navigates to username button and clicks
    And User clicks on Password and verifies password  for[user] page is displayed
    When User enters the current "<password>"
    And User enters the "<newpassword>"
    When User enters the "<newpassword>" confirmation
    And User clicks on save button
    Then User verifies "password changed" message is displayed

    Examples:US08 test data for  new password
      | app_url             | username     | password | newpassword |
      | https://medunna.com | team87user02 | 1234567  | 1Qaz.2Wsx   |



   Scenario: test negative password scenario
