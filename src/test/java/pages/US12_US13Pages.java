package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US12_US13Pages {

    public US12_US13Pages() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="account-menu")
    public WebElement accountMenu;

    @FindBy(id="login-item")
    public WebElement loginItem;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    public WebElement signinButton;

    @FindBy(xpath = "//span[normalize-space()='team87doctor team87doctor']")
    public WebElement doctorAccount;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement myPage;

    @FindBy(partialLinkText = "My Appointments")
    public WebElement myAppointement;

    @FindBy(id="appointment-heading")
    public WebElement myAppointmentHeading;

    @FindBy(xpath = "(//span[@class=\"d-none d-md-inline\"])[1]")
    public WebElement editButton;
    //==================
    @FindBy(xpath = "//h2[@id=\"hospitalmsappfrontendApp.appointment.home.createOrEditLabel\"]")
    public WebElement createOrEditAnAppointementHeading;

    @FindBy(xpath = "//a[normalize-space()='Request A Test']")
    public WebElement requestATestButton;

    @FindBy(xpath = "//h2[@id=\"c-test-item-heading\"]")
    public WebElement testItemHeading;

    @FindBy(id = "1404")
    public WebElement sodium;

    @FindBy(id = "1408")
    public WebElement hemoglobin;

    @FindBy(id = "1402")
    public WebElement urea;

    @FindBy(id="save-entity")
    public WebElement saveTestButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement testIsCreatedAlertMessage;

    @FindBy(xpath = "//span[normalize-space()='No Test Items found']")
    public WebElement testIsNotCreatedAlertErrorMessage;

    @FindBy(xpath = "//button[normalize-space()='Request Inpatient']")
    public WebElement requestInpatientButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement InpatientRequestDoneAlertErrorMessage;

    @FindBy(xpath = "//div[@role='alert']")
    public  WebElement InpatientRequestDoneAlertSuccessMessage;

    @FindBy (xpath = "//a[normalize-space()='Show Test Results']")
    public WebElement showTheTestResultButton;

    @FindBy(xpath = "//a[@class=\"btn btn-info btn-sm\"][1]")
    public WebElement viewResultButton;

    @FindBy(xpath = "//h2")
    public WebElement testsPageHeading;

    @FindBy(xpath = "//table/thead/tr")
    public WebElement testResultHeadingList;
}
