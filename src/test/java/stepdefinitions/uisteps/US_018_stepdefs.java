package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class US_018_stepdefs {
    HomePage homePage = new HomePage();
    SignInPageMedunna signInPageMedunna = new SignInPageMedunna();
    HomeAfterSignInPage homeAfterSignInPage = new HomeAfterSignInPage();
    PhysicianPage physicianPage = new PhysicianPage();
    PhysicianInfoPage physicianInfoPage = new PhysicianInfoPage();
    Select select;
    static List<WebElement> tableBody;

    @When("eh User click on the account dropdown toggle")
    public void user_click_on_the_account_dropdown_toggle() throws InterruptedException {
        homePage.accountMenuDropdown.click();
    }

    @And("eh User clicks on the Sign in button")
    public void UserClicksOnTheLink() {
        Driver.clickWithJS(homePage.signInButton);
    }

    @And("eh User enters the user login credentials {string} and {string}")
    public void UserEntersTheAdminLoginCredentialsAnd(String username, String password) {
        signInPageMedunna.usernameBox.sendKeys(username);
        signInPageMedunna.passwordBox.sendKeys(password);
    }

    @Then("eh User verifies successful log in as an Administrator by verifying {string} user type visibility")
    public void UserVerifiesSuccessfulLogInAsAnAdministratorByVerifyingUserTypeVisibility(String expectedText) {
        String adminButtonText = homeAfterSignInPage.administrationButton.getText();
        Assert.assertEquals(expectedText, adminButtonText);
    }

    @And("eh User click on the Sign in button")
    public void UserClickOnTheButton() {
        signInPageMedunna.signInButton.click();
    }


    @Then("eh User navigates to Physicians page")
    public void user_navigates_to_physicians_page() throws InterruptedException {
        homeAfterSignInPage.itemsAndTitles.click();
        homeAfterSignInPage.physicianDropDownMenuItem.click();
    }

    @Then("eh User verifies successful landing to the Physicians page")
    public void user_verifies_successful_landing_to_the_physicians_page() throws InterruptedException {
        Assert.assertTrue(physicianPage.physicianText.isDisplayed());
    }

    @Then("eh User verifies Create a new Physician button is visible")
    public void user_verifies_create_a_new_physician_button_is_visible() {
        Assert.assertTrue(physicianPage.createNewPhysicianButton.isDisplayed());
    }

    @Then("eh User clicks on Create a new Physician")
    public void user_clicks_on_create_a_new_physician() {
        physicianPage.createNewPhysicianButton.click();
    }

    @Then("eh User fills all fields to complete registration \\({string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string})")
    public void user_fills_all_fiedls_to_complete_registration_and(String firstName, String lastName, String birthDate, String phone, String address, String gender, String speciality, String bloodGroup, String description, String photoPath, String examFee, String user, String country, String city) throws InterruptedException {
        physicianPage.firstNameField.sendKeys(firstName);
        physicianPage.lastNameField.sendKeys(lastName);
        physicianPage.birthDate.sendKeys(birthDate);
        physicianPage.phoneField.sendKeys(phone);
        physicianPage.addressField.sendKeys(address);
        select = new Select(physicianPage.genderMenu);
        select.selectByVisibleText(gender);
        select = new Select(physicianPage.specialityMenu);
        select.selectByVisibleText(speciality);
        select = new Select(physicianPage.bloodGroupMenu);
        select.selectByValue(bloodGroup);
        physicianPage.descriptionField.sendKeys(description);
        physicianPage.chooseFileButton.sendKeys(photoPath);
        physicianPage.examFeeField.sendKeys(examFee);
        select = new Select(physicianPage.userDropdown);
        select.selectByVisibleText(user);
        select = new Select(physicianPage.countryField);
        select.selectByVisibleText(country);
        select = new Select(physicianPage.stateCityMenu);
        select.selectByVisibleText(city);
        Driver.clickWithJS(physicianPage.saveButton);
    }

    @And("eh User verifies successful registration")
    public void UserVerifiesSuccessfulRegistration() {
        Assert.assertTrue(physicianPage.getToastifyMessage().contains("A new Physician is created with identifier"));
    }

    @And("eh User clicks on Use Search")
    public void UserClicksOnUseSearch() {
        while (!physicianPage.useSSNCheckBox.isSelected()) {
            physicianPage.useSSNCheckBox.click();
        }
    }

    @And("eh User types {string} and clicks the Search User Button")
    public void UserTypesAndClicksTheSearchUserButton(String sSN) {
        physicianPage.sSNSearchBox.sendKeys(sSN);
        physicianPage.searchUserButton.click();
    }

    @Then("eh User confirms a user with the provided SSN is found")
    public void UserConfirmsAUserWithTheProvidedSSNIsFound() {
        Assert.assertEquals("User found with search SSN", physicianPage.getToastifyMessage());
    }

    @And("eh User verifies all personal information boxes are populated correctly")
    public void userVerifiesAllPersonalInformationBoxesArePopulatedCorrectly() {
        Assert.assertFalse(physicianPage.firstNameField.getAttribute("value").isEmpty());
        Assert.assertFalse(physicianPage.firstNameField.getAttribute("value").isEmpty());
        LocalDate birthDate = LocalDate.parse(physicianPage.birthDate.getAttribute("value"), DateTimeFormatter.ISO_LOCAL_DATE);
        Assert.assertFalse(birthDate.equals(LocalDate.now()));
        Assert.assertFalse(physicianPage.phoneField.getText().isEmpty());
        Assert.assertFalse(physicianPage.addressField.getText().isEmpty());
        select = new Select(physicianPage.countryField);
        Assert.assertFalse(select.getFirstSelectedOption().getText().equals(""));
        select = new Select(physicianPage.stateCityMenu);
        Assert.assertFalse(select.getFirstSelectedOption().getText().equals(""));
    }

    @And("eh User sends the profile photo path to upload the photo {string}")
    public void userSendsTheProfilePhotoPathToUploadThePhoto(String path) {
        physicianPage.chooseFileButton.sendKeys(path);
    }

    @Then("eh User confirms file is succesfully uploaded")
    public void userConfirmsFileIsSuccesfullyUploaded() {
        try {
            Assert.assertTrue(physicianPage.profilePhoto.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false);
        }
    }

    @Then("eh User clicks on the Save button")
    public void userClicksOnTheButton() throws InterruptedException {
        Driver.clickWithJS(physicianPage.saveButton);
    }

    @And("eh User confirms succesfull update notification is displayed")
    public void userConfirmsSuccesfullUpdateNotificationIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(physicianPage.toastifyAlertBoxMessage.getText().contains("A Physician is updated with identifier"));
    }

    @And("eh User clicks on the Edit button for a record")
    public void UserClicksOnTheEditButtonForARecord() {
        physicianPage.editButton.click();
    }

    @And("eh User verifies Create or Edit a Physician is visible")
    public void UserVerifiesCreateOrEditAPhysicianIsVisible() {
        Assert.assertTrue(physicianPage.createOrEditAPhysicianText.isDisplayed());
    }

    @And("eh User selects the doctor speciality as {string}")
    public void userSelectsTheDoctorSpecialityAs(String speciality) throws InterruptedException {
        select = new Select(physicianPage.specialityMenu);
        select.selectByVisibleText(speciality);
        Thread.sleep(1000);
        Assert.assertEquals(speciality, select.getFirstSelectedOption().getText());
    }

    @And("eh User selects the doctor exam fee as {string}")
    public void userSelectsTheDoctorExamFeeAs(String examFee) throws InterruptedException {
        physicianPage.examFeeField.clear();
        physicianPage.examFeeField.sendKeys(examFee);
        Assert.assertEquals(examFee, physicianPage.examFeeField.getAttribute("value"));
    }

    @And("eh User clicks the view button of the first record from the list")
    public void UserClicksTheViewButtonOfTheFirstRecordFromTheList() {
        physicianPage.viewButton.click();
    }

    @Then("eh User confirms that all Physician info is visible")
    public void UserConfirmsThatAllPhysicianInfoIsVisible() {
        try {
            Assert.assertTrue(physicianInfoPage.address.isDisplayed());
            Assert.assertFalse(physicianInfoPage.address.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.country.isDisplayed());
            Assert.assertFalse(physicianInfoPage.country.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.description.isDisplayed());
            Assert.assertFalse(physicianInfoPage.description.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.user.isDisplayed());
            Assert.assertFalse(physicianInfoPage.user.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.bloodGroup.isDisplayed());
            Assert.assertFalse(physicianInfoPage.bloodGroup.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.phone.isDisplayed());
            Assert.assertFalse(physicianInfoPage.photo.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.birthDate.isDisplayed());
            Assert.assertFalse(physicianInfoPage.birthDate.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.createdDate.isDisplayed());
            Assert.assertFalse(physicianInfoPage.createdDate.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.firstName.isDisplayed());
            Assert.assertFalse(physicianInfoPage.firstName.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.lastName.isDisplayed());
            Assert.assertFalse(physicianInfoPage.lastName.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.gender.isDisplayed());
            Assert.assertFalse(physicianInfoPage.gender.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.photo.isDisplayed());
            Assert.assertFalse(physicianInfoPage.photo.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.speciality.isDisplayed());
            Assert.assertFalse(physicianInfoPage.speciality.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.ssn.isDisplayed());
            Assert.assertFalse(physicianInfoPage.ssn.getText().isEmpty());
            Assert.assertTrue(physicianInfoPage.state.isDisplayed());
            Assert.assertFalse(physicianInfoPage.state.getText().isEmpty());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false);
        }

    }

    @Then("eh User edits all fields to complete registration \\({string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string} and {string})")
    public void UserEditsAllFieldsToCompleteRegistrationAnd(String firstName, String lastName, String birthDate, String phone, String address, String gender, String speciality, String bloodGroup, String description, String photoPath, String examFee, String user, String country, String city) {
        physicianPage.firstNameField.clear();
        physicianPage.firstNameField.sendKeys(firstName);
        physicianPage.lastNameField.clear();
        physicianPage.lastNameField.sendKeys(lastName);
        physicianPage.birthDate.clear();
        physicianPage.birthDate.sendKeys(birthDate);
        physicianPage.phoneField.clear();
        physicianPage.phoneField.sendKeys(phone);
        physicianPage.addressField.clear();
        physicianPage.addressField.sendKeys(address);
        select = new Select(physicianPage.genderMenu);
        select.selectByVisibleText(gender);
        select = new Select(physicianPage.specialityMenu);
        select.selectByVisibleText(speciality);
        select = new Select(physicianPage.bloodGroupMenu);
        select.selectByValue(bloodGroup);
        physicianPage.descriptionField.clear();
        physicianPage.descriptionField.sendKeys(description);
        physicianPage.chooseFileButton.clear();
        physicianPage.chooseFileButton.sendKeys(photoPath);
        physicianPage.examFeeField.clear();
        physicianPage.examFeeField.sendKeys(examFee);
        select = new Select(physicianPage.userDropdown);
        select.selectByVisibleText(user);
        select = new Select(physicianPage.countryField);
        select.selectByVisibleText(country);
        select = new Select(physicianPage.stateCityMenu);
        select.selectByVisibleText(city);
    }

    @Then("eh User verifies all field labels are visible on Create or Edit a Physician")
    public void UserVerifiesAllFieldLabelsAreVisibleOnCreateOrEditAPhysician() {
        Assert.assertTrue(physicianPage.addressLabel.isDisplayed());
        Assert.assertTrue(physicianPage.bloodGroupLabel.isDisplayed());
        Assert.assertTrue(physicianPage.countryLabel.isDisplayed());
        Assert.assertTrue(physicianPage.lastNameLabel.isDisplayed());
        Assert.assertTrue(physicianPage.firstNameLabel.isDisplayed());
        Assert.assertTrue(physicianPage.ssnLabel.isDisplayed());
        Assert.assertTrue(physicianPage.phoneLabel.isDisplayed());
        Assert.assertTrue(physicianPage.genderLabel.isDisplayed());
        Assert.assertTrue(physicianPage.specialityLabel.isDisplayed());
        Assert.assertTrue(physicianPage.descriptionLabel.isDisplayed());
        Assert.assertTrue(physicianPage.imageLabel.isDisplayed());
        Assert.assertTrue(physicianPage.examFeeLabel.isDisplayed());
        Assert.assertTrue(physicianPage.userLabel.isDisplayed());
        Assert.assertTrue(physicianPage.stateCityLabel.isDisplayed());
        try {
            Assert.assertTrue(physicianPage.birthdayLabel.isDisplayed());
        }catch (NoSuchElementException e) {
            Assert.assertTrue(false);
        }
    }
    @Then("eh User verifies the Delete button is visible")
    public void user_verifies_the_delete_button_is_visible() {
        Assert.assertTrue(physicianPage.deleteButton.isDisplayed());
    }
    @Then("eh User clicks the Delete button to delete record")
    public void user_clicks_the_button_to_delete_record() {
        physicianPage.deleteButton.click();
        physicianPage.deleteConfirm.click();
    }

    @And("eh User clicks the Delete button again to confirm the deletion")
    public void userClicksTheDeleteButtonAgainToConfirmTheDeletion() {
        physicianPage.deleteConfirm.click();
    }

    @Then("eh User verifies all information is deleted")
    public void user_verifies_all_information_is_deleted() throws InterruptedException {
        try {
            Assert.assertTrue(physicianPage.physicianDeleteConfirmation.getText().contains("A Physician is deleted with identifier"));
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false);
        }
    }

    @Then("eh User verifies the delete button is not visible for staff")
    public void userVerifiesTheDeleteButtonIsNotVisibleForStaff() {

        try {
            Assert.assertFalse(physicianPage.deleteButton.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }

    }

    @And("eh User closes the browser")
    public void UserClosesTheBrowser() {
        Driver.getDriver().quit();
    }


    @Then("User retrieves the info for all Physicians from the first page")
    public void userRetrievesTheInfoForAllPhysiciansFromTheFirstPage() {
        tableBody = physicianPage.tableBody;
    }

//    @Then("eh User closes the browser")
//    public void eh_user_closes_the_browser() {
//
//        Driver.closeDriver();
//    }
}


