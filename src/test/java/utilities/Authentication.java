package utilities;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;
import java.util.HashMap;
import java.util.Map;
import static Hooks.Hooks.spec;
public class Authentication{
    public static String generateToken() {

        //Set the base url and path params

        spec.pathParams("first", "api", "second", "authenticate");

        //Set the expected data
/*
        {
            "password": "string",
                "rememberMe": true,
                "username": "string"
        }

*/
        Map<String, Object> expectedData = new HashMap<>();
         expectedData.put("password","vusalgasimov");
         expectedData.put("rememberMe",true);
         expectedData.put("username","vusalgasimov");


    //Send the request and get the response

    Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}/{second}");

    response.prettyPrint();

        JsonPath json = response.jsonPath();
        return json.getString("id_token");
    }
}


