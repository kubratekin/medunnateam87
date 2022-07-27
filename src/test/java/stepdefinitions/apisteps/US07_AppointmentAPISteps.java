package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.US07_Appointment;
import utilities.ConfigReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.Authentication.generateToken;

public class US07_AppointmentAPISteps {

    Response response;

    US07_Appointment[] appointments;

    @Given("user sends a get request for appointment data")
    public void userSendsAGetRequestForAppointmentData() {

        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                "ContentType",
                ContentType.JSON, "Accept",
                ContentType.JSON).when().get(ConfigReader.getProperty("appointment_api_endpoint"));
        //  response.prettyPrint();

    }
    @And("user deserializes the appointment data to java")
    public void userDeserializesTheAppointmentDataToJava() throws Exception {

        ObjectMapper obj = new ObjectMapper();

        appointments = obj.readValue(response.asString(), US07_Appointment[].class);

        System.out.println("Size of the actual elements :" + appointments.length);

        System.out.println(appointments[10].getEndDate());

        System.out.println(appointments[10].getPatient().getFirstName());

        System.out.println(appointments[10].getPatient().getUser().getEmail());

        // response.prettyPrint();

       // saveAppointmentData(appointments);

    }
        @Then("user saves the appointment' data to correspondent files and validates")
        public void userSavesTheAppointmentDataToCorrespondentFilesAndValidates() throws Exception {

            // saveAppointmentData(appointments);

             ObjectMapper obj = new ObjectMapper();

             US07_Appointment actualData [] = obj.readValue(response.asString(), US07_Appointment[].class);

             assertEquals("Ciftci",actualData[2].getPatient().getFirstName());


    }
}



