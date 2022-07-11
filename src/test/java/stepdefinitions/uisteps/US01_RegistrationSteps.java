package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.SettingsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US01_RegistrationSteps {

    Faker faker= new Faker();
    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();
    SettingsPage settingsPage = new SettingsPage();
//Background
    @Given("user goes to Medunna page")
    public void user_goes_to_medunna_page() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }


    @When("user navigate to registration page")
    public void user_navigate_to_registration_page() throws InterruptedException {
        homePage.accountMenuDropdown.click();
        Thread.sleep(2000);
        homePage.accountRegisterDropdownSelect.click();

    }

    @Then("user Verify that Registration page is displayed")
    public void user_verify_that_registration_page_is_displayed() throws InterruptedException {
        Assert.assertTrue(registrationPage.registrationTitle.isDisplayed());
    }

    //TC01
    @When("User enters {string}")
    public void user_enters(String validSSN) {
        registrationPage.ssnTextbox.sendKeys(validSSN+Keys.TAB);

    }
    @When("User shouldn't see error message Your SSN is invalid and Your SSN is required.")
    public void user_shouldn_t_see_error_message_your_ssn_is_invalid_and_your_ssn_is_required() {
        Assert.assertTrue(registrationPage.verifyValidSSN.isDisplayed());
    }
//

  /*  @When("User enters ValidSSN")
    public void user_enters_valid_ssn() {
        registrationPage.ssnTextbox.sendKeys(faker.idNumber().valid());
    }


    @Then("User verify ssn is valid")
    public void user_verify_ssn_is_valid() {
        registrationPage.firstnameTextbox.sendKeys(faker.name().firstName());
        registrationPage.lastnameTextbox.sendKeys(faker.name().lastName());
        registrationPage.usernameTextbox.sendKeys(faker.name().username());
        registrationPage.emailTextbox.sendKeys(faker.internet().emailAddress());
        String password= faker.internet().password(4,8);
        registrationPage.firstPasswordTextbox.sendKeys(password);
        registrationPage.newPasswordTextbox.sendKeys(password+ Keys.ENTER);
        Assert.assertTrue(registrationPage.registrationSavedAlert.isDisplayed());
    }
*/
   //TC02
    @When("User enters an {string} with sign after 3rd and 5th digits")
    public void user_enters_an_with_sign_after_3rd_and_5th_digits(String invalidSSN) {
        registrationPage.ssnTextbox.sendKeys(invalidSSN+ Keys.ENTER);
    }
    @Then("User should see Your SSN is invalid error message")
    public void user_should_see_your_ssn_is_invalid_error_message() throws InterruptedException {
       Assert.assertTrue(registrationPage.ssnInvalidErrorMessage.isDisplayed());
        // Assert.assertEquals("Your SSN is invalid",registrationPage.ssnInvalidErrorMessage.getText());
    }

    //TC03
    @When("User enters {string} not {int} digits long")
    public void user_enters_not_digits_long(String invalidSSN2, Integer int1) {
        registrationPage.ssnTextbox.sendKeys(invalidSSN2+ Keys.ENTER);
    }
    //TC04
    @When("User enters {string} containing characters or letters")
    public void user_enters_containing_characters_or_letters(String invalidSSN3) {
        registrationPage.ssnTextbox.sendKeys(invalidSSN3+ Keys.ENTER);
    }
    //TC05
    @When("SSN is {string} if all block before or after contains {int} or starts {int} ,{int}")
    public void ssn_is_if_all_block_before_or_after_contains_or_starts(String invalidSSN4, Integer int1, Integer int2, Integer int3) {
        registrationPage.ssnTextbox.sendKeys(invalidSSN4+ Keys.ENTER);
    }
    //TC06
    @When("User enters  blankSSN")
    public void user_enters_blank_ssn() {
       registrationPage.ssnTextbox.sendKeys( Keys.SPACE);
       registrationPage.firstnameTextbox.click();
    }
    @Then("User should see error message Your SSN is required.")
    public void user_should_see_error_message_your_ssn_is_required() {
        Assert.assertTrue(registrationPage.ssnRequiredErrorMessage.isDisplayed());

    }

    //TC07
    @When("User enters valid FirstName {string}")
    public void user_enters_valid_first_name(String validFirstame) {
        registrationPage.firstnameTextbox.sendKeys(validFirstame+Keys.TAB);
    }
    @Then("User shouldn't see error message Your FirstName is required.")
    public void user_shouldn_t_see_error_message_your_first_name_is_required() {
        Assert.assertTrue(registrationPage.verifyValidFirstname.isDisplayed());
    }

    //TC08
    @When("User enters  blankfirstname")
    public void user_enters_blankfirstname() {
       registrationPage.firstnameTextbox.sendKeys(Keys.SPACE);
       registrationPage.lastnameTextbox.click();
    }
    @Then("User should see error message Your FirstName is required.")
    public void user_should_see_error_message_your_first_name_is_required() {
       Assert.assertTrue(registrationPage.firstnameRequiredErrorMessage.isDisplayed());
    }

    //TC09
    @When("User enters valid Lastname {string}")
    public void user_enters_valid_lastname(String validLastname) {
       registrationPage.lastnameTextbox.sendKeys(validLastname+Keys.TAB);
    }
    @Then("User shouldn't see error message Your LastName is required.")
    public void user_shouldn_t_see_error_message_your_last_name_is_required() {
      Assert.assertTrue(registrationPage.verifyValidLastname.isDisplayed());
    }

    //TC10
    @When("User enters  blanklastname")
    public void user_enters_blanklastname() {
     registrationPage.lastnameTextbox.sendKeys(Keys.SPACE);
     registrationPage.usernameTextbox.click();
    }
    @Then("User should see error message Your LastName is required.")
    public void user_should_see_error_message_your_last_name_is_required() {
      Assert.assertTrue(registrationPage.lastnameRequiredErrorMessage.isDisplayed());
    }



}
