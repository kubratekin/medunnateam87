Feature:US08_1Lowercase_accepts

  Background: go to url,sign in,fill in the text boxes
    Given User goes to "<app_url>"
    And User navigates to Sign in page and verifies sign in  page is displayed
    When User enters "<username>" and "<password>" with credentials and clicks Sign in button
    And User navigates to username button and clicks
    And User clicks on Password and verifies password  for[user] page is displayed
    When User enters the current "<password>"

  @US008_TC002
  Scenario Outline:TC002 Password contains 1 lowercase

    When User enters the "<newpassword>" contains at least 1 lowercase
    And User reenters on "<newpassword>" confirmation
    And User verifies the level chart change to stronger

    Examples: 1 lowercase test data
    |newpassword|
    |123456a|

