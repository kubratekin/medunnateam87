@team87   @US_15_Create_Edit_Patient_By_Admin
  Feature: US15_Create Edit Patient By Admin

    @TC01_New_Patient_Only_Created_By_Admin
    Scenario Outline: Create New Patient
      Given Go to medunna home page
      When Admin clicks Sign in Link
      Then Admin fills the username "<username>"
      And Admin fills the password "<password>"
      And Admin clicks the Sign in button
      And Admin clicks the Items&Titles dropdown
      And Admin clicks Patient link
      And Admin clicks the Create a new Patient Button
      And Admin fills the "<Birth Date>","<Gender>","<Blood Group>","<Address>","<Description>","<User>","<Country>","<State>"
      And Admin clicks Save Button
      Then Verify the A new patient is created message
      And Closes the browser

      Examples: Test Datas
        |username    |password|Birth Date         |Gender|Blood Group|Address |Description|User     |Country|State     |
        |team87_admin|1234567 |05/05/1980 03:20 AM|MALE  |A+         |A street|Big Home   |jon.haley|USA    |California|


    @TC02_New_Patients_Can_Not_Be_Created_By_Staff
    Scenario Outline: Create New Patient By Staff Negative Scenario
      Given Go to medunna home page
      When Staff clicks Sign in Link
      Then Staff fills the username "<username>"
      And Staff fills the password "<password>"
      And Staff clicks the Sign in button
      Then Verify the Mypages link is displayed instead of Items&Titles link
      And Closes the browser

      Examples:
        |username      |password|
        |team87staff001|1234567 |


    @TC03_New_Patients_Can_Not_Be_Created_By_Doctor
    Scenario Outline: Create New Patient By Doctor Negative Scenario
      Given Go to medunna home page
      When Doctor clicks Sign in Link
      Then Doctor fills the username "<username>"
      And Doctor fills the password "<password>"
      And Doctor clicks the Sign in button
      Then Verify the Mypages link is displayed instead of Items&Titles link
      And Closes the browser

      Examples:
        |username       |password|
        |team87doctor001|1234567 |


    @TC04_New_Patients_Can_Not_Be_Created_By_Patient
    Scenario Outline: Create New Patient By Patient Negative Scenario
      Given Go to medunna home page
      When Patient clicks Sign in Link
      Then Patient fills the username "<username>"
      And Patient fills the password "<password>"
      And Patient clicks the Sign in button
      Then Verify the Mypages(Patient) link is displayed instead of Items&Titles link
      And Closes the browser

      Examples:
        |username        |password|
        |team87patient001|1234567 |


    @TC05_Admin_Can_See_All_Patient_Information
    Scenario Outline: See Patient Info
      Given Go to medunna home page
      When Admin clicks Sign in Link
      Then Admin fills the username "<username>"
      And Admin fills the password "<password>"
      And Admin clicks the Sign in button
      And Admin clicks the Items&Titles dropdown
      And Admin clicks Patient link
      Then Verify all patient information
      And Closes the browser

      Examples: Credentials
        |username    |password    |
        |team87_admin|1234567|


    @TC06_Admin_Can_Also_See_Patient_ID
    Scenario Outline: See Patient ID
      Given Go to medunna home page
      When Admin clicks Sign in Link
      Then Admin fills the username "<username>"
      And Admin fills the password "<password>"
      And Admin clicks the Sign in button
      And Admin clicks the Items&Titles dropdown
      And Admin clicks Patient link
      And Admin clicks Edit Button
      Then Verify ID information is shown
      And Closes the browser

      Examples: Credentials
        |username    |password    |
        |team87_admin|1234567     |


    @TC07_State_Should_Be_Provided_Can_Not_Be_Blank
    Scenario Outline: Create New Patient Provide State Positive Scenario
      Given Go to medunna home page
      When Admin clicks Sign in Link
      Then Admin fills the username "<username>"
      And Admin fills the password "<password>"
      And Admin clicks the Sign in button
      And Admin clicks the Items&Titles dropdown
      And Admin clicks Patient link
      And Admin clicks the Create a new Patient Button
      And Admin fills the "<Birth Date>","<Gender>","<Blood Group>","<Address>","<Description>","<User>","<Country>"
      And Admin clicks Save Button
      Then Verify the A new patient is created message
      And Closes the browser

      Examples: Test Datas
        |username    |password|Birth Date         |Gender|Blood Group|Address|Description|User     |Country|State|
        |team87_admin|1234567 |05/05/1980 03:20 AM|MALE  |A+         |A street|Big Home  |jon.haley|USA    |California|


    @TC09_Admin_Can_Delete_Patient
    Scenario Outline: Admin Delete Patient
      Given Go to medunna home page
      When Admin clicks Sign in Link
      Then Admin fills the username "<username>"
      And Admin fills the password "<password>"
      And Admin clicks the Sign in button
      And Admin clicks the Items&Titles dropdown
      And Admin clicks Patient link
      And Admin clicks the Delete button next to the patient "<First Name>","<Last Name>","<Email>","<Phone>"
      And Admin clicks the Delete button on the delete message window
      Then Verify the user is deleted message
      And Closes the browser

      Examples: Credentials
        |username    |password|First Name      |Last Name|Email             |Phone     |
        |team87_admin|1234567 |Temprory Patient|Delete   | temprory@temp.com|3685964586|


    @TC08_State_Should_Be_Provided_Can_Not_Be_Blank_Negative
    Scenario Outline: Create New Patient Provide State Negative Scenario
      Given Go to medunna home page
      When Admin clicks Sign in Link
      Then Admin fills the username "<username>"
      And Admin fills the password "<password>"
      And Admin clicks the Sign in button
      And Admin clicks the Items&Titles dropdown
      And Admin clicks Patient link
      And Admin clicks the Create a new Patient Button
      And Admin fills the "<Birth Date>","<Gender>","<Blood Group>","<Address>","<Description>","<User>","<Country>"
      And Admin clicks Save Button
      Then Verify the A new patient is not created successfully
      And Closes the browser

      Examples: Test Datas
        |username    |password|Birth Date         |Gender|Blood Group|Address|Description|User     |Country|State|
        |team87_admin|1234567 |05/05/1980 03:20 AM|MALE  |A+         |A street|Big Home  |jon.haley|USA    |California|