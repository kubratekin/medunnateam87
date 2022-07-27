package stepdefinitions.uisteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AppointmentPage;
import pages.LoginPage;
import pages.US07_AppointmentPage;
import utilities.Driver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US25_StepDefs {
    LoginPage loginPage =new LoginPage();
    AppointmentPage appointmentPage=new AppointmentPage();
    US07_AppointmentPage appointmentPageUS7 = new US07_AppointmentPage();
    String choosenFutureDate;
    LocalDate dateformatFutureDate;
    DateTimeFormatter frmCurrentDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @When("user enters {string} and {string} clicks sign in")
    public void user_enters_and_clicks_sign_in(String username, String password) {
        Driver.waitAndSendText(loginPage.username, username);
        Driver.waitAndSendText(loginPage.password, password);
        loginPage.loginButton.click();

    }
    @When("user clicks to Make an appointment button under My Pages menu")
    public void user_clicks_to_make_an_appointment_button_under_my_pages_menu() throws InterruptedException {
        Thread.sleep(1000);
        appointmentPage.myPagesButton.click();
        Driver.waitAndClick(appointmentPage.makeanAppointmentButton);

    }

    @Then("user selects future date")
    public void user_can_select_future_date() {
        LocalDate futureDate = LocalDate.now().plusMonths(2);
        dateformatFutureDate=futureDate;

        choosenFutureDate = futureDate.format(frmCurrentDate);
        appointmentPageUS7.appointmentDate.sendKeys(choosenFutureDate);
        System.out.println(choosenFutureDate);

    }


    @Then("verify Make an Appointment page is displayed on user portal")
    public void verify_make_an_appointment_page_is_displayed_on_user_portal() {
        Driver.wait(1);
        Assert.assertTrue(appointmentPage.makeappointmentTitleinPortal.isDisplayed());


    }
    @Then("verify that firstname, lastname, SSN and email of the user being populated")
    public void verify_that_firstname_lastname_ssn_and_email_of_the_user_being_populated() {

        Assert.assertFalse(appointmentPage.firstname.getAttribute("value").equals(""));
        Assert.assertFalse(appointmentPage.lastname.getAttribute("value").equals(""));
        Assert.assertFalse(appointmentPage.ssn.getAttribute("value").equals(""));
        Assert.assertFalse(appointmentPage.email.getAttribute("value").equals(""));

    }


    @Then("verify that the created Appointment is displayed")
    public void verifyThatTheCreatedAppointmentIsDisplayed() {
        Driver.wait(1);
        Assert.assertTrue(appointmentPage.appointmentsTitle.isDisplayed());
        appointmentPage.fromDate.sendKeys(dateformatFutureDate.minusDays(3).format(frmCurrentDate));
        appointmentPage.toDate.sendKeys(choosenFutureDate);
        Driver.wait(1);
        System.out.println(appointmentPage.startDateTime.getText());

        Driver.wait(1);
        DateTimeFormatter tabledateformat = DateTimeFormatter.ofPattern("dd/MM/yy");
        String totableformat= dateformatFutureDate.format(tabledateformat)+ " 02:00";
        Assert.assertTrue(totableformat.equals(appointmentPage.startDateTime.getText()));


    }
}
