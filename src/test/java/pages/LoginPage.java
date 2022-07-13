package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class  LoginPage {

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


    @FindBy (xpath = "//h5[@class='modal-title']")
    public WebElement signInTitle;

    //sign in after
    @FindBy (id ="account-menu")
    public WebElement signInAccountMenuDropdown;
    @FindBy (xpath = "//span[text()='Settings']")
    public WebElement accountSettingsDropdownSelect;








}
