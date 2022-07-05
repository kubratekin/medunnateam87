package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class US09StepDefs {
    HomePageMedunna homePage = new HomePageMedunna();
    SignInPageMedunna signInPage = new SignInPageMedunna();
    AdminPageMedunna adminPage = new AdminPageMedunna();
    PatientViewByAdminAndStaffPageMedunna viewByAdminAndStaffPage = new PatientViewByAdminAndStaffPageMedunna();
    StaffPageMedunna staffPage = new StaffPageMedunna();
    PatientDetailPage detailPage = new PatientDetailPage();
    CreateOrEditPatientPage createOrEdit = new CreateOrEditPatientPage();


    @Given("user goes to URL")
    public void user_goes_to_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_home_url"));
    }

    @Given("User navigates to Sign in page")
    public void user_navigates_to_sign_in_page() {
        homePage.logInDropdown.click();
        homePage.signInButton.click();
    }

    @And("User enters username {string} and password {string} with Admin credentials and clicks Sign in button")
    public void userEntersUsernameAndPasswordWithAdminCredentialsAndClicksSignInButton(String username, String password) {
        signInPage.usernameBox.sendKeys(username);
        signInPage.passwordBox.sendKeys(password);
        signInPage.signInButton.click();
    }
    @Then("User verifies that landed at Admin page")
    public void user_verifies_that_landed_at_admin_page() {
        ReusableMethods.waitForVisibility(adminPage.administrationDropdown,5);
        Assert.assertEquals("Administration",adminPage.administrationDropdown.getText());
    }

    @When("User navigate to Patients information page")
    public void user_navigate_to_patients_information_page() {
        adminPage.itemsAndTitlesDropdown.click();
        adminPage.patientButton.click();
    }
    @Then("User verifies that landed at Patients information page")
    public void user_verifies_that_landed_at_patients_information_page() {
        Assert.assertTrue(viewByAdminAndStaffPage.patientInfoTableHeader.getText().contains("Patients"));
    }
    @Then("User verifies that can see patient information")
    public void user_verifies_that_can_see_patient_information() {
        List<WebElement> listOfFirstPatientInfo = Driver.getDriver().findElements(By.xpath("(//table/tbody/tr)[1]/td"));
        Assert.assertFalse(listOfFirstPatientInfo.isEmpty());
    }

    @Then("User closes the browser")
    public void user_closes_the_browser() {
        Driver.closeDriver();
    }


    //TC02
    @And("User enters username {string} and password {string} with Staff credentials and clicks Sign in button")
    public void userEntersUsernameAndPasswordWithStaffCredentialsAndClicksSignInButton(String username, String password) {
        signInPage.usernameBox.sendKeys(username);
        signInPage.passwordBox.sendKeys(password);
        signInPage.signInButton.click();
    }

    @Then("User verifies that landed at Staff page")
    public void userVerifiesThatLandedAtStaffPage() {
        ReusableMethods.waitForVisibility(staffPage.staffNameDropdown,5);
        Assert.assertEquals("John Doe",staffPage.staffNameDropdown.getText());
    }


    @When("User navigate to Patients information page from Staff page")
    public void userNavigateToPatientsInformationPageFromStaffPage() {
        staffPage.myPagesDropdown.click();
        staffPage.searchPatientButton.click();
    }

    //TC03
    @And("User clicks on ID of patient to go to Patient detail page")
    public void userClicksOnIDOfPatientToGoToPatientDetailPage() {
        Driver.waitAndClick(viewByAdminAndStaffPage.idOfFirstPatient,2);
    }

    @And("User clicks on Edit button")
    public void userClicksOnEditButton() {
        Driver.waitAndClick(detailPage.editButton,2);
    }

    @Then("User verifies Create or edit a Patient page is opened")
    public void userVerifiesCreateOrEditAPatientPageIsOpened() {
        Assert.assertEquals("Create or edit a Patient",createOrEdit.createOrEditTableHeader.getText());
    }

    @And("User writes new informations in each information boxes")
    public void userWritesNewInformationsInEachInformationBoxes(DataTable firstLastName) {
        List<String> newCredentials = firstLastName.row(0);
        Driver.wait(2);
        createOrEdit.firstNameTextBox.clear();
        Driver.waitAndSendText(createOrEdit.firstNameTextBox, newCredentials.get(0));
        Driver.wait(2);
        createOrEdit.lastNameTextBox.clear();
        Driver.waitAndSendText(createOrEdit.lastNameTextBox,newCredentials.get(1));
        Driver.waitAndSendText(createOrEdit.birthDateTextBox,"01.01.1987 01:01");
        createOrEdit.emailTextBox.clear();
        Driver.waitAndSendText(createOrEdit.emailTextBox, Faker.instance().internet().emailAddress());
        createOrEdit.phoneTextBox.clear();
        Driver.waitAndSendText(createOrEdit.phoneTextBox,"1234567890");
        Driver.selectByIndex(createOrEdit.genderDropdown,1);
        Driver.selectByIndex(createOrEdit.bloodGroupDropdown,3);
        createOrEdit.addressTextBox.clear();
        Driver.waitAndSendText(createOrEdit.addressTextBox,Faker.instance().address().fullAddress());
        createOrEdit.descriptionTextBox.clear();
        Driver.waitAndSendText(createOrEdit.descriptionTextBox,"change87");
        Driver.selectByIndex(createOrEdit.userDropdown,0);
        Driver.selectByIndex(createOrEdit.countryDropdown,5);
        Driver.selectByIndex(createOrEdit.stateCityDropdown,0);
        Driver.waitAndClick(createOrEdit.saveButton,2);
    }

    @Then("User verifies that all informations are changed")
    public void userVerifiesThatAllInformationsAreChanged() {
        Driver.wait(3);
        Assert.assertTrue(viewByAdminAndStaffPage.infoSavedMessage.getText().contains("A Patient is updated with identifier"));
    }

    //TC04
    @And("User clicks Edit button")
    public void userClicksEditButton() {
        Driver.waitAndClick(viewByAdminAndStaffPage.editButton,2);
    }

    //TC05
    @And("User clicks view button")
    public void userClicksViewButton() {
        Driver.waitAndClick(viewByAdminAndStaffPage.viewButton,2);
    }

    //TC08
    @When("User enters patient SSN {string} into search box")
    public void userEntersPatientSSNIntoSearchBox(String SSN) {
        Driver.waitAndSendText(viewByAdminAndStaffPage.searchBox,SSN);
        Driver.wait(2);
    }

    @Then("User verifies that can see patient registration information populated")
    public void userVerifiesThatCanSeePatientRegistrationInformationPopulated() {
        String xpath = "(//table/tbody/tr/td)[";
        List<String> patientList = new ArrayList<>();
        for (int i = 1; i<16;i++){
            patientList.add(Driver.getDriver().findElement(By.xpath(xpath+i+"]")).getText());
        }
        List<String> headerList = ReusableMethods.getElementsText(By.xpath("//table/thead/tr/th"));
        Map<String,String > patientMap = new LinkedHashMap<>();
        for (int i=0;i<patientList.size();i++){
            if (patientList.get(i).equals("")){
                patientMap.put(headerList.get(i), null);
            }else {
                patientMap.put(headerList.get(i), patientList.get(i));
            }
        }
            Assert.assertFalse(patientMap.get("SSN").isEmpty());
            Assert.assertFalse(patientMap.get("First Name").isEmpty());
            Assert.assertFalse(patientMap.get("Last Name").isEmpty());
            Assert.assertFalse(patientMap.get("Email").isEmpty());
            Assert.assertFalse(patientMap.get("User").isEmpty());
    }
}
