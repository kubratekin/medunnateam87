package stepdefinitions.apisteps;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.ConfigReader;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;
import utilities.Authentication;

import static io.restassured.RestAssured.*;


public class US19_API_StaffStepDef extends Authentication{


    Map<String,Object> expectedData;
    Response response;


    @Given("Admin set the params for staff info")
    public void admin_set_the_params_for_staff_info() {
        RequestSpecification spec = new RequestSpecBuilder().
                setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("param1","api","param2","staff","param3","138219");

    }
    @Given("Admin set expected data")
    public void admin_set_expected_data() {
        expectedData = new HashMap<>();
        expectedData.put("firstName", "team87staff001");
        expectedData.put("lastName", "Staff");
        expectedData.put("birthDate", "2022-07-24T21:00:00Z");
        expectedData.put("phone","111-223-1930");
        expectedData.put("gender", "MALE");
        expectedData.put("bloodGroup", "Apositive");
        expectedData.put("adress", "1232 Sandia ave. Fremont");
        expectedData.put("decription", "This is test");


    }
    @Given("Admin set get request for staff and response")
    public void admin_set_get_request_for_staff_and_response() {

        response = given().headers(
                "Authorization","Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when().
                get(ConfigReader.getProperty("staff_endpoint"));
        //        response.prettyPrint();

    }
    @Then("Admin validates staff info")
    public void admin_validates_staff_info() {
        response.then().assertThat().statusCode(200);
        Map<String, Object> actualData = response.as(HashMap.class);
        System.out.println(expectedData);
        System.out.println(actualData);
        Assert.assertEquals(expectedData.get("firstName"),actualData.get("firstName"));
        Assert.assertEquals(expectedData.get("lastName"), actualData.get("lastName"));
        Assert.assertEquals(expectedData.get("birthDate"), actualData.get("birthDate"));
        Assert.assertEquals(expectedData.get("phone"), actualData.get("phone"));
        Assert.assertEquals(expectedData.get("gender"), actualData.get("gender"));
        Assert.assertEquals(expectedData.get("bloodGroup"), actualData.get("bloodGroup"));
        Assert.assertEquals(expectedData.get("adress"), actualData.get("adress"));



    }

}
