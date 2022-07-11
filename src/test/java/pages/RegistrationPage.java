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

    @FindBy (xpath ="//h1[@id='register-title']" )
    public WebElement registrationTitlename ;

    @FindBy (xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnInvalidErrorMessage;

    //            "//*[text()='Your SSN is invalid']"

    @FindBy (xpath = "//*[text()='Your SSN is required.']")
    public WebElement ssnRequiredErrorMessage;

    @FindBy (xpath = "//*[text()='Your FirstName is required.']")
    public WebElement firstnameRequiredErrorMessage;

    @FindBy (xpath = "//*[text()='Your LastName is required.']")
    public WebElement lastnameRequiredErrorMessage;

    @FindBy (xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement registrationSavedAlert;

    @FindBy(xpath = "(//div[@class='form-group'])[1]")
    public WebElement verifyValidSSN;

    @FindBy(xpath = "(//div[@class='form-group'])[2]")
    public WebElement verifyValidFirstname;

    @FindBy(xpath = "(//div[@class='form-group'])[3]")
    public WebElement verifyValidLastname;

}
