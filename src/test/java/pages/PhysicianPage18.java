package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysicianPage18 extends BasePage18 {
    /*
    This page is navigated from signed admin home page from Items&Titles
     */

    public PhysicianPage18() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[text()='Physicians']")
    public WebElement physicianText;
    @FindBy(xpath = "//span[normalize-space()='Create a new Physician']")
    public WebElement createNewPhysicianButton;
    @FindBy(xpath = "//input[@id='physician-firstName']")
    public WebElement firstNameField;
    @FindBy(xpath = "//input[@id='physician-lastName']")
    public WebElement lastNameField;
    @FindBy(xpath = "//input[@id='physician1-birthDate']")
    public WebElement birthDate;
    @FindBy(xpath = "//input[@id='physician-adress']")
    public WebElement addressField;
    @FindBy(xpath = "//select[@id='physician-gender']")
    public WebElement genderMenu;
    @FindBy(xpath = "//select[@id='physician-speciality']")
    public WebElement specialityMenu;
    @FindBy(xpath = "//select[@id='physician-bloodGroup']")
    public WebElement bloodGroupMenu;
    @FindBy(xpath = "//input[@id='physician-description']")
    public WebElement descriptionField;
    @FindBy(xpath = "//input[@id='file_image']")
    public WebElement chooseFileButton;
    @FindBy(xpath = "//input[@id='physician-examFee']")
    public WebElement examFeeField;
    @FindBy(xpath = "//select[@id='physician-user']")
    public WebElement userDropdown;
    @FindBy(xpath = "//select[@id='physician-country']")
    public WebElement countryField;
    @FindBy(xpath = "//select[@id='physician-cstate']")
    public WebElement stateCityMenu;
    @FindBy(xpath = "//input[@id='physician-phone']")
    public WebElement phoneField;
    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;
    @FindBy(id = "useSSNSearch")
    public WebElement useSSNCheckBox;
    @FindBy(id = "searchSSN")
    public WebElement sSNSearchBox;
    @FindBy(xpath = "//button[text()='Search User']")
    public  WebElement searchUserButton;
    @FindBy(xpath = "//div[@role='alert']")
    public WebElement internalServerErrorAlert;
    @FindBy(xpath = "(//div//a//img)[2]")
    public WebElement profilePhoto;
    @FindBy(xpath = "//*[@data-icon='pencil-alt']")
    public WebElement editButton;
    @FindBy(xpath = "//*[@data-icon='eye']")
    public WebElement viewButton;
    @FindBy(xpath = "//span[text()='Create or edit a Physician']")
    public WebElement createOrEditAPhysicianText;
    @FindBy(xpath = "//label[normalize-space()='SSN']")
    public WebElement ssnLabel;
    @FindBy(xpath = "//span[normalize-space()='First Name']")
    public WebElement firstNameLabel;
    @FindBy(xpath = "//span[normalize-space()='Last Name']")
    public WebElement lastNameLabel;
    @FindBy(xpath = "//span[normalize-space()='Phone']")
    public WebElement phoneLabel;
    @FindBy(xpath = "//span[normalize-space()='Address']")
    public WebElement addressLabel;
    @FindBy(xpath = "//span[normalize-space()='Gender']")
    public WebElement genderLabel;
    @FindBy(xpath = "//span[normalize-space()='Speciality']")
    public WebElement specialityLabel;
    @FindBy(xpath = "//span[normalize-space()='Blood Group']")
    public WebElement bloodGroupLabel;
    @FindBy(xpath = "//span[normalize-space()='Description']")
    public WebElement descriptionLabel;
    @FindBy(xpath = "//span[normalize-space()='Image']")
    public WebElement imageLabel;
    @FindBy(xpath = "//span[normalize-space()='Created Date']")
    public WebElement createdDateLabel;
    @FindBy(xpath = "//span[normalize-space()='Exam Fee']")
    public WebElement examFeeLabel;
    @FindBy(xpath = "//span[normalize-space()='User']")
    public WebElement userLabel;
    @FindBy(xpath = "//label[@for='physician-country']//span[contains(text(),'Country')]")
    public WebElement countryLabel;
    @FindBy(xpath = "//label[@for='physician-cstate']//span[contains(text(),'State/City')]")
    public WebElement stateCityLabel;
    @FindBy(xpath = "//label[@for='physician-birthDate']")
    public WebElement birthdayLabel;
    @FindBy(xpath = "(//span[contains(text(),'Delete')])[1]")
    public WebElement deleteButton;
    @FindBy(xpath = "(//span[contains(text(),'Delete')])[21]")
    public WebElement deleteConfirm;
    @FindBy(xpath = "//div[contains(text(), 'A Physician is deleted with identifier')]")
    public WebElement physicianDeleteConfirmation;
}
