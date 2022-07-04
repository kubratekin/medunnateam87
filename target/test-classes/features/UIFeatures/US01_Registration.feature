@US_01
Feature: Test Registrant data

   Background:
   Given user goes to Medunna page
   When  user navigate to registration page
   Then  user Verify that Registration page is displayed

  @US01_TC01
  Scenario Outline: TC01_Test_Valid_SNN
  When User enters "<ValidSSN>"
  Then User shouldn't see Your SSN is invalid error message
  And  User shouldn't see Your SSN is required error message
  And  close the application

  Examples: Valid SNN
    |ValidSSN   |
    |123-12-1234|

  @US01_TC02
  Scenario Outline: TC02_Test_inValid_SNN
    When User enters an "<inValidSSN>" with "-" sign after 3rd and 5th digits
    Then User should see Your SSN is invalid, error message
    And  close the application

    Examples: Valid SNN
      |inValidSSN   |
      |12-312-1234  |
      |123-121-234  |
      |123121234    |

  @US01_TC03
  Scenario Outline: TC03_Test_inValid_SNN
    When User enters "<inValidSSN2>" not 9 digits long
    Then User should see Your SSN is invalid, error message
    And  close the application

    Examples: Valid SNN
      |inValidSSN2  |
      |123-12-123   |
      |123-12-12345 |

  @US01_TC04
  Scenario Outline: TC04_Test_inValid_SNN
    When User enters "<inValidSSN3>" containing characters or letters
    Then User should see Your SSN is invalid, error message
    And  close the application

    Examples: Valid SNN
      |inValidSSN3  |
      | 123-12-123@ |
      | a23-12-1234 |
      | 123-a2-1234 |
      | 123-ab-123* |







