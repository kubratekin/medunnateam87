package stepdefinitions.uisteps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US008_PasswordPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US08_UserPasswordStepDefs {

    US008_PasswordPage userPassword = new US008_PasswordPage();

    @Given("user navigates to Url")
    public void user_navigates_to_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

    }
    @Given("user clicks on Account menu")
    public void user_clicks_on_account_menu() throws InterruptedException {
        Thread.sleep(1000);
        userPassword.accountMenu.click();


    }
    @Given("user clicks on Sign in button")
    public void user_clicks_on_sign_in_button() {
        userPassword.homePageSignIn.click();

    }
    @Given("user enters {string} as username and {string} as password")
    public void user_enters_as_username_and_as_password(String username, String password) {
        userPassword.username.sendKeys("team87user01");
        userPassword.password.sendKeys("1234567");

    }
    @Given("user clicks on the Signin button")
    public void user_clicks_on_the_signin_button() {

        userPassword.signInPageSignInButton.click();
    }
    @Given("verify the login is successful")
    public void verify_the_login_is_successful() throws InterruptedException {
        Assert.assertTrue(userPassword.loginPageAccountMenu.isDisplayed());
        Thread.sleep(2000);
    }

    @And("user clicks on account menu on the account page")
    public void userClicksOnAccountMenuOnTheAccountPage() {
        Driver.waitAndClick(userPassword.loginPageAccountMenu, 3);
    }


    @Then("user clicks on Password button")
    public void user_clicks_on_password_button() throws InterruptedException {

        Driver.waitAndClick(userPassword.loginPagePasswordButton, 3);

        Thread.sleep(2000);
    }

    @Given("user sends current password {string} to current password part")
    public void user_sends_current_password_to_current_password_part(String currentPassword) throws InterruptedException {
        Driver.waitAndSendText(userPassword.currentPassword, currentPassword);
        Thread.sleep(2000);
    }

    @Given("user sends new password {string} to new password part")
    public void user_sends_new_password_to_new_password_part(String newPassword) throws InterruptedException {
        Driver.waitAndSendText(userPassword.newPassword, newPassword);
        Thread.sleep(2000);
    }

    @Given("user sends new password {string} again to new password confirmation part")
    public void user_sends_new_password_again_to_new_password_confirmation_part(String confirmationPassword) throws InterruptedException {
        Driver.waitAndSendText(userPassword.confirmationPassword, confirmationPassword, 3);
        Thread.sleep(2000);
    }

    @Given("user clicks on save button")
    public void user_clicks_on_save_button() throws InterruptedException {
        Driver.waitAndClick(userPassword.saveButton, 3);
        Thread.sleep(3000);
    }

    @Then("user sees success message in the toast container box")
    public void user_sees_success_message_in_the_toast_container_box() throws InterruptedException {
        String expectedResult="Password changed!";
        String actualResult=userPassword.successMessage.getText();

        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(4000);
    }

    /*@And("user clicks account_menu")
    public void userClicksAccount_menu() throws InterruptedException {
        Driver.waitAndClick(userPassword.accountMenu);
        Thread.sleep(2000);
    }*/

    @And("user add character {string} to new password part")
    public void userAddCharacterToNewPasswordPart(String newpass) {
        Driver.waitAndSendText(userPassword.newPassword,newpass);
        Driver.wait(2);

    }
    @And("user cleans the current password part")
    public void userCleansTheCurrentPasswordPart() {
        userPassword.currentPassword.clear();
        Driver.wait(2);
    }

    @And("user cleans the new password part")
    public void userCleansTheNewPasswordPart() {
        userPassword.newPassword.clear();
        Driver.wait(2);
    }
    @And("user cleans the confirmation password part")
    public void userCleansTheConfirmationPasswordPart() {
        userPassword.confirmationPassword.clear();
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is one")
    public void userVerifiesThePasswordStrengthBarIsOne() {
        Assert.assertTrue(userPassword.passwordStrength1.isDisplayed());
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is two")
    public void userVerifiesThePasswordStrengthBarIsTwo() {
        Assert.assertTrue(userPassword.passwordStrength2.isDisplayed());
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is four")
    public void userVerifiesThePasswordStrengthBarIsFour() {
        Assert.assertTrue(userPassword.passwordStrength4.isDisplayed());
        Driver.wait(2);
    }

    @And("user verifies the password strength bar is five")
    public void userVerifiesThePasswordStrengthBarIsFive() {
        Assert.assertTrue(userPassword.passwordStrength5.isDisplayed());
        Driver.wait(2);
    }

    @And("user sends current password {string} to new password part")
    public void userSendsCurrentPasswordToNewPasswordPart(String newPass) {
        Driver.waitAndSendText(userPassword.newPassword,newPass);
        Driver.wait(2);
    }

    @And("user sends current password {string} to confirmation password part")
    public void userSendsCurrentPasswordToConfirmationPasswordPart(String confirmationPass) {
        Driver.waitAndSendText(userPassword.confirmationPassword,confirmationPass);
        Driver.wait(2);
    }

    @Then("user sees the success message on the toast container box as a BUG")
    public void userSeesTheSuccessMessageOnTheToastContainerBoxAsABUG() throws InterruptedException, IOException {
        String expectedResult="Password changed!";
        String actualResult=userPassword.successMessage.getText();
        Assert.assertEquals(expectedResult,actualResult);
        ReusableMethods.getScreenshot("password changed");
        Thread.sleep(4000);
    }

    @And("user verifies the success message on the toast container box")
    public void userVerifiesTheSuccessMessageOnTheToastContainerBox() throws InterruptedException {
        String expectedResult="Password changed!";
        String actualResult=userPassword.successMessage.getText();
        Assert.assertEquals(expectedResult,actualResult);
        Thread.sleep(4000);
    }

    @Then("user close the driver")
    public void userCloseTheDriver() {
        Driver.closeDriver();
    }


    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }
    }
