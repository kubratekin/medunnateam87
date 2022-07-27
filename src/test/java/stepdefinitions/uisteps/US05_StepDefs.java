package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import pojos.Appointment;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

import static utilities.TXTWriter.saveUIAppointmentData;
import static utilities.TXTWriter.saveUIRegistrantData;

public class US05_StepDefs {

    HomePage homePage = new HomePage();
    HomePageMedunna homePageMedunna=new HomePageMedunna();
    RegistrationPage registrationPage=new RegistrationPage();
    AppointmentPage appointmentPage= new AppointmentPage();
    LoginPage loginPage=new LoginPage();
    Actions actions = new Actions(Driver.getDriver());
    WebDriver driver;

    Faker faker  = new Faker();
    Appointment appointment=new Appointment();
    Registrant registrant=new Registrant();

    @Given("user goes to Medunna webpage")
    public void user_goes_to_medunna_webpage() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

    }

    @When("user clicks to Make an Appointment")
    public void user_clicks_to_make_an_appointment() {
        homePage.makeAnAppointmentButton.click();

    }


    @Then("verify make an appointment button is displayed")
    public void verify_make_an_appointment_button_is_displayed() {
        Assert.assertTrue(homePage.makeAnAppointmentButton.isDisplayed());
    }



    @Then("verify Make an Appointment page is displayed")
    public void verify_make_an_appointment_page_is_displayed() throws InterruptedException {


        String expectedUrl = "https://www.medunna.com/#appointment";
        // Process ReusableMethods;
        // ReusableMethods.waitFor(2);
        Thread.sleep(2000);
        String actualUrl = Driver.getDriver().getCurrentUrl();
        System.out.println("Actual URL: " + actualUrl);
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @When("user enters first name {string}")
    public void user_enters_first_name(String firstname) throws InterruptedException {


        if(firstname.equals("-1")){
            firstname=faker.name().firstName();
        }

        appointmentPage.firstname.sendKeys(firstname + Keys.ENTER);
        appointment.setFirstName(firstname);
    }


//    @Then("user gets no invalid error message")
//    public void user_gets_no_first_name_error_message() {
//        //System.out.println(appointmentPage.firstnameRequired.getText());
//        //Assert.assertFalse(appointmentPage.firstnameRequired.getText().isEmpty());
//
//     //   Assert.assertFalse(appointmentPage.firstnameRequired.isDisplayed());
//
//        Assert.assertTrue(appointmentPage.verifyValid.isDisplayed());
//
//    }

    @Then("user does not get invalid error message")
    public void user_does_not_get_invalid_error_message() {
        Assert.assertTrue(appointmentPage.verifyValid.isDisplayed());
    }


    @Then("user gets first name error message")
    public void user_gets_first_name_error_message() {
        Assert.assertTrue(appointmentPage.firstnameRequired.isDisplayed());

    }



    /*
    @Then("user verifies if navigated to the APPOINTMENT page")
public void user_verifies_if_navigated_to_the_appointment_page() {
    String expectedUrl = "https://www.medunna.com/#appointment";
    ReusableMethods.waitFor(2);
    String actualUrl = Driver.getDriver().getCurrentUrl();
    System.out.println("Actual URL: " + actualUrl);
    Assert.assertEquals(expectedUrl,actualUrl);

}
     */



    @When("user provides the {string} SSN")
    public void user_provides_the_ssn(String SSN) {
        if(SSN.equals("-1")){
            SSN=faker.idNumber().ssnValid();
        }
        appointmentPage.ssn.sendKeys(SSN+ Keys.ENTER);
        appointment.setSsn(SSN);
    }


    @Then("user gets Your SSN is invalid error message")
    public void user_gets_your_ssn_is_invalid_error_message() {
        Assert.assertTrue(appointmentPage.SSNinvalid.isDisplayed());

    }
    @Then("user gets Your SSN is required error message")
    public void user_gets_your_ssn_is_required_error_message() {
        Assert.assertTrue(appointmentPage.SSNRequired.isDisplayed());
    }

    @When("user provides the {string} lastname")
    public void user_provides_the_lastname(String lastName) {

        if(lastName.equals("-1")){
            lastName=faker.name().lastName();
        }

        appointmentPage.lastname.sendKeys(lastName + Keys.ENTER);
        appointment.setLastName(lastName);


    }
    @Then("user gets Your LastName is required error message")
    public void user_gets_your_last_name_is_required_error_message() {
        Assert.assertTrue(appointmentPage.lastnameRequired.isDisplayed());
    }



    @When("user provides the {string} phone number")
    public void user_provides_the_phone_number(String phone) {

        if(phone.equals("-1")){
            phone=faker.number().digits(10);
        }

        appointmentPage.phone.sendKeys(phone+Keys.ENTER);
        appointment.setPhone(phone);
    }


    @Then("user gets Phone number is invalid error message")
    public void user_gets_phone_number_is_invalid_error_message() {
        Driver.wait(1);
        Assert.assertTrue(appointmentPage.phoneInvalid.isDisplayed());
    }

    @Then("user gets Phone number is required error message")
    public void userGetsPhoneNumberIsRequiredErrorMessage() {
        Assert.assertTrue(appointmentPage.phoneRequired.isDisplayed());
    }

    @When("user provides the {string} Email")
    public void user_provides_the_email(String email) {
        if(email.equals("-1")){
            email=appointment.getFirstName()+"55@gma.com";
        }
        appointmentPage.email.sendKeys(email+Keys.ENTER);
        appointment.setEmail(email);

    }
    @When("user clicks Send an Appointment Request")
    public void user_clicks_send_an_appointment_request() {
        appointmentPage.sendAppointmentButton.click();

    }
    @Then("verify Appointment registration saved! We will call you as soon as possible. is displayed")
    public void verify_appointment_registration_saved_we_will_call_you_as_soon_as_possible_is_displayed() throws InterruptedException {

        Thread.sleep(3000);
        Assert.assertTrue(appointmentPage.successMessageToastContainer.isDisplayed());
        saveUIAppointmentData(appointment);
    }


//    @When("user navigates to registration page")
//    public void user_navigates_to_registration_page() {
//        homePageMedunna.logInDropdown.click();
//        homePageMedunna.registerButton.click();
//
//
//    }
    @Then("provide <valid> info for Registiration")
    public void provide_valid_info_for_registiration() {
        registrationPage.ssnTextbox.sendKeys(appointment.getSsn()+Keys.ENTER);
        registrationPage.firstnameTextbox.sendKeys(appointment.getFirstName()+Keys.ENTER);
        registrationPage.lastnameTextbox.sendKeys(appointment.getLastName()+Keys.ENTER);

        registrant.setLogin(appointment.getFirstName()+"_"+appointment.getLastName());
        registrationPage.usernameTextbox.sendKeys(registrant.getLogin());

        // burda e maili degistirmek zorunda kaldık
        registrationPage.emailTextbox.sendKeys(appointment.getEmail()+"om");

        registrant.setPassword("1234");

        registrationPage.firstPasswordTextbox.sendKeys(registrant.getPassword());
        registrationPage.newPasswordTextbox.sendKeys(registrant.getPassword());

    }
    @Then("click Register")
    public void click_register() {
        registrationPage.registerButton.click();

    }
    @Then("verify {string} is displayed")
    public void verify_is_displayed(String string) throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(registrationPage.successMessageToastContainer.isDisplayed());
        saveUIRegistrantData(registrant);

    }


    @When("navigate to Sign in page")
    public void navigate_to_sign_in_page() {
        homePageMedunna.logInDropdown.click();
        homePage.signInButton.click();
    }
    @When("provide username and password and sign in")
    public void provide_username_and_password_and_sign_in() {
        loginPage.username.sendKeys(registrant.getLogin());
        loginPage.password.sendKeys(registrant.getPassword());
        loginPage.loginButton.click();
    }
    @When("navigate to My Appointments")
    public void navigate_to_my_appointments() throws InterruptedException {
        Thread.sleep(1000);
        appointmentPage.myPagesButton.click();
        Thread.sleep(1000);
        appointmentPage.myAppointmentsButton.click();

    }
    @When("verify Appointments is displayed")
    public void verify_appointments_is_displayed() {
        Assert.assertTrue(appointmentPage.appointmentsTitle.isDisplayed());

    }




    //@And("close the application")
   // public void close_the_application() {
   //     Driver.closeDriver();
   // }



}

