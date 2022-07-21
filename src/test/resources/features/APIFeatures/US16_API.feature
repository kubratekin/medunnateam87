@US16_API
Feature:Validate Room creation by Admin. Create View, Update, Delete with API

  @US16_API_TC01
    @ApiRegistrant
  Scenario Outline: Validate rooms with API create
    Given Admin set the expected data "<description>", <price>, "<roomType>" and "<status>"
    When Admin sends the "POST" request
    Then Admin status code should be 201 for rooms
    Then Admin verify that the response body should be as an expected data
    Examples:
      | description | price | roomType | status |
      | With TV     | 200   | DELUXE   | false  |

  @US16_API_TC02
    @ApiRegistrant
  Scenario Outline: Validate all rooms with API read
    Given Admin set the expected data "<description>", <price>, <roomNumber>, "<roomType>" and "<status>"
    When Admin sends the "GET" request
    Then Admin status code should be 200 for rooms
    Then Admin verify that the response body contains all expected data
    Examples:
      | description | price | roomNumber | roomType | status |
      | mus         | 111   | 1111       | TWIN     | true   |

  @US16_API_TC03
    @ApiRegistrant
  Scenario Outline: Validate rooms with API update
    Given Admin set the expected data "<description>", <price>, <roomNumber>, "<roomType>","<status>" and <roomId>
    When Admin sends the "PUT" request
    Then Admin status code should be 200 for rooms
    Then Admin verify that the response body should be as an expected
    Examples:
      | description | price  | roomNumber | roomType | status | roomId |
      | free room   | 100 | 14555      | DELUXE   | false  | 28488  |

  @US16_API_TC04
  @ApiRegistrant
  Scenario: Validate rooms with API delete
    Given Admin sends the delete request
    Then Admin  status code should be 204 for roooms