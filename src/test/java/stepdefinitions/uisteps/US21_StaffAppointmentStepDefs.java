package stepdefinitions.uisteps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class US21_StaffAppointmentStepDefs {

    static String errorMessage;
    HomePageMedunna homePage = new HomePageMedunna();
    SignInPageMedunna signInPage = new SignInPageMedunna();
    AdminPageMedunna adminPage = new AdminPageMedunna();
    PatientViewByAdminAndStaffPageMedunna viewByAdminAndStaffPage = new PatientViewByAdminAndStaffPageMedunna();
    StaffPageMedunna staffPage = new StaffPageMedunna();
    PatientDetailPage detailPage = new PatientDetailPage();
    CreateOrEditPatientPage createOrEdit = new CreateOrEditPatientPage();
    UserManagementPage userManagement = new UserManagementPage();
    PatientAppointmentPage patientAppointment = new PatientAppointmentPage();
    CreateOrEditAppointmentPage editAppointment = new CreateOrEditAppointmentPage();
    PatientsPage patients = new PatientsPage();
    PatientTestsPage patientTest = new PatientTestsPage();

    @Given("user goes to Medunna URL")
    public void userGoesToMedunnaURL() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        Driver.waitAndClick(homePage.logInDropdown,2);
        Driver.waitAndClick(homePage.signInButton,2);
        Driver.waitAndSendText(signInPage.usernameBox,"team87-1");
        Driver.waitAndSendText(signInPage.passwordBox,"1234");
        Driver.waitAndClick(signInPage.signInButton,2);
        Driver.waitAndClick(patients.myPagesDropdown,2);
        Driver.waitAndClick(patients.makeAnAppointmentButton,2);
        Driver.waitAndSendText(patients.phoneTextBox,"123-456-7890");
        Driver.waitAndClick(patients.sendAppointmentRequest,2);
        Driver.waitAndClick(patients.userMenuDropdown,2);
        Driver.waitAndClick(patients.signOutButton,2);
    }


    @When("User enters patient SSN {string} in the search box")
    public void user_enters_patient_ssn_in_the_search_box(String ssn) {
        Driver.waitAndSendText(viewByAdminAndStaffPage.ssnSearchBox,ssn,5);
        Driver.wait(3);
    }
    @When("User clicks Show Appointments")
    public void user_clicks_show_appointments() throws InterruptedException {
        Thread.sleep(2000);
        Driver.waitAndClick(viewByAdminAndStaffPage.showAppointmentButton,2);
    }
    @When("User clicks edit and changes status to PENDING")
    public void userClicksEditAndChangesStatusToPENDING() {
        Driver.waitAndClick(patientAppointment.editButton,2);
        Driver.wait(2);
        Driver.selectByVisibleText(editAppointment.appointmentStatusDropdown,"PENDING");
        Driver.waitAndClick(editAppointment.saveButton,2);
    }


    @Then("User verifies that {string} message is shown after clicks save button")
    public void userVerifiesThatMessageIsShownAfterClicksSaveButton(String message) {
        Driver.wait(3);
        Assert.assertTrue(editAppointment.updatedSuccessMessage.getText().contains(message));
    }
    @When("User clicks edit and changes status to UNAPPROVED")
    public void userClicksEditAndChangesStatusToUNAPPROVED() {
        Driver.waitAndClick(patientAppointment.editButton,2);
        Driver.wait(2);
        Driver.selectByVisibleText(editAppointment.appointmentStatusDropdown,"UNAPPROVED");
        Driver.waitAndClick(editAppointment.saveButton,2);
    }

    @When("User clicks edit and changes status to CANCELLED")
    public void userClicksEditAndChangesStatusToCANCELLED() {
        Driver.waitAndClick(patientAppointment.editButton,2);
        Driver.wait(2);
        Driver.selectByVisibleText(editAppointment.appointmentStatusDropdown,"CANCELLED");
        Driver.waitAndClick(editAppointment.saveButton,2);
    }

    @When("User clicks edit and changes status to COMPLETED")
    public void userClicksEditAndChangesStatusToCOMPLETED() {
        //ReusableMethods.makeAnAppointment("team87-1","1234");
        Driver.waitAndClick(patientAppointment.editButton,2);
        Driver.wait(2);
        try {
            Select select = new Select(editAppointment.appointmentStatusDropdown);
            select.selectByIndex(4);
        }catch (Exception e){
            e.printStackTrace();
            errorMessage = e.getMessage();
        }
        errorMessage=errorMessage.substring(0,34);
        Driver.waitAndClick(editAppointment.saveButton,2);
    }

    @Then("User verifies that COMPLETED cannot be selected")
    public void userVerifiesThatCOMPLETEDCannotBeSelected() {
        Assert.assertEquals("Cannot locate option with index: 4", errorMessage);
    }

    @When("User clicks edit and selects the appropriate doctor {string} for the patient")
    public void userClicksEditAndSelectsTheAppropriateDoctorForThePatient(String doctor) throws InterruptedException {
        Driver.waitAndClick(patientAppointment.editButton,2);
        Driver.wait(2);
        LocalDateTime myDateObj = LocalDateTime.now().plusDays(1);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String startDateTime = myDateObj.format(myFormatObj);
        String startDate = startDateTime.substring(0,11);
        String startTime = startDateTime.substring(12);
        System.out.println(startDate);
        System.out.println(startTime);
        LocalDateTime endDateObj = LocalDateTime.now().plusDays(1).plusMinutes(2);
        DateTimeFormatter endFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String endDateTime = endDateObj.format(endFormatObj);
        String endDate = endDateTime.substring(0,11);
        String endTime = endDateTime.substring(12);
        System.out.println(endDate);
        System.out.println(endTime);
        Driver.wait(1);
        Driver.waitAndSendText(editAppointment.startDateBox,startDate + Keys.ARROW_RIGHT + startTime,2);
        Thread.sleep(2000);
        Driver.waitAndSendText(editAppointment.endDateBox,endDate + Keys.ARROW_RIGHT + endTime,2);
        Thread.sleep(3000);
        Driver.selectByVisibleText(editAppointment.physicianDropdown,"102975:team87doctor002 team87doctor002:ALLERGY_IMMUNOLOGY");
        Driver.waitAndClick(editAppointment.saveButton,2);
    }

    @Then("User clicks save button and verifies that successfully saved message.")
    public void userClicksSaveButtonAndVerifiesThatSuccessfullySavedMessage() {
        Driver.wait(3);
        String savedMessage = viewByAdminAndStaffPage.appointmentSavedMessage.getText();
        Assert.assertTrue(savedMessage.contains("The Appointment is updated with identifier "));
    }

    @When("User clicks edit and leaves the anamnesis, treatment and diagnosis boxes blank")
    public void userClicksEditAndLeavesTheAnamnesisTreatmentAndDiagnosisBoxesBlank() {
        Driver.waitAndClick(patientAppointment.editButton,2);
        Driver.waitAndSendText(editAppointment.anamnesisTextBox,"test-team87",2);
        Driver.wait(1);
        editAppointment.anamnesisTextBox.clear();
        Driver.waitAndSendText(editAppointment.treatmentTextBox,"test-team87",2);
        Driver.wait(1);
        editAppointment.treatmentTextBox.clear();
        Driver.waitAndSendText(editAppointment.diagnosisTextBox,"test-team87",2);
        Driver.wait(1);
        editAppointment.diagnosisTextBox.clear();
        Driver.waitAndClick(editAppointment.saveButton,2);
    }

    @When("User clicks Show tests button")
    public void userClicksShowTestsButton() {
        Driver.waitAndClick(patientAppointment.showTestsButton,2);
    }

    @Then("User verifies that can see {string} text if the doctor has not requested the test for the patient")
    public void userVerifiesThatCanSeeTextIfTheDoctorHasNotRequestedTheTestForThePatient(String noTestMessage) {
        String actualText = patientTest.noTestsText.getText();
        Assert.assertEquals(noTestMessage,actualText);
        Driver.wait(1);
        Driver.waitAndClick(patients.userMenuDropdown,2);
        Driver.waitAndClick(patients.signOutButton,2);
        Driver.waitAndClick(homePage.logInDropdown,2);
        Driver.waitAndClick(homePage.signInButton,2);
        Driver.waitAndSendText(signInPage.usernameBox,"team87_admin");
        Driver.waitAndSendText(signInPage.passwordBox,"1234567");
        Driver.waitAndClick(signInPage.signInButton,2);
        Driver.waitAndClick(adminPage.itemsAndTitlesDropdown,2);
        Driver.wait(1);
        Driver.waitAndClick(adminPage.appointmentAdmin,2);
        Driver.wait(2);
        Driver.waitAndClick(adminPage.lastPageButton,2);
        Driver.wait(2);
        Driver.waitAndClick(adminPage.deleteButton,2);
        Driver.wait(1);
        Driver.waitAndClick(userManagement.confirmDeleteButton,2);
    }

    @And("User clicks View Results button if the doctor has requested the test for the patient")
    public void userClicksViewResultsButtonIfTheDoctorHasRequestedTheTestForThePatient() {
        Driver.waitAndClick(patientTest.viewResultsButton);

    }

    @Then("User verifies that can see the test results if the doctor has requested the test for the patient and the requested test has been completed")
    public void userVerifiesThatCanSeeTheTestResultsIfTheDoctorHasRequestedTheTestForThePatientAndTheRequestedTestHasBeenCompleted() {
        Driver.wait(1);
        List<WebElement> resultsList = patientTest.testResultsList;
        Assert.assertFalse(resultsList.isEmpty());
    }


}
