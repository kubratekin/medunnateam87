package stepdefinitions.uisteps;

// 31-23-4433

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.*;

public class US22StepDefs {

     US22Page us22Page =new US22Page();

    @Given("User staff goes to Medunna HomePage")
    public void userStaffGoesToMedunnaHomePage()  throws InterruptedException {
        Driver.navigateToUrl(ConfigReader.getProperty("https://medunna.com/"));
    }


    @Then("User staff logs on")
    public void userStaffLogsOn() {
        us22Page.Logindropdown.click();

    }

    @Then("User staff sign in page")
    public void userStaffSignInPage() {
        us22Page.signin.click();

    }

    @Then("User staff types {string}")
    public void userStaffTypes(String username) {
        us22Page.usernamestaff.sendKeys(username);
    }

    @Then("User staff types  the {string}")
    public void userStaffTypesThe(String password) throws InterruptedException {
        us22Page.passwordstaff.sendKeys(password);
        Thread.sleep(2000);
    }

    @Then("User submit user info")
    public void userSubmitUserInfo() {
        us22Page.submituser.click();

    }

    @Then("User staff clicks on My page tab")
    public void userStaffClicksOnMyPageTab() {
        us22Page.mypage.click();

    }

    @Then("User staff clicks on Search Patient")
    public void userStaffClicksOnSearchPatient() {
        us22Page.searchpatient.click();

    }

    @Then("User staff types patient SSN in blanks")
    public void userStaffTypesPatientSSNInBlanks() throws InterruptedException {
        us22Page.ssnblank.sendKeys("231-23-4433");
        Thread.sleep(2000);


    }

    @Then("User staff clicks on Show Appointments")
    public void userStaffClicksOnShowAppointments() {
        us22Page.showapp.click();

    }

    @Then("User staff clicks on Show Tests")
    public void userStaffClicksOnShowTests() {
        us22Page.showtest.click();

    }

    @Then("User staff clicks on View Results")
    public void userStaffClicksOnViewResults() {
        us22Page.viewresult.click();

    }

    @Then("User staff clicks on Edit button")
    public void userStaffClicksOnEditButton() {
        us22Page.testedit.click();

    }

    @Then("User staff can see result title")
    public void userStaffCanSeeResultTitle() {
        Assert.assertTrue(us22Page.testtitle.getText().contains("Create or edit a Test Result"));


    }
    @Then("User staff types result value")
    public void userStaffTypesResultValue() throws InterruptedException { us22Page.resultform.sendKeys("4.1");
        Thread.sleep(2000);
    }

    @And("User staff types result description")
    public void userStaffTypesResultDescription() throws InterruptedException {
        us22Page.description.sendKeys("regular interval")   ;
    Thread.sleep(2000);
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);



    }

    @Then("User staff can see test item")
    public void userStaffCanSeeTestItem() throws InterruptedException {
        Assert.assertEquals("1408:Hemoglobin",us22Page.testitem.getText());



    }


    @Then("User staff save the records")
    public void userStaffSaveTheRecords() throws InterruptedException {
        Thread.sleep(2000);
    }



    @And("user staff closes the browser")
    public void userStaffClosesTheBrowser() {
        Driver.closeDriver();
    }


//github
}
