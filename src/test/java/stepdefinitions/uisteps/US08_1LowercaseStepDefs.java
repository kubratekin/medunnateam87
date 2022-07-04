package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.US08PasswordEditPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US08_1LowercaseStepDefs {
    US08PasswordEditPage us08PasswordEditPage = new US08PasswordEditPage();
    @Given("User goes to {string}")
    public void user_goes_to(String app_url) {
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

    }

    @When("User enters {string} and {string} with credentials and clicks Sign in button")
    public void user_enters_and_with_credentials_and_clicks_sign_in_button(String username, String password) {
        us08PasswordEditPage.userNameTextBox.sendKeys(username);
        us08PasswordEditPage.passwordTextBox.sendKeys(password);
        us08PasswordEditPage.secondSignInButton.click();

    }
    @When("User navigates to username button and clicks")
    public void user_navigates_to_username_button_and_clicks() {
        Driver.waitAndClick(us08PasswordEditPage.userNameLoginPage);

    }
    @When("User clicks on Password and verifies password  for[user] page is displayed")
    public void user_clicks_on_password_and_verifies_password_for_user_page_is_displayed() {
        Driver.waitAndClick(us08PasswordEditPage.passwordButtonLoginPage);

    }
    @When("User enters the current {string}")
    public void user_enters_the_current(String password) {
        Driver.waitAndSendText(us08PasswordEditPage.currentPassword,password,5);

    }
    @When("User enters the {string}")
    public void user_enters_the(String newpassword) {
        Driver.waitAndSendText(us08PasswordEditPage.newPassword,newpassword,5);

    }



}
