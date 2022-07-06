package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.ConfigReader;
import utilities.Driver;

public class US_002_Stepdefs {
    @Given("user goes to webpage")
    public void user_goes_to_webpage() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @When("user navigates to registration page")
    public void user_navigates_to_registration_page() {


    }
    @When("user verifies Registration is displayed")
    public void user_verifies_registration_is_displayed() {

    }
    @When("user provides ssn id as {string}")
    public void user_provides_ssn_id_as(String user) {

    }
    @When("user provides firstname as {string}")
    public void user_provides_firstname_as(String firstname) {

    }
    @When("user provides lastname as {string}")
    public void user_provides_lastname_as(String lastname) {

    }
    @When("user provides username as {string}")
    public void user_provides_username_as(String username) {

    }
    @When("user provides email as {string}")
    public void user_provides_email_as(String email) {

    }
    @When("user types password as {string}")
    public void user_types_password_as(String password) {

    }
    @When("user types password confirmation as {string}")
    public void user_types_password_confirmation_as(String passwordConfirm) {

    }
    @When("user clicks on Register button")
    public void user_clicks_on_register_button() {

    }
    @Then("user should see Registration saved message")
    public void user_should_see_registration_saved_message() {

    }
    @Then("user closes the browser")
    public void user_closes_the_browser() {

    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String arg0) {
    }

    @And("user provides the invalid email as {string}")
    public void userProvidesTheInvalidEmailAs(String arg0) {
        
    }

    @And("user clicks on new password field")
    public void userClicksOnNewPasswordField() {
    }
}
