package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US008_PasswordPage {
    public US008_PasswordPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']//*[name()='svg']")
    public WebElement accountMenu;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    public WebElement homePageSignIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Sign in')]")
    public WebElement signInPageSignInButton;
    @FindBy(xpath = "//span[normalize-space()='team87user01 team87user01']")
    public WebElement loginPageAccountMenu;

    @FindBy(xpath = "//span[normalize-space()='Password']")
    public WebElement loginPagePasswordButton;
    @FindBy(xpath = "//input[@id='currentPassword']")
    public WebElement currentPassword;
    @FindBy(xpath = "//input[@id='newPassword']")
    public WebElement newPassword;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    public WebElement confirmationPassword;
    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;
    @FindBy(xpath = "(//*[.='Password changed!'])[3]")
    public WebElement successMessage;

    @FindBy(xpath = "//span[normalize-space()='Sign out']")
    public WebElement signOutButton;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "//*[@id=\"strengthBar\"]/li[2]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "//ul[@id='strengthBar']")
    public WebElement passwordStrength4;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(0, 255, 0)')]")
    public WebElement passwordStrength5;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement saveSubmitButton;

    @FindBy(xpath = "//*[text()='Password changed!']")
    public  WebElement passwordChangedMessage;

    @FindBy(xpath = "//*[contains(text(),'The password could not be changed')]")
    public  WebElement passwordNotChangedMessage;

    @FindBy(xpath = "//*[contains(text(),'at least 4 characters')]")
    public  WebElement passwordMoreThanFourMessage;

    @FindBy(xpath = "//*[contains(text(),'confirmation do not match!')]")
    public  WebElement passwordNotMatchMessage;

    @FindBy(xpath = "//*[text()='New password confirmation']")
    public  WebElement passwordShouldBeConfirmMessage;

    @FindBy(xpath = "//div[text()='Your password is required.']")
    public  WebElement passwordIsRequiredMessage;

    @FindBy(xpath = "//div[text()='Authentication information not correct.']")
    public  WebElement passwordInformationIncorrectMessage;

}