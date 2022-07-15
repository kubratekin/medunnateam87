@team87
@appointment
Feature: First Feature File

  Background: opening medunna page
    Given user goes to Medunna webpage
    And verify make an appointment button is displayed
    When user clicks to Make an Appointment
    Then verify Make an Appointment page is displayed


  @TC01
  Scenario: TC01
    When user enters first name "ali"
    Then user does not get invalid error message
    And close the application

  @TC02
  Scenario: TC02
    When user enters first name ""
    Then user gets first name error message
    And close the application

  @TC03
  Scenario Outline: TC03
    When user provides the "<valid>" SSN
    Then user does not get invalid error message
    And close the application

    Examples:
      | valid       |
      | 123-12-1234 |
      | 456-00-0000 |

  @TC04
  Scenario Outline: TC04
    When user provides the "<invalid>" SSN
    Then user gets Your SSN is invalid error message
    And close the application

    Examples:
      | invalid     |
      | 123-12-123  |
      | 456000000   |
      | 1234-4-1234 |

  @TC05
  Scenario: TC05
    When user provides the "" SSN
    Then user gets Your SSN is required error message
    And close the application

  @TC06
  Scenario: TC06
    When user provides the "" lastname
    Then user gets Your LastName is required error message
    And close the application

  @TC07
  Scenario Outline: TC07
    When user provides the "<valid>" lastname
    Then user does not get invalid error message
    And close the application

    Examples:
      | valid    |
      | velioğlu |
      | a        |
      | a142     |

  @TC08
  Scenario Outline: TC08
    When user provides the "<valid>" phone number
    Then user does not get invalid error message
    And close the application


    Examples:
      | valid        |
      | 123-456-7890 |
      | 000-568-0000 |
      | 000-000-0000 |

  @TC09
  Scenario Outline: TC09
    When user provides the "<invalid>" phone number
    Then user gets Phone number is invalid error message
    And close the application

    Examples:
      | invalid      |
      | 123          |
      | 00056800005  |
      | 1234568790   |
      | 12345687902  |
      | 12-325-45698 |

  @TC10
  Scenario: TC10
    When user provides the "" phone number
    Then user gets Phone number is required error message
    And close the application

  @TC11
  Scenario: TC11
    When user enters first name "-1"
    And user provides the "-1" SSN
    And user provides the "-1" lastname
    And user provides the "-1" phone number
    And user provides the "-1" Email
    And user clicks Send an Appointment Request
    Then verify Appointment registration saved! We will call you as soon as possible. is displayed
    And user navigates to registration page
    And provide <valid> info for Registiration
    And click Register
    Then verify "Registration saved" is displayed
    When navigate to Sign in page
    And provide username and password and sign in
    And navigate to My Appointments
    And verify Appointments is displayed
    And close the application

   # Examples: patient info
    #| firstname | ssn | lastname | phone |email |
    #| ali       |1235689|gurs    |14236  |fnue.com|







