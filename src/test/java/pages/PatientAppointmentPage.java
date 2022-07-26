package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientAppointmentPage {

    public PatientAppointmentPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//tbody/tr[1]/td/div[1]/a[1]")
    public WebElement editButton;

    @FindBy(xpath = "//tbody/tr[1]/td/div/a[2]")
    public WebElement showTestsButton;




}
