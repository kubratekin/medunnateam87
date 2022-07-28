package stepdefinitions.uisteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.UserManagementPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US20_UserManagementStepDef {

    UserManagementPage userManagementPage = new UserManagementPage();

    @Given("Admin goes to Medunna url")
    public void admin_goes_to_medunna_url() {
        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }
    @Given("Admin clicks on Login Dropdown Icon")
    public void admin_clicks_on_login_dropdown_icon() {
        userManagementPage.loginDropDownButton.click();
    }
    @Given("Admin clicks on SignIn")
    public void admin_clicks_on_sign_in() {
        userManagementPage.signInButtonfirst.click();
    }
    @And("Admin fills username and password as {string},{string}")
    public void adminFillsUsernameAndPasswordAs(String username, String password) {
        userManagementPage.usernameBox.sendKeys(username);
        userManagementPage.passwordBox.sendKeys(password);
        userManagementPage.signInButton.click();
    }
    @Given("Admin clicks on SignIn Button")
    public void admin_clicks_on_sign_in_button() {
        userManagementPage.signInButton.click();
    }
    @Given("Admin clicks Administration button.")
    public void admin_clicks_administration_button() {
        userManagementPage.administration.click();
    }
    @Given("Admin clicks User Management button")
    public void admin_clicks_user_management_button() {
        userManagementPage.userManagement.click();
    }
    @Then("Admin clicks verifies User text is visible.")
    public void admin_clicks_verifies_user_text_is_visible() {
        Assert.assertTrue(userManagementPage.usersHead.isDisplayed());
    }
    @Then("Admin clicks Create a new user button")
    public void admin_clicks_create_a_new_user_button() {
        userManagementPage.createAnewUser.click();
    }
    @Then("Admin fills login name, first name, last name,ssn, email boxes as {string},{string},{string},{string},{string}")
    public void admin_fills_login_name_first_name_last_name_ssn_email_boxes_as(String login, String firstname, String lastname, String ssn, String email) {
        userManagementPage.login.sendKeys(login);
        userManagementPage.first_Name.sendKeys(firstname);
        userManagementPage.last_Name.sendKeys(lastname);
        userManagementPage.ssnNumber.sendKeys(ssn);
        userManagementPage.email_Name.sendKeys(email);
    }
    @Then("Admin clicks Save user button")
    public void admin_clicks_save_user_button() throws InterruptedException {
        Driver.clickWithJS(userManagementPage.saveButton);
    }
    @Then("Admin verifies new registrant saved message successfully")
    public void admin_verifies_new_registrant_saved_message_successfully() throws InterruptedException {
        Thread.sleep(2);
        Assert.assertTrue(userManagementPage.successMessage.isDisplayed());
    }
    @Then("Admin clicks on modified date")
    public void admin_clicks_on_modified_date() throws InterruptedException {
        Thread.sleep(1000);
        Driver.clickWithJS(userManagementPage.ModifiedDate);
    }
    @Then("Admin clicks on edit button")
    public void admin_clicks_on_edit_button() throws InterruptedException {
        Thread.sleep(3000);
        Driver.clickWithJS(userManagementPage.editButton);
    }
    @Then("Admin can view firstName,lastName, email are visible.")
    public void admin_can_view_first_name_last_name_email_are_visible() {
        Assert.assertTrue(userManagementPage.viewFirstName.isDisplayed());
    }
    @Then("Admin selects select box deactivated button.")
    public void admin_selects_select_box_deactivated_button() throws InterruptedException {
        Thread.sleep(3000);
        Driver.waitAndClick(userManagementPage.activated);
    }
    @When("Admin clicks on save changes button")
    public void admin_clicks_on_save_changes_button() throws InterruptedException {
        Thread.sleep(3000);
        Driver.clickWithJS(userManagementPage.SaveButton);
    }
    @Given("Admin selects select box activated button")
    public void admin_selects_select_box_activated_button() throws InterruptedException {
        Driver.clickWithJS(userManagementPage.activated);
    }
    @Given("Admin provides a role from profiles as Staff")
    public void admin_provides_a_role_from_profiles_as_staff() throws InterruptedException {
        Driver.waitForVisibility(userManagementPage.activated,3);
        Thread.sleep(1000);
        Driver.selectByIndex(userManagementPage.profiles,3);//Staff
    }
    @Then("Admin verifies new registrant saved message succesfully")
    public void admin_verifies_new_registrant_saved_message_succesfully() {
        ReusableMethods.waitForVisibility(userManagementPage.successMessage,1);
    }
    @Given("Admin clicks on delete button")
    public void admin_clicks_on_delete_button() {
        Driver.clickWithJS(userManagementPage.delete);
    }
    @Given("Admin confirms delete")
    public void admin_confirms_delete() {
        Driver.waitAndClick(userManagementPage.confirmDeleteButton);
    }
    @Then("Admin verifies success deleted message")
    public void admin_verifies_success_deleted_message() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(userManagementPage.deleteSuccessMessage.isDisplayed());
    }

}
