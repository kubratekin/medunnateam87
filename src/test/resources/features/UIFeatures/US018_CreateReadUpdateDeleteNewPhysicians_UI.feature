@US018_UI @18ui
Feature: US018_Create,read,update and delete new Physicians

  Scenario Outline: US_018_TC001_UI To confirm that user (admin)  can view patient information by navigating to the view portal
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And  eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User verifies Create a new Physician button is visible
    And eh User clicks on Create a new Physician
    And eh User verifies Create or Edit a Physician is visible
    Then eh User fills all fields to complete registration ("<first name>", "<last name>", "<birth date>", "<phone>", "<address>", "<gender>", "<speciality>", "<blood group>", "<description>", "<photo path>", "<exam fee>", "<user>", "<country>" and "<state/city>")
    And eh User verifies successful registration
    And eh User closes the browser
    Examples:
      | username     | password | first name | last name | birth date | phone      | address          | gender | speciality         | blood group | description | photo path                         | exam fee | user                    | country | state/city |
      | team87_admin | 1234567  | Alehandro  | Manus     | 02/02/1990 | 0123456789 | 1051 47th street | MALE   | Allergy_immunology | Bnegative   | n/a         | C:\Users\SEMA\Desktop\photo111.png | 100      | melindauser:100-20-1901 | USA     | California |


  Scenario Outline: US_018_TC002_UI To confirm that user (admin) can choose/search an existing registered user by SSN id    When si User click on the account dropdown toggle
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User verifies Create a new Physician button is visible
    And eh User clicks on Create a new Physician
    And eh User verifies Create or Edit a Physician is visible
    And eh User clicks on Use Search
    And eh User types "<SSN>" and clicks the Search User Button
    Then eh User confirms a user with the provided SSN is found
    And eh User closes the browser

    Examples:
      | username     | password | SSN         |
      | team87_admin | 1234567  | 444-11-8877 |


  Scenario Outline: US_018_TC003_UI To confirm that Physicians' info is be populated firstname, lastname birth date etc..
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User verifies Create a new Physician button is visible
    And eh User clicks on Create a new Physician
    And eh User verifies Create or Edit a Physician is visible
    And eh User clicks on Use Search
    And eh User types "<SSN>" and clicks the Search User Button
    Then eh User confirms a user with the provided SSN is found
    And eh User verifies all personal information boxes are populated correctly
    And eh User closes the browser
    Examples:
      | username     | password | SSN         |
      | team87_admin | 1234567  | 444-11-8877 |

  Scenario Outline: US_018_TC004_UI To confirm that user (admin) can provide a profile picture of the doctor
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User clicks on the Edit button for a record
    And eh User verifies Create or Edit a Physician is visible
    And eh User sends the profile photo path to upload the photo "<path>"
    Then eh User confirms file is succesfully uploaded
    Then eh User clicks on the Save button
    And eh User confirms succesfull update notification is displayed
    And eh User closes the browser

    Examples:
      | username     | password | path                               |
      | team87_admin | 1234567  | C:\Users\SEMA\Desktop\photo111.png |


  Scenario Outline: US_018_TC005_UI To onfirm that user (admin) can  provide a specialty for the Doctor
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User clicks on the Edit button for a record
    And eh User verifies Create or Edit a Physician is visible
    And eh User selects the doctor speciality as "<speciality>"
    Then eh User confirms file is succesfully uploaded
    Then eh User clicks on the Save button
    And eh User confirms succesfull update notification is displayed
    And eh User closes the browser

    Examples:
      | username     | password | speciality |
      | team87_admin | 1234567  | Surgery    |

  Scenario Outline: US_018_TC006_UI To confirm that user (admin) can provide the Exam fee of the doctor (earning amount)
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User clicks on the Edit button for a record
    And eh User verifies Create or Edit a Physician is visible
    And eh User selects the doctor exam fee as "<exam fee>"
    Then eh User confirms file is succesfully uploaded
    Then eh User clicks on the Save button
    And eh User confirms succesfull update notification is displayed
    And eh User closes the browser

    Examples:
      | username     | password | exam fee |
      | team87_admin | 1234567  | 350      |


  Scenario Outline: US_018_TC007_UI To confirm that user (admin) can provide the Exam fee of the doctor (earning amount)
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User clicks the view button of the first record from the list
    Then eh User confirms that all Physician info is visible
    And eh User closes the browser

    Examples:
      | username     | password |
      | team87_admin | 1234567  |

  Scenario Outline: US_018_TC008_UI To confirm that user (admin) can edit existing Physicians' info using new data
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User clicks on the Edit button for a record
    And eh User verifies Create or Edit a Physician is visible
    Then eh User edits all fields to complete registration ("<first name>", "<last name>", "<birth date>", "<phone>", "<address>", "<gender>", "<speciality>", "<blood group>", "<description>", "<photo path>", "<exam fee>", "<user>", "<country>" and "<state/city>")
    Then eh User clicks on the Save button
    And eh User confirms succesfull update notification is displayed
    And eh User closes the browser


    Examples:
      | username     | password | first name | last name | birth date | phone      | address          | gender | speciality | blood group | description | photo path                         | exam fee | user                     | country | state/city |
      | team87_admin | 1234567  | Frank      | Einstein  | 01/01/1881 | 0123456789 | 1051 47th street | MALE   | Surgery    | Onegative   | Prof Dr     | C:\Users\SEMA\Desktop\photo111.png | 1000     | team87_user1:321-48-7891 | USA     | California |


  Scenario Outline: US_018_TC009_UI To confirm that user (admin) can delete existing Physicians
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    And eh User verifies the Delete button is visible
    And eh User clicks the Delete button to delete record
    And eh User clicks the Delete button again to confirm the deletion
    Then eh User verifies all information is deleted
    And eh User closes the browser

    Examples:
      | username     | password |
      | team87_admin | 1234567  |


  Scenario Outline: US_018_TC010_UI To confirm that all field labels are visible on Create or Edit a Physician
    Given user goes to webpage
    When eh User click on the account dropdown toggle
    And eh User clicks on the Sign in button
    And eh User enters the user login credentials "<username>" and "<password>"
    And eh User click on the Sign in button
    Then eh User verifies successful log in as an Administrator by verifying "Administration" user type visibility
    And eh User navigates to Physicians page
    Then eh User verifies successful landing to the Physicians page
    Then eh User clicks on the Edit button for a record
    And eh User verifies Create or Edit a Physician is visible
    Then eh User verifies all field labels are visible on Create or Edit a Physician
    And eh User closes the browser

    Examples:
      | username     | password |
      | team87_admin | 1234567  |