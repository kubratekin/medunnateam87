package stepdefinitions.apisteps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.US17_Pojo;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;

public class US17_ApiStepDefs {


    RequestSpecification spec;
    Response response;
    US17_Pojo expectedData;


    @Given("admin sets the path params to create test items")
    public void admin_sets_the_path_params_to_create_test_items() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first","api", "second","c-test-items");
    }

    @When("admin sets the expected data")
    public void admin_sets_the_expected_data() {

        expectedData = new US17_Pojo("C_VITAMIN_87_C", "87_C_VITAMIN_87", 100, 170,80);
    }

    @When("admin sends post request and get the response")
    public void admin_sends_post_request_and_get_the_response() {

        response = given().spec(spec).headers("Authorization", "Bearer " + generateToken("vusalgasimov","vusalgasimov"),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(expectedData).
                when().post("/{first}/{second}");

        response.prettyPrint();
    }

    @Then("admin validates the test items")
    public void admin_validates_the_test_items() {

        assertEquals(201, response.getStatusCode());

        US17_Pojo actualData = response.as(US17_Pojo.class);

        assertEquals(expectedData.getName(),actualData.getName());
        assertEquals(expectedData.getDescription(),actualData.getDescription());
        assertEquals(expectedData.getPrice(),actualData.getPrice());
        assertEquals(expectedData.getDefaultValMax(),actualData.getDefaultValMax());
        assertEquals(expectedData.getDefaultValMin(),actualData.getDefaultValMin());
    }

// Api02

    @Given("admin sets the path params to read test items")
    public void admin_sets_the_path_params_to_read_test_items() {

        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first","api", "second","c-test-items","third", "143655");
    }


    @And("admin sends a get request for created test item")
    public void admin_sends_a_get_request_for_created_test_item() {

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken("vusalgasimov","vusalgasimov"),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("adminendpoint"));

        response.prettyPrint();
    }

    @Then("admin validates the test item")
    public void admin_validates_the_test_item() throws JsonProcessingException {

        response.then().assertThat().statusCode(200);

        assertTrue(response.asString().contains("87_CERATINE_87"));
    }
}
