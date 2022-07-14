package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US10_PatientPage {
  public  US10_PatientPage() {

    PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy( xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement Logindropdown;
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signin;
    @FindBy(name="username")
    public WebElement usernamephysician;
    @FindBy (name ="password")
    public WebElement passwordphysician;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;
    @FindBy(id = "entity-menu")
    public WebElement mypage;

    @FindBy(xpath = "//*[text()='My Patients']")
    public WebElement mypatients;
    @FindBy(xpath="//h2[@id='patient-heading']")
    public WebElement patientheading;
    @FindBy (xpath="//*[text()='First Name']")
    public WebElement patientfirstname;
    @FindBy (xpath = "//*[text()='Last Name']")
    public WebElement patientlastname;
    @FindBy (xpath="//*[text()='Created Date']")
    public WebElement createddate;
}
