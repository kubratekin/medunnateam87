package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AppointmentPage {

    public AppointmentPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="firstName")
    public WebElement firstname;


    @FindBy(id="lastName")
    public WebElement lastname;

    @FindBy(id="ssn")
    public WebElement ssn;

    @FindBy(id="email")
    public WebElement email;

    @FindBy(id="phone")
    public WebElement phone;



    @FindBy(xpath = "//*[text()='Your LastName is required.']")
    public WebElement lastnameRequired;

    // @FindBy(xpath = "//*[text()='Your FirstName is required.']")
    @FindBy(xpath = "//*[contains(text(),'Your FirstName is required.')]")
    public WebElement firstnameRequired;

    @FindBy(xpath = "//*[text()='Your SSN is required.']")
    public WebElement SSNRequired;

    @FindBy(xpath = "//*[text()='Your SSN is invalid']")
    public WebElement SSNinvalid;

    @FindBy(xpath = "//*[text()='Your email is required.']")
    public WebElement emailRequired;

    @FindBy(xpath = "//*[text()='This field is invalid']")
    public WebElement emailInvalid;

    @FindBy(xpath = "//*[text()='Phone number is required.']")
    public WebElement phoneRequired;

    @FindBy(xpath = "//*[text()='Phone number is invalid']")
    public WebElement phoneInvalid;

    @FindBy(xpath = "//*[text()='Send an Appointment Request']")
    public WebElement sendAppointmentButton;

    // bu kısımdan emin degilim

    @FindBy(xpath = "//*[@id='appointment']/div[1]/div/div/h2/text()")
    public WebElement makeAnAppointmentTitle;

    @FindBy(xpath = "//*[contains(text(),'Appointment registration saved')]")
    public WebElement successMessageToastContainer;



    @FindBy(xpath = "//*[@class='is-touched is-dirty av-valid form-control']")
    public WebElement verifyValid;

    // bu kısımdan sonrası sign In yaptıktan sonra gelen sayfa


    @FindBy(xpath = "//*[text()='MY PAGES(PATIENT)']")
    public WebElement myPagesButton;



    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myAppointmentsButton;

    @FindBy(id="appointment-heading")
    public WebElement appointmentsTitle;

    @FindBy(xpath = "//h2[text()='Make an Appointment']")
    public WebElement makeappointmentTitleinPortal;

    @FindBy(id= "fromDate")
    public WebElement fromDate;

    @FindBy(id= "toDate")
    public WebElement toDate;

    @FindBy(xpath = "//table/tbody/tr/td[3]")
    public WebElement startDateTime;

    @FindBy(xpath = "//span[text()='Make an Appointment']")
    public WebElement makeanAppointmentButton;













}

