package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US07_AppointmentPage {
    public US07_AppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@href='#appointment'])[1]")
    public WebElement makeAnAppointment;

    @FindBy(xpath = "(//h2['Make an Appointment'])[4]")
    public WebElement makeAnAppointmentTitle;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssn;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phone;

    @FindBy(xpath = "//input[@name='appoDate']")
    public WebElement appointmentDate;

    @FindBy(xpath = "//div[@class='col-md-12']//span")
    public WebElement sendAnAppointmentRequest;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertMessage;

    @FindBy(xpath = "//span[text()='Appointment date can not be past date!']")
    public WebElement pastDateWarning;
}
