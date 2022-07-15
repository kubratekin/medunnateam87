package stepdefinitions.apisteps;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static stepdefinitions.apisteps.Authentication.generateToken;


public class ApiAppointmentStepDef {

    Response response;




        @Given("User reads appointments from {string}")
        public void userReadsAppointmentsFrom(String ApiAppointment) {
            response = given().headers(
                    "Authorization",
                    "Bearer " + generateToken(),
                    "Content-Type",
                    io.restassured.http.ContentType.JSON,
                    "Accept",
                    ContentType.JSON).when().get(ConfigReader.getProperty("ApiAppointment"));
            response.prettyPrint();
        }
    }



