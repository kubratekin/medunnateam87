package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

public class US01_RegistrantDBSteps {

    List<Object> ssnList;

    @Given("user sets a connection with database")
    public void userSetsAConnectionWithDatabase() {
        DBUtils.getConnection();

    }
    @And("user selects all {string} column data")
    public void userSelectsAllColumnData(String ssn) {
        String query = "select * from jhi_user";
        ssnList= DBUtils.getColumnData(query,ssn);
    }

    @Then("user validates registrant {string} ids with database")
    public void userValidatesRegistrantIdsWithDatabase(String ssn) {
      //  System.out.println("ssnList = " + ssnList);
        Assert.assertTrue(ssnList.contains(ssn));
    }

}
