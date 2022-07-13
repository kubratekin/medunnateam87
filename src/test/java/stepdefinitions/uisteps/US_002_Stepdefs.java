package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePageMedunna;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US_002_Stepdefs {

    HomePageMedunna homePageMedunna = new HomePageMedunna();
    RegistrationPage registrationPage = new RegistrationPage();

    @Given("user goes to webpage")
    public void user_goes_to_webpage() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @When("user navigates to registration page")
    public void user_navigates_to_registration_page() {
      homePageMedunna.logInDropdown.click();
      homePageMedunna.registerButton.click();


    }
    @When("user verifies Registration is displayed")
    public void user_verifies_registration_is_displayed() {
        Assert.assertTrue(registrationPage.registrationTitle.isDisplayed());

    }
    @When("user provides ssn id as {string}")
    public void user_provides_ssn_id_as(String user) {
        registrationPage.ssnTextbox.sendKeys(user);

    }
    @When("user provides firstname as {string}")
    public void user_provides_firstname_as(String firstname) {
        registrationPage.firstnameTextbox.sendKeys(firstname);

    }
    @When("user provides lastname as {string}")
    public void user_provides_lastname_as(String lastname) {
        registrationPage.lastnameTextbox.sendKeys(lastname);

    }
    @When("user provides username as {string}")
    public void user_provides_username_as(String username) {
        registrationPage.usernameTextbox.sendKeys(username);

    }
    @When("user provides email as {string}")
    public void user_provides_email_as(String email) {
        registrationPage.emailTextbox.sendKeys(email + Keys.TAB);

    }
    @When("user types password as {string}")
    public void user_types_password_as(String password) {
        registrationPage.firstPasswordTextbox.sendKeys(password);

    }
    @When("user types password confirmation as {string}")
    public void user_types_password_confirmation_as(String passwordConfirm) {
        registrationPage.newPasswordTextbox.sendKeys(passwordConfirm);

    }
    @When("user clicks on Register button")
    public void user_clicks_on_register_button() {
        registrationPage.registerButton.submit();

    }
    @Then("user should see Registration saved message")
    public void user_should_see_registration_saved_message() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Registration Saved']")));
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());

    }
    @Then("user closes the browser")
    public void user_closes_the_browser() {
        Driver.closeDriver();

    }

    @Then("user should see {string} message")
    public void userShouldSeeMessage(String errorMessage) {
    switch (errorMessage) {

        case "Your email is required to be at least 5 characters." :
            Assert.assertTrue(registrationPage.emailAtLeast5CharactersMessage.isDisplayed());
            break;
        case "This field is invalid" :
            Assert.assertTrue(registrationPage.thisFieldIsInvalid.isDisplayed());
            break;
    }
    }

    @And("user provides the invalid email as {string}")
    public void userProvidesTheInvalidEmailAs(String arg0) {
        registrationPage.emailTextbox.sendKeys(arg0 + Keys.ENTER);
    }






}
