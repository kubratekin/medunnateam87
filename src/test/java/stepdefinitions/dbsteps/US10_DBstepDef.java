package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US10_DBstepDef {

    List< Object > dbAppointment;

    @Given("user creates a connection with DB using {string} and {string}, {string}")
    public void userCreatesAConnectionWithDBUsingAnd(String url, String username, String password) {
    }


    @Given("user send the to DB  {string} and {string}")
    public void userSendTheToDBAnd(String query, String columnName) {
        dbAppointment= DBUtils.getColumnData(query,columnName);
        System.out.println(dbAppointment);
    }

  //  @And("user saves the DB records to correspondent files {string} and {string}")
  //  public void userSavesTheDBRecordsToCorrespondentFilesAnd() {
  //      userSavesTheDBRecordsToCorrespondentFilesAnd(dbAppointment);
  //  }

    @Then("user validates DB data")
    public void userValidatesDBData() {
        List<String> expectedstatus = new ArrayList<>();
        expectedstatus.add("COMPLETED");
        expectedstatus.add("PENDING");
    }



}
