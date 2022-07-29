@US028
Feature:create_country_using_api
  @US028_Api01
  Scenario:create_country_using_post_request
    Given admin sets the path params to create a country
    And admin set the expected data
    And admin sends POST request and get the response
    Then admin validates the created country

  @US028_Api02
  Scenario: validate_country_with_api
    Given admin sets the path params to read country
    And admin sends a get request for created country
    Then admin validates the country


  @US028_Api03
  Scenario: create_state_city_using_post_request
    Given admin sets the path params to create a stateCity
    And admin setss the exxpected DData
    And admin sendss POST requestt and Get the response
    Then admin validates the created state

  @US028_Api04
  #Scenario: validate_state_with_api
    #Given admin sets the path params to read test items
    #And admin sends a get request for created test item
    #Then admin validates the test item


  @US028_Api05
  Scenario: update_country_using_put_request
    Given admin sets the path params to update a country
    And admin setss the exxpected Dataa
    And admin sendss Put requestt and Get the response
    Then admin validates the updated country



