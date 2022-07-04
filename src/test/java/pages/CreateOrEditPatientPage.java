package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CreateOrEditPatientPage {

    public CreateOrEditPatientPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2")
    public WebElement createOrEditTableHeader;

    @FindBy(id = "patient-firstName")
    public WebElement firstNameTextBox;

    @FindBy(id = "patient-lastName")
    public WebElement lastNameTextBox;

    @FindBy(id = "patient-birthDate")
    public WebElement birthDateTextBox;

    @FindBy(id = "email")
    public WebElement emailTextBox;

    @FindBy(id = "patient-phone")
    public WebElement phoneTextBox;

    @FindBy(id = "patient-gender")
    public WebElement genderDropdown;

    @FindBy(id = "patient-bloodGroup")
    public WebElement bloodGroupDropdown;

    @FindBy(id = "patient-adress")
    public WebElement addressTextBox;

    @FindBy(id = "patient-description")
    public WebElement descriptionTextBox;

    @FindBy(id = "patient-user")
    public WebElement userDropdown;

    @FindBy(id = "patient-country")
    public WebElement countryDropdown;

    @FindBy(id = "patient-cstate")
    public WebElement stateCityDropdown;

    @FindBy(id = "save-entity")
    public WebElement saveButton;
}
