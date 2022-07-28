package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserManagementPage {

    public UserManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//nav/ul/li[last()]")
    public WebElement lastPageButton;

    @FindBy(css = ".modal-content>div:last-of-type>button:last-of-type")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteSuccessMessage;

    @FindBy(xpath = "(//nav/ul/li)[5]/a")
    public WebElement beforePageNumber;

    @FindBy(xpath = "(//nav/ul/li)[6]/a")
    public WebElement actualPageNumber;

    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement loginDropDownButton;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signInButtonfirst;

    @FindBy(css = "#username")
    public WebElement usernameBox;

    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(css = "button[type='submit']")
    public WebElement signInButton;

    @FindBy(xpath ="//span[text()='Administration']")
    public WebElement administration;

    @FindBy(xpath ="//span[text()='User management']")
    public WebElement userManagement;

    @FindBy(xpath ="//span[text()='Users']")
    public WebElement usersHead;

    @FindBy(xpath ="//span[text()='Create a new user']")
    public WebElement createAnewUser;

    @FindBy(xpath ="//input[@name='login']")
    public WebElement login;

    @FindBy(xpath ="//input[@name='firstName']")
    public WebElement first_Name;

    @FindBy(xpath ="//input[@name='lastName']")
    public WebElement last_Name;

    @FindBy(xpath ="//input[@name='email']")
    public WebElement email_Name;

    @FindBy(xpath ="//input[@name='ssn']")
    public WebElement ssnNumber;

    @FindBy(xpath ="//span[text()='Save']")
    public WebElement saveButton;

    @FindBy(id = "modified-date-sort")
    public WebElement ModifiedDate;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement successMessage;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public  WebElement editButton;

    @FindBy(xpath = "(//span[text()='First name'])[1]")
    public  WebElement viewFirstName;

    @FindBy( id = "activated" )
    public WebElement activated;

    @FindBy( xpath = "//span[text()='Save']")
    public WebElement SaveButton;

    @FindBy(id = "authorities")
    public  WebElement profiles;

    @FindBy(xpath = "(//span[text()='Delete'])[1]")
    public  WebElement delete;

//    @FindBy(css = ".modal-content>div:last-of-type>button:last-of-type")
//    public WebElement confirmDeleteButton;
//
//    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
//    public WebElement deleteSuccessMessage;
//
//    @FindBy(xpath = "//nav/ul/li[last()]")
//    public WebElement lastPageButton;
//
//    @FindBy(xpath = "(//nav/ul/li)[5]/a")
//    public WebElement beforePageNumber;
//
//    @FindBy(xpath = "(//nav/ul/li)[6]/a")
//    public WebElement actualPageNumber;
//

}
