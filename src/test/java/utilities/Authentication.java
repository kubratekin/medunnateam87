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

    public static void main(String[] args) {
        String newToken=generateToken();
        System.out.println("newToken = " + newToken);
    }
    public static String generateToken() {

        String username="vusalgasimov";
        String password ="vusalgasimov";

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("username","vusalgasimov");
        expectedData.put("password","vusalgasimov");
        expectedData.put("rememberMe",true);


        String endPoint ="https://medunna.com/api/authenticate";

        Response response=given().contentType(ContentType.JSON).body(expectedData).when().post(endPoint);

        JsonPath token = response.jsonPath();

        return token.getString("id_token");

    }
}


