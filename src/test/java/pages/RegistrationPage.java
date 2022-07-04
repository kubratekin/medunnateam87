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

    @FindBy(xpath = "//*[text()='Registration saved!']")
    public WebElement successMessageToastContainer;

    @FindBy (xpath ="//h1[@id='register-title']" )
    public WebElement registrationTitle ;

    @FindBy (className = "//*[text()='Your SSN is invalid']")
    public WebElement ssnInvalidErrorMessage;

    @FindBy (xpath = "//*[text()='Your SSN is required.']")
    public WebElement ssnRequiredErrorMessage;

    @FindBy (xpath = "//*[text()='Your FirstName is required.']")
    public WebElement firstnameRequiredErrorMessage;

    @FindBy (xpath = "//*[text()='Your LastName is required.']")
    public WebElement lastnameRequiredErrorMessage;


}
