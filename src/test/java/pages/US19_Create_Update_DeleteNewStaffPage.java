package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US19_Create_Update_DeleteNewStaffPage {

    public US19_Create_Update_DeleteNewStaffPage() {

        PageFactory.initElements(Driver.getDriver(),this);

        }



    @FindBy(id = "account-menu")
    public WebElement loginDropdown;

    @FindBy(xpath = "//*[text() ='Sign in']")
    public WebElement signInDropdown;

    @FindBy(xpath = "//input[@id = 'username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='password']")
    public  WebElement passwordBox;

    @FindBy(xpath = "(//*[contains(text(), 'Sign in')])[3]")
    public WebElement sigInButton;

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemsTitlesDropdown;

    @FindBy(xpath = "//span[text()='Staff']")
    public WebElement staffDropdown;

    @FindBy(id = "jh-create-entity")
    public WebElement createANewStaffButton;

    @FindBy(xpath = "//*[contains(text(), 'A new Staff is created')]")
    public WebElement newStaffCreatedMessage;

    @FindBy(id = "searchSSN")
    public WebElement ssnBox;

    @FindBy(id = "useSSNSearch")
    public WebElement useSearchCheckbox;

    @FindBy(xpath = "//button[text()='Search User']")
    public WebElement searchUserButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement userFoundMessage;

    @FindBy(xpath = "//input[@id='staff-firstName']")
    public WebElement firstNameBox;

    @FindBy(xpath = "//input[@id='staff-lastName']")
    public WebElement lastNameBox;

    @FindBy(xpath = "//input[@id='staff-birthDate']")
    public WebElement birthDateBox;

    @FindBy(xpath = "//input[@id='staff-phone']")
    public WebElement phoneBox;

    @FindBy(xpath = "//select[@id='staff-gender']")
    public WebElement genderDropdown;

    @FindBy(xpath = "//select[@id='staff-bloodGroup']")
    public WebElement bloodGroupDropdown;

    @FindBy(id = "staff-adress")
    public WebElement adressBox;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//select[@id='staff-user']")
    public WebElement userBox;

    @FindBy(xpath = "//select[@id='staff-country']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//select[@id='staff-cstate']")
    public WebElement cityDropdown;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewutton;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button/span[text()='Delete']")
    public WebElement deleteButtonFromAlert;

// staff view page elements
    @FindBy(xpath = "(//*[text()='Staff'])[2]")
    public WebElement staffTitleCanSee;
    @FindBy(xpath = "//h2/b")
    public WebElement idCansee;
    @FindBy(xpath = "//dt[1]")
    public WebElement ssnCanSee;
    @FindBy(xpath = "//dt[2]")
    public WebElement firstnameCanSee;
    @FindBy(xpath = "//dt[3]")
    public WebElement lastnameCanSee;
    @FindBy(xpath = "//dt[4]")
    public WebElement birthdateCanSee;
    @FindBy(xpath = "//dt[5]")
    public WebElement phoneCanSee;
    @FindBy(xpath = "//dt[6]")
    public WebElement genderCanSee;
    @FindBy(xpath = "//dt[7]")
    public WebElement bloodCanSee;
    @FindBy(xpath = "//dt[8]")
    public WebElement addressCanSee;
    @FindBy(xpath = "//dt[9]")
    public WebElement descriptionCanSee;
    @FindBy(xpath = "//dt[10]")
    public WebElement createdateCanSee;
    @FindBy(xpath = "//dt[11]")
    public WebElement userCanSee;
    @FindBy(xpath = "//dt[12]")
    public WebElement countryCanSee;
    @FindBy(xpath = "//dt[13]")
    public WebElement stateCanSee;

    // TOAST Containers
    @FindBy(xpath = "//div[contains(text(),'created')]")
    public WebElement createdToastContainer;
    @FindBy(xpath = "//div[contains(text(),'deleted')]")
    public WebElement deletedToastContainer;
    @FindBy(xpath = "//div[contains(text(),'found')]")
    public WebElement foundToastContainer;
    @FindBy(xpath = "//div[contains(text(),'updated')]")
    public WebElement updatedToastContainer;




}
