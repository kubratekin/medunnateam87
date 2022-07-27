package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.US19_Create_Update_DeleteNewStaffPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US19_Create_Update_DeleteNewStaffStepDefs {

    US19_Create_Update_DeleteNewStaffPage staffPage = new US19_Create_Update_DeleteNewStaffPage();
    //TC01
    @Given("Admin is on the login page")
    public void admin_is_on_the_login_page() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @When("Admin clicks on login dropdown icon")
    public void admin_clicks_on_login_dropdown_icon() {

        Driver.waitAndClick(staffPage.loginDropdown,1);
    }
    @When("Admin clicks on sign in dropdown")
    public void admin_clicks_on_sign_in_dropdown() {
        Driver.waitAndClick(staffPage.signInDropdown,1);

    }
    @When("Admin sends username {string}")
    public void admin_sends_username(String string) {
        Driver.waitAndSendText(staffPage.usernameBox, ConfigReader.getProperty("admin_username"));
    }
    @When("Admin sends password {string}")
    public void admin_sends_password(String string) {
        Driver.waitAndSendText(staffPage.passwordBox, ConfigReader.getProperty("admin_password"));
    }
    @Then("Admin clicks on the sign in dropdown")
    public void admin_clicks_on_the_sign_in_dropdown() {
        Driver.waitAndClick(staffPage.sigInButton,1);
    }
    @Then("Admin clicks Items&Titles Dropdown")
    public void admin_clicks_items_titles_dropdown() {
        Driver.waitAndClick(staffPage.itemsTitlesDropdown,1);
    }
    @Then("Admin clicks StaffDropdown")
    public void admin_clicks_staff_dropdown() {
        Driver.waitAndClick(staffPage.staffDropdown,1);
    }
    @Then("Admin clicks Create a new staff button")
    public void admin_clicks_create_a_new_staff_button() {
        Driver.waitAndClick(staffPage.createANewStaffButton,1);
        Driver.wait(1);
    }
    @Then("Admin selects Use search checkbox")
    public void admin_selects_use_search_checkbox() {

        Driver.waitAndClick(staffPage.useSearchCheckbox,1);
    }
    @Then("Admin fills SSN box with {string} number")
    public void admin_fills_ssn_box_with_number(String SSN) {
        Driver.waitAndSendText(staffPage.ssnBox,SSN);
    }
    @Then("Admin clicks Search User button")
    public void admin_clicks_search_user_button() {

        Driver.clickWithJS(staffPage.searchUserButton);
    }
    @Then("Admin clicks Save button")
    public void admin_clicks_save_button() {
        Driver.clickWithJS(staffPage.saveButton);

    }
    @Then("Admin verify {string} message is visible")
    public void admin_verify_message_is_visible(String string) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(staffPage.userFoundMessage.getText().contains("User found"));
    }

    @Then("Admin close the application")
    public void admin_clicks_sign_out_button() {
        Driver.closeDriver();

    }


    //TC02
    @Then("Admin fills {string} box")
    public void admin_fills_box(String SSN) {
        Driver.waitAndSendText(staffPage.ssnBox,SSN);
        Driver.wait(1);
    }

    @Then("Admin change firstname {string} and lastname {string}")
    public void admin_change_firstname_and_lastname(String firstname, String lastname) {
        staffPage.firstNameBox.clear();
        Driver.wait(1);
        staffPage.firstNameBox.sendKeys(firstname);
        staffPage.lastNameBox.clear();
        Driver.wait(1);
        staffPage.lastNameBox.sendKeys(lastname);
    }
    @Then("Admin fills {string} and {string} from birthdate and phone boxes")
    public void admin_fills_and_from_birthdate_and_phone_boxes(String birthdate, String Phone) {
        Driver.wait(1);
        staffPage.birthDateBox.sendKeys(birthdate);
        Driver.wait(1);
        staffPage.phoneBox.sendKeys(Phone);

    }
    @Then("Admin selects Blood Group")
    public void admin_selects_blood_group() {
        Select selectBlood = new Select(staffPage.bloodGroupDropdown);
        selectBlood.selectByVisibleText("B+");
    }
    @Then("Admin fills {string} and {string} boxes")
    public void admin_fills_and_boxes(String Adress, String Description) {
        Driver.wait(1);
        staffPage.adressBox.sendKeys(Adress);
        Driver.wait(1);
        staffPage.descriptionBox.sendKeys(Description);

    }
    @Then("Admin selects Country and City from dropdown boxes")
    public void admin_selects_country_and_city_from_dropdown_boxes() {
        Driver.wait(1);
        Select selectCountry = new Select(staffPage.countryDropdown);
        selectCountry.selectByVisibleText("USA");
        Driver.wait(1);
        Select selectState = new Select(staffPage.cityDropdown);
        selectState.selectByVisibleText("California");
        Driver.wait(1);
    }
    @When("Admin verifies to {string} message is visible")
    public void admin_verifies_to_message_is_visible(String string) {
        try {
            Driver.wait(1);
            Assert.assertTrue(staffPage.createdToastContainer.getText().contains("new Staff is created"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //TC03
    @Then("Admin selects any user from the existing users")
    public void admin_selects_any_user_from_the_existing_users() {
        Driver.wait(1);
        Driver.waitAndClick(staffPage.viewutton);
    }
    @Then("Admin verifies selected user all information is visible")
    public void admin_verifies_selected_user_all_information_is_visible() {
        Assert.assertTrue(staffPage.staffTitleCanSee.isDisplayed());
        Driver.wait(1);
        Assert.assertTrue(staffPage.idCansee.isDisplayed());
        Driver.wait(1);
        Assert.assertTrue(staffPage.ssnCanSee.isDisplayed());
        Driver.wait(1);
        Assert.assertTrue(staffPage.firstnameCanSee.isDisplayed());
        Driver.wait(1);
        Assert.assertTrue(staffPage.lastnameCanSee.isDisplayed());
        Assert.assertTrue(staffPage.birthdateCanSee.isDisplayed());
        Assert.assertTrue(staffPage.phoneCanSee.isDisplayed());
        Assert.assertTrue(staffPage.genderCanSee.isDisplayed());
        Assert.assertTrue(staffPage.bloodCanSee.isDisplayed());
        Assert.assertTrue(staffPage.addressCanSee.isDisplayed());
        Assert.assertTrue(staffPage.descriptionCanSee.isDisplayed());
        Assert.assertTrue(staffPage.createdateCanSee.isDisplayed());
        Assert.assertTrue(staffPage.userCanSee.isDisplayed());
        Assert.assertTrue(staffPage.countryCanSee.isDisplayed());
        Assert.assertTrue(staffPage.stateCanSee.isDisplayed());
    }

    //TC04
    @Then("Admin clicks edit button")
    public void admin_clicks_edit_button() {
        Driver.waitAndClick(staffPage.editButton,1);
    }
    @Then("Admin fill {string} and {string} from birthdate and phone boxes")
    public void admin_fill_and_from_birthdate_and_phone_boxes(String birthdate, String phone) {
        Driver.wait(1);
        staffPage.birthDateBox.sendKeys(birthdate);
        staffPage.phoneBox.clear();
        Driver.wait(1);
        staffPage.phoneBox.sendKeys(phone);
    }
    @Then("Admin fills bloodgroup")
    public void admin_fills_bloodgroup() {
        Select selectBlood = new Select(staffPage.bloodGroupDropdown);
        selectBlood.selectByVisibleText("AB+");
    }

    @Then("Admin fill {string} and {string} boxes")
    public void admin_fill_and_boxes(String adress, String description) {
        staffPage.adressBox.clear();
        Driver.wait(1);
        staffPage.adressBox.sendKeys(adress);
        Driver.wait(1);
        staffPage.descriptionBox.clear();
        Driver.wait(1);
        staffPage.descriptionBox.sendKeys(description);
    }
    @Then("Admin select Country and City from dropdown boxes")
    public void admin_select_country_and_city_from_dropdown_boxes() {
        Driver.wait(1);
        Select selectCountry = new Select(staffPage.countryDropdown);
        selectCountry.selectByVisibleText("USA");
        Driver.wait(1);
        Select selectState = new Select(staffPage.cityDropdown);
        selectState.selectByVisibleText("California");
        Driver.wait(1);
    }
    @When("Admin verifies that {string} message is visible")
    public void admin_verifies_that_message_is_visible(String string) {
        Driver.wait(1);
        Assert.assertTrue(staffPage.updatedToastContainer.getText().contains("A Staff is updated"));
    }

    //TC05
    @Then("Admin clicks Delete Button at the Staff Page")
    public void admin_clicks_delete_button_at_the_staff_page() {
        Driver.waitAndClick(staffPage.deleteButton,1);
    }
    @Then("Admin clicks Delete Button at he Alert Page")
    public void admin_clicks_delete_button_at_he_alert_page() {
        Driver.wait(1);
        Driver.clickWithJS(staffPage.deleteButtonFromAlert);
    }
    @Then("Admin verifies at {string} message is visible")
    public void admin_verifies_at_message_is_visible(String string) {
        Driver.wait(1);
        Assert.assertTrue(staffPage.deletedToastContainer.getText().contains("is deleted"));
    }





}
