package utilities;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class Authentication {


    static RequestSpecification spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
    public static String generateToken(String admin_username, String admin_pass){
        spec.pathParams("first","api","second","authenticate");
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("username","team87_admin");
        expectedData.put("password","1234567");
        expectedData.put("rememberMe",true);
        Response response = given().spec(spec).contentType(ContentType.JSON).
                            body(expectedData).when().post("/{first}/{second}");
        JsonPath json = response.jsonPath();
        return json.getString("id_token");
    }

}
