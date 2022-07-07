package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class RegistrationPage {

    public RegistrationPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id = "ssn")
    public WebElement ssnTextbox;

    @FindBy(name = "firstName")
    public WebElement firstnameTextbox;

    @FindBy(name = "lastName")
    public WebElement lastnameTextbox;

    @FindBy(name = "username")
    public WebElement usernameTextbox;

    @FindBy(id = "email")
    public WebElement emailTextbox;

    @FindBy(name = "firstPassword")
    public WebElement firstPasswordTextbox;

    @FindBy(name = "secondPassword")
    public WebElement newPasswordTextbox;

    @FindBy(id = "register-submit")
    public WebElement registerButton;

    @FindBy(xpath = "//*[text()='Registration Saved']") // Changed by Emin
    public WebElement successMessageToastContainer;

    @FindBy(xpath = "//span[normalize-space()='Registration']")
    public WebElement registrationTitle; //emin

    @FindBy (xpath = "//div[text()='Your email is required to be at least 5 characters.']")
    public WebElement emailAtLeast5CharactersMessage; //emin

    @FindBy (xpath = "//div[text()='This field is invalid']")
    public WebElement thisFieldIsInvalid; //emin
}
