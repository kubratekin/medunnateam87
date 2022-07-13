package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonPageElement;
import pages.LoginPage;
import pages.US14_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US14_StepDefs {

    WebDriver driver;
    CommonPageElement cp = new CommonPageElement();
    LoginPage login = new LoginPage();
    US14_Page us14Page = new US14_Page();

    @Given("doctor is on the medunna website")
    public void doctor_is_on_the_medunna_website() {

        Driver.getDriver().get(ConfigReader.getProperty("base_url"));
    }

    @When("navigates the Sign in page")
    public void navigates_the_sign_in_page() {

        Driver.waitAndClick(cp.signInAndRegistrationPortal);
        cp.signIn.click();
    }

    @When("doctor sends {string} and {string}")
    public void doctor_sends_and(String username, String password) {

        login.username.sendKeys(ConfigReader.getProperty("doctor_username"));
        login.password.sendKeys(ConfigReader.getProperty("doctor_password"));
    }

    @When("doctor clicks on Sign in button")
    public void doctor_clicks_on_sign_in_button() {

        login.loginButton.click();
    }

    @When("doctor clicks on MY PAGES dropdown menu and selects My Inpatients section")
    public void doctor_clicks_on_my_pages_dropdown_menu_and_selects_my_inpatients_section() {

        us14Page.myPages.click();
        us14Page.myInpatients.click();
    }

    @Then("doctor verifies all inpatient info")
    public void doctor_verifies_all_inpatient_info() throws IOException {

        WebElement table = Driver.waitForVisibility(us14Page.entireTable, 1);
        System.out.println(table.getText());
        Assert.assertTrue(us14Page.entireTable.isDisplayed());
        ReusableMethods.getScreenshot("All Patient Info");
    }

    @Then("doctor closes the application")
    public void doctor_closes_the_application() {

        Driver.closeDriver();
    }

//    @When("doctor clicks on Edit button on a {string}")
//    public void doctor_clicks_on_edit_button_on_a(String inpatient) {
//
//        Driver.waitAndClick(us14Page.editButton);
//    }


    @When("doctor updates the Description field as {string}")
    public void doctor_updates_the_description_field_as(String description) throws IOException {

        us14Page.description.clear();
        Driver.waitAndSendText(us14Page.description,"The patient has asthma");
        Driver.clickWithJS(us14Page.saveButton);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Description Info");
    }


    @Then("doctor verifies Description field is updatable")
    public void doctor_verifies_description_field_is_updatable() throws IOException {

        Assert.assertTrue(us14Page.successMsgAlert.isDisplayed());
    }

    @When("doctor updates the Created Date field as {string}")
    public void doctor_updates_the_created_date_field_as(String createdDate) throws IOException {

        Driver.waitAndSendText(us14Page.createdDate, "08/06/2022");
        ReusableMethods.waitFor(2);
        Driver.clickWithJS(us14Page.saveButton);
        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("Created Date Info");

    }

    @Then("doctor verifies Created Date field is updatable")
    public void doctor_verifies_created_date_field_is_updatable() throws IOException {

        Assert.assertTrue(us14Page.successMsgAlert.isDisplayed());
    }

    @When("doctor updates the Status field as {string}")
    public void doctor_updates_the_status_field_as(String status) {

        Driver.scrollIntoViewJS(us14Page.status);
        Driver.selectByVisibleText(us14Page.status, "UNAPPROVED");
        ReusableMethods.waitFor(1);
        Driver.clickWithJS(us14Page.saveButton);
        ReusableMethods.waitFor(1);

    }

    @Then("doctor verifies Status field is updatable")
    public void doctor_verifies_status_field_is_updatable() throws IOException {

        Assert.assertTrue(us14Page.failureMessage.isDisplayed());
    }

    @When("doctor clicks on Edit button on a {string}")
    public void doctor_clicks_on_edit_button_on_a_inpatient(String inpatient) {

        Driver.waitAndClick(us14Page.editButton);
    }

    @When("doctor selects a room that is available")
    public void doctor_selects_a_room_that_is_available() throws IOException {

        Driver.waitAndSendText(us14Page.room,"421:TWIN");
        ReusableMethods.waitFor(1);
        Driver.clickWithJS(us14Page.saveButton);
        ReusableMethods.waitFor(1);
    }

    @Then("doctor verifies the Room {string} can be updatable")
    public void doctor_verifies_the_room_can_be_updatable(String room) {

        Assert.assertTrue(us14Page.successMsgAlert.isDisplayed());
    }
}
