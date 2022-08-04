package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.US_027_AdminPages;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class US_027_AdminPagesStepDefs {


    US_027_AdminPages kfp = new US_027_AdminPages();

    @Given("FK Admin navigates to Medunna home page")
    public void fk_admin_navigates_to_medunna_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

    }

    @Given("FK Admin clicks on human icon")
    public void fk_admin_clicks_on_human_icon() {
        Driver.waitAndClick(kfp.accountmenu,2);
        Driver.wait(2);
    }

    @Given("FK Admin clicks on sign in button under human icon at homepage")
    public void fk_admin_clicks_on_sign_in_button_under_human_icon_at_homepage() {
        Driver.waitAndClick(kfp.homePageSignIn,2);
        Driver.wait(2);

    }

    @Given("FK Admin sends username {string} and password {string} in sign in page")
    public void fk_admin_sends_username_and_password_in_sign_in_page(String username, String password) {
        Driver.waitAndSendText(kfp.adminnUserName, username,2);
        Driver.waitAndSendText(kfp.adminnPassword, password,2);

    }

    @Given("FK Admin clicks on sign in button in sign in page")
    public void fk_admin_clicks_on_sign_in_button_in_sign_in_page() {
        Driver.waitAndClick(kfp.adminnSignInButton,2);
        Driver.wait(2);

    }

    @Then("FK Admin verifies the admin page is displayed")
    public void fk_admin_verifies_the_admin_page_is_displayed() {
        Assert.assertTrue(kfp.adminPageAdministrationDropDown.isDisplayed());

    }

    @Then("FK Admin clicks on items and titles dropdown")
    public void fk_admin_clicks_on_items_and_titles_dropdown() {
        Driver.waitAndClick(kfp.adminPageItemsAndTitlesDropDown,2);
        Driver.wait(2);
    }

    @Given("FK Admin clicks on messages button")
    public void fk_admin_clicks_on_messages_button() {
        Driver.waitAndClick(kfp.adminItemsAndTitlesDropdownMessagesButton,2);
        Driver.wait(2);
    }

    @Then("FK Admin verifies the messages page is displayed")
    public void fk_admin_verifies_the_messages_page_is_displayed() {
        Assert.assertTrue(kfp.messagePageMessagesText.isDisplayed());
        Driver.wait(2);

    }

    @Then("FK Admin verifies all names, emails and messages are displayed")
    public void fk_admin_verifies_all_names_emails_and_messages_are_displayed() {
        int size = kfp.allMessagesInfo.size();
        System.out.println("size = " + size);
        List<WebElement> allDataCell = kfp.allMessagesInfo;
        List<String> data = new ArrayList<>();
        int cellNum = 1;

        List<WebElement> allRows = Driver.getDriver().findElements(By.xpath("//table//tbody//tr"));


        for (WebElement eachCellData : allRows) {
            data.add(eachCellData.getText());
            System.out.println(cellNum + ":" + eachCellData.getText().replace("View\n" +
                    "Edit\n" +
                    "Delete", ""));
            cellNum++;
        }

        List<WebElement> idList = kfp.messagesIdColumn;
        int idSize = idList.size();
        List<String> arrIdList = new ArrayList<>();
        for (WebElement eachIdCell : idList) {
            arrIdList.add(eachIdCell.getText());
        }
        System.out.println("arrIdList = " + arrIdList);

        List<WebElement> nameList = kfp.messagesNameColumn;
        int nameSize = nameList.size();
        List<String> arrNameList = new ArrayList<>();
        for (WebElement eachNameCell : nameList) {
            arrNameList.add(eachNameCell.getText());
        }
        System.out.println("arrNameList = " + arrNameList);

        List<WebElement> emailList = kfp.messagesEmailColumn;
        int emailSize = emailList.size();
        List<String> arrEmailList = new ArrayList<>();
        for (WebElement eachEmailCell : emailList) {
            arrEmailList.add(eachEmailCell.getText());
        }
        System.out.println("arrEmailList = " + arrEmailList);

        List<WebElement> subjectList = kfp.messagesSubjectColumn;
        int subjectSize = subjectList.size();
        List<String> arrSubjectList = new ArrayList<>();
        for (WebElement eachSubjectCell : subjectList) {
            arrSubjectList.add(eachSubjectCell.getText());
        }
        System.out.println("arrSubjectList = " + arrSubjectList);

        List<WebElement> messageList = kfp.messagesMessageColumn;
        int messageSize = messageList.size();
        List<String> arrMessageList = new ArrayList<>();
        for (WebElement eachMessageCell : messageList) {
            arrMessageList.add(eachMessageCell.getText());
        }
        System.out.println("arrMessageList = " + arrMessageList);

        Assert.assertTrue(idSize == nameSize && nameSize == emailSize && emailSize == subjectSize && subjectSize == messageSize);

    }

    @Then("FK Admin clicks on the create a new message button")
    public void fk_admin_clicks_on_the_create_a_new_message_button() {
        Driver.waitAndClick(kfp.creatingANewMessage, 2);

    }

    @Then("FK Admin verifies the Create or edit a Message page is displayed")
    public void fk_admin_verifies_the_create_or_edit_a_message_page_is_displayed() {
        Assert.assertTrue(kfp.createOrEditAMessagePageText.isDisplayed());

    }

    @Then("FK Admin enters name {string} into name text box")
    public void fk_admin_enters_name_into_name_text_box(String name) {
        Driver.waitAndSendText(kfp.messageNameTextBox, name);
    }

    @Then("FK Admin enters email {string} into email text box")
    public void fk_admin_enters_email_into_email_text_box(String email) {
        Driver.waitAndSendText(kfp.messageEmailTextBox, email);
    }

    @Then("FK Admin enters subject {string} into subject text box")
    public void fk_admin_enters_subject_into_subject_text_box(String subject) {
        Driver.waitAndSendText(kfp.messageSubjectTextBox, subject);

    }

    @Then("FK Admin enters message {string} into message text box")
    public void fk_admin_enters_message_into_message_text_box(String message) {
        Driver.waitAndSendText(kfp.messageMessageTextBox, message);

    }

    @Then("FK Admin clicks on save button in create or edit a message page")
    public void fk_admin_clicks_on_save_button_in_create_or_edit_a_message_page() {
        Driver.waitAndClick(kfp.createOrEditAMessagePageSaveButton);

    }

    @Then("FK Admin verifies successfully created message is displayed")
    public void fk_admin_verifies_successfully_created_message_is_displayed() {
        Driver.wait(2);
        Assert.assertTrue(kfp.successfullyCreatedANewMessageText.isDisplayed());
    }

    @Then("FK Admin clicks on the edit button in the message page")
    public void fk_admin_clicks_on_the_edit_button_in_the_message_page() {
        Driver.waitAndClick(kfp.messagePageForthEditButton);

    }

    @Then("FK Admin updates the name {string} into name text box")
    public void fk_admin_updates_the_name_into_name_text_box(String name) {
        Driver.wait(2);
        kfp.messageNameTextBox.clear();
        Driver.waitAndSendText(kfp.messageNameTextBox, name, 1);

    }

    @Then("FK Admin updates the email {string} into email text box")
    public void fk_admin_updates_the_email_into_email_text_box(String email) {
        kfp.messageEmailTextBox.clear();
        Driver.waitAndSendText(kfp.messageEmailTextBox, email, 1);
    }

    @Then("FK Admin updates the subject {string} into subject text box")
    public void fk_admin_updates_the_subject_into_subject_text_box(String subject) {
        kfp.messageSubjectTextBox.clear();
        Driver.waitAndSendText(kfp.messageSubjectTextBox, subject, 1);
    }

    @Then("FK Admin updates the message {string} into message text box")
    public void fk_admin_updates_the_message_into_message_text_box(String message) {
        kfp.messageMessageTextBox.clear();
        Driver.waitAndSendText(kfp.messageMessageTextBox, message, 1);
    }

    @Then("FK Admin verifies successfully updated message is displayed")
    public void fk_admin_verifies_successfully_updated_message_is_displayed() {
        Driver.wait(2);
        Assert.assertTrue(kfp.succesfullyUpdatedMessageText.isDisplayed());
    }

    @Then("FK Admin clicks on the delete button in the message page")
    public void fk_admin_clicks_on_the_delete_button_in_the_message_page() {
        Driver.waitAndClick(kfp.messagePageForthDeleteButton);

    }

    @Then("FK Admin verifies the delete confirmation toast container is displayed")
    public void fk_admin_verifies_the_delete_confirmation_toast_container_is_displayed() {
        Driver.wait(2);
        Assert.assertTrue(kfp.deleteConfirmationToastContainerText.isDisplayed());
    }

    @Then("FK Admin clicks the delete button in the toast container")
    public void fk_admin_clicks_the_delete_button_in_the_toast_container() {
        Driver.waitAndClick(kfp.deleteConfirmationToastContainerDeleteButton, 1);
    }

    @Then("FK Admin verifies successfully deleted message is displayed")
    public void fk_admin_verifies_successfully_deleted_message_is_displayed() {
        Driver.wait(2);
        Assert.assertTrue(kfp.succesfullyDeletedMessageText.isDisplayed());

    }
}






