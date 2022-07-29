@US17_UI
Feature: test_items
  Background: opening_medunna_page_and_sign_in
    Given admin goes to the medunna website
    When admin navigates to Sign in page
    And admin sends "<username>" and "<password>"
    And admin clicks on Sign in button
    And admin clicks on Items&Titles dropdown menu and selects Test Item section

  @US17_TC01
  Scenario Outline: create_a_new_test_item
    And admin clicks on Create a new Test Item button
    And admin enters information to "<Name>", "<Description>", "<Price>", "<Default Min. Value>", "<Default Max. Value>" fields
    And admin clicks on Save button
    Then admin verifies the test item created successfully
    And admin clicks on Sign out button
    Then admin closes the application
    Examples: test_items
      | Name            | Description | Price | Default Min. Value | Default Max. Value |  |
      | team87B12_testt | test4       | 50    | 3.5                | 5.1                |  |

  @US17_TC02
  Scenario Outline: update_test_item
    And admin clicks on Edit button
    And admin updates the "<Name>", "<Description>", "<Price>", "<Default Min. Value>", "<Default Max. Value>" fields and clicks on Save button
    Then admin verifies all fields updated succesfully
    And admin clicks on Sign out button
    Then admin closes the application
    Examples: updated_test_item
      | Name          | Description | Price | Default Min. Value | Default Max. Value |  |
      | team87_testtt | testtt      | 120   | 74                 | 110                |  |

  @US17_TC03
  Scenario: view_test_item
    And admin clicks on View button on a test item
    Then admin verifies all fields such as Name, Description, Price, Default Min. Value, Default Max. Value and Created Date
    And admin clicks on Sign out button
    Then admin closes the application


  @US17_TC04
  Scenario: delete_test_item
    And admin clicks on Delete button on a test item
    Then admin verifies the test item is deleted
    And admin clicks on Sign out button
    Then admin closes the application



