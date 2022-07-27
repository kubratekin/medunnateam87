@US16
Feature: Room creation by Admin. View, Update, Delete.

  @US16_TC01
  Scenario:  (Admin) can create new rooms for impatients. Created date as MM/DAY/YEAR and cannot be typed earlier
    Given Admin navigate to Medduna Home Page
    And Admin Click on Account DropDownMenu button
    When Admin Click on Sign in
    Then Admin Click on Username input box.
    Then Admin Enter Valid "team87_admin" Username
    Then Admin Click on Password input box.
    Then Admin Enter Valid "1234567" Password
    Then Admin Click on Sign in button
    And Admin Click on Items&Titles
    And Admin select Room from drop down menu and click
    When Admin clicks on Create a new Room button
    Then Admin verify that user on the "Create or edit a Room" page
    Given Admin provides a Room Number
    And Admin provides a Price
    And Admin sets date as "03/12/2022"
    When Admin clicks on the Save button
    Then Admin should see the "A new Room is created"
      #And Admin verify that Created Date is updated automatically

  @US16_TC02
  Scenario: When creating a room, there should be room number (required field),room type as TWIN, DELUXE, PREMIUM_DELUXE, SUIT and DAYCARE, Current status can be set for the room,Price can be added and cannot be blank,Description can be provided optionally

    When Admin clicks on Create a new Room button
    Given Admin leave blank Room Number field and click enter
    And Adminshould see "This field is required." feedback twice
    When Admin clicks on the Room Type dropdown
    Then Admin should see options like "TWIN", "DELUXE", "PREMIUM_DELUXE", "SUITE" and "DAYCARE"
    And Admin can set current status for the room

  @US16_TC03
  Scenario:Admin can view all rooms with same items,Admin can edit(update) existing rooms,Rooms can be Deleted by admin

    Given Admin on the Rooms page
    And Admin should see all rooms on the same page
    When Admin clicks on "edit" button for last created room
    Then Admin verify that user on the "Create or edit a Room" page
    And Admin provides "Room without TV" as description
    When Admin clicks on the Save button
    Then Admin should see the "Room is updated"
    When Admin clicks on "delete" button for last created room
    And Admin confirms delete operation
    Then Admin should see the "Room is deleted"