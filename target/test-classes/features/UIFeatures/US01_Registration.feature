@US_01 @team87
Feature: Test Registrant data

   Background:
   Given user goes to Medunna page
   When  user navigate to registration page
   Then  user Verify that Registration page is displayed

  @US01_TC01
  Scenario Outline: TC01_Test_Valid_SNN
 # When User enters ValidSSN
 # Then User verify ssn is valid
  When User enters "<ValidSSN>"
  When User shouldn't see error message Your SSN is invalid and Your SSN is required.
  And  close the application
    Examples: Valid SNN
      | ValidSSN  |
      |123-12-1234|

  @US01_TC02
  Scenario Outline: TC02_Test_inValid_SNN
    When User enters an "<inValidSSN>" with sign after 3rd and 5th digits
    Then User should see Your SSN is invalid error message
   And  close the application

    Examples: Valid SNN
      |inValidSSN   |
      |12-312-1234  |
      |123-121-234  |
      |123121234    |

  @US01_TC03
  Scenario Outline: TC03_Test_inValid_SNN
    When User enters "<inValidSSN2>" not 9 digits long
    Then User should see Your SSN is invalid error message
    And  close the application

    Examples: inValid SNN
      |inValidSSN2  |
      |123-12-123   |
      |123-12-12345 |

  @US01_TC04
  Scenario Outline: TC04_Test_inValid_SNN
    When User enters "<inValidSSN3>" containing characters or letters
    Then User should see Your SSN is invalid error message
    And  close the application

    Examples: inValid SNN
      |inValidSSN3  |
      | 123-12-123@ |
      | a23-12-1234 |
      | 123-a2-1234 |
      | 123-ab-123* |

  @US01_TC05
  Scenario Outline: TC05_Test_inValid_SNN
    When SSN is "<inValidSSN4>" if all block before or after contains 0 or starts 9 ,666
    Then User should see Your SSN is invalid error message
    And  close the application

    Examples: inValid SNN
      |inValidSSN4 |
      | 000-12-1234|
      | 123-00-1234|
      | 123-12-0000|
      | 000-00-0000|
      | 923-12-1234|
      | 666-12-1234|

  @US01_TC06
  Scenario: TC06_Test_LeftBlank_SNN
    When User enters  blankSSN
    Then User should see error message Your SSN is required.
    And  close the application

  @US01_TC07
 Scenario Outline: TC07_Test_Valid_Firstname
    When User enters valid FirstName "<validFirstname>"
    Then User shouldn't see error message Your FirstName is required.
    And  close the application
    Examples: Valid SNN
      | validFirstname  |
      |   a   |
      |   1   |
      |   *   |
      |   0   |
      |team_87|
      |ayşe   |
      |123456 |
  @US01_TC08
  Scenario: TC08_Test_LeftBlank_Firstname
    When User enters  blankfirstname
    Then User should see error message Your FirstName is required.
    And  close the application



  @US01_TC09
  Scenario Outline: TC09_Test_Valid_Lastname
    When User enters valid Lastname "<validLastname>"
    Then User shouldn't see error message Your LastName is required.
    And  close the application
    Examples: Valid SNN
      | validLastname  |
      |   a   |
      |   1   |
      |   *   |
      |   0   |
      |team_87|
      |ayşe   |
      |123456 |

  @US01_TC10
  Scenario: TC10_Test_LeftBlank_Lastname
    When User enters  blanklastname
    Then User should see error message Your LastName is required.
    And  close the application







