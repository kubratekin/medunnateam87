package stepdefinitions.uisteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.CommonPageElement;
import pages.US10_AppointmentPage;

import pages.LoginPage;
import pages.US10_AppointmentPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class US10_AppointmentStepDef {
    LoginPage login = new LoginPage();
   US10_AppointmentPage appointmentPage = new US10_AppointmentPage();
  //  CommonPageElements cp = new CommonPageElements();
    ReusableMethods reusableMethods = new ReusableMethods();
    CommonPageElement cp = new CommonPageElement();



    //*****


    @Given("Physician goes to Medunna page")
    public void physicianGoesToMedunnaPage() throws InterruptedException {
        Driver.navigateToUrl(ConfigReader.getProperty("https://medunna.com/"));

        Thread.sleep(1000);

    }

    @Then("Physician reaches Medunna pages to login")
    public void physicianReachesMedunnaPagesToLogin() {
        appointmentPage.Logindropdown.click();

    }

    @Then("Physician does Sign in page")
    public void physicianDoesSignInPage() {
        appointmentPage.signin.click();

    }

    @Then("Physician types {string}")
    public void physicianTypes(String username) {
        appointmentPage.usernamephysician.sendKeys(username);

    }

    @Then("Physician clicks submit")
    public void physicianClicksSubmit(String password) {
        appointmentPage.passwordphysician.sendKeys(password);

    }

    @And("Physicians goes own pages from MY PAGES tab")
    public void physiciansGoesOwnPagesFromMYPAGESTab() {
        appointmentPage.mypage.click();

    }

    @And("Physician clicks My appoitment button")
    public void physicianClicksMyAppoitmentButton() {
        appointmentPage.myappointment.click();

    }

    @And("Physician can see appoitment list")
    public void physicianCanSeeAppoitmentList() {
        String appointmentList = "Appointments";
        String actualSearch = appointmentPage.appointmentheading.getText();
        Assert.assertTrue(actualSearch.contains(appointmentList));

    }

    @Then("Physician can check startdate")
    public void physicianCanCheckStartdate() {
        String startdate = "Start DateTime";
        String actualStartDate = appointmentPage.startdate.getText();
        Assert.assertTrue((actualStartDate.contains(startdate)));

    }

    @And("Physician can check enddate")
    public void physicianCanCheckEnddate() {
        String enddate = "End DateTime";
        String actualEnddate = appointmentPage.enddate.getText();
        Assert.assertTrue(actualEnddate.contains(enddate));

    }

    @And("Physician can clicks Edit button")
    public void physicianCanClicksEditButton() throws InterruptedException {
        appointmentPage.editapp.click();
        Thread.sleep(2000);

    }

    @Then("Physician can edit the any appointment")
    public void physicianCanEditTheAnyAppointment() throws InterruptedException {
        appointmentPage.statusapp.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.click().perform();
        Thread.sleep(2000);
        Driver.selectByIndex(appointmentPage.statusapp,2);

    }

    @Then("Physician can save it")
    public void physicianCanSaveIt() throws InterruptedException {
        Driver.waitAndClick(appointmentPage.savesubmit);
        Thread.sleep(5000);
    }

    @Then("Physician can close the browser")
    public void physicianCanCloseTheBrowser() {
        Driver.closeDriver();
    }
}

/*
    @Given("Physician on the Medunna page")
    public void physician_on_the_medunna_page() throws InterruptedException {
        Driver.navigateToUrl(ConfigReader.getProperty("app_url"));

        Thread.sleep(1000);
    }

    @Then("Physician goes to login")
    public void physicianGoesToLogin() {
        appointmentPage.Logindropdown.click();
    }


    @Then("Physician navigates to Sign in page")
    public void physicianNavigatesToSignInPage() {
        appointmentPage.signin.click();
    }

    @Then("Physician enter {string}")
    public void physicianEnter(String username) {
        appointmentPage.usernamephysician.sendKeys(username);
    }

    @Then("Physician input {string}")
    public void physicianInput(String password) {
        appointmentPage.passwordphysician.sendKeys(password);
    }


/*
    @Then("Physician enter username")
    public void physicianEntersUsername() {
        Driver.navigateToUrl(ConfigReader.getProperty("username"));
    }

    @Then("Physician enter password")
    public void physicianEnterPassword() {
        Driver.navigateToUrl(ConfigReader.getProperty("password"));
    }

 /*

    @Then("Physician does submit")
    public void physicianDoesSubmit() {
        appointmentPage.submit.click();
    }

    @Given("Physicians reaches own pages from MY PAGES tab")
    public void physicians_reaches_own_pages_from_my_pages_tab() {
        appointmentPage.mypage.click();
    }

    @Given("Physician clicks My appoitment")
    public void physician_clicks_my_appoitment() {
        appointmentPage.myappointment.click();
    }

    @Given("Physician checks appoitment list")
    public void physician_checks_appoitment_list() {
        String appointmentList = "Appointments";
        String actualSearch = appointmentPage.appointmentheading.getText();
        Assert.assertTrue(actualSearch.contains(appointmentList));
    }

    @Then("Physician can see startdate")
    public void physicianCanSeeStartdate() {
        String startdate = "Start DateTime";
        String actualStartDate = appointmentPage.startdate.getText();
        Assert.assertTrue((actualStartDate.contains(startdate)));
    }


    @And("Physician can see enddate")
    public void physicianCanSeeEnddate() {
        String enddate = "End DateTime";
        String actualEnddate = appointmentPage.enddate.getText();
        Assert.assertTrue(actualEnddate.contains(enddate));
    }

    @Given("Physician anyone from list then clicks Edit button")
    public void physician_anyone_from_list_then_clicks_edit_button() throws InterruptedException {
        appointmentPage.editapp.click();
        Thread.sleep(2000);
    }


    @Then("Physician can edit the page")
    public void physicianCanEditThePage() throws InterruptedException {
/*
            appointmentPage.statusapp.click();

            Actions actions = new Actions(Driver.getDriver());
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            actions.click().perform();


        Thread.sleep(2000);
        Driver.selectByIndex(appointmentPage.statusapp,2);
    }


    @Then("Physician can save appoinment")
    public void physicianCanSaveAppoinment() throws InterruptedException {
        Driver.waitAndClick(appointmentPage.savesubmit);
        Thread.sleep(5000);
    }

    @Then("Physician closes the browser")
    public void physicianClosesTheBrowser() {
        Driver.closeDriver();
    }
    */
