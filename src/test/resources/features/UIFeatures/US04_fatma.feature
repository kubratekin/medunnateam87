@SignInPage @team87
Feature:Login page should be accessible only with valid credentials


  @login
  Scenario Outline: User log in with correct username and password
    Given user navigates to url
    And user clicks on account dropdown
    And user clicks on sign in button
    And user verifies that sign in page is visible
    And user enters "<username>" username and "<password>" password
    And user clicks on sign in page sign in button
    And close the application


    Examples:
      | username   | password |
      | team87inci | 1Finci.  |


  @rememberMe
  Scenario Outline: User always logs in with existing credentials
    Given user navigates to url
    And user clicks on account dropdown
    And user clicks on sign in button
    And user verifies that sign in page is visible
    And user enters "<username>" username and "<password>" password
    And user verifies remember me check box is clickable
    And close the application

    Examples:
      | username   | password |
      | team87inci | 1Finci.  |


  @didYouForget
  Scenario Outline: User updates password with did you forget your password option
    Given user navigates to url
    And user clicks on account dropdown
    And user clicks on sign in button
    And user verifies that sign in page is visible
    And user enters "<username>" as username
    And user clicks on Did you forget your password text box
    #And user clicks on email text box
    And user enters "<email>" address
    And user clicks Reset password button
    And user verifies Alert check your email for details on how to reset your password
    And close the application

    Examples:
      | username   | email                |
      | team87inci | team87inci@gmail.com |

  @registrationPage
  Scenario: User registers with not registered yet option
    Given user navigates to url
    And user clicks on account dropdown
    And user clicks on sign in button
    And user verifies that sign in page is visible
    And user verifies You don't have an account yet? Register a new account is visible
    And user clicks on register new account
    And user verifies that Registration page is visible
    And close the application

  @cancel
  Scenario Outline: User log in with correct username and password
    Given user navigates to url
    And user clicks on account dropdown
    And user clicks on sign in button
    And user enters "<username>" username and "<password>" password
    And user verifies that cancel button is enable
    And user clicks cancel button
    And close the application


    Examples:
      | username   | password |
      | team87inci | 1Finci.  |


  @loginWithWrongUserNameAndPassword
  Scenario Outline: User log in with wrong username and password
    Given user navigates to url
    And user clicks on account dropdown
    And user clicks on sign in button
    And user verifies that sign in page is visible
    And user enters "<wusername>" username and "<wpassword>" password
    And user clicks on sign in page sign in button
    And Verify that Authentication information not correct  is displayed
    And close the application


    Examples:
      | wusername | wpassword |
      | team87inc | 1Finci    |