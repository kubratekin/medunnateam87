package stepdefinitions.uisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.US23_PaymentInvoiceByStaffPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US23_PaymentInvoiceByStaffStepDefs {

    US23_PaymentInvoiceByStaffPage paymentInvoiceByStaffPage = new US23_PaymentInvoiceByStaffPage();

    @Given("Staff goes to medunna.com")
    public void staff_goes_to_https_medunna_com() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @When("Staff click Sign in Link")
    public void staff_click_sign_in_link() {
        Driver.wait(1);
        Driver.waitAndClick(paymentInvoiceByStaffPage.signInLogo);
        Driver.wait(1);
        Driver.waitAndClick(paymentInvoiceByStaffPage.signIn);
    }
    @When("Provides the username {string} textbox")
    public void provides_the_username_textbox(String username) {
        Driver.wait(1);
        Driver.waitAndSendText(paymentInvoiceByStaffPage.username,username);
    }
    @When("Provides the password {string} textbox")
    public void provides_the_password_textbox(String password) {
        Driver.wait(1);
        Driver.waitAndSendText(paymentInvoiceByStaffPage.password,password);
    }
    @When("Clicks the Sign in button")
    public void clicks_the_sign_in_button() {
        Driver.wait(1);
        Driver.waitAndClick(paymentInvoiceByStaffPage.loginButton);
    }
    @When("Clicks the My Page and Search Patient")
    public void clicks_the_my_page_and_search_patient() {
        Driver.wait(1);
        Driver.waitAndClick(paymentInvoiceByStaffPage.myPages);
        Driver.waitAndClick(paymentInvoiceByStaffPage.searchPatient);
    }
    @When("Search patient with SSN {string}")
    public void search_patient_with_ssn(String ssn) {
        Driver.wait(1);
        Driver.waitAndSendText(paymentInvoiceByStaffPage.ssnSerchBox,ssn,2);
        Driver.wait(1);
    }
    @When("Clicks Show Appointments button")
    public void clicks_show_appointments_button() {
        Driver.wait(1);
        Driver.waitAndClick(paymentInvoiceByStaffPage.showAppointmentsButton);

    }
    @When("Clicks Payment Invoice Proccess button")
    public void clicks_payment_invoice_proccess_button() {
        try {
            Driver.waitAndClick(paymentInvoiceByStaffPage.paymentInvoiceProccessButton);
        }catch (Exception e){
            e.printStackTrace();
        }
//        Assert.assertTrue(paymentInvoiceByStaffPage.paymentInvoiceProccessButton.isDisplayed());
//        Driver.wait(1);

    }
    @Then("Verify PAYMENT DETAIL title")
    public void verify_payment_detail_title() {
        Driver.wait(2);
        Assert.assertTrue(paymentInvoiceByStaffPage.paymentDetailTitle.isDisplayed());
    }
    @And("Close the browser")
    public void close_the_browser() {
        Driver.closeDriver();
    }

//-------------TC02 -------------------
    @Then("Verify the status as completed")
    public void verify_the_status_as_completed() {
        Assert.assertEquals(paymentInvoiceByStaffPage.appointmentsStatus.getText(),"COMPLETED");
    }
    @Then("Verify Create Invoice button is visible")
    public void verify_create_invoice_button_is_visible() {
        Driver.wait(1);
        Assert.assertTrue(paymentInvoiceByStaffPage.createInvoiceButton.isDisplayed());
    }

//----------------TC03----------------

    @Then("Verify the status as cancelled")
    public void verify_the_status_as_cancelled() {
        System.out.println(paymentInvoiceByStaffPage.appointmentsStatus.getText());
        Assert.assertEquals(paymentInvoiceByStaffPage.appointmentsStatus.getText(),"CANCELLED");
    }

//---------------TC04-------------------
    @Then("Verify Exam Fee, Test Item Price, Create Invoice button")
    public void verify_exam_fee_test_item_price_create_invoice_button() {
        Assert.assertTrue(paymentInvoiceByStaffPage.examFeeTitle.isDisplayed());
        Assert.assertTrue(paymentInvoiceByStaffPage.testItemFeeTitle.isDisplayed());
        Assert.assertTrue(paymentInvoiceByStaffPage.createInvoiceButton.isDisplayed());
    }

//-----------------TC05---------------
    @When("Clicks Show Invoice button")
    public void clicks_show_invoice_button() {
        Driver.waitAndClick(paymentInvoiceByStaffPage.showInvoiceButton);
    }
    @Then("Verify INVOICE title is visible")
    public void verify_invoice_title_is_visible() {
        Assert.assertTrue(paymentInvoiceByStaffPage.invoiceTitleInInvoicePage.isDisplayed());
    }

}
