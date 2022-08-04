package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CommonPageElement;
import pages.LoginPage;
import pages.US17_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US17_StepDefs {

    WebDriver driver;
    CommonPageElement cp = new CommonPageElement();
    LoginPage login = new LoginPage();
    US17_Page us17Page = new US17_Page();

    @Given("admin goes to the medunna website")
    public void admin_goes_to_the_medunna_website() {

        Driver.getDriver().get(ConfigReader.getProperty("app_url"));
    }

    @When("admin navigates to Sign in page")
    public void admin_navigates_to_sign_in_page() {

        Driver.waitAndClick(cp.signInAndRegistrationPortal,1);
        cp.signIn.click();
    }

    @When("admin sends {string} and {string}")
    public void doctor_sends_and(String username, String password) {

        login.username.sendKeys(ConfigReader.getProperty("admin_username"));
        login.password.sendKeys(ConfigReader.getProperty("admin_password"));
    }

    @When("admin clicks on Sign in button")
    public void admin_clicks_on_sign_in_button() {

        Driver.waitAndClick(login.loginButton,1);
    }

    @When("admin clicks on Items&Titles dropdown menu and selects Test Item section")
    public void admin_clicks_on_items_titles_dropdown_menu_and_selects_test_item_section() {

        Driver.waitAndClick(us17Page.itemsTitlesDropdown,1);
        Driver.waitAndClick(us17Page.testItem,1);
    }

    @When("admin clicks on Create a new Test Item button")
    public void admin_clicks_on_create_a_new_test_item_button() {

        Driver.waitAndClick(us17Page.createANewTestItem,1);
    }

    @When("admin enters information to {string}, {string}, {string}, {string}, {string} fields")
    public void admin_enters_information_to_fields(String name, String description, String price, String defMinVal, String defMaxVal) {

        Driver.waitAndSendText(us17Page.nameBox, name,1);
        Driver.waitAndSendText(us17Page.descriptionBox, description, 1);
        Driver.waitAndSendText(us17Page.priceBox, price, 1);
        Driver.waitAndSendText(us17Page.defMinValueBox, defMinVal,1);
        Driver.waitAndSendText(us17Page.defMaxValueBox, defMaxVal,1);
    }

    @When("admin clicks on Save button")
    public void admin_clicks_on_save_button() throws IOException {

        Driver.clickWithJS(us17Page.saveButton);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Created A New Test Item");
    }

    @Then("admin verifies the test item created successfully")
    public void admin_verifies_the_test_item_created_successfully() {

        Assert.assertTrue(us17Page.createdItemSuccessMsg.isDisplayed());
    }

    @Then("admin clicks on Sign out button")
    public void admin_clicks_on_sign_out_button() {

        Driver.waitAndClick(us17Page.dropdownMenu,1);
        Driver.waitAndClick(us17Page.signOutButton,1);
    }

    @Then("admin closes the application")
    public void admin_closes_the_application() {

        Driver.closeDriver();
    }

// TC02

    @When("admin clicks on Edit button")
    public void admin_clicks_on_edit_button() {

        Driver.waitAndClickElement(us17Page.editButton,2);
    }

    @When("admin updates the {string}, {string}, {string}, {string}, {string} fields and clicks on Save button")
    public void admin_updates_the_fields_and_clicks_on_save_button(String name, String description, String price, String defMinVal, String defMaxVal) {

        ReusableMethods.waitFor(1);
        us17Page.nameBox.clear();
        Driver.waitAndSendText(us17Page.nameBox, name,1);

        ReusableMethods.waitFor(1);
        us17Page.descriptionBox.clear();
        Driver.waitAndSendText(us17Page.descriptionBox, description, 1);

        ReusableMethods.waitFor(1);
        us17Page.priceBox.clear();
        Driver.waitAndSendText(us17Page.priceBox, price,1);

        ReusableMethods.waitFor(1);
        us17Page.defMinValueBox.clear();
        Driver.waitAndSendText(us17Page.defMinValueBox, defMinVal, 1);

        ReusableMethods.waitFor(1);
        us17Page.defMaxValueBox.clear();
        Driver.waitAndSendText(us17Page.defMaxValueBox, defMaxVal, 1);

        Driver.clickWithJS(us17Page.saveButton);
    }


    @Then("admin verifies all fields updated succesfully")
    public void admin_verifies_all_fields_updated_succesfully() {

        ReusableMethods.waitFor(1);
        Assert.assertTrue(us17Page.updatedItemSuccessMsg.isDisplayed());
    }

// TC03

    @When("admin clicks on View button on a test item")
    public void admin_clicks_on_view_button_on_a_test_item() {

        Driver.waitAndClickElement(us17Page.viewButton,2);
    }

    @Then("admin verifies all fields such as Name, Description, Price, Default Min. Value, Default Max. Value and Created Date")
    public void admin_verifies_all_fields_such_as_name_description_price_default_min_value_default_max_value_and_created_date() {

        ReusableMethods.waitFor(1);
        Assert.assertTrue(us17Page.verifyTestItem.isDisplayed());
    }

// TC04

    @When("admin clicks on Delete button on a test item")
    public void admin_clicks_on_delete_button_on_a_test_item() {

        Driver.wait(2);
        Driver.findItemAmongPagesDeleteButton("87_CERATINEEE","CERATINEEE");
    }

    @Then("admin verifies the test item is deleted")
    public void admin_verifies_the_test_item_is_deleted() {

        ReusableMethods.waitFor(2);
        Assert.assertTrue(us17Page.deleteSuccessMsg.isDisplayed());
    }

}
