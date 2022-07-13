Feature: SeeAppointments

  @GetTheAppointments
  Scenario: User sees his own appointments
    Given user goes to Medunna page
    Then  user sends a request to get response
    Then user validates api appointments