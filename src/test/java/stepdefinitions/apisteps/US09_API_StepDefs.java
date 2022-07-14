package stepdefinitions.apisteps;

import baseUrl.Medunna;
import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.ApiUtils;
import utilities.Authentication;
import utilities.ConfigReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.*;

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
    Response response;
    Map<String,Object> expectedDataMap;
    List patients;

    @Given("User sets the path params to read patient info")
    public void user_sets_the_path_params_to_read_patient_info() {
        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first","api","second","patients");
    }

    @Given("User sets expected data")
    public void user_sets_expected_data() {
        expectedDataMap=new HashMap<>();
        expectedDataMap.put("firstName","team87del2");
        expectedDataMap.put("lastName","team87");
        expectedDataMap.put("email","aa@b.com");
        expectedDataMap.put("ssn","872-22-2222");
    }

    @When("User send get request for patient info and get response")
    public void user_send_get_request_for_patient_info_and_get_response() {
        response = given().headers("Authorization","Bearer "+generateToken(),
                                    "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when()
                .get(ConfigReader.getProperty("patients_endpoint"));
//        response.prettyPrint();
    }

    @Then("User validates patient info {string} {string} {string} {string}.")
    public void userValidatesPatientInfo(String firstname, String lastname, String email, String ssn) {
        response.then().assertThat().statusCode(200);
        patients = response.as(List.class);
        boolean flag= false;
        for (Object patient : patients) {
            if (((Map) patient).get("firstName").equals(firstname) &&
                    ((Map) patient).get("lastName").equals(lastname) &&
                    ((Map) patient).get("email").equals(email)) {
                flag=true;
                Assert.assertEquals(ssn, ((Map) (((Map) patient).get("user"))).get("ssn"));
            }
        }
        Assert.assertTrue(flag);


            // One patient validation with ID
//        Map<String,Object> actualData = response.as(HashMap.class);
//        System.out.println(actualData.toString());
//        Assert.assertEquals(expectedDataMap.get("firstName"),actualData.get("firstName"));
//        Assert.assertEquals(expectedDataMap.get("lastName"),actualData.get("lastName"));
//        Assert.assertEquals(expectedDataMap.get("email"),actualData.get("email"));
//        Assert.assertEquals(expectedDataMap.get("ssn"),((Map<?, ?>)actualData.get("user")).get("ssn"));
    }





/*
    Medunna medunna = new Medunna();
    Map<String,String> userMap = new HashMap<>();
    Map<String,Object> bodyMap = new HashMap<>();
    String patientEndPoint = "https://medunna.com/api/patients/";
    String ID = null;

    @Given("User sets the path params to create and update patient info")
    public void userSetsThePathParamsToCreateAndUpdatePatientInfo() {
        RequestSpecification spec = medunna.setup();
        spec.pathParams("first","api","second","patients");
    }

    @When("User creates new patient using Post request firstname {string} lastname {string} email {string} ssn {string}")
    public void userCreatesNewPatientUsingPostRequestFirstnameLastnameEmailSsn(String firstname, String lastname, String email, String ssn) {
        userMap.put("firstName",firstname);
        userMap.put("lastName",lastname);
        userMap.put("email",email);
        userMap.put("ssn",ssn);

        bodyMap.put("firstName",firstname);
        bodyMap.put("lastName",lastname);
        bodyMap.put("email",email);
        bodyMap.put("phone","123-123-1234");
        bodyMap.put("user",userMap);
        Object [] patient={bodyMap};

        response = given().headers("Authorization","Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
                contentType(ContentType.JSON).body(patient).when().post("https://medunna.com/api/patients");
        response.then().assertThat().statusCode(201);
        ID = ApiUtils.getPatientID(firstname,lastname,email);

    }

    @And("User sends Put request to update patient info firstname {string} lastname {string} email {string} ssn {string}")
    public void userSendsPutRequestToUpdatePatientInfoFirstnameLastnameEmailSsn(String firstName, String lastName, String email, String ssn) {
        patientEndPoint = patientEndPoint.concat(ID);
        userMap.replace("firstName",firstName);
        userMap.replace("lastName",lastName);
        userMap.replace("email",email);
        userMap.replace("ssn",ssn);

        bodyMap.replace("firstName",firstName);
        bodyMap.replace("lastName",lastName);
        bodyMap.replace("email",email);
        bodyMap.replace("phone","321-321-4321");
        bodyMap.replace("user",userMap);
        Object [] newPatient = {bodyMap};
        response = given().headers("Authorization","Bearer "+generateToken(),
                "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).
                contentType(ContentType.JSON).body(newPatient).when().put(patientEndPoint);
    }


    @Then("User validates patient new info firstname {string} lastname {string} email {string} ssn {string}")
    public void userValidatesPatientNewInfoFirstnameLastnameEmailSsn(String firstName, String lastName, String email, String ssn) {
        response = given().headers("Authorization","Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when()
                .get(patientEndPoint);
        Map<String,Object> actualData = response.as(HashMap.class);
        Assert.assertEquals(firstName,actualData.get("firstName"));
        Assert.assertEquals(lastName,actualData.get("lastName"));
        Assert.assertEquals(email,actualData.get("email"));
        Assert.assertEquals("321-321-4321",actualData.get("phone"));
        Assert.assertEquals(ssn,((Map<?, ?>)actualData.get("user")).get("ssn"));
    }
*/
}
