package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class StaffPageMedunna {

    public StaffPageMedunna(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#account-menu>a>span")
    public WebElement staffNameDropdown;

    @FindBy(css = "#entity-menu")
    public WebElement myPagesDropdown;

    @FindBy(xpath = "(//div/a/span)[1]")
    public WebElement searchPatientButton;
}
