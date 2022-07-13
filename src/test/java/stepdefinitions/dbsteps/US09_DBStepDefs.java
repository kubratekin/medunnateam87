package stepdefinitions.dbsteps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.ConfigReader;
import utilities.DBUtils;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class US09_DBStepDefs {
    List<Map<String, Object>> patientInfoTable;
    public static int newID;
    Connection connection;
    public static int check;

    @Given("User connects to DB")
    public void user_connects_to_db() {
        DBUtils.createConnection();
    }
    @When("User gets information from DB")
    public void user_gets_information_from_DB() {
        String query = "SELECT ssn, first_name, last_name, email FROM jhi_user WHERE EXISTS (SELECT * FROM patient WHERE patient.user_id = jhi_user.id)";
        patientInfoTable= DBUtils.getQueryResultMap(query);
//        System.out.println(patientInfoTable);
//        System.out.println(patientInfoTable.size());

    }
    @Then("User verifies that patients exists in DB {string} {string} {string} {string}")
    public void user_verifies_that_patients_exists_in_db(String lastname, String firstname, String email, String ssn) {
        boolean flag=false;
        for (Map<String,Object> each : patientInfoTable ) {
            if (each.get("last_name").equals(lastname)&&
                each.get("first_name").equals(firstname)&&
                each.get("email").equals(email)&&
                each.get("ssn").equals(ssn)) {
                flag=true;
                System.out.println(each);
            }
        }
        Assert.assertTrue(flag);
    }
    @Then("User closes the DB connection")
    public void user_closes_the_db_connection() {
        DBUtils.closeConnection();
    }

//  TC12
    @When("User creates a new patient in the patient table using the DB")
    public void userCreatesANewPatientInThePatientTableUsingTheDB() {
        String queryID = "SELECT id FROM patient ORDER BY id ASC";
        List<Object> idList = DBUtils.getColumnData(queryID,"id");
        String lastID =  idList.get(idList.size()-1).toString();
        System.out.println(lastID);
        newID = Integer.parseInt(lastID)+1;
        String query = "INSERT INTO patient ( id, email, first_name, gender, phone, last_name, created_by) VALUES ('" +newID+ "', 'team87@qa.com', 'team87NewPatient', 'male', '123-456-7890', 'team87New', 'DB') RETURNING *";
        DBUtils.executeQuery(query);
        System.out.println(newID);
    }

    @Then("User verifies that new patient has been added to the DB")
    public void userVerifiesThatNewPatientHasBeenAddedToTheDB() {
        String query = "Select * FROM patient WHERE first_name= 'team87NewPatient' AND email='team87@qa.com'";
        Map<String,Object> newPatient = DBUtils.getRowMap(query);
        System.out.println(newPatient);
        Assert.assertEquals("team87NewPatient",newPatient.get("first_name"));
        Assert.assertEquals("team87New",newPatient.get("last_name"));
        Assert.assertEquals("team87@qa.com",newPatient.get("email"));
        Assert.assertEquals("male",newPatient.get("gender"));
    }

//  TC13
    @When("User deletes a patient from patient table")
    public void userDeletesAPatientFromPatientTable() throws SQLException {
        String query = "DELETE FROM patient WHERE id = '" +newID+ "'";
        System.out.println(newID);
        connection = DriverManager.getConnection(ConfigReader.getProperty("db_credentials_url"),
                                                 ConfigReader.getProperty("db_username"),
                                                 ConfigReader.getProperty("db_password"));
        PreparedStatement stmt = connection.prepareStatement(query);
        check = stmt.executeUpdate();

    }

    @Then("User verifies that patient has been deleted")
    public void userVerifiesThatPatientHasBeenDeleted() {
        Assert.assertTrue(check>0);
    }
}
