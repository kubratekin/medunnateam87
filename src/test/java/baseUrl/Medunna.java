package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class Medunna {

    public static RequestSpecification spec;

    @Before
    public RequestSpecification setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://www.medunna.com/").build();
        return spec;
    }
}
