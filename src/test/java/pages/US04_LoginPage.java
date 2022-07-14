package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US04_LoginPage {
    public US04_LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement accountMenu;

    @FindBy(xpath = "//a[@id='login-item']//*[name()='svg']")
    public WebElement homePageSignIn;

    @FindBy(xpath = "//h5[@class='modal-title']//span[contains(text(),'Sign in')]")
    public WebElement signInPageHeader;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Sign in')]")
    public WebElement signInPageSignInButton;

    @FindBy (xpath = "//span[normalize-space()='Remember me']")
    public WebElement getSignInPageRememberMeButton;

    @FindBy(xpath = "//input[@id='rememberMe']")
    public WebElement signInPageRememberMeButton;

    @FindBy(xpath = "//span[normalize-space()='Did you forget your password?']")
    public WebElement didYouForgetYourPassword;

    @FindBy(xpath = "//span[normalize-space()='Reset your password']")
    public WebElement resetHeader;

    @FindBy(xpath="//*[@id='email']")
    public WebElement emailTextBox;

    @FindBy(xpath = "//span[normalize-space()='Reset password']")
    public WebElement resetPasswordButton;

    @FindBy(xpath = "//*[contains(text(),'Check your emails for details on how to reset your password.')]")
    public WebElement detailsForReset;

    @FindBy(xpath = "//div[@role='dialog']//div[4]")
    public WebElement registerNewAccount;

    @FindBy(xpath = "//span[normalize-space()='Register a new account']")
    public WebElement registrationPage;

     @FindBy(xpath = "//span[normalize-space()='Cancel']")
    public WebElement cancelButton;

     @FindBy(xpath = "//*[contains(text(),'Authentication information not correct.')]")
    public WebElement authenticationToaster;



}


