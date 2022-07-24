package utilities;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
public class ApiUtils {
    private static String bearerToken;
    private static RequestSpecification spec;
    private static Response response;
    private static String requestBody;
    private static Map<String, Object> objectPool = new HashMap<>();
    public static RequestSpecification getSpec(){
        if (spec==null){
            spec = setUpSpec();
        }
        return spec;
    }
    public static Response getResponse() {
        return response;
    }
    public static String getRequestBody() {
        return requestBody;
    }
    public static void setRequestBody(String requestBody) {
        ApiUtils.requestBody = requestBody;
    }
    public static void setBearerToken(String bearerToken) {
        ApiUtils.bearerToken = bearerToken;
    }
    private static RequestSpecification setUpSpec(){
        RequestSpecification spec;
        String base_api_url = ConfigReader.getProperty("api_base_url");
        spec = new RequestSpecBuilder().
                setBaseUri(base_api_url).
                build();
        spec.header("Accept", ContentType.JSON);
        spec.contentType(ContentType.JSON);
        //spec.header("Authorization", "Bearer " + getBearerToken());
        return spec;
    }
    public static String getBearerToken(String userName,String password){
        RequestSpecification spec1;
        spec1 = new RequestSpecBuilder().
                setBaseUri("https://medunna.com/api").
                build();
        spec1.header("Accept", ContentType.JSON);
        spec1.contentType(ContentType.JSON);
        spec1.pathParams("first","authenticate");
        String str = "{\"password\":\"%s\",\"rememberMe\":true,\"username\":\"%s\"}";
        String requestBody = String.format(str,password,userName);
        Response response1 = given()
                .spec(spec1)
                .body(requestBody)
                .post("/{first}");
        response1.prettyPrint();
        JsonPath jsonPath = response1.jsonPath();
        String token = jsonPath.getString("id_token");
        return token;
    }
    public static void addBearerTokenToSpec(String userName, String password){
        bearerToken = getBearerToken(userName,password);
        spec.header("Authorization","Bearer "+bearerToken);
    }
    public static void addBearerTokenToSpec(){
        if (bearerToken==null) {
            bearerToken = getBearerToken();
        }
        spec.header("Authorization","Bearer "+bearerToken);
    }
    private static String getBearerToken(){
        RequestSpecification spec1;
        spec1 = new RequestSpecBuilder().
                setBaseUri("https://medunna.com/api").
                build();
        spec1.header("Accept", ContentType.JSON);
        spec1.contentType(ContentType.JSON);
        spec1.pathParams("first","authenticate");
        String userNameApi = ConfigReader.getProperty("userNameForBearerTokenApi");
        String passwordApi = ConfigReader.getProperty("passwordForBearerTokenApi");
        String str = "{\"password\":\"%s\",\"rememberMe\":true,\"username\":\"%s\"}";
        String requestBody = String.format(str,passwordApi,userNameApi);
        Response response1 = given()
                .spec(spec1)
                .body(requestBody)
                .post("/{first}");
//        response1.prettyPrint();
        JsonPath jsonPath = response1.jsonPath();
        String token = jsonPath.getString("id_token");
        return token;
    }
    public static void get(String relativePath){
        response = given()
                .spec(spec)
                .get(relativePath);
    }
    public static void post(String relativePath){
        response = given()
                .spec(spec)
                .body(requestBody)
                 .post(relativePath);
    }
    public static void put(String relativePath){
        response = given()
                .spec(spec)
                .body(requestBody)
                .put(relativePath);
    }
    public static void patch(String relativePath){
        response = given()
                .spec(spec)
                .body(requestBody)
                .patch(relativePath);
    }
    public static void delete(String relativePath){
        response = given()
                .spec(spec)
                .body(requestBody)
                .delete(relativePath);
    }
    //-------------------------------OBJECT MAPPER CODES----------------------------------------------
    private static ObjectMapper mapper;
    static {
        mapper = new ObjectMapper();
    }
    //1. method: this method will convert Json data to Java Object(de-serialization)
    //  Class<BookingPojo>
    public static <T> T convertJsonToJavaObject(String json, Class<T> cls){ //generic method
        T javaResult = null;
        try {
            javaResult = mapper.readValue(json,cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return javaResult;
    }
    //2. Method: this method will convert Java Object to Json data (serialization)
    public static String convertJavaObjectToJson(Object obj){
        String jsonResult = null;
        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonResult;
    }
    //-------------------------------------------------------------------------------------------------
    public static void addObjectToApiPool(String key,Object object){
        objectPool.put(key, object);
    }
    public static Object getObjectFromApiPool(String key){
        return objectPool.get(key);
    }
    public static void removeObjectFromApiPool(String key){
        objectPool.remove(key);
    }
    public static void clearApiPool(){
        objectPool.clear();
    }
}


