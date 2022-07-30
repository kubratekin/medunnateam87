  @US19 @team87-2
  Feature:US19 Create new Staff-Update existing Staff-View and Delete the Staff-Validate with API and DB
    Scenario Outline: TC0001 Admin can search new Staff among registered people using their SSN
      Given Admin is on the login page
      When Admin clicks on login dropdown icon
      And Admin clicks on sign in dropdown
      And Admin sends username "<username>"
      And Admin sends password "<password>"
      Then Admin clicks on the sign in dropdown
      And Admin clicks Items&Titles Dropdown
      And Admin clicks StaffDropdown
      And Admin clicks Create a new staff button
      And Admin selects Use search checkbox
      And Admin fills SSN box with "<SSN>" number
      And Admin clicks Search User button
      And Admin verify "user found with search SSN" message is visible
      Then Admin close the application

      Examples:
      |SSN        |
      |358-65-3578|

    Scenario Outline: TC0002 All their information should be populated
      Given Admin is on the login page
      When Admin clicks on login dropdown icon
      And Admin clicks on sign in dropdown
      And Admin sends username "<username>"
      And Admin sends password "<password>"
      Then Admin clicks on the sign in dropdown
      And Admin clicks Items&Titles Dropdown
      And Admin clicks StaffDropdown
      And Admin clicks Create a new staff button
      And Admin selects Use search checkbox
      And Admin fills "<SSN>" box
      And Admin clicks Search User button
      And Admin fills "<birthdate>" and "<Phone>" from birthdate and phone boxes
      And Admin selects Blood Group
      And Admin fills "<Adress>" and "<Description>" boxes
      And Admin selects Country and City from dropdown boxes
      When Admin clicks Save button
      And Admin verifies to "A new Staff is created" message is visible
      Then Admin close the application

      Examples:
      |SSN        |birthdate  |Phone        |Adress                   |Description  |
      |241-43-2917|07/10/2001 |111-223-1930 |1232 Sandia ave. Fremont |This is test |

    Scenario: TC0003 User (Admin) can select a user from the existing users (registered people)
      Given Admin is on the login page
      When Admin clicks on login dropdown icon
      And Admin clicks on sign in dropdown
      And Admin sends username "<username>"
      And Admin sends password "<password>"
      Then Admin clicks on the sign in dropdown
      And Admin clicks Items&Titles Dropdown
      And Admin clicks StaffDropdown
      And Admin selects any user from the existing users
      And Admin verifies selected user all information is visible
      Then Admin close the application

    Scenario Outline: TC0004 User can edit their info
      Given Admin is on the login page
      When Admin clicks on login dropdown icon
      And Admin clicks on sign in dropdown
      And Admin sends username "<username>"
      And Admin sends password "<password>"
      Then Admin clicks on the sign in dropdown
      And Admin clicks Items&Titles Dropdown
      And Admin clicks StaffDropdown
      And Admin clicks edit button
      And Admin change firstname "<firstname>" and lastname "<lastname>"
      And Admin fill "<birthdate>" and "<phone>" from birthdate and phone boxes
      And Admin fills bloodgroup
      And Admin fill "<adress>" and "<description>" boxes
      And Admin select Country and City from dropdown boxes
      When Admin clicks Save button
      And Admin verifies that "A Staff is updated" message is visible
      Then Admin close the application

      Examples:
      |firstname        |lastname       |birthdate  |phone        |adress                   |description  |
      |firstname edited |lastname edited|04/03/1968 |123-451-6787 |New York 1234 street     |Next test    |

    Scenario: TC0005 User can delete their info
      Given Admin is on the login page
      When Admin clicks on login dropdown icon
      And Admin clicks on sign in dropdown
      And Admin sends username "<username>"
      And Admin sends password "<password>"
      Then Admin clicks on the sign in dropdown
      And Admin clicks Items&Titles Dropdown
      And Admin clicks StaffDropdown
      And Admin clicks Delete Button at the Staff Page
      And Admin clicks Delete Button at he Alert Page
      And Admin verifies at "A Staff is deleted" message is visible
      Then Admin close the application

