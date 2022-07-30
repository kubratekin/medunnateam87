package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.US04_LoginPage;
import utilities.ConfigReader;
import utilities.Driver;



public class US04_UserLogInStepDefs {
    US04_LoginPage userLogin = new US04_LoginPage();

    @Given("user navigates to url")
    public void user_navigates_to_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Given("user clicks on account dropdown")
    public void user_clicks_on_account_dropdown() throws InterruptedException {
        Thread.sleep(3000);
        userLogin.accountMenu.click();
    }

    @Given("user clicks on sign in button")
    public void user_clicks_on_sign_in_button() throws InterruptedException {
        Thread.sleep(2000);
        userLogin.homePageSignIn.click();
    }





    @Given("user clicks on sign in page sign in button")
    public void user_clicks_on_sign_in_page_sign_in_button() {
        userLogin.signInPageSignInButton.click();
    }




    @Given("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String username, String password) {
        userLogin.username.sendKeys("team87inci");
        userLogin.password.sendKeys("1Finci.");

    }

    @Given("user verifies remember me check box is clickable")
    public void user_verifies_remember_me_check_box_is_clickable() throws InterruptedException {
        userLogin.signInPageRememberMeButton.click();
        Assert.assertTrue(userLogin.signInPageRememberMeButton.isSelected());
        Thread.sleep(3000);
    }

    @Given("user clicks on Did you forget your password text box")
    public void user_clicks_on_did_you_forget_your_password_text_box() {

        userLogin.didYouForgetYourPassword.click();
        //Driver.wait(2000);

    }


    @Given("user clicks on email text box")
    public void user_clicks_on_email_text_box() throws InterruptedException {
        Thread.sleep(2000);
        userLogin.emailTextBox.click();
    }

    @And("user enters {string} address")
    public void userEntersAddress(String email) {
        Driver.waitAndSendText(userLogin.emailTextBox,email);
    }


    @Given("user clicks Reset password button")
    public void user_clicks_reset_password_button() throws InterruptedException {
        Thread.sleep(2000);
        userLogin.resetPasswordButton.click();
    }

    @Given("user verifies Alert check your email for details on how to reset your password")
    public void user_verifies_alert_check_your_email_for_details_on_how_to_reset_your_password() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(userLogin.detailsForReset.isDisplayed());
    }

    @Given("user verifies You don't have an account yet? Register a new account is visible")
    public void user_verifies_you_don_t_have_an_account_yet_register_a_new_account_is_visible() throws InterruptedException {
        Assert.assertTrue(userLogin.registerNewAccount.isDisplayed());
        Thread.sleep(3000);
    }


    @Given("user clicks on register new account")
    public void user_clicks_on_register_new_account() throws InterruptedException {

        userLogin.registerNewAccount.click();
        Thread.sleep(3000);
    }




    @And("user enters {string} as username")
    public void userEntersAsUsername(String username) throws InterruptedException {
        userLogin.username.sendKeys("username");
        Thread.sleep(3000);

    }

    @And("user verifies Reset your password button is enable")
    public void userVerifiesResetYourPasswordButtonIsEnable() throws InterruptedException {
        Assert.assertTrue(userLogin.resetPasswordButton.isEnabled());
        Thread.sleep(3000);
    }

    @And("user verifies that cancel button is enable")
    public void userVerifiesThatCancelButtonIsEnable() throws InterruptedException {
        Assert.assertTrue(userLogin.cancelButton.isEnabled());

    }

    @And("user clicks cancel button")
    public void userClicksCancelButton() throws InterruptedException {
        Thread.sleep(2000);
        userLogin.cancelButton.click();
    }

    @And("user verifies that sign in page is visible")
    public void userVerifiesThatSignInPageIsVisible() throws InterruptedException {
        Thread.sleep(1000);
    Assert.assertTrue(userLogin.signInPageHeader.isDisplayed());
    }

    @And("user verifies that Reset your password header is visible")
    public void userVerifiesThatResetYourPasswordHeaderIsVisible() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(userLogin.resetHeader.isDisplayed());
    }

    @And("user verifies that Registration page is visible")
    public void userVerifiesThatRegistrationPageIsVisible() {
        Assert.assertTrue(userLogin.registrationPage.isDisplayed());

    }

    @And("Verify that Authentication information not correct  is displayed")
    public void verifyThatAuthenticationInformationNotCorrectIsDisplayed() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(userLogin.authenticationToaster.isDisplayed());
    }





}


