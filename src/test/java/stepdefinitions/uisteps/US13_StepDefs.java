package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import pages.US12_US13Pages;
import utilities.ConfigReader;
import utilities.Driver;

public class US13_StepDefs {
    US12_US13Pages us12And13Pages = new US12_US13Pages();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaURL"));
    }
    @When("User clicks on account menu")
    public void user_clicks_on_account_menu() {

        Driver.waitAndClick(us12And13Pages.accountMenu);
    }
    @Then("User clicks on signin")
    public void user_clicks_on_signin() {

        Driver.waitAndClick(us12And13Pages.loginItem);
    }
    @Then("User enters username")
    public void user_enters_username() {
        us12And13Pages.username.sendKeys(ConfigReader.getProperty("user_doctor"));
    }
    @Then("User enters password")
    public void user_enters_password() {
        us12And13Pages.password.sendKeys(ConfigReader.getProperty("user_password"));
    }
    @Then("User clicks on signin button")
    public void user_clicks_on_signin_button() {

        Driver.waitAndClick(us12And13Pages.signinButton);
    }
    @Then("Doctor verifies that his page is displayed")
    public void doctor_verifies_that_his_page_is_displayed() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(us12And13Pages.doctorAccount.isDisplayed());
    }
    @Then("Doctor clicks on mypage")
    public void doctor_clicks_on_mypage() {
        Driver.waitAndClick(us12And13Pages.myPage);
    }
    @Then("Doctor clicks on myaccountement")
    public void doctor_clicks_on_myaccountement() {
        Driver.waitAndClick(us12And13Pages.myAppointement);
    }
    @Then("Doctor verifies Appointement page is displayed")
    public void doctor_verifies_appointement_page_is_displayed() {
        Assert.assertTrue(us12And13Pages.myAppointmentHeading.isDisplayed());
    }
    @Then("Doctor clicks on Edit button")
    public void doctor_clicks_on_edit_button() throws InterruptedException {
        Thread.sleep(2000);
        Driver.waitAndClick(us12And13Pages.editButton);
    }
    @Then("Doctor clicks on one of the Show Test Result button.")
    public void doctor_clicks_on_one_of_the_show_test_result_button() throws InterruptedException {
        Thread.sleep(2000);
        Driver.clickWithJS(us12And13Pages.showTheTestResultButton);
        // Driver.waitAndClick(us12And13Pages.showTheTestResultButton);
    }
    @Then("Doctor clicks on one of the View Results button.")
    public void doctor_clicks_on_one_of_the_view_results_button() throws InterruptedException {
        Thread.sleep(1000);
        Driver.waitAndClick(us12And13Pages.viewResultButton);
    }
    @Then("Doctor verifies that the Test Results page is displayed.")
    public void doctor_verifies_that_the_test_results_page_is_displayed() {
        Driver.waitForVisibility(us12And13Pages.testsPageHeading,2);
        Assert.assertTrue(us12And13Pages.testsPageHeading.isDisplayed());
    }
    @Then("Doctor verifies that  testListHeader is displayed.")
    public void doctor_verifies_that_testListHeader_is_displayed() throws InterruptedException {

        Thread.sleep(2000);
        Driver.waitForVisibility(us12And13Pages.testResultHeadingList,2);
        String strOfList = "ID Name Result Default Min. Value Default Max. Value Test Description Date";
        String actuelStrOfList= us12And13Pages.testResultHeadingList.getText();
        Assert.assertTrue(strOfList.equals(actuelStrOfList));
    }
    @Then("Doctor closes the browser")
    public void doctor_closes_the_browser() {
        Driver.closeDriver();

    }
    @Then("Doctor clicks on the Request Inpatient Result button.")
    public void doctor_clicks_on_the_request_inpatient_result_button() {
        Driver.clickWithJS(us12And13Pages.requestInpatientButton);
    }
    @Then("Doctor get error message or success message")
    public void doctor_get_error_message_or_success_message() throws InterruptedException {
        Thread.sleep(1000);
        try {
            Thread.sleep(1000);
            Boolean result = us12And13Pages.InpatientRequestDoneAlertSuccessMessage.isDisplayed();
            Assert.assertTrue(result);

        }catch (NoSuchElementException e){
            Boolean result = us12And13Pages.InpatientRequestDoneAlertErrorMessage.isDisplayed();
            Assert.assertTrue(result);
        }
    }
}
