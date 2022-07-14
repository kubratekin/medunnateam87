package stepdefinitions.apisteps;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static void main(String[] args) {
        String newToken = generateToken();
        System.out.println(newToken);
    }
    public static String generateToken()
    {
            //Set the base url
            //api/authenticate
            RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com/").build();
            spec.pathParams("first", "api", "second", "authenticate");

            //Set the expected data
            String username = "Elharezmi";
            String password = "1elharezmi1";

            Map<String, Object> expectedData = new HashMap<>();
            expectedData.put("username", username);
            expectedData.put("password", password);
            expectedData.put("rememberMe", "true");
            String endpoint = "https://www.medunna.com/api/authenticate";

            //Send the Post request and get the data
            Response response = given().spec(spec).contentType(ContentType.JSON).
                    body(expectedData).when().post("/{first}/{second}");

            response.prettyPrint();
            JsonPath json = response.jsonPath();


            return json.getString("id_token");

        }

    }

