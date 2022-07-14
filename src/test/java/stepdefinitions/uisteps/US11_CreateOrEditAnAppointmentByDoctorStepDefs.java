package stepdefinitions.uisteps;

import freemarker.template.Configuration;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.DoctorPage;
import utilities.ConfigReader;
import utilities.Driver;


public class US11_CreateOrEditAnAppointmentByDoctorStepDefs {

    DoctorPage doctorPage = new DoctorPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @When("user clicks on login dropdown icon")
    public void userClicksOnLoginDropdownIcon() {

        Driver.waitAndClick(doctorPage.loginDropdown);
    }

    @And("user clicks on sign in dropdown")
    public void userClicksOnSignInDropdown() {
        Driver.waitAndClick(doctorPage.signInDropdown);
    }

    @And("user sends username {string}")
    public void userSendsUsername(String arg0) {
        Driver.waitAndSendText(doctorPage.usernameBox, ConfigReader.getProperty("doctor_username"));
    }

    @And("user sends password {string}")
    public void userSendsPassword(String arg0) {
        Driver.waitAndSendText(doctorPage.passwordBox, ConfigReader.getProperty("doctor_password"));
    }

    @Then("user clicks on the sign in dropdown")
    public void userClicksOnTheSignInDropdown() {
        Driver.waitAndClick(doctorPage.sigInButton);
    }

    @Then("user verifies the login is successful")
    public void verifyTheLoginIsSuccessful() {

        Assert.assertEquals("team87doctor team87doctor", doctorPage.doctorUsername.getText().toString());
    }

    @And("Doctor navigates to My Pages Dropdown")
    public void doctorNavigatesToMyPagesDropdown() {
        Driver.waitAndClick(doctorPage.myPagesDropdown,2);
    }

    @And("Doctor clicks on My Appointments Button")
    public void doctorClicksOnMyAppointmentsButton() {

        Driver.waitAndClick(doctorPage.myAppointments,2);
    }

    @And("Doctor selects Appointment date from and to boxes")
    public void doctorSelectsAppointmentDateFromAndToBoxes() {
        Driver.waitAndSendText(doctorPage.fromDate, "06.29.2022");
        Driver.waitAndSendText(doctorPage.toDate, "07.10.2022");
        Driver.wait(1);
    }

    @And("Doctor clicks on Edit Button")
    public void doctorClicksOnEditButton() {
        Driver.waitAndClick(doctorPage.editButton);
    }

    @Given("Doctor verifies patient's info id, start and end date, status, physician are visible")
    public void doctorVerifiesPatientSInfoIdStartAndEndDateStatusPhysicianAreVisible() {
        Assert.assertTrue(doctorPage.idField.isDisplayed());
        Assert.assertTrue(doctorPage.startDateTime.isDisplayed());
        Assert.assertTrue(doctorPage.endDateTime.isDisplayed());
        Assert.assertTrue(doctorPage.statusDropDown.isDisplayed());
        Assert.assertTrue(doctorPage.physicianField.isDisplayed());
    }

    @And("Doctor should fills in required fields, anemnesis, treatment, diagnosis which as required fields")
    public void doctorShouldFillsInRequiredFieldsAnemnesisTreatmentDiagnosisWhichAsRequiredFields() {
        Driver.waitAndClick(doctorPage.anamnesisField);
        doctorPage.anamnesisField.clear();
        Driver.waitAndSendText(doctorPage.anamnesisField, "Test",2);
        Driver.waitAndClick(doctorPage.treatmentField);
        doctorPage.treatmentField.clear();
        Driver.waitAndSendText(doctorPage.treatmentField, "Test",2);
        Driver.waitAndClick(doctorPage.diagnosisField);
        doctorPage.diagnosisField.clear();
        Driver.waitAndSendText(doctorPage.diagnosisField, "Test",2);

    }

    @And("Doctor should fills in optional fields precription and description Which as optional fields")
    public void doctorShouldFillsInOptionalFieldsPrecriptionAndDescriptionWhichAsOptionalFields() {
        Driver.waitAndClick(doctorPage.prescriptionField);
        doctorPage.prescriptionField.clear();
        Driver.waitAndSendText(doctorPage.prescriptionField, "Test", 2);
        Driver.waitAndClick(doctorPage.descriptionField);
        doctorPage.descriptionField.clear();
        Driver.waitAndSendText(doctorPage.descriptionField, "Test", 2);
    }

    @And("Doctor can be select as PENDING, COMPLETED or CANCELLED at Status Dropdown")
    public void doctorCanBeSelectAsPENDINGCOMPLETEDOrCANCELLEDAtStatusDropdown() {
        Driver.waitAndClick(doctorPage.statusDropDown, 2);
        Driver.waitAndClick(doctorPage.pending, 2);
        Assert.assertEquals("PENDING", doctorPage.pending.getText());
        Driver.wait(2);
        Driver.waitAndClick(doctorPage.cancelled,2);
        Assert.assertEquals("CANCELLED", doctorPage.cancelled.getText());
        Driver.wait(2);
        Driver.waitAndClick(doctorPage.completed,2);
        Assert.assertEquals("COMPLETED", doctorPage.completed.getText());
        Driver.wait(2);
    }

    @And("Doctor ckicks on Save Button")
    public void doctorCkicksOnSaveButton() {
        Driver.waitAndClick(doctorPage.saveButton);
    }

    @And("Doctor verifies Appointment is updated succesfully")
    public void doctorVerifiesAppointmentIsUpdatedSuccesfully() {
        Driver.waitForVisibility(doctorPage.appointmentUpdatedMessage,4);
        Assert.assertTrue(doctorPage.appointmentUpdatedMessage.isDisplayed());
    }

    @Then("Doctor clicks Sign Out Button")
    public void doctorClicksSignOutButton() {
        Driver.waitAndClick(doctorPage.loginDropdown,2);
        Driver.waitAndClick(doctorPage.signOutDropdown);
        Driver.getDriver().close();
    }

    @Given("Doctor leaves anamesis field blank")
    public void doctorLeavesAnamesisFieldBlank() {
        Driver.waitAndClick(doctorPage.anamnesisField);
        doctorPage.anamnesisField.clear();
        Driver.waitAndSendText(doctorPage.anamnesisField, ""+ Keys.TAB);

    }

    @And("Doctor verifies anamesis field is required")
    public void doctorVerifiesAnamesisFieldIsRequired() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.anamnesisMessage,3).isDisplayed());
    }

    @And("Doctor leaves treatment field blank")
    public void doctorLeavesTreatmentFieldBlank() {
        Driver.waitAndClick(doctorPage.treatmentField);
        doctorPage.treatmentField.clear();
        Driver.waitAndSendText(doctorPage.treatmentField, ""+ Keys.TAB);

    }

    @And("Doctor verifies treatment field required")
    public void doctorVerifiesTreatmentFieldRequired() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.treatmentMessage,3).isDisplayed());
    }

    @And("Doctor doctor leaves diagnosis field blank")
    public void doctorDoctorLeavesDiagnosisFieldBlank() {
        Driver.waitAndClick(doctorPage.diagnosisField);
        doctorPage.diagnosisField.clear();
        Driver.waitAndSendText(doctorPage.diagnosisField, ""+Keys.TAB);

    }

    @And("Doctor verifies diagnosis field required")
    public void doctorVerifiesDiagnosisFieldRequired() {
        Assert.assertTrue(Driver.waitForVisibility(doctorPage.diagnosisMessage, 3).isDisplayed());
    }

    @And("Doctor selects UNAPPROVED from status field")
    public void doctorSelectsUNAPPROVEDFromStatusField() {
        Driver.waitAndClick(doctorPage.statusDropDown);
        Driver.wait(2);
    }

    @And("Doctor verifies UNAPPROVED can not selecteble")
    public void doctorVerifiesUNAPPROVEDCanNotSelecteble() {
        Assert.assertFalse(doctorPage.unApproved.isSelected());
    }

    @Then("Doctor close the application")
    public void doctorCloseTheApplication() {
        Driver.closeDriver();
    }
}
