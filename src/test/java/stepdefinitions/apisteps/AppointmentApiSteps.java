package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Appointment;
import utilities.ConfigReader;

import java.util.Arrays;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class AppointmentApiSteps {
    Response response;

    Appointment[] appointments;

    @Given("user sends a get request for users' data")
    public void user_sends_a_get_request_for_users_data() {
        response = given().headers("Authorization", "Bearer " + ConfigReader.getProperty("token"), "ContentType",
                ContentType.JSON, "Accept", ContentType.JSON).when().get(ConfigReader.getProperty("users_api_url"));


        response.prettyPrint();
    }
    @Given("user deserializes the users' data to java")
    public void user_deserializes_the_users_data_to_java() throws Exception {

        ObjectMapper obj = new ObjectMapper();

        // appointments = obj.readValue(response.asString(),Appointment[].class);

        appointments = obj.readValue(response.asString(),Appointment[].class);


        System.out.println("Size of the actual elements :" + appointments.length);

        boolean flag = false;

        for (int i = 0; i < appointments.length; i++) {

            if ("147-25-0613".contains(appointments[i].getSsn())) {
                flag = true;
            }
        }

        assertTrue(flag);

        for (int i = 0; i < appointments.length; i++) {
            System.out.println("name " + (i + 1) + " : "+appointments[i].getFirstName());

            System.out.println("lastname " + (i + 1) + " :"+appointments[i].getLastName());

        }

    }

    @Then("user saves the users' data to correspondent files and validates")
    public void user_saves_the_users_data_to_correspondent_files_and_validates()
    {

                                                                               }

    }



