package stepdefinitions.dbsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

public class US028_DB_StepDefs {



    @Given("admin connect to the database")
    public void admin_connect_to_the_database() {
        DBUtils.createConnection();
    }

    @Given("admin get the {string} from {string} table")
    public void admin_get_the_from_table(String string, String string2) {
        String query = "select name from country";
        DBUtils.executeQuery(query);
    }


    @Then("admin verify {string} table {string} column contain {string}")
    public void admin_verify_table_column_contain(String table, String column, String name) {
        List<Object> allColumnData =  DBUtils.getColumnData("select * from "+table,column);
        System.out.println(allColumnData);
        Assert.assertTrue(allColumnData.contains(name));
        System.out.println(name);
    }

    @Then("admin close db connection")
    public void admin_close_db_connection() {
        DBUtils.closeConnection();
    }

}
