@team87 @US25
@team87-2
Feature: US25_AppointmentOnPortal

  Background: open medunna page
    Given user goes to Medunna webpage
    When navigate to Sign in page

  @US25_TC01
  Scenario Outline: TC01
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    Then verify Make an Appointment page is displayed on user portal
    And verify that firstname, lastname, SSN and email of the user being populated
    And close the application

    Examples:
      | username | password |
      | ali6589  | 1234     |

  @US25_TC02
  Scenario Outline: TC02
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    And user provides the "<valid>" phone number
    Then user does not get invalid error message
    And close the application

    Examples:
      | username | password | valid       |
      | ali6589  | 1234     | 123-457-7896 |

  @US25_TC03
  Scenario Outline: TC03
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    And user provides the "<invalid>" phone number
    Then user gets Phone number is invalid error message
    And close the application

    Examples:
      | username | password | invalid       |
      | ali6589  | 1234     | 123-45-7896 |

  @US25_TC04
  Scenario Outline: TC04
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    And user provides the "" phone number
    Then user gets Phone number is required error message
    And close the application

    Examples:
      | username | password |
      | ali6589  | 1234     |

  @US25_TC05
  Scenario Outline: TC05
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    And user provides the "<valid>" phone number
    And user can select current date
    And user click Send an Appointment Request
    Then verify Appointment registration saved! We will call you as soon as possible. is displayed
    And close the application

    Examples:
      | username | password | valid       |
      | ali6589  | 1234     | 123-457-7896 |

  @US25_TC06
  Scenario Outline: TC06
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    And user provides the "<valid>" phone number
    And user can select future date
    And user click Send an Appointment Request
    Then verify Appointment registration saved! We will call you as soon as possible. is displayed
    And close the application

    Examples:
      | username | password | valid       |
      | ali6589  | 1234     | 123-457-7896 |

  @US25_TC07
  Scenario Outline: TC07
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    And user provides the "<valid>" phone number
    And user can select past date
    And user click Send an Appointment Request
    Then verify created the message Appointment date can not be past date! is visible
    And close the application

    Examples:
      | username | password | valid       |
      | ali6589  | 1234     | 123-457-7896 |

  @US25_TC08
  Scenario Outline: TC08
    When user enters "<username>" and "<password>" clicks sign in
    And user clicks to Make an appointment button under My Pages menu
    And user provides the "<valid>" phone number
    And user selects future date
    And user click Send an Appointment Request
    Then verify Appointment registration saved! We will call you as soon as possible. is displayed
    When navigate to My Appointments
    Then verify that the created Appointment is displayed
    And close the application

    Examples:
      | username | password | valid       |
      | ali6589  | 1234     | 123-457-7896 |


