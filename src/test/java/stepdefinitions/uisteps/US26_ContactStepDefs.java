package stepdefinitions.uisteps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.ContactPage;
import utilities.Driver;

public class US26_ContactStepDefs {

    ContactPage contactPage = new ContactPage();

    //background
    @When("User navigate to contact page")
    public void user_navigate_to_contact_page() {
        contactPage.contactButton.click();
    }
    @Then("Verify that contact page is displayed")
    public void verify_that_contact_page_is_displayed() {
        Assert.assertTrue(contactPage.contactTextTitle.isDisplayed());
    }


    //TC01
    @Then("Verify that the Name box exists")
    public void verify_that_the_name_box_exists() {
        Driver.scrollIntoViewJS(contactPage.contactNameTextBox);
        Assert.assertTrue(contactPage.contactNameTextBox.isDisplayed());
    }
    @Then("Verify that the E-mail box exists")
    public void verify_that_the_e_mail_box_exists() {
        Driver.scrollIntoViewJS(contactPage.contactEmailTextBox);
        Assert.assertTrue(contactPage.contactEmailTextBox.isDisplayed());
    }
    @Then("Verify that the Subject box exists")
    public void verify_that_the_subject_box_exists() {
        Driver.scrollIntoViewJS(contactPage.contactSubjectTextBox);
        Assert.assertTrue(contactPage.contactSubjectTextBox.isDisplayed());
    }
    @Then("Verify that the Message box exists")
    public void verify_that_the_message_box_exists() {
        Driver.scrollIntoViewJS(contactPage.contactMessageTextBox);
        Assert.assertTrue(contactPage.contactMessageTextBox.isDisplayed());
    }


    //TC02
    @When("User enter name blank")
    public void user_enter_name_blank() {
        Driver.scrollIntoViewJS(contactPage.contactNameTextBox);
        contactPage.contactNameTextBox.sendKeys("  "+Keys.TAB);
    }
    @Then("User should see error message Name is required.")
    public void user_should_see_error_message_name_is_required() {
        Assert.assertTrue(contactPage.nameRequiredMessage.isDisplayed());
    }


    //TC03
    @When("User enter subject blank")
    public void user_enter_subject_blank() {
        Driver.scrollIntoViewJS(contactPage.contactSubjectTextBox);
        contactPage.contactSubjectTextBox.sendKeys("  "+Keys.TAB);
    }
    @Then("User should see error message This field is required.")
    public void user_should_see_error_message_this_field_is_required() {
        Assert.assertTrue(contactPage.subjectRequiredMessage.isDisplayed());
    }


    //TC04
    @When("User enter email blank")
    public void user_enter_email_blank() {
        Driver.scrollIntoViewJS(contactPage.contactEmailTextBox);
        contactPage.contactEmailTextBox.sendKeys("  "+Keys.TAB);
    }
    @Then("User should see error message Your email is required.")
    public void user_should_see_error_message_your_email_is_required() {
        Assert.assertTrue(contactPage.emailRequiredMessage.isDisplayed());
    }


    //TC05
    @When("User enter inValidEmail {string}")
    public void user_enter_in_valid_email(String inValidEmail) {
        Driver.scrollIntoViewJS(contactPage.contactEmailTextBox);
        contactPage.contactEmailTextBox.sendKeys(inValidEmail+Keys.TAB);
    }
    @Then("User should see error message This field is invalid.")
    public void user_should_see_error_message_this_field_is_invalid() {
        Assert.assertTrue(contactPage.invalidEmailMessage.isDisplayed());
    }


    //TC06
    @When("User enter Name {string}")
    public void user_enter_name(String name) {
        Driver.scrollIntoViewJS(contactPage.contactNameTextBox);
        contactPage.contactNameTextBox.sendKeys(name);
    }
    @When("User enter valid email {string}")
    public void user_enter_valid_email(String validEmail) {
        Driver.scrollIntoViewJS(contactPage.contactEmailTextBox);
        contactPage.contactEmailTextBox.sendKeys(validEmail);
    }
    @When("User enter Subject {string}")
    public void user_enter_subject(String subject) {
        Driver.scrollIntoViewJS(contactPage.contactSubjectTextBox);
        contactPage.contactSubjectTextBox.sendKeys(subject);
    }
    @When("User enter Message {string}")
    public void user_enter_message(String message) {
        Driver.scrollIntoViewJS(contactPage.contactMessageTextBox);
        contactPage.contactMessageTextBox.sendKeys(message);
    }
    @When("User sends message")
    public void user_sends_message() {
        Driver.clickWithJS(contactPage.contactSendButton);
    }
    @Then("User should see message Your message has been received")
    public void user_should_see_message_your_message_has_been_received() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertTrue(contactPage.contactSendAlert.isDisplayed());
    }


}
