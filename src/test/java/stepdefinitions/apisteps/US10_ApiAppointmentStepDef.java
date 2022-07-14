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

import static io.restassured.RestAssured.*;

public class US10_ApiAppointmentStepDef {

   US10_PhysicianAppointment  physicianAppointment =new  US10_PhysicianAppointment();
    Response response;
    RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com/appointment-update/101942").build();

    @Given("user goes to Medunna page")
    public void userGoesToMedunnaPage() {
       spec.pathParams("first","appointment","second","patapp");
    }

    @Then("user sends a request to get response")
    public void userSendsARequestToGetResponse() {
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");

        response =given().spec(spec).contentType(ContentType.JSON)
                .body(physicianAppointment)
                .when().post("/{first}/{second}");
    }



    @Then("user validates api appointments")
    public void userValidatesApiAppointments() {
        physicianAppointment=response.then().extract().as(US10_PhysicianAppointment.class);

        System.out.println("response from appointment request endpoint: " + physicianAppointment);

        Assert.assertEquals("899-68-3333",physicianAppointment.ssn);
    }
}
