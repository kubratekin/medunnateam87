@US16_DB
Feature: Validate Room creation by Admin with DB

  Scenario Outline: Validate all rooms with DB
    Given  Admin connects to the Database
    When Admin selects "id,room_number,price, room_type, status, description" from the "room" table
    And Admin verify that the data includes <id>, <room_number>, "<price>", "<room_type>", "<status>", "<description>" information
    Then Admin close the database connection

    Examples:
      | id     | room_number | price  | room_type | status | description |
      | 129234 | 3626        | 120.00 | DAYCARE   | true   | critic      |



