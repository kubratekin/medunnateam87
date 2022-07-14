package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US07_AppointmentPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class US07_AppointmentUIStepDef {

    US07_AppointmentPage appointmentPage = new US07_AppointmentPage();

    @Given("user navigate to medunna page")
    public void user_navigate_to_medunna_page() {

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @Given("user click on Make An Appointment")
    public void user_click_on_make_an_appointment() {
        appointmentPage.makeAnAppointment.click();
    }
    @Then("verify {string} header created on the page")
    public void verify_header_created_on_the_page(String string) {
        Assert.assertTrue(appointmentPage.makeAnAppointmentTitle.isDisplayed());
    }
    @Then("user send firstName ,lastName ,ssn ,phone ,email,as {string},{string},{string},{string},{string}")
    public void user_send_first_name_last_name_ssn_phone_email_as(String firstName, String lastName, String ssn, String phone, String email) {
        appointmentPage.firstName.sendKeys(firstName);
        appointmentPage.lastName.sendKeys(lastName);
        appointmentPage.ssn.sendKeys(ssn);
        appointmentPage.phone.sendKeys(phone);
        appointmentPage.email.sendKeys(email);
    }
    @Then("user can select current date")
    public void user_can_select_current_date() {
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter frmCurrentDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String strCurrentDate = currentDate.format(frmCurrentDate);
        System.out.println(strCurrentDate);
        appointmentPage.appointmentDate.sendKeys(strCurrentDate);
        //System.out.println(LocalDate.now());
    }
    @Then("verify created the Appointment registration saved! We will call you as soon as possible alert message is visible")
    public void verify_created_the_appointment_registration_saved_we_will_call_you_as_soon_as_possible_alert_message_is_visible() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue(appointmentPage.alertMessage.isDisplayed());
    }
    @Then("close this application")
    public void close_this_application() {
        Driver.closeDriver();
    }
    @Then("user can select future date")
    public void user_can_select_future_date() {
        LocalDate futureDate =LocalDate.now().plusMonths(2);
        DateTimeFormatter frmCurrentDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String strFutureDate = futureDate.format(frmCurrentDate);
        appointmentPage.appointmentDate.sendKeys(strFutureDate);
        System.out.println(strFutureDate);
    }
    @Then("user click Send an Appointment Request")
    public void user_click_send_an_appointment_request() {
        Driver.waitAndClick(appointmentPage.sendAnAppointmentRequest);
    }
    @Then("user can select past date")
    public void user_can_select_past_date() {
        LocalDate pastDate =LocalDate.now().minusMonths(2);
        DateTimeFormatter frmPastDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String strPastDate = pastDate.format(frmPastDate);
        appointmentPage.appointmentDate.sendKeys(strPastDate);
        System.out.println(strPastDate);
    }
    @Then("verify created the message Appointment date can not be past date! is visible")
    public void verify_created_the_message_appointment_date_can_not_be_past_date_is_visible() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(appointmentPage.pastDateWarning.isDisplayed());
    }
}
