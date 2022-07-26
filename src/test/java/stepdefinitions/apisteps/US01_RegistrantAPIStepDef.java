package stepdefinitions.apisteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utilities.ConfigReader;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;
public class US01_RegistrantAPIStepDef {

    List<Map<String,Object>> listOfUsers;
    Response response;

    @Given("user sends request and gets response")
    public void user_sends_request_and_gets_response() {
        response = given().headers(
                "Authorization",
                "Bearer " + generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                "ContentType",
                ContentType.JSON, "Accept",
                ContentType.JSON).when().get(ConfigReader.getProperty("registrant_endpoint"));
       // response.prettyPrint();
    }

    @Then("user deserializes data to Java")
    public void userDeserializesDataToJava() {
        listOfUsers  = response.as(ArrayList.class);
       // System.out.println("listOfUsers = " + listOfUsers);
    }

    @And("user validates {string} in the list")
    public void userValidatesInTheList(String ssn) {

        int count = 0 ;
        for (int i=0; i<=listOfUsers.size()-1;i++) {
            if (listOfUsers.get(i).get("ssn").toString().equals(ssn)){
            count++;
            }

        }
        Assert.assertTrue(count==1);
    }
}