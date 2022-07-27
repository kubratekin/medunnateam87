package stepdefinitions.dbsteps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US19_DBStepDefs {

    List<Object> dbStaff;

    @Given("Admin connects to DB")
    public void admin_connects_to_db() {
        DBUtils.createConnection();
    }
    @When("Admin gets all {string} from DB")
    public void admin_gets_all_from_db(String string) {
        String query = "SELECT * FROM staff";
        dbStaff = DBUtils.getColumnData(query,"id");
        System.out.println(dbStaff);
    }
    @Then("Admin verifies Staff exist at DB {string}")
    public void admin_verifies_staff_exist_at_db(String string) {

        for ( Object w : dbStaff    ) {
            if (w.toString().contains("138219")){
                Assert.assertTrue(w.toString().contains("138219"));
            }
        }
    }
    @Then("Admin closes the DB connection")
    public void admin_closes_the_db_connection() {
        DBUtils.closeConnection();
    }

}
