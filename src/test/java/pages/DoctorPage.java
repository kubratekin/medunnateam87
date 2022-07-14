package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DoctorPage {

    public DoctorPage(){

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

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement doctorUsername;

    @FindBy(xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[1]")
    public WebElement myPagesDropdown;

    @FindBy(xpath = "(//*[contains(text(),'My Appointments')])[1]")
    public WebElement myAppointments;

    @FindBy(id = "appointment-heading")
    public WebElement appointmentsText;

    @FindBy(id = "fromDate")
    public WebElement fromDate;

    @FindBy(id = "toDate")
    public WebElement toDate;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButton;

    @FindBy(xpath = "//*[text()='Create or Edit an Appointment']")
    public WebElement creatOrEditAnAppointmentText;

    @FindBy(xpath = "//input[@id='appointment-id']")
    public WebElement idField;

    @FindBy(xpath= "//input[@id='appointment-startDate']")
    public WebElement startDateTime;

    @FindBy(xpath= "//input[@id='appointment-endDate']")
    public WebElement endDateTime;

    @FindBy(xpath = "//select[@id='appointment-status']")
    public WebElement statusDropDown;

    @FindBy(xpath = "//select[@id='appointment-status']//option[1]")
    public WebElement unApproved;

    @FindBy(xpath = "//select[@id='appointment-status']//option[2]")
    public WebElement pending;

    @FindBy(xpath = "//select[@id='appointment-status']//option[3]")
    public WebElement completed;

    @FindBy(xpath = "//select[@id='appointment-status']//option[4]")
    public WebElement cancelled;

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anamnesisField;

    @FindBy(xpath = "(//*[text() ='This field is required.'])[1]")
    public WebElement anamnesisMessage;

    @FindBy(xpath = "//textarea[@id='appointment-treatment']")
    public WebElement treatmentField;

    @FindBy(xpath = "(//*[text() ='This field is required.'])[2]")
    public WebElement treatmentMessage;

    @FindBy(xpath = "//textarea[@id='appointment-diagnosis']")
    public WebElement diagnosisField;

    @FindBy(xpath = "(//*[text() ='This field is required.'])[3]")
    public WebElement diagnosisMessage;

    @FindBy(xpath = "//textarea[@id='appointment-prescription']")
    public WebElement prescriptionField;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionField;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public WebElement physicianField;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement appointmentUpdatedMessage;

    @FindBy(xpath = "//*[contains(text(), 'Sign out')]")
    public WebElement signOutDropdown;
}




