package stepdefinitions.apisteps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pages.US16_Pages;
import pojos.US16_Room;
import pojos.US16_RoomPost;
import utilities.ConfigReader;

import java.io.BufferedReader;
import java.io.FileReader;

import static Hooks.Hooks.spec;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.*;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveRoomData;

public class US16_RoomApi {

    //US16_Pages us16Pages = new US16_Pages();
    Faker faker = new Faker();
    US16_Room room;
    Response response;
    US16_RoomPost roomPost;
    static String roomNumber = "";
    static int price = 0;
    static String createdDate = "";
    String query = "";

    Authentication authentication;


    @Given("Admin set the expected data {string}, {int}, {string} and {string}")
    public void admin_set_the_expected_data_and(String description, Integer price, String roomType, String status) {
        Faker faker = new Faker();
        int number = faker.number().numberBetween(300, 1000);
        boolean status2 = Boolean.parseBoolean(status);
        roomPost = new US16_RoomPost(description, price, number, roomType, status2);
    }

    @When("Admin sends the {string} request")
    public void admin_sends_the_request(String arg0) throws Exception {
        ObjectMapper obj = new ObjectMapper();
//        System.out.println(obj.writeValueAsString(room));
        switch (arg0) {
            case "POST":
                response = postRequestRoom(generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                        ConfigReader.getProperty("base_url") + "/api/rooms", roomPost);
                break;
            case "GET":
                response = getRequest(generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                        ConfigReader.getProperty("base_url") + "/api/rooms");
                break;
            case "PUT":
                response = putRequestRoom(generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                        ConfigReader.getProperty("base_url") + "/api/rooms", room);
                break;
            default:
                break;
        }

    }

    @Then("Admin status code should be {int} for rooms")
    public void admin_status_code_should_be_for_rooms(Integer arg0) {
        response.then().statusCode(arg0);

    }

    @Then("Admin verify that the response body should be as an expected data")
    public void admin_verify_that_the_response_body_should_be_as_an_expected_data() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        US16_RoomPost actualRoom = objectMapper.readValue(response.asString(), US16_RoomPost.class);

        assertEquals(roomPost.getDescription(), actualRoom.getDescription());
        assertEquals(roomPost.getPrice(), actualRoom.getPrice());
        assertEquals(roomPost.getRoomNumber(), actualRoom.getRoomNumber());
        assertEquals(roomPost.getRoomType(), actualRoom.getRoomType());
        assertEquals(roomPost.isStatus(), actualRoom.isStatus());
        JsonPath jsonPath = response.jsonPath();
        saveRoomData(String.valueOf(jsonPath.getInt("id")), jsonPath.getInt("price"), jsonPath.getString("createdDate"));

    }


    @Given("Admin set the expected data {string}, {int}, {int}, {string} and {string}")
    public void admin_set_the_expected_data_and(String description, Integer price, Integer roomNumber, String roomType, String status) {
        boolean status2 = Boolean.parseBoolean(status);
        room = new US16_Room(description, price, roomNumber, roomType, status2);
    }

    @Then("Admin verify that the response body contains all expected data")
    public void admin_verify_that_the_response_body_contains_all_expected_data() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        US16_Room[] rooms = objectMapper.readValue(response.asString(), US16_Room[].class);

        for (US16_Room eachRoom : rooms
        ) {
            if (eachRoom.getRoomNumber() == room.getRoomNumber()) {
                assertEquals(room.getDescription(), eachRoom.getDescription());
                assertEquals(room.getPrice(), eachRoom.getPrice());
                assertEquals(room.getRoomType(), eachRoom.getRoomType());
                assertEquals(room.isStatus(), eachRoom.isStatus());
            }

        }


    }


    @Then("Admin verify that the response body should be as an expected")
    public void admin_verify_that_the_response_body_should_be_as_an_expected() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        US16_Room actualRoom = objectMapper.readValue(response.asString(), US16_Room.class);

        assertEquals(room.getDescription(), actualRoom.getDescription());
        assertEquals(room.getPrice(), actualRoom.getPrice());
        assertEquals(room.getRoomNumber(), actualRoom.getRoomNumber());
        assertEquals(room.getRoomType(), actualRoom.getRoomType());
        assertEquals(room.isStatus(), actualRoom.isStatus());
    }

    @Given("Admin sends the delete request")
    public void admin_sends_the_delete_request() {
        int id = 0;
        try {

            //identify file location
            FileReader fileReader = new FileReader("./src/test/resources/testdata/RoomData.txt");

            //Read the records of the file in given location
            BufferedReader br = new BufferedReader(fileReader);

            String line = br.readLine().substring(5, 11);
            System.out.println(line);
            id = Integer.parseInt(line);
            System.out.println(id);

        } catch (Exception e) {

            e.printStackTrace();

        }

        response = deleteRequest(generateToken(ConfigReader.getProperty("Admin_username"), ConfigReader.getProperty("Admin_pass")),
                ConfigReader.getProperty("base_url") + "/api/rooms/" + id);
    }


    @Then("Admin  status code should be {int} for roooms")
    public void adminStatusCodeShouldBeForRoooms(int arg0) {

        response.then().statusCode(arg0);
    }


    @Given("Admin set the expected data {string}, {int}, {int}, {string},{string} and {int}")
    public void admin_set_the_expected_data_and(String description, Integer price, Integer roomNumber, String roomType, String status, Integer roomId) {
        boolean status2 = Boolean.parseBoolean(status);
        room = new US16_Room(description, price, roomNumber, roomType, status2);
        room.setId(roomId);

    }
}

