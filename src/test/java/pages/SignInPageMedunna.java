package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPageMedunna {

    public SignInPageMedunna(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#username")
    public WebElement usernameBox;

    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;
}
