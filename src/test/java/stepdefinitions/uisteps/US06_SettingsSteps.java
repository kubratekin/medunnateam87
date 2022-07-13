package stepdefinitions.uisteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.SettingsPage;

public class US06_SettingsSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    SettingsPage settingsPage = new SettingsPage();



    //Background
    @When("user navigate to sign in page")
    public void user_navigate_to_sign_in_page() throws InterruptedException {
        homePage.accountMenuDropdown.click();
        Thread.sleep(2000);
        homePage.accountSignInDropdownSelect.click();

    }
    @Then("user Verify that sign in page is displayed")
    public void user_verify_that_sign_in_page_is_displayed() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(loginPage.signInTitle.isDisplayed());;
    }

    //TC01
    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
    }
    @When("User navigate to settings page")
    public void user_navigate_to_settings_page() {
        loginPage.loginButton.click();
    }
    @Then("Verify that settings page is displayed")
    public void verify_that_settings_page_is_displayed() throws InterruptedException {
        loginPage.signInAccountMenuDropdown.click();
        loginPage.accountSettingsDropdownSelect.click();
        Thread.sleep(3000);
        Assert.assertTrue(settingsPage.settingsTitle.isDisplayed());
    }
    @Then("Verify that there is user {string} in the First Name box")
    public void verify_that_there_is_user_in_the_first_name_box(String firstname) {
        Assert.assertEquals(firstname,settingsPage.firstnameTextBox.getAttribute("value"));

    }
    @Then("Verify that there is user {string} in the Last Name box")
    public void verify_that_there_is_user_in_the_last_name_box(String lastname) {
        Assert.assertEquals(lastname,settingsPage.lastnameTextBox.getAttribute("value"));
    }
    @Then("Verify that there is user {string} in the email")
    public void verify_that_there_is_user_in_the_email(String email) {
        Assert.assertEquals(email,settingsPage.emailTextBox.getAttribute("value"));
    }

    //TC02
    @Then("User enters new firstname {string}")
    public void user_enters_new_firstname(String newFirstname) {
        settingsPage.firstnameTextBox.clear();
        settingsPage.firstnameTextBox.sendKeys(newFirstname+Keys.ENTER);
    }
    @Then("Verify saved user new firstname")
    public void verify_saved_user_new_firstname() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(settingsPage.settingsSavedAlert.isDisplayed());
    }
    @Then("User enters previous firstname {string}")
    public void user_enters_previous_firstname(String previousFirstname) throws InterruptedException {
        settingsPage.firstnameTextBox.clear();
        settingsPage.firstnameTextBox.sendKeys(previousFirstname + Keys.ENTER);
    }

    //TC03
    @Then("User enters new lastname {string}")
    public void user_enters_new_lastname(String newLastname) {
        settingsPage.lastnameTextBox.clear();
        settingsPage.lastnameTextBox.sendKeys(newLastname+Keys.ENTER);
    }
    @Then("Verify saved user new lastname")
    public void verify_saved_user_new_lastname() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(settingsPage.settingsSavedAlert.isDisplayed());
    }
    @Then("User enters previous lastname {string}")
    public void user_enters_previous_lastname(String previousLastname) {
        settingsPage.lastnameTextBox.clear();
        settingsPage.lastnameTextBox.sendKeys(previousLastname+Keys.ENTER);
    }


}
