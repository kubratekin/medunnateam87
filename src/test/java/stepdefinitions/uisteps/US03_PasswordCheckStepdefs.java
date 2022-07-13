package stepdefinitions.uisteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.US003_PasswordCheck;
import utilities.ConfigReader;
import utilities.Driver;

public class US03_PasswordCheckStepdefs {

    private WebDriver driver;


    US003_PasswordCheck RPS = new US003_PasswordCheck();


    @Given("user navigates to {string}")
    public void user_navigates_to(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @Then("user clicks on registiration button and navigates to registiration page")
    public void user_clicks_on_registiration_button_and_navigates_to_registiration_page() {
        RPS.register1.click();
        RPS.register2.click();
    }
    @Then("user types one char and sees the length is not enough")
    public void user_types_one_char_and_sees_the_length_is_not_enough() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword1"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword1"));
        String yourpasswordShort=RPS.shortPassword.getText();
        String expectedWord=ConfigReader.getProperty("charlength4");
        Assert.assertEquals(expectedWord,yourpasswordShort);
    }
    @Then("user types two char and sees the length is not enough")
    public void user_types_two_char_and_sees_the_length_is_not_enough() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword2"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword2"));
        String yourpasswordShort=RPS.shortPassword.getText();
        String expectedWord=ConfigReader.getProperty("charlength4");
        Assert.assertEquals(expectedWord,yourpasswordShort);
    }
    @Then("user types three char sees the length is not enough")
    public void user_types_three_char_sees_the_length_is_not_enough() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword3"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword3"));
        String yourpasswordShort=RPS.shortPassword.getText();
        String expectedWord=ConfigReader.getProperty("charlength4");
        Assert.assertEquals(expectedWord,yourpasswordShort);
    }
    @Then("user types {int} char and sees the length is enough")
    public void user_types_char_and_sees_the_length_is_enough(Integer int1) {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword4"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("InsufficientPassword4"));
        //String yourpasswordShort=RPS.shortPassword.getText();
        String expectedWord=ConfigReader.getProperty("charlength4");
        Assert.assertFalse(expectedWord,false);

    }

    @Then("user types seven chars")
    public void user_types_seven_chars() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("sevenChars"));
        String FirstStrength=RPS.strength1.getText();
        String SecondStrength=RPS.strength2.getText();
        Assert.assertEquals(FirstStrength,SecondStrength);
    }
    @Then("user types seven chars included one lowercase char")
    public void user_types_seven_chars_included_one_lowercase_char() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("LowerCase"));

    }

    @Then("user sees strength level is changed to stronger")
    public void user_sees_strength_level_is_changed_to_stronger() {
        String FirstStrength=RPS.strength1.getText();
        String SecondStrength=RPS.strength2.getText();
        Assert.assertEquals(FirstStrength,SecondStrength);
    }
    @Then("user types seven chars included one lowercase and one uppercase")
    public void user_types_seven_chars_included_one_lowercase_and_one_uppercase() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("upperCase"));
        String SecondStrength=RPS.strength2.getText();
        String ThirdStrength=RPS.strength3.getText();
        Assert.assertEquals(ThirdStrength,SecondStrength);
    }
    @Then("user types seven chars included one lowercase and one uppercase and number")
    public void user_types_seven_chars_included_one_lowercase_and_one_uppercase_and_number() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("numberChar"));
        String thirdStrength=RPS.strength3.getText();
        String fourthStrength=RPS.strength4.getText();
        Assert.assertEquals(thirdStrength,fourthStrength);
    }
    @Then(": user types seven chars included one lowercase and one uppercase and number and special char")
    public void user_types_seven_chars_included_one_lowercase_and_one_uppercase_and_number_and_special_char() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("specialChar"));
        String fifthStrength=RPS.strength5.getText();
        String forthStrength=RPS.strength4.getText();
        Assert.assertEquals(fifthStrength,forthStrength);

    }
}




