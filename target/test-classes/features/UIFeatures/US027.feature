@US027
Feature: US027 Admin should be able to go to messages portal and view all messages, their authors and emails

  @US027_TC001
  Scenario: Admin verifies all names, emails and messages are displayed
    Given FK Admin navigates to Medunna home page
    And FK Admin clicks on human icon
    And FK Admin clicks on sign in button under human icon at homepage
    And FK Admin sends username "kfadmin" and password "kfadmin" in sign in page
    And FK Admin clicks on sign in button in sign in page
    Then FK Admin verifies the admin page is displayed
    Then FK Admin clicks on items and titles dropdown
    Given FK Admin clicks on messages button
    Then FK Admin verifies the messages page is displayed
    Then FK Admin verifies all names, emails and messages are displayed

  @US027_TC002
  Scenario Outline: Admin should be able to create messages
    Given FK Admin navigates to Medunna home page
    And FK Admin clicks on human icon
    And FK Admin clicks on sign in button under human icon at homepage
    And FK Admin sends username "kfadmin" and password "kfadmin" in sign in page
    And FK Admin clicks on sign in button in sign in page
    Then FK Admin verifies the admin page is displayed
    Then FK Admin clicks on items and titles dropdown
    And FK Admin clicks on messages button
    Then FK Admin verifies the messages page is displayed
    And FK Admin clicks on the create a new message button
    Then FK Admin verifies the Create or edit a Message page is displayed
    And FK Admin enters name "<Name>" into name text box
    And FK Admin enters email "<Email>" into email text box
    And FK Admin enters subject "<Subject>" into subject text box
    And FK Admin enters message "<Message>" into message text box
    And FK Admin clicks on save button in create or edit a message page
    Then FK Admin verifies successfully created message is displayed

    Examples:
      | Name          | Email                  | Subject       | Message               |
      | Admin Message | adminmessage@yahoo.com | Admin creates | Admin creates message |

  @US027_TC003
  Scenario Outline:Admin should be able to update messages
    Given FK Admin navigates to Medunna home page
    And FK Admin clicks on human icon
    And FK Admin clicks on sign in button under human icon at homepage
    And FK Admin sends username "kfadmin" and password "kfadmin" in sign in page
    And FK Admin clicks on sign in button in sign in page
    Then FK Admin verifies the admin page is displayed
    Then FK Admin clicks on items and titles dropdown
    And FK Admin clicks on messages button
    Then FK Admin verifies the messages page is displayed
    And FK Admin clicks on the edit button in the message page
    Then FK Admin verifies the Create or edit a Message page is displayed
    And FK Admin updates the name "<Name>" into name text box
    And FK Admin updates the email "<Email>" into email text box
    And FK Admin updates the subject "<Subject>" into subject text box
    And FK Admin updates the message "<Message>" into message text box
    And FK Admin clicks on save button in create or edit a message page
    Then FK Admin verifies successfully updated message is displayed


    Examples:
      | Name         | Email                 | Subject       | Message               |
      | Admin update | adminupdate@yahoo.com | Admin updates | Admin updates message |

  @US027_TC004
  Scenario: Admin should be able to delete messages
    Given FK Admin navigates to Medunna home page
    And FK Admin clicks on human icon
    And FK Admin clicks on sign in button under human icon at homepage
    And FK Admin sends username "kfadmin" and password "kfadmin" in sign in page
    And FK Admin clicks on sign in button in sign in page
    Then FK Admin verifies the admin page is displayed
    Then FK Admin clicks on items and titles dropdown
    And FK Admin clicks on messages button
    Then FK Admin verifies the messages page is displayed
    And FK Admin clicks on the delete button in the message page
    Then FK Admin verifies the delete confirmation toast container is displayed
    And FK Admin clicks the delete button in the toast container
    Then FK Admin verifies successfully deleted message is displayed

  @US027_TC005 @Api
  Scenario: Admin should validate creating messages using API

    Given FK Admin set the path params for message
    And FK Admin enters expected data for message
    And FK Admin sends POST request and receives response for message
    Then FK Admin save all aappii information for message
    Then FK Admin verify aappii records for message

  @US027_TC006 @Db
  Scenario:Admin should validate messages with DB
    Given FK Admin connects to the database
    And FK Admin creates a new message data with these values "'78055','admin dbde','admindbde@yahoo.com','admindb','admin databasede'"
    And FK Admin reads all of the "message" column data from "cmessage" table
    And FK Admin reads all of the "select * from cmessage" and "id" and "name" and "email" and "subject" and "message" column data
    Then FK Admin verifies the creation is successfull using DB
