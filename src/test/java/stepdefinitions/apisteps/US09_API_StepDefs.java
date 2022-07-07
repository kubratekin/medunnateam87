package stepdefinitions.apisteps;

import baseUrl.Medunna;
import io.cucumber.java.en.*;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class US09_API_StepDefs extends Medunna{

/*
[
    {
        "activated": true,
            "authorities": [
        "string"
    ],
        "createdBy": "string",
        "createdDate": "2022-07-07T15:45:56.882Z",
        "email": "string",
        "firstName": "string",
        "id": 0,
        "imageUrl": "string",
        "langKey": "string",
        "lastModifiedBy": "string",
        "lastModifiedDate": "2022-07-07T15:45:56.882Z",
        "lastName": "string",
        "login": "string",
        "ssn": "string"
    }
]
 */
        String ssn;
        String firstName;
        String lastName;
        String login;
        String email;
        int id;


    @Given("User sets the path params to read patient info")
    public void user_sets_the_path_params_to_read_patient_info() {
        spec.pathParams("first","patients","second","search");
    }
    @Given("User sets expected data")
    public void user_sets_expected_data() {

        Map<String,Object> expectedDataMap = new HashMap<>();

    }
    @When("User send get request for patient info and get response")
    public void user_send_get_request_for_patient_info_and_get_response() {



    }
    @Then("User validates patient info.")
    public void user_validates_patient_info() {



    }




}
