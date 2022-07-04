package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name="username")
    public WebElement username;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(name="rememberMe")
    public WebElement rememberMeCheckmark;

    @FindBy(xpath="(//span[text()='Sign in'])[3]")
    public WebElement loginButton;

    @FindBy(xpath="//*[text()='Did you forget your password?']")
    public WebElement updatePassword;

    @FindBy(xpath="//*[text()='Register a new account']")
    public WebElement proceedToRegistration;

    @FindBy(xpath = "//li[@class='dropdown show nav-item']")
    public WebElement accountMenuDropdown;
    @FindBy (xpath = "//a[@href='/login']")
    public WebElement accountSignInDropdownSelect;
    @FindBy (xpath = "//a[@href='/account/register']")
    public WebElement accountRegisterDropdownSelect;

    //sign in after
    @FindBy (xpath = "//span[text()='Settings']")
    public WebElement accountSettingsDropdownSelect;


    //sign in for patient
    @FindBy (xpath = "//*[text()='team87patient team87patient']")
    public WebElement accountMenuPatientUsername;

    //sign in for doctor
    @FindBy (xpath = "//*[text()='team87doctor team87doctor']")
    public WebElement accountMenuDoctorUsername;


    //sign in for staff
    @FindBy (xpath = "//*[text()='team87staff team87staff']")
    public WebElement accountMenuStaffUsername;


    //sign in for admin
    @FindBy (xpath = "///*[text()='team87admin team87admin']")
    public WebElement accountMenuAdminUsername;

}
