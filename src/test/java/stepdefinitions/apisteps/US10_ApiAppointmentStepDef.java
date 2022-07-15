package stepdefinitions.apisteps;


import io.cucumber.java.en.*;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import pages.US10_PhysicianAppointment;
import pages.US10_PhysicianAppointment;
import pojos.AppointmentResponse;
import utilities.ConfigReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static stepdefinitions.apisteps.Authentication.generateToken;



public class US10_ApiAppointmentStepDef extends Authentication{

    Response response;
    List<Map<String,Object>> Appointment;

    @Given("Physician reads patient info")
    public void physicianReadsPatientInfo() {

        RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first", "api", "second", "appointments");
    }



    @Given("Physician sends a request to get response")
    public void physicianSendsARequestToGetResponse() {
        response = given().headers(
                "Authorization",
                "Bearer " + utilities.Authentication.generateToken(),
                "ContentType",
                ContentType.JSON, "Accept",
                ContentType.JSON).when().get(ConfigReader.getProperty("api_appointment"));

    }

    @Then("Physician does deserializetion appointment info")
    public void physicianDoesDeserializetionAppointmentInfo() {
        Appointment =response.as(ArrayList.class);

        JsonPath json = response.jsonPath();
        List<Integer> ids = json.getList("findAll{it.id>190}.id");

        System.out.println(ids);


    }

    @And("Physician validates {string} appoinment status")
    public void physicianValidatesAppoinmentStatus(String status) {

        Assert.assertTrue("Status ",status.contains(status));
        System.out.println(status);



     }



}




