package stepdefinitions.apisteps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.Messages;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

import static stepdefinitions.apisteps.Authentication.generateToken;
import static utilities.WriteToTxt.saveMessagesData;

public class US_027ApiStepDefs {

    static Response response;
    static Messages messages = new Messages();
    @Given("FK Admin set the path params for message")
    public void fk_admin_set_the_path_params_for_message() {
        // spec = new RequestSpecBuilder().setBaseUri(ConfigurationReader.getProperty("medunnaUrl")).build();
        spec.pathParams("1", "api", "2", "c-messages");

    }
    @Given("FK Admin enters expected data for message")
    public void fk_admin_enters_expected_data_for_message() {
        messages.setName("Admin ApiMessage");
        messages.setEmail("AdminApiMessage@yahoo.com");
        messages.setSubject("AdminMessageFromApi");
        messages.setMessage("Admin Sends Message From Api");

    }
    @Given("FK Admin sends POST request and receives response for message")
    public void fk_admin_sends_post_request_and_receives_response_for_message() {
        response = given().spec(spec).header("Authorization", "Bearer " + generateToken())
                .contentType(ContentType.JSON).body(messages).when().post("/{1}/{2}");
        //  response.prettyPrint();

        Response response2 = given().spec(spec).auth().oauth2(generateToken())
                .contentType(ContentType.JSON).body(messages).when().post("/{1}/{2}");
        //  response2.prettyPrint();

    }

    @Then("FK Admin save all aappii information for message")
    public void fk_admin_save_all_aappii_information_for_message() {
        try {
            response.then().statusCode(201);
            saveMessagesData(messages);
            System.out.println(messages.toString());
        } catch (Exception e) {

        }

    }
    @Then("FK Admin verify aappii records for message")
    public void fk_admin_verify_aappii_records_for_message() throws JsonProcessingException {

        response.then().statusCode(201);
        response.prettyPrint();
        ObjectMapper obj = new ObjectMapper();
        Messages actualMessages = obj.readValue(response.asString(), Messages.class);
        System.out.println("actualMessages = " + actualMessages);
        Assert.assertEquals(messages.getName(), actualMessages.getName());
        Assert.assertEquals(messages.getEmail(), actualMessages.getEmail());
        Assert.assertEquals(messages.getSubject(), actualMessages.getSubject());
        Assert.assertEquals(messages.getMessage(), actualMessages.getMessage());

    }
}





