package stepdefinitions.apisteps;


import io.cucumber.java.en.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pojos.US09_PatientsPojo;
import pojos.US09_UserPojo;
import utilities.Authentication;
import utilities.ConfigReader;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import utilities.API_Utils;

import static io.restassured.RestAssured.given;

public class US09_API_StepDefs extends Authentication{
/*
{
    "createdBy": "team87delete2",
    "createdDate": "2022-07-05T15:55:39.763502Z",
    "id": 107942,
    "firstName": "team87del2",
    "lastName": "team87",
    "birthDate": null,
    "phone": "123-456-7890",
    "gender": null,
    "bloodGroup": null,
    "adress": null,
    "email": "aa@b.com",
    "description": null,
    "user": {
        "createdBy": "anonymousUser",
        "createdDate": "2022-07-05T15:54:05.875250Z",
        "id": 108995,
        "login": "team87delete2",
        "firstName": "team87del2",
        "lastName": "team87",
        "email": "aa@b.com",
        "activated": true,
        "langKey": "en",
        "imageUrl": null,
        "resetDate": null,
        "ssn": "872-22-2222"
    },
    "appointments": null,
    "inPatients": null,
    "country": null,
    "cstate": null
}
 */
    static RequestSpecification spec = API_Utils.spec;
    static Response response;
    static Map<String,Object> expectedDataMap;
    static US09_PatientsPojo[] patients;
    static US09_UserPojo user;
    static US09_PatientsPojo patient;

    @Given("User sets the path params to read patient info")
    public void user_sets_the_path_params_to_read_patient_info() {
        //RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first","api","second","patients");
    }
    @Given("User sets expected data")  // For making 1 patient assertion use this. Use patient_endpoint as endpoint. It will search with ID.
    public void user_sets_expected_data() {
        expectedDataMap=new HashMap<>();
        expectedDataMap.put("firstName","team87del2");
        expectedDataMap.put("lastName","team87");
        expectedDataMap.put("email","aa@b.com");
        expectedDataMap.put("ssn","872-22-2222");
    }
    @When("User send get request for patient info and get response")
    public void user_send_get_request_for_patient_info_and_get_response() {
        response = given().headers("Authorization","Bearer "+generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when()
                .get(ConfigReader.getProperty("patients_endpoint"));
//        response.prettyPrint();
    }
    @Then("User validates patient info {string} {string} {string} {string} .")
    public void userValidatesPatientInfo(String firstname, String lastname, String email, String ssn) {
        response.then().assertThat().statusCode(200);
        patients = response.as(US09_PatientsPojo[].class);
        boolean flag = false;
        for (US09_PatientsPojo us09_patientsPojo : patients) {
            if (us09_patientsPojo.getFirstName().equals(firstname) &&
                    us09_patientsPojo.getLastName().equals(lastname) &&
                    us09_patientsPojo.getEmail().equals(email) &&
                    us09_patientsPojo.getUser().getSsn().equals(ssn)) {
                flag = true;
                System.out.println(us09_patientsPojo);
            }
        }
        Assert.assertTrue(flag);
    }


//    @When("User creates new patient using Post request firstname {string} lastname {string} email {string} ssn {string}")
//    public void userCreatesNewPatientUsingPostRequestFirstnameLastnameEmailSsn(String firstname, String lastname, String email, String ssn) throws IOException {
//        user= new US09_UserPojo(firstname,lastname,"team87apiPatient",ssn);
//        patient= new US09_PatientsPojo(firstname,lastname,"1234567890",email);
//        response = given().headers("Authorization","Bearer "+generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
//                        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
//                contentType(ContentType.JSON).body(patient).when().post(ConfigReader.getProperty("patient_endpoint"));
//        response.prettyPrint();
//        response.then().assertThat().statusCode(201);
//    }

   /*

    @Given("User sets the path params to create and update patient info")
    public void userSetsThePathParamsToCreateAndUpdatePatientInfo() {
        spec.pathParams("first","api","second","patients");
    }

    @Given("User sends Put request to update patient info firstname {string} lastname {string} email {string} ssn {string}")
    public void user_sends_put_request_to_update_patient_info_firstname_lastname_email_ssn(String firstName, String lastName, String email, String ssn) {
        user= new US09_UserPojo(firstName,lastName,"team87apiPatient",ssn);
        patient= new US09_PatientsPojo(firstName,lastName,"1234567891",email,user);
        response = given().headers("Authorization","Bearer "+generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
                contentType(ContentType.JSON).body(patient).when().put(ConfigReader.getProperty("patient_endpoint"));
        response.then().assertThat().statusCode(200);
    }

    */

//    @Then("User sends delete request and verifies that patient id {string} has been deleted.")
//    public void user_sends_delete_request_and_verifies_that_patient_id_has_been_deleted(String id) {
//        response = given().headers("Authorization","Bearer "+generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
//                "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).contentType(ContentType.JSON)
//                .when().delete(ConfigReader.getProperty("api_patients_id_endpoint"));
//        response.then().assertThat().statusCode(200);
//
//    }



}
