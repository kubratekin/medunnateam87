package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static baseUrl.Medunna.spec;
import static io.restassured.RestAssured.given;
import static utilities.Authentication.generateToken;

public class ApiUtils {

    static Response response;
    static List patients;


    public static String getPatientID (String firstName, String lastName, String email) {
        spec.pathParams("1","api","2","patients");

        response = given().headers("Authorization","Bearer "+generateToken(),
                        "Content-Type", ContentType.JSON,"Accept",ContentType.JSON).when()
                .get(ConfigReader.getProperty("patients_endpoint"));

        patients = response.as(List.class);
        String ID = null;
        for (Object patient : patients) {
            if (  ((Map) patient).get("firstName").equals(firstName) &&
                    ((Map)patient).get("lastName").equals(lastName) &&
                    ((Map)patient).get("email").equals(email) ) {
            ID = ((Map) patient).get("id").toString();
            }
            }
        return ID;
        }
}

