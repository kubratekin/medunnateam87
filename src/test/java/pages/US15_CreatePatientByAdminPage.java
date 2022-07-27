package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US15_CreatePatientByAdminPage {
    public US15_CreatePatientByAdminPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //------------ Login Page Elements----------
    @FindBy(name="username")
    public WebElement username;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath="(//span[text()='Sign in'])[3]")
    public WebElement loginButton;

// ----------------Home Page Elements ------------
    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement signInLogo;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signIn;


    @FindBy(xpath = "//*[@id='entity-menu']")
    public WebElement itemsTitles;

    @FindBy(xpath = "//span[normalize-space()='MY PAGES']")
    public WebElement myPages;

    @FindBy(xpath = "//span[normalize-space()='MY PAGES(PATIENT)']")
    public WebElement myPagesPatient;

    @FindBy(xpath = "//a[@href='/patient']")
    public WebElement patient;

    @FindBy(xpath = "//*[@id='jh-create-entity']")
    public WebElement createNewPatientButton;


    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastname;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement birthDate;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//select[@name='gender']")
    public WebElement gender;

    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement bloodGroup;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement address;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement description;

    @FindBy(xpath = "//select[@name='user.id']")
    public WebElement userId;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement countryId;

    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement stateId;

    @FindBy(xpath = "//*[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'new Patient is created')]")
    public WebElement saveSuccessfullMessage;

    //---------All Patient Information Titles-----------

    @FindBy(xpath = "//*[text()='ID']")
    public WebElement idTitle;

    @FindBy(xpath = "//*[text()='SSN']")
    public WebElement SSNTitle;

    @FindBy(xpath = "//*[text()='First Name']")
    public WebElement firstNameTitle;

    @FindBy(xpath = "//*[text()='Last Name']")
    public WebElement lastNameTitle;

    @FindBy(xpath = "//*[text()='Birth Date']")
    public WebElement birthDateTitle;

    @FindBy(xpath = "//*[text()='Phone']")
    public WebElement phoneTitle;

    @FindBy(xpath = "//*[text()='Email']")
    public WebElement emailTitle;

    @FindBy(xpath = "//*[text()='Gender']")
    public WebElement genderTitle;

    @FindBy(xpath = "//*[text()='Blood Group']")
    public WebElement bloodGroupTitle;

    @FindBy(xpath = "//*[text()='Address']")
    public WebElement addressTitle;

    @FindBy(xpath = "//*[text()='Description']")
    public WebElement descriptionTitle;

    @FindBy(xpath = "//*[text()='Created Date']")
    public WebElement createDateTitle;

    @FindBy(xpath = "//*[text()='User']")
    public WebElement userTitle;

    @FindBy(xpath = "(//*[text()='Country'])[2]")
    public WebElement countryTitle;

    @FindBy(xpath = "//*[text()=' State/City']")
    public WebElement stateTitle;


    @FindBy(xpath = "(//table/tbody/tr/td[16])/div/a[2]")
    public WebElement editButton;

    @FindBy(xpath = "//*[text()='ID']")
    public WebElement editPatientIdTitle;

    //---------Delete Patient------------
    @FindBy(xpath = "(//a[@class='page-link'])[9]")
    public WebElement lastPageIcon;

    @FindBy(xpath = "//table/tbody/tr[last()]/td[last()]/div/a[3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-patient']")
    public WebElement deleteButtonOnMessage;

    @FindBy(xpath = "//*[contains(text(),'Patient is deleted')]")
    public WebElement patientDeletedMessage;


}
