package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.util.*;

public class US09_AdminStaffStepDefs {
    HomePageMedunna homePage = new HomePageMedunna();
    SignInPageMedunna signInPage = new SignInPageMedunna();
    AdminPageMedunna adminPage = new AdminPageMedunna();
    PatientViewByAdminAndStaffPageMedunna viewByAdminAndStaffPage = new PatientViewByAdminAndStaffPageMedunna();
    StaffPageMedunna staffPage = new StaffPageMedunna();
    PatientDetailPage detailPage = new PatientDetailPage();
    CreateOrEditPatientPage createOrEdit = new CreateOrEditPatientPage();
    UserManagementPage userManagement = new UserManagementPage();

    @Given("user goes to URL")
    public void user_goes_to_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @Given("User navigates to Sign in page")
    public void user_navigates_to_sign_in_page() {
        Driver.waitAndClick(homePage.logInDropdown,2);
        Driver.waitAndClick(homePage.signInButton,2);
    }
    @And("User enters username {string} and password {string} with Admin credentials and clicks Sign in button")
    public void userEntersUsernameAndPasswordWithAdminCredentialsAndClicksSignInButton(String username, String password) {
        Driver.waitAndSendText(signInPage.usernameBox,username);
        Driver.waitAndSendText(signInPage.passwordBox,password);
        Driver.waitAndClick(signInPage.signInButton,2);
    }
    @Then("User verifies that landed at Admin page")
    public void user_verifies_that_landed_at_admin_page() {
        ReusableMethods.waitForVisibility(adminPage.administrationDropdown,5);
        Assert.assertEquals("Administration",adminPage.administrationDropdown.getText());
    }
    @When("User navigate to Patients information page")
    public void user_navigate_to_patients_information_page() {
        Driver.waitAndClick(adminPage.itemsAndTitlesDropdown,2);
        Driver.waitAndClick(adminPage.patientButton,2);
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
        Driver.waitAndSendText(signInPage.usernameBox,username);
        Driver.waitAndSendText(signInPage.passwordBox,password);
        Driver.waitAndClick(signInPage.signInButton,2);
    }
    @Then("User verifies that landed at Staff page")
    public void userVerifiesThatLandedAtStaffPage() {
        ReusableMethods.waitForVisibility(staffPage.staffNameDropdown,5);
        Assert.assertTrue(staffPage.staffNameDropdown.getText().contains("team87staff team87staff"));
    }
    @When("User navigate to Patients information page from Staff page")
    public void userNavigateToPatientsInformationPageFromStaffPage() {
        Driver.waitAndClick(staffPage.myPagesDropdown,2);
        Driver.waitAndClick(staffPage.searchPatientButton,2);
    }

    //TC03
    @And("User clicks on ID of patient to go to Patient detail page")
    public void userClicksOnIDOfPatientToGoToPatientDetailPage(DataTable patient) {
        List<String> wantedPatient=patient.row(0);
        //ReusableMethods.findPatientAmongPagesAndClickID(wantedPatient.get(0),wantedPatient.get(1));
        //Driver.waitAndClick(viewByAdminAndStaffPage.idOfFirstPatient,2);
        Driver.wait(1);
        WebElement lastPageButton = Driver.getDriver().findElement(By.xpath("//nav/ul/li[last()]/a"));
        WebElement previousPageButton = Driver.getDriver().findElement(By.xpath("//nav/ul/li[2]/a"));
        List<WebElement> nameList;
        List<WebElement> ssnList;
        int row = 1;
        int pagesNumber = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//nav/ul/li[7]")).getText()); // number of last page
        boolean doWhile = false;        // For breaking the loop
        do {
            nameList= viewByAdminAndStaffPage.nameList;     // Otherwise it gave exception
            ssnList= viewByAdminAndStaffPage.ssnList;       // Otherwise it gave exception
            for (int i = 0; i < nameList.size(); i++) {
                if (nameList.get(i).getText().equals(wantedPatient.get(0)) && ssnList.get(i).getText().equals(wantedPatient.get(1))) {
                    row = i + 1;
                    doWhile=true;
                    break;
                }
            }
            if (doWhile){
                break;
            }
            nameList.clear();
            ssnList.clear();
            String showingNumberOfItems = Driver.getDriver().findElement(By.xpath("//div/div/span")).getText();  // To be sure that this is page 1 or not.
            String [] showingNumberOFItems = showingNumberOfItems.split(" ");            // To be sure that this is page 1 or not.
            if (Integer.parseInt(showingNumberOFItems[1])==1){
                Driver.waitAndClick(lastPageButton,2);
            }else {
                Driver.waitAndClick(previousPageButton,2);
                pagesNumber--;
            }
        } while (pagesNumber>1);
        Driver.wait(1);
        String xpath = "//tbody/tr["+row+"]/td[1]/a";
        WebElement idButton = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.wait(2);
        Driver.waitAndClick(idButton,2);
        Driver.wait(2);
    }
    @And("User clicks on Edit button")
    public void userClicksOnEditButton() {
        Driver.waitAndClick(detailPage.editButton,2);
    }
    @Then("User verifies Create or edit a Patient page is opened")
    public void userVerifiesCreateOrEditAPatientPageIsOpened() {
        Driver.wait(1);
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
        Driver.waitAndSendText(createOrEdit.birthDateTextBox,newCredentials.get(2)+Keys.ARROW_RIGHT+newCredentials.get(3));
        createOrEdit.emailTextBox.clear();
        Driver.waitAndSendText(createOrEdit.emailTextBox, Faker.instance().internet().emailAddress());
        createOrEdit.phoneTextBox.clear();
        Driver.waitAndSendText(createOrEdit.phoneTextBox,newCredentials.get(4));
        Driver.selectByIndex(createOrEdit.genderDropdown,1);
        Driver.selectByIndex(createOrEdit.bloodGroupDropdown,3);
        createOrEdit.addressTextBox.clear();
        Driver.waitAndSendText(createOrEdit.addressTextBox,Faker.instance().address().fullAddress());
        createOrEdit.descriptionTextBox.clear();
        Driver.waitAndSendText(createOrEdit.descriptionTextBox,newCredentials.get(5));
        Driver.selectByIndex(createOrEdit.userDropdown,0);
        Driver.wait(1);
        Driver.selectByIndex(createOrEdit.countryDropdown,2);
        Driver.wait(1);
        Driver.selectByIndex(createOrEdit.countryDropdown,Integer.parseInt(newCredentials.get(6)));
        Driver.wait(1);
        Driver.selectByVisibleText(createOrEdit.stateCityDropdown,newCredentials.get(7));
        Driver.waitAndClick(createOrEdit.saveButton,2);
        Driver.wait(1);
    }
    @Then("User verifies that all informations are changed")
    public void userVerifiesThatAllInformationsAreChanged() {
        Driver.wait(3);
        Assert.assertTrue(viewByAdminAndStaffPage.infoSavedMessage.getText().contains("A Patient is updated with identifier"));
    }

    //TC04
    @And("User clicks Edit button")
    public void userClicksEditButton(DataTable patient) {
        List<String> wantedPatient = patient.row(0);
//        ReusableMethods.findPatientAmongPagesAndClickEdit(wantedPatient.get(0),wantedPatient.get(1));
        //Driver.waitAndClick(viewByAdminAndStaffPage.editButton,2);
        Driver.wait(1);
        WebElement lastPageButton = Driver.getDriver().findElement(By.xpath("//nav/ul/li[last()]/a"));
        WebElement previousPageButton = Driver.getDriver().findElement(By.xpath("//nav/ul/li[2]/a"));
        List<WebElement> nameList;
        List<WebElement> ssnList;
        int row = 1;
        int pagesNumber = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//nav/ul/li[7]")).getText()); // number of last page
        boolean doWhile = false;        // For breaking the loop
        do {
            nameList= viewByAdminAndStaffPage.nameList;     // Otherwise it gave exception
            ssnList= viewByAdminAndStaffPage.ssnList;       // Otherwise it gave exception
            for (int i = 0; i < nameList.size(); i++) {
                if (nameList.get(i).getText().equals(wantedPatient.get(0)) && ssnList.get(i).getText().equals(wantedPatient.get(1))) {
                    row = i + 1;
                    doWhile=true;
                    break;
                }
            }
            if (doWhile){
                break;
            }
            nameList.clear();
            ssnList.clear();
            String showingNumberOfItems = Driver.getDriver().findElement(By.xpath("//div/div/span")).getText();  // To be sure that this is page 1 or not.
            String [] showingNumberOFItems = showingNumberOfItems.split(" ");            // To be sure that this is page 1 or not.
            if (Integer.parseInt(showingNumberOFItems[1])==1){
                Driver.waitAndClick(lastPageButton,2);
            }else {
                Driver.waitAndClick(previousPageButton,2);
                pagesNumber--;
            }
        } while (pagesNumber>1);
        String xpath = "//tbody/tr["+row+"]/td/div/a[2]/span";
        WebElement editButton = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.wait(2);
        Driver.waitAndClick(editButton,2);
        Driver.wait(1);
    }

    //TC05
    @And("User clicks view button")
    public void userClicksViewButton(DataTable patient) {
        List<String> wantedPatient = patient.row(0);
        //ReusableMethods.findPatientAmongPagesAndClickView(wantedPatient.get(0),wantedPatient.get(1));
        //Driver.waitAndClick(viewByAdminAndStaffPage.viewButton,2);
        Driver.wait(1);
        WebElement lastPageButton = Driver.getDriver().findElement(By.xpath("//nav/ul/li[last()]/a"));
        WebElement previousPageButton = Driver.getDriver().findElement(By.xpath("//nav/ul/li[2]/a"));
        List<WebElement> nameList;
        List<WebElement> ssnList;
        int row = 1;
        int pagesNumber = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//nav/ul/li[7]")).getText()); // number of last page
        boolean doWhile = false;        // For breaking the loop
        do {
            nameList= viewByAdminAndStaffPage.nameList;     // Otherwise it gave exception
            ssnList= viewByAdminAndStaffPage.ssnList;       // Otherwise it gave exception
            for (int i = 0; i < nameList.size(); i++) {
                if (nameList.get(i).getText().equals(wantedPatient.get(0)) && ssnList.get(i).getText().equals(wantedPatient.get(1))) {
                    row = i + 1;
                    doWhile=true;
                    break;
                }
            }
            if (doWhile){
                break;
            }
            nameList.clear();
            ssnList.clear();
            String showingNumberOfItems = Driver.getDriver().findElement(By.xpath("//div/div/span")).getText();  // To be sure that this is page 1 or not.
            String [] showingNumberOFItems = showingNumberOfItems.split(" ");            // To be sure that this is page 1 or not.
            if (Integer.parseInt(showingNumberOFItems[1])==1){
                Driver.waitAndClick(lastPageButton,2);
            }else {
                Driver.waitAndClick(previousPageButton,2);
                pagesNumber--;
            }
        } while (pagesNumber>1);
        String xpath = "//tbody/tr["+row+"]/td/div/a[1]/span";
        WebElement viewButton = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.wait(2);
        Driver.waitAndClick(viewButton,2);
        Driver.wait(1);
    }

    //TC06
    @Then("User clicks Edit button Staff")
    public void user_clicks_edit_button_staff(DataTable dataTable) {
        List<String> wantedPatient=dataTable.row(0);
        Driver.waitAndSendText(viewByAdminAndStaffPage.ssnSearchBox,wantedPatient.get(1));
        Driver.wait(2);
        int row = 1;
        List<WebElement> nameList= viewByAdminAndStaffPage.nameList;     // Otherwise it gave exception
        List<WebElement> ssnList= viewByAdminAndStaffPage.ssnList;       // Otherwise it gave exception
            for (int i = 0; i < nameList.size(); i++) {
                if (nameList.get(i).getText().equals(wantedPatient.get(0)) && ssnList.get(i).getText().equals(wantedPatient.get(1))) {
                    row = i + 1;
                    break;
                }
            }
        String xpath = "//tbody/tr["+row+"]/td/div/a[2]/span";
        WebElement editButton = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.waitAndClick(editButton,2);
        Driver.wait(1);

    }

    //TC07
    @Then("User clicks view button Staff")
    public void user_clicks_view_button_staff(DataTable dataTable) {
        List<String> wantedPatient=dataTable.row(0);
        Driver.waitAndSendText(viewByAdminAndStaffPage.ssnSearchBox,wantedPatient.get(1));
        Driver.wait(2);
        int row = 1;
        List<WebElement> nameList= viewByAdminAndStaffPage.nameList;     // Otherwise it gave exception
        List<WebElement> ssnList= viewByAdminAndStaffPage.ssnList;       // Otherwise it gave exception
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).getText().equals(wantedPatient.get(0)) && ssnList.get(i).getText().equals(wantedPatient.get(1))) {
                row = i + 1;
                break;
            }
        }
        String xpath = "//tbody/tr["+row+"]/td/div/a[1]/span";
        WebElement viewButton = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.waitAndClick(viewButton,2);
        Driver.wait(1);
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

    //TC09
    @When("User finds patient and clicks Delete button")
    public void userFindsPatientAndClicksDeleteButton() {
        Driver.waitAndClick(viewByAdminAndStaffPage.createNewPatientButton,1);
        CreateOrEditPatientPage createPatient = new CreateOrEditPatientPage();
        Driver.waitAndSendText(createPatient.firstNameTextBox, "team87del4");
        Driver.waitAndSendText(createPatient.lastNameTextBox, "team87");
        Driver.waitAndSendText(createPatient.emailTextBox, "aaaa@b.com");
        Driver.waitAndSendText(createPatient.phoneTextBox, "874-444-4444");
        Driver.waitAndClick(createOrEdit.saveButton,2);
        Driver.wait(6);
        List<WebElement> nameList = Driver.getDriver().findElements(By.xpath("//tbody/tr/td[3]"));
        int row = 1;
        for (int i = 0; i < 20; i++) {
            if (nameList.get(i).getText().contains("team87del4")) {
                row = i + 1;
                break;
            }
        }
        String xpath = "//tbody/tr["+row+"]/td[last()]//a[3]";
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.clickWithJS(deleteButton);
        Driver.waitAndClick(userManagement.confirmDeleteButton,3);

    }
    @Then("User verifies all informations are deleted")
    public void userVerifiesAllInformationsAreDeleted() {
        Driver.wait(5);
        Assert.assertTrue(userManagement.deleteSuccessMessage.getText().contains("A Patient is deleted with identifier"));
    }
}
