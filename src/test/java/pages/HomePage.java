package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//a[@aria-expanded='false']")
    public WebElement accountMenuDropdown;
    @FindBy (xpath = "//a[@href='/login']")
    public WebElement accountSignInDropdownSelect;
    @FindBy (xpath = "//a[@href='/account/register']")
    public WebElement accountRegisterDropdownSelect;



}
