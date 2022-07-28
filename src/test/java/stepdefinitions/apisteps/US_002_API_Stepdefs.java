//package stepdefinitions.apisteps;
//
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//import org.junit.Assert;
//import utilities.API_Utils;
//
//public class US_002_API_Stepdefs {
//
//    @Given("user sends POST request to get Bearer Token")
//    public void user_sends_post_request_to_get_bearer_token() {
//        API_Utils.getSpec();
//        RequestSpecification spec = API_Utils.getSpec();
//        spec.pathParams("first", "authenticate");
//        String requestBody = "{\"password\":\"vusalgasimov\",\"rememberMe\":true,\"username\":\"vusalgasimov\"}";
//        API_Utils.setRequestBody(requestBody);
//        String relativeURL = "/{first}";
//        API_Utils.post(relativeURL);
//    }
//    @Then("user verifies that response status code is {int}")
//    public void user_verifies_that_response_status_code_is(Integer statusCode) {
//        Response response = ApiUtils.getResponse();
//        String res = response.asString();
//        response.then().assertThat().statusCode(statusCode);
//    }
//    @Then("user sends a GET request to get email address")
//    public void user_sends_a_get_request_to_get_email_address() {
//        RequestSpecification spec = ApiUtils.getSpec();
//        spec.pathParams("first", "users", "second", "notpatient");
//        ApiUtils.addBearerTokenToSpec();
//        String relativePath = "/{first}/{second}";
//        ApiUtils.get(relativePath);
//
//    }
//    @Then("user verifies that the returned information matches the expected one")
//    public void user_verifies_that_the_returned_information_matches_the_expected_one() {
//
//        Response response = ApiUtils.getResponse();
//        Assert.assertTrue(response.asString().contains("11mariocosta5@gmail.com"));
//    }
//
//    @Then("user verifies that the returned information matches the expected one, and is unique")
//    public void userVerifiesThatTheReturnedInformationMatchesTheExpectedOneAndIsUnique() {
//        Response response = ApiUtils.getResponse();
//        Assert.assertTrue(response.asString().contains("opqrstuvwxyz111"));
//        Assert.assertEquals(response.asString().indexOf("opqrstuvwxyz111"),response.asString().lastIndexOf("opqrstuvwxyz111"));
//    }
//}
