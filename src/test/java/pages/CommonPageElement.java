package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CommonPageElement {
    public CommonPageElement(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id="account-menu")
    public WebElement signInAndRegistrationPortal;

    @FindBy(id="login-item")
    public WebElement signIn;

}
