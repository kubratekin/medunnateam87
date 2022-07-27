package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientsPage {

    public PatientsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#entity-menu")
    public WebElement myPagesDropdown;

    @FindBy(css = "#entity-menu>div>a:last-of-type")
    public WebElement makeAnAppointmentButton;

    @FindBy(css = "#phone")
    public WebElement phoneTextBox;

    @FindBy(css = "#register-submit")
    public WebElement sendAppointmentRequest;

    @FindBy(css = "#account-menu>a")
    public WebElement userMenuDropdown;

    @FindBy(css = "#account-menu>div>a:last-of-type")
    public WebElement signOutButton;

    @FindBy(css = "#account-menu>div>a:first-of-type")
    public WebElement signInButton;



}
