package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class US_027_AdminPages extends BasePage{

    //-----------US027 locators------------------
    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement accountmenu;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement homePageSignIn;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement adminnUserName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement adminnPassword;

    @FindBy(xpath = "(//*[.='Sign in'])[4]")
    public WebElement adminnSignInButton;

    @FindBy(xpath = "(//*[.='Administration'])[2]")
    public WebElement adminPageAdministrationDropDown;

    @FindBy (xpath = "(//*[.='Items&Titles'])[2]")
    public WebElement adminPageItemsAndTitlesDropDown;

    @FindBy (xpath = "(//*[.='Messages'])[1]")
    public WebElement adminItemsAndTitlesDropdownMessagesButton;

    @FindBy (xpath = "(//*[.='Messages'])[2]")
    public WebElement messagePageMessagesText;

    //(//table//tbody//tr)[position()<=last()] -->  webtabledaki tum datalar
    @FindBy (xpath = "(//table//tbody//tr[position()<=last()])//td[position()<6]")
    public List<WebElement> allMessagesInfo;

    @FindBy (xpath = "//table//tbody//tr//td[1]")
    public List<WebElement> messagesIdColumn;

    @FindBy (xpath = "//table//tbody//tr//td[2]")
    public List<WebElement> messagesNameColumn;

    @FindBy (xpath = "//table//tbody//tr//td[3]")
    public List<WebElement> messagesEmailColumn;

    @FindBy (xpath = "//table//tbody//tr//td[4]")
    public List<WebElement> messagesSubjectColumn;

    @FindBy (xpath = "//table//tbody//tr//td[5]")
    public List<WebElement> messagesMessageColumn;

////table//tbody//tr//td[position()= 1 or position() = 2 or position()= 3 or position() = 4 or  position() = 5]

    //------------TC027002------------------------
    @FindBy (xpath = "//*[.='Create a new Message']")
    public WebElement creatingANewMessage;

    @FindBy (xpath = "(//*[.='Create or edit a Message'])[4]")
    public WebElement createOrEditAMessagePageText;

    @FindBy (id ="c-message-name")
    public WebElement messageNameTextBox;

    @FindBy (id = "c-message-email")
    public WebElement messageEmailTextBox;

    @FindBy (id = "c-message-subject")
    public WebElement messageSubjectTextBox;

    @FindBy (id = "c-message-message")
    public WebElement messageMessageTextBox;

    @FindBy (xpath = "//*[.='Save']")
    public WebElement createOrEditAMessagePageSaveButton;

    @FindBy (xpath = "//*[contains(text(),'A new Message is created with identifier')]")
    public WebElement successfullyCreatedANewMessageText;


    //------------TC027003------------------------
    @FindBy (xpath = "(//*[.='Edit'])[4]")
    public WebElement messagePageForthEditButton;

    @FindBy (xpath = "//*[contains(text(),'A Message is updated with identifier')]")
    public WebElement succesfullyUpdatedMessageText;


    //------------TC027005,6,7,8,9,10------------------------
    @FindBy(xpath = "(//*[.='Delete'])[4]")
    public WebElement messagePageForthDeleteButton;

    @FindBy(xpath = "//*[contains(text(),'Are you sure you want to delete Message')]")
    public WebElement deleteConfirmationToastContainerText;

    @FindBy(id="jhi-confirm-delete-cMessage")
    public WebElement deleteConfirmationToastContainerDeleteButton;

    @FindBy (xpath = "//*[contains(text(),'Message is deleted with identifier')]")
    public WebElement succesfullyDeletedMessageText;

    @FindBy (xpath = "(//*[.='This field is required.'])[2]")
    public WebElement warningMessageUnderNameTextBox;

    @FindBy (xpath = "(//*[.='Your email is required.'])[2]")
    public WebElement warningMessageUnderEmailTextBox;

    @FindBy (xpath = "(//*[.='This field is required.'])[2]")
    public WebElement warningMessageUnderSubjectTextBox;

    @FindBy (xpath = "(//*[.='This field is invalid'])[2]")
    public WebElement invalidEmailWarningMessageUnderEmailTextBox;




}
