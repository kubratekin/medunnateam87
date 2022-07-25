package stepdefinitions.uisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pages.US16_Pages;

import pojos.US16_Room;
import pojos.US16_RoomPost;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static utilities.WriteToTxt.saveRoomData;

public class US16steps {

    US16_Pages us16Pages= new US16_Pages();

    Faker faker=new Faker();
    US16_Room room;
    Response response;
    US16_RoomPost roomPost;
    static String roomNumber="";
    static int price=0;
    static String createdDate="";
    String query="";


    @Given("Admin navigate to Medduna Home Page")
    public void admin_navigate_to_medduna_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

    }
    @Given("Admin Click on Account DropDownMenu button")
    public void admin_click_on_account_drop_down_menu_button() throws InterruptedException {
        Thread.sleep(1000);
        us16Pages.accountMenu.click();

    }
    @When("Admin Click on Sign in")
    public void admin_click_on_sign_in() {
        us16Pages.homePageSignIn.click();
    }
    @Then("Admin Click on Username input box.")
    public void admin_click_on_username_input_box() {

    }
    @Then("Admin Enter Valid {string} Username")
    public void admin_enter_valid_username(String string) {
        us16Pages.username.sendKeys("team87_admin");

    }
    @Then("Admin Click on Password input box.")
    public void admin_click_on_password_input_box() throws InterruptedException {
        us16Pages.password.click();
        Thread.sleep(2000);
    }
    @Then("Admin Enter Valid {string} Password")
    public void admin_enter_valid_password(String string) {
        us16Pages.password.sendKeys("1234567");

    }
    @Then("Admin Click on Sign in button")
    public void admin_click_on_sign_in_button() {
        us16Pages.signInPageSignInButton.click();

    }
    @Then("Admin Click on Items&Titles")
    public void admin_click_on_items_titles() throws InterruptedException {
        Thread.sleep(2000);
        Driver.waitAndClick(us16Pages.itemsTitlesDropdown);

    }
    @Then("Admin select Room from drop down menu and click")
    public void admin_select_room_from_drop_down_menu_and_click() throws InterruptedException {
        Driver.waitAndClick(us16Pages.roomDropdown);

    }
    @When("Admin clicks on Create a new Room button")
    public void admin_clicks_on_create_a_new_room_button() {
        Driver.waitAndClick(us16Pages.createANewRoomButton);

    }
    @Then("Admin verify that user on the {string} page")
    public void admin_verify_that_user_on_the_page(String string) {
        assertTrue(Driver.waitForVisibility(us16Pages.createOrEditARoomHeading, 1).isDisplayed());

    }
    @Given("Admin provides a Room Number")
    public void admin_provides_a_room_number() {
        roomNumber=String.valueOf(faker.number().numberBetween(100,300));
        Driver.waitAndSendText(us16Pages.roomNumberTextBox,roomNumber );

    }
    @Given("Admin provides a Price")
    public void admin_provides_a_price() {
        price=faker.number().numberBetween(100,500);
        Driver.waitAndSendText(us16Pages.priceTextBox,String.valueOf(price));

    }
    @Given("Admin sets date as {string}")
    public void admin_sets_date_as(String arg0) {
        createdDate=arg0;
        Driver.waitAndSendText(us16Pages.createdDateTextBox,createdDate);
        saveRoomData(roomNumber,price,createdDate);

    }
    @When("Admin clicks on the Save button")
    public void admin_clicks_on_the_save_button() {
        //us16Pages.roomcreationsave.click();
        Driver.waitAndClick(us16Pages.roomcreationsave);


    }
    @Then("Admin should see the {string}")
    public void admin_should_see_the(String string) {
      // assertTrue(us16Pages.roomcreatedtoastcontainer.isDisplayed());

    }
    //@Then("Admin verify that Created Date is updated automatically")
    //public void admin_verify_that_created_date_is_updated_automatically() {
      //  Driver.waitForVisibility(us16Pages.roomsHeading,5);
      //  Driver.clickWithJS(us16Pages.lastPage);
        //Driver.wait(1);
        //String lastRow= us16Pages.allRows.get(us16Pages.allRows.size()-1).getText();

        //System.out.println(lastRow);
        //Driver.wait(2);
        //assertTrue(lastRow.contains(roomNumber));
        //assertTrue(lastRow.contains(String.valueOf(price)));
        //assertTrue(lastRow.contains(createdDate));

    //}

    @Given("Admin leave blank Room Number field and click enter")
    public void admin_leave_blank_room_number_field_and_click_enter() {
        Driver.waitAndSendText(us16Pages.roomNumberTextBox,""+ Keys.ENTER);

    }
    @Given("Adminshould see {string} feedback twice")
    public void adminshould_see_feedback_twice(String arg0) {
        assertEquals(arg0,Driver.waitAndGetText(us16Pages.invalidFeedbacks.get(0),1));
        assertEquals(arg0,Driver.waitAndGetText(us16Pages.invalidFeedbacks.get(1),1));

    }
    @When("Admin clicks on the Room Type dropdown")
    public void admin_clicks_on_the_room_type_dropdown() {
        Driver.waitAndClick(us16Pages.roomTypeSelect);

    }
    @Then("Admin should see options like {string}, {string}, {string}, {string} and {string}")
    public void admin_should_see_options_like_and(String arg0, String arg1, String arg2, String arg3, String arg4) {

        Select options=new Select(us16Pages.roomTypeSelect);
        List<String > expectedData=new ArrayList<>();
        expectedData.add(arg0);
        expectedData.add(arg1);
        expectedData.add(arg2);
        expectedData.add(arg3);
        expectedData.add(arg4);
        List<String> actualData=new ArrayList<>();
        for (WebElement w:options.getOptions()
        ) {
            actualData.add(w.getText());
        }

        assertTrue(actualData.containsAll(expectedData));

    }
    @Then("Admin can set current status for the room")
    public void admin_can_set_current_status_for_the_room() {
        Driver.waitAndClick(us16Pages.statusCheckBox);
        assertTrue(us16Pages.statusCheckBox.isSelected());

    }

    @Given("Admin on the Rooms page")
    public void admin_on_the_rooms_page() {
        Driver.getDriver().navigate().back();
        assertTrue(Driver.waitForVisibility(us16Pages.roomsHeading,1).isDisplayed());

    }
    @Given("Admin should see all rooms on the same page")
    public void admin_should_see_all_rooms_on_the_same_page() {
        Driver.wait(1);
        assertEquals(20, us16Pages.allRows.size());
        System.out.println(us16Pages.allRows.size());

    }
    @When("Admin clicks on {string} button for last created room")
    public void admin_clicks_on_button_for_last_created_room(String arg0) {
        Driver.waitAndClick(us16Pages.lastPage);
        Driver.wait(1);
        if(arg0.equals("edit"))  {
            Driver.waitAndClick(us16Pages.editElements.get(us16Pages.allRows.size()-1));
        }else if (arg0.equals("delete")){
            Driver.waitAndClick(us16Pages.deleteElements.get(us16Pages.allRows.size()-1));
        }

    }
    @Then("Admin provides {string} as description")
    public void admin_provides_as_description(String arg0) {
        Driver.waitAndSendText(us16Pages.descriptionTextBox,arg0);

    }
    @When("Admin confirms delete operation")
    public void admin_confirms_delete_operation() {
        Driver.waitAndClick(us16Pages.deleteConfirm);

    }


}


