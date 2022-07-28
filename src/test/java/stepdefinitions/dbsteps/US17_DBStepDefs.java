package stepdefinitions.dbsteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

public class US17_DBStepDefs {

    @Given("admin connects to the database")
    public void admin_connects_to_the_database() {

        DBUtils.createConnection();
    }

    @And("admin gets the {string} from {string} table")
    public void admin_gets_the_from_table(String id, String c_test_item) {

        String query = "select name from c_test_item";
        DBUtils.executeQuery(query);
    }

    @Then("admin verify {string} table {string} column contains {string}")
    public void admin_verify_table_column_contains(String table, String column, String name) {

        List<Object> allColumnData =  DBUtils.getColumnData("select * from "+table,column);
        System.out.println(allColumnData);
        Assert.assertTrue(allColumnData.contains(name));
        System.out.println(name);
    }


    @Then("admin closes db connection")
    public void admin_closes_db_connection() {

        DBUtils.closeConnection();
    }

}
