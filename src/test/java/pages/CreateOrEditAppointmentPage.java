package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateOrEditAppointmentPage {

    public CreateOrEditAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#appointment-status")
    public WebElement appointmentStatusDropdown;

    @FindBy(css = "#save-entity")
    public WebElement saveButton;

    @FindBy(css = ".app-container>.Toastify>div>div>div:nth-of-type(1)")
    public WebElement updatedSuccessMessage;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDateBox;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDateBox;

    @FindBy(css = "#appointment-physician")
    public WebElement physicianDropdown;

    @FindBy(css = "#appointment-anamnesis")
    public WebElement anamnesisTextBox;

    @FindBy(css = "#appointment-treatment")
    public WebElement treatmentTextBox;

    @FindBy(css = "#appointment-diagnosis")
    public WebElement diagnosisTextBox;



}
