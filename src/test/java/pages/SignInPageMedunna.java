package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPageMedunna {

    public SignInPageMedunna(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#username")
    public WebElement usernameBox;

    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;

    @FindBy(id = "account-menu")
    public WebElement loginDropdown;

    @FindBy(xpath = "//*[contains(text(),'Sign in')]")
    public WebElement signDropdown;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(id = "rememberMe")
    public WebElement rememberMe;

    @FindBy(xpath = "//*[contains(text(),'Register')]")
    public WebElement registerButton;



    @FindBy(xpath = "//*[@id='login-item']/span")//div[@role='menu']
    public WebElement sigIn;



    @FindBy(xpath = "//*[@id='login-page']/div/form/div[3]/button[2]/span")
    public WebElement signinButton;

    @FindBy(xpath= "//*[@id='account-menu']/a")
    public WebElement logInDropdown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement logInButton;


    @FindBy(xpath="//*[contains(text(),'Items&Titles')]")
    public WebElement itemsTitleButton;

//    @FindBy(xpath = "//*[@id='entity-menu']")
//    public WebElement itemsTitleButton;

    @FindBy(xpath = "//*[@id='entity-menu']/div/a[1]")
    public WebElement patients;

    @FindBy(xpath = "//span[normalize-space()='Create a new Patient']")
    public WebElement newpatientbutton;

    @FindBy(xpath = "//*[@id='patient-firstName']")
    public WebElement firstname;

    @FindBy(xpath = "//*[@id='patient-lastName']")
    public WebElement lastname;

    @FindBy(xpath = "//*[@id='patient-birthDate']")
    public WebElement birthdate;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='patient-phone']")
    public WebElement phone;

    @FindBy(xpath = "//select[@id='patient-gender']")
    public WebElement gender;

    @FindBy(xpath = "//select[@id='patient-bloodGroup']")
    public WebElement blood;

    @FindBy(xpath= "//input[@id='patient-adress']")
    public WebElement address;

    @FindBy(xpath = "//textarea[@id='patient-description']")
    public WebElement description;

    @FindBy(xpath = "//select[@id='patient-user']")
    public WebElement user;

    @FindBy(xpath = "//select[@id='patient-country']")
    public WebElement country;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement savebutton;

//    @FindBy(xpath = "//a[normalize-space()='»»']")
//    public WebElement lastpagebutton;

    @FindBy(xpath = "//a[normalize-space()='»»']")
    public WebElement goToLastPageButton;

//    @FindBy(xpath = "//a[@href='javascript:void(0)'])[7]")
//    public WebElement goToLastPageButton;

    @FindBy(xpath = "(//*[text()='Delete'])[last()]")
    public WebElement deleteLastCreated;


    @FindBy(xpath = "(//*[contains(text(),'Edit')])[last()]")
    public WebElement editLastCreated;

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div[1]/div/table/tbody/tr[4]/td[16]/div/a[3]/span/span")
    public WebElement foundPatient;

    @FindBy(xpath = "//*[@id='app-view-container']/div/div/div/div/div/a[2]/span/span")
    public WebElement editButton;

    @FindBy(xpath = "//*[@id='patient-lastName']")
    public WebElement changelastname;

    @FindBy(xpath ="//*[contains(text(), 'deleted')]" )
    public WebElement deleteMessage;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-patient']")
    public WebElement confirmDelete;




}

