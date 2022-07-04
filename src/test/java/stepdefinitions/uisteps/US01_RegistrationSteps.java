package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.RegistrationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US01_RegistrationSteps {


    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();




    @When("user navigate to registration page")
    public void user_navigate_to_registration_page() throws InterruptedException {
        homePage.accountMenuDropdown.click();
        Thread.sleep(2000);
        homePage.accountRegisterDropdownSelect.click();


    }

    @Then("user Verify that Registration page is displayed")
    public void user_verify_that_registration_page_is_displayed() {
        Assert.assertTrue(registrationPage.registrationTitle.isDisplayed());
    }

    @When("User enters {string}")
    public void user_enters(String validSNN) {
        registrationPage.ssnTextbox.sendKeys(validSNN + Keys.ENTER);
    }

    @Then("User shouldn't see Your SSN is invalid, error message")
    public void user_shouldn_t_see_your_ssn_is_invalid_error_message() {
        Assert.assertFalse(registrationPage.ssnInvalidErrorMessage.isDisplayed());

    }
    @Then("User shouldn't see Your SSN is required. , error message")
    public void user_shouldn_t_see_your_ssn_is_required_error_message() {
        Assert.assertFalse(registrationPage.ssnRequiredErrorMessage.isDisplayed());
    }
    @Then("close the application")
    public void close_the_application() {
        Driver.closeDriver();
    }

}
