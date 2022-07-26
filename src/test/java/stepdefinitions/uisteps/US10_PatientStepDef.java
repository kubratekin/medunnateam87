package stepdefinitions.uisteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.US10_PatientPage;
import pages.US10_PatientPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
public class US10_PatientStepDef {
    LoginPage login = new LoginPage();
    US10_PatientPage patientPage =new US10_PatientPage();
    ReusableMethods reusableMethods = new ReusableMethods();
    @Given("Physician reaches Medunna page")
    public void physicianReachesMedunnaPage() throws InterruptedException {
        Driver.navigateToUrl(ConfigReader.getProperty("app_url"));
        Thread.sleep(1000);
    }
    @Then("Physician reaches to login")
    public void physicianReachesToLogin() {
        patientPage.Logindropdown.click();
    }
    @Then("Physician  click Sign in page")
    public void physicianClickSignInPage() {
        patientPage.signin.click();
    }
    @Then("Physician inputs {string}")
    public void physicianInputs(String username) { patientPage.usernamephysician.sendKeys(username);}
    @Then("Physician enters {string}")
    public void physicianEnters(String password) { patientPage.passwordphysician.sendKeys(password);
    }
    @Then("Physician click submit")
    public void physicianClickSubmit() throws InterruptedException {
        patientPage.submit.click();
        Thread.sleep(3000);
    }
    @And("Physicians reaches  MY PAGES tab")
    public void physiciansReachesMYPAGESTab() { patientPage.mypage.click(); }
    @Given("Physician clicks My patients")
    public void physician_clicks_my_patients() {
        patientPage.mypatients.click();
    }
    @Given("Physician checks patient list")
    public void physician_checks_patient_list() throws InterruptedException {
        String patientList ="Patients";
        String actualPatients=patientPage.patientheading.getText();
        Assert.assertTrue(actualPatients.contains(patientList));
        Thread.sleep(3000);
    }
    @Then("Physician close the browser")
    public void physicianCloseTheBrowser() {
        Driver.closeDriver();
    }
}