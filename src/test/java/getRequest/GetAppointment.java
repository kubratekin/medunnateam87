package getRequest;
import baseUrl.MedunnaBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetAppointment extends MedunnaBaseUrl{
    @Test
    public void get1() {
        // String url = "https://medunna.com/physician-appointment/1";
        spec.pathParams("first","api","second","appointments");
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        System.out.println(response.getHeader("Appointments"));
    }

}
