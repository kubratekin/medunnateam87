package stepdefinitions.apisteps;


import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pages.US10_PhysicianAppointment;
import pages.US10_PhysicianAppointment;
import pojos.AppointmentResponse;
import utilities.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static stepdefinitions.apisteps.Authentication.generateToken;



public class US10_ApiAppointmentStepDef extends Authentication{

    Response response;
    Map<String,Object> expectedDataPatient;
    List patients;

    @Given("Physician reads patient info")
    public void physicianReadsPatientInfo() {

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "patients");
    }

    }


/*
    @Given("Physician sets expected data")
    public void physicianSetsExpectedData() {
      //  public void user_sets_the_path_params_to_read_patient_info () {
            expectedDataPatient=new HashMap<>();
            expectedDataPatient.put("patient_id","102038");
            expectedDataPatient.put("firstname","patient1");

        }




    @When("Physician get request and get response")
    public void physicianGetRequestAndGetResponse() {
        response = given().headers("Authorization","Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when()
                .get(ConfigReader.getProperty("patients_endpoint"));
//        response.prettyPrint();

    }


 */



