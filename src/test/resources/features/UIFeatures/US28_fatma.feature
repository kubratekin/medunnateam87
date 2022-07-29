Feature:Admin can create,delete,update new country/state/city

  @createCountry
  Scenario Outline: Admin can create a country
    Given admin navigates to url
    And admin clicks on account dropdown
    And admin clicks on sign in button
    And admin verifies that sign in page is visible
    And admin enters "<username>" username and "<password>" password
    And admin clicks on sign in page sign in button
    And admin verifies admin page is displayed
    And admin clicks on items and titles dropdown
    And admin clicks on country button
    And admin verifies countries page is visible
    And admin clicks on create a new Country button
    And admin verifies Create or edit a Country page is visible
    And admin enters "<umutistan111>" countryname
    And admin clicks on Save button
    And admin verifies a new country is created with identifier message is displayed

    Examples:
      | username     | password |
      | team87_admin | 1234567  |


  @createStateCity
  Scenario Outline: Admin can create a State/City
    Given user navigates to url
    And admin clicks on account dropdown
    And admin clicks on sign in button
    And admin verifies that sign in page is visible
    And admin enters "<username>" username and "<password>" password
    And admin clicks on sign in page sign in button
    And admin verifies admin page is displayed
    And admin clicks on items and titles dropdown
    And admin clicks on states and cities button
    And admin clicks on crete a new StateCity button
    And admin enters a StateCity "<stateCity>" name
    And admin clicks on a country "<country>"
    And admin clicks on Save button
    And admin verifies a new StateCity is created message
    Examples:
      | username     | password | stateCity | country   |
      | team87_admin | 1234567  | umut      | umutistan |


  @deleteCountries
  Scenario Outline: Admin can create a country
    Given admin navigates to url
    And admin clicks on account dropdown
    And admin clicks on sign in button
    And admin verifies that sign in page is visible
    And admin enters "<username>" username and "<password>" password
    And admin clicks on sign in page sign in button
    And admin verifies admin page is displayed
    And admin clicks on items and titles dropdown
    And admin clicks on country button

    And admin clicks on create a new Country button
    And admin verifies Create or edit a Country page is visible
    And admin Enters "<umutumut2>" countryname
    And admin clicks on Save button


    # And admin selects a country
    And admin clicks on delete button
    And admin verifies confirm delete operation alert
    And admin verifies a new country is deleted with identifier


    Examples:
      | username     | password |
      | team87_admin | 1234567  |


