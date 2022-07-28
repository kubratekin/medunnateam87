@US17_Api
Feature: create_and_validate_test_item_using_api

  @US17_Api_01
  Scenario: create_test_item_using_post_request
    Given admin sets the path params to create test items
    And admin sets the expected data
    And admin sends post request and get the response
    Then admin validates the test items


  @US17_Api_02
  Scenario: validate_test_item_using_get_request
    Given admin sets the path params to read test items
    And admin sends a get request for created test item
    Then admin validates the test item
