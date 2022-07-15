package stepdefinitions.dbsteps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;

public class US_002_DB_Stepdefs {
    static List<Object> result;
    @Given("user connects to medunna_db with valid credentials")
    public void user_connects_to_medunna_db_with_valid_credentials() {
        DBUtils.createConnection();
    }
    @When("user sends a requests to get the user details with a specific valid email address")
    public void user_sends_a_requests_to_get_the_user_details_with_a_specific_valid_email_address() {
        String query = "select email from jhi_user\n" +
                "where email = '11mariocosta5@gmail.com'";
        List<List<Object>> quaryResult = DBUtils.getQueryResultList(query);
        result = quaryResult.get(0);

    }
    @Then("user confirmes the request with the email address returns information")
    public void user_confirmes_the_request_with_the_email_address_returns_information() {
        Assert.assertEquals("11mariocosta5@gmail.com", result.get(0));
    }
    @Then("user closes database connection")
    public void user_closes_database_connection() {
    DBUtils.closeConnection();
    }
}
