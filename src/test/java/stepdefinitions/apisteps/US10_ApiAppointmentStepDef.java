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
import java.util.Map;

import static io.restassured.RestAssured.*;
import static stepdefinitions.apisteps.Authentication.generateToken;

/*
public class US10_ApiAppointmentStepDef {

<<<<<<< HEAD
   Map<String, Object> physicianAppointment =new HashMap<>();
=======

   US10_PhysicianAppointment  physicianAppointment =new  US10_PhysicianAppointment();
>>>>>>> 98d48eea5611fdcdca42871e7baddb006f7bfee3
    Response response;
    RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com/").build();

<<<<<<< HEAD
    @Given("user goes to Medunna page")
    public void userGoesToMedunnaPage() {
        spec.pathParams("first","api","second","appointments");
    }
=======
//    @Given("user goes to Medunna page")
//    public void userGoesToMedunnaPage() {
//        spec.pathParams("first","appointment","second","patapp");
//    }
>>>>>>> 98d48eea5611fdcdca42871e7baddb006f7bfee3

    @Then("user sends a request to get response")
    public void userSendsARequestToGetResponse() {
      //  response = given().headers().when().get("/{first}/{second}");


        response = given().headers(
                "Authorization",
                "Bearer " + Authentication.generateToken(),
                "ContentType",
                ContentType.JSON, "Accept",
                ContentType.JSON).when().get("https://medunna.com/api/appointments");

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");


         response.prettyPrint();


    /*    response =given().spec(spec).contentType(ContentType.JSON)
                .body(physicianAppointment)
                .when().post("/{first}/{second}");

     */
/*
}

    @Then("user validates api appointments")
    public void userValidatesApiAppointments() {
        physicianAppointment=response.as(HashMap.class);

        System.out.println("response from appointment request endpoint: " + physicianAppointment);

        Assert.assertEquals("899-68-3333",physicianAppointment.get("patient"));
    }


}
*/