package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminPageMedunna {

    public AdminPageMedunna(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#admin-menu")
    public WebElement administrationDropdown;

    @FindBy(css = "#entity-menu")
    public WebElement itemsAndTitlesDropdown;

    @FindBy(xpath = "(//a[@href='/patient'])[1]")
    public WebElement patientButton;
}
