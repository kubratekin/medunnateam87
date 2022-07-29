package stepdefinitions.uisteps;

import io.cucumber.java.cs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.US28_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US28_StepDefs {
    US28_Page admin28 = new US28_Page();

    @Given("admin navigates to url")
    public void admin_navigates_to_url() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @Given("admin clicks on account dropdown")
    public void admin_clicks_on_account_dropdown() throws InterruptedException {
        Thread.sleep(3000);
        admin28.accountMenu.click();
    }

    @Given("admin clicks on sign in button")
    public void admin_clicks_on_sign_in_button() throws InterruptedException {
        Thread.sleep(2000);
        admin28.homePageSignIn.click();
    }
    @Given("admin verifies that sign in page is visible")
    public void admin_verifies_that_sign_in_page_is_visible() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(admin28.signInPageHeader.isDisplayed());
    }

    @Given("admin enters {string} username and {string} password")
    public void admin_enters_username_and_password(String username, String password) throws InterruptedException {
        Thread.sleep(1000);
        admin28.username.sendKeys("team87_admin");
        admin28.password.sendKeys("1234567");
    }

    @Given("admin clicks on sign in page sign in button")
    public void admin_clicks_on_sign_in_page_sign_in_button() throws InterruptedException {
        Thread.sleep(1000);
        admin28.signInPageSignInButton.click();
    }

    @Given("admin verifies admin page is displayed")
    public void admin_verifies_admin_page_is_displayed() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(admin28.adminPage.isDisplayed());
    }

    @Given("admin clicks on items and titles dropdown")
    public void admin_clicks_on_items_and_titles_dropdown() throws InterruptedException {
        Thread.sleep(1000);
        admin28.itemsTitles.click();
    }

    @Given("admin clicks on country button")
    public void admin_clicks_on_country_button() throws InterruptedException {
        Thread.sleep(1000);
        admin28.countryDropdown.click();
    }
    @Given("admin verifies countries page is visible")
    public void admin_verifies_countries_page_is_visible() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(admin28.countriesHeader.isDisplayed());
    }

    @Given("admin clicks on create a new Country button")
    public void admin_clicks_on_create_a_new_country_button() throws InterruptedException {
        Thread.sleep(1000);
        admin28.createANewCountryButton.click();

    }

    @Given("admin verifies Create or edit a Country page is visible")
    public void admin_verifies_create_or_edit_a_country_page_is_visible() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(admin28.CreateANewCountryPage.isDisplayed());
    }

    @Given("admin enters {string} countryname")
    public void admin_enters_countryname(String countryname) throws InterruptedException {
        Thread.sleep(1000);
        admin28.countryNameBox.sendKeys("umutistan111");
    }



    @Given("admin click on Save button")
    public void admin_click_on_save_button() throws InterruptedException, IOException {
        admin28.saveButton.click();
        Thread.sleep(2000);
        ReusableMethods.getScreenshot("not created state");

    }

    @Given("admin verifies a new country is created with identifier message is displayed")
    public void admin_verifies_a_new_country_is_created_with_identifier_message_is_displayed() {
        Assert.assertTrue(admin28.alertNewCountryCreated.isDisplayed());

    }

    //test2

    @Given("admin clicks on states and cities button")
    public void admin_clicks_on_states_and_cities_button() throws InterruptedException {
        Thread.sleep(1000);
        admin28.stateCityDropdown.click();
    }
    @Given("admin clicks on crete a new StateCity button")
    public void admin_clicks_on_crete_a_new_state_city_button() {
        Driver.waitAndClick(admin28.createANewStateCity, 2);
    }

    @Given("admin enters a StateCity {string} name")
    public void admin_enters_a_state_city_name(String name) {
        Driver.waitAndSendText(admin28.stateCityNameBox, "adalar", 2);

    }
    @Given("admin clicks on a country {string}")
    public void admin_clicks_on_a_country(String string) {
        Driver.selectByVisibleText(admin28.countryDropDown,"Senegal");
        Driver.wait(2);
    }
    @Given("admin verifies a new StateCity is created message")
    public void admin_verifies_a_new_state_city_is_created_message() {
        Assert.assertTrue(admin28.stateCityAlert.isDisplayed());


    }

    //test3

//    @Given("admin selects a country")
//    public void admin_selects_a_country() {
//        Driver.scrollIntoViewJS(admin28.deleteCountry);
//        Driver.selectByVisibleText(admin28.deleteCountry, "umutumut");
//        Driver.wait(8);



    @And("admin Enters {string} countryname")
    public void adminEntersCountryname(String countryname) {
        admin28.countryNameBox.sendKeys("umutumut2");
        Driver.wait(3);
    }



    @Given("admin clicks on delete button")
    public void admin_clicks_on_delete_button() {

        Driver.waitAndClick(admin28.deleteCountry,3);

    }

    @Given("admin verifies confirm delete operation alert")
    public void admin_verifies_confirm_delete_operation_alert() {
        Driver.waitAndClick(admin28.deleteConfirm, 2);


    }
    @Given("admin verifies a new country is deleted with identifier")
    public void admin_verifies_a_new_country_is_deleted_with_identifier() throws InterruptedException {
        Assert.assertTrue(admin28.deletedMessage.isDisplayed());
        Thread.sleep(2000);

    }





}
