package stepdefinitions.apisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.US28_PojoCreateCountry;
import pojos.US28_PojoCreateStateCity;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;

public class US28_ApiStepDefs {

    RequestSpecification spec;
    Response response;
    US28_PojoCreateCountry expectedData;
    Map<String,Object> country;




    @Given("admin sets the path params to create a country")
    public void admin_sets_the_path_params_to_create_a_country() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "countries");


    }

    @Given("admin set the expected data")
    public void admin_set_the_expected_data() {

        expectedData = new US28_PojoCreateCountry("umustistan11");

    }

    @Given("admin sends POST request and get the response")
    public void admin_sends_post_request_and_get_the_response() {
        response = given().spec(spec).headers("Authorization", "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(expectedData).
                when().post("/{first}/{second}");

        response.prettyPrint();


    }

    @Then("admin validates the created country")
    public void admin_validates_the_created_country() {
        US28_PojoCreateCountry actualData = response.as(US28_PojoCreateCountry.class);

        assertEquals(201, response.getStatusCode());

        assertEquals(expectedData.getName(), actualData.getName());


    }

    //api3

//    static List<US28_PojoCreateStateCity>  expectedDataa;
//    static US28_PojoCreateCountry country;
//    static US28_PojoCreateStateCity stateCity;

    @Given("admin sets the path params to create a stateCity")
    public void admin_sets_the_path_params_to_create_a_state_city() {
        //spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        //spec.pathParams("first", "api", "second", "c-states", "third", "initial");

    }

    @Given("admin setss the exxpected DData")
    public void admin_setss_the_exxpected_ddata() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "c-states", "third", "initial");

        Map<String,Object> country = new HashMap<>();
        Map<String,Object> state = new HashMap<>();
        country.put("name","umustistan11");
        country.put("id", 142566);
        state.put("name","adalar");
        state.put("country", country);
        Object[] data = {state};

        response = given().spec(spec).headers("Authorization", "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(data).
                when().post("/{first}/{second}/{third}");

        response.prettyPrint();


//        country= new US28_PojoCreateCountry("umustistan11", 142566);
//        stateCity= new US28_PojoCreateStateCity("adalar", country);
//        expectedDataa.add(stateCity);
    }


    @Given("admin sendss POST requestt and Get the response")
    public void admin_sendss_post_requestt_and_get_the_response() {
//        response = given().spec(spec).headers("Authorization", "Bearer " + generateToken(),
//                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
//                body(expectedDataa).
//                when().post("/{first}/{second}/{third}");
//
//        response.prettyPrint();


    }

    @Then("admin validates the created state")
    public void admin_validates_the_created_state() {
//        US28_PojoCreateStateCity actualData = response.as(US28_PojoCreateStateCity.class);
//        assertEquals(200, response.getStatusCode());
//
//        assertEquals(expectedData.getName(), actualData.getName());

    }

    //api2



    @Given("admin sets the path params to read country")
    public void admin_sets_the_path_params_to_read_country() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "countries", "third", "142558");


    }


    @Given("admin sends a get request for created country")
    public void admin_sends_a_get_request_for_created_country() {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(),
                "Content-Type", ContentType.JSON,
                "Accept", ContentType.JSON
        ).when().get(ConfigReader.getProperty("countries_endpoint"));

        response.prettyPrint();


    }


    @Then("admin validates the country")
    public void admin_validates_the_country() {
        response.then().assertThat().statusCode(200);

        assertTrue(response.asString().contains("umustistan7"));

    }


    //api05

    @Given("admin sets the path params to update a country")
    public void admin_sets_the_path_params_to_update_a_country() {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "countries");

    }
    @Given("admin setss the exxpected Dataa")
    public void admin_setss_the_exxpected_dataa() {
        country = new HashMap<>();
        country.put("name", "umutistan_umutistan");
        country.put("id", "142555");
    }


    @Given("admin sendss Put requestt and Get the response")
    public void admin_sendss_put_requestt_and_get_the_response() {
        response = given().spec(spec).headers("Authorization", "Bearer " + generateToken(),
                        "Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                body(country).
                when().put("/{first}/{second}");

        response.prettyPrint();
    }


    @Then("admin validates the updated country")
    public void admin_validates_the_updated_country() {
        Map<String, Object> actualDataMap = response.as(HashMap.class);

        assertEquals(country.get("name"), actualDataMap.get("name"));
    }



}
