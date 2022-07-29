package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomeAfterSignInPage extends HomePage{
    public HomeAfterSignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Administration')]")
    public WebElement administrationButton;

    @FindBy(xpath = "//span[contains(text(),'User management')]")
    public WebElement userManagementButton;

    @FindBy(xpath = "//span[contains(text(),'Items&Titles')]")
    public WebElement itemsAndTitles;

    @FindBy(xpath = "//span[contains(text(),'Patient')]")
    public WebElement patientDropDown;

    @FindBy(id="entity-menu")
    public WebElement ItemsTitlesDropDownMenu;


    @FindBy(xpath = "//span[contains(text(),'Appointment')]")
    public WebElement appointment;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutDropDownMenuItem;


    @FindBy(xpath = "//*[contains(text(),'MY PAGES')]")
    public WebElement dropdownMyPage;

    @FindBy(xpath = "(//*[contains(text(),'My Appointments')])[1]")
    public WebElement myAppointmentDropDownMenuItem;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountMenuAfterSignIn;

    @FindBy(xpath = "//div[*='Username cannot be empty!']")
    public WebElement invalidFeedbackForUserName;

    @FindBy(xpath = "//div[*='Password cannot be empty!']")
    public WebElement invalidFeedbackForPassword;

    @FindBy(xpath = "//span[*='Failed to sign in!']")
    public WebElement invalidFeedbackForSignIn;
    //div[@class='alert alert-danger fade show']

    @FindBy(xpath = "//*[text()='MY PAGES']")
    public WebElement myPagesTab;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientButton;

    @FindBy(xpath = "//div[@class='col-lg-3 col-md-6 footer-links']//h4")
    public WebElement footerMyLinks;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement invalidFeedbackForUserNameFalseAssertion;

    @FindBy(id = "rememberMe")
    public WebElement rememberMeButton;

    @FindBy(linkText = "Did you forget your password?")
    public WebElement forgetPassword;

    @FindBy(xpath = "//span[contains(text(),'Reset your password')]")
    public WebElement resetYourPasswordVerification;

    @FindBy(xpath = "//input[@id ='email']")
    public WebElement resetYourPasswordMailBox;

    @FindBy(linkText = "Register a new account")
    public WebElement registerANewAccount;

    @FindBy(xpath = "//button [@class='btn btn-secondary']")
    public WebElement cancelButtonInSignInPage;

    @FindBy(xpath = "//button [@class = 'close']")
    public WebElement closeButtonInSignInPage;

    @FindBy(id="entity-menu")
    public WebElement entityDropDownMenu;

    @FindBy(xpath="//*[.='Make an Appointment']")
    public WebElement makeAnAppointmentMenuItem;

    @FindBy(xpath = "(//*[text()='Room'])[1]")
    public WebElement roomButton;

    @FindBy(partialLinkText = "Test Item")
    public WebElement testItem;

    @FindBy(xpath = "//span[normalize-space()='Physician']")
    public WebElement physicianDropDownMenuItem;
}
