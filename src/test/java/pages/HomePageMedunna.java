package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePageMedunna {

    public HomePageMedunna(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#account-menu>a")
    public WebElement logInDropdown;

    @FindBy(css = "#login-item")
    public WebElement signInButton;

   @FindBy(xpath = "//span[normalize-space()='Register']")
    public WebElement registerButton;  //emin
}
