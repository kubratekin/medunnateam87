package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US28_Page {
    public US28_Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement accountMenu;

    @FindBy(xpath = "//a[@id='login-item']//*[name()='svg']")
    public WebElement homePageSignIn;

    @FindBy(xpath = "//h5[@class='modal-title']//span[contains(text(),'Sign in')]")
    public WebElement signInPageHeader;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']//span[contains(text(),'Sign in')]")
    public WebElement signInPageSignInButton;

    @FindBy(xpath = "//span[normalize-space()='team87admin team87admin']")
    public WebElement adminPage;

    @FindBy(xpath = "//span[normalize-space()='Items&Titles']")
    public WebElement itemsTitles;

    @FindBy(xpath = "//span[normalize-space()='Country']")
    public WebElement countryDropdown;

    @FindBy(xpath = "//span[normalize-space()='Countries']")
    public WebElement countriesHeader;

    @FindBy(xpath = "//span[normalize-space()='Create a new Country']")
    public WebElement createANewCountryButton;

    @FindBy(xpath = "//span[normalize-space()='Create or edit a Country']")
    public WebElement CreateANewCountryPage;

    @FindBy(xpath = "//input[@id='country-name']")
    public WebElement countryNameBox;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains(text(),'A new Country is created with identifier')]")
    public WebElement alertNewCountryCreated;

    @FindBy(xpath = "//span[normalize-space()='State/City']")
    public WebElement stateCityDropdown;

    @FindBy(xpath = "//span[normalize-space()='States/Cities']")
    public WebElement stateCityHeader;

    @FindBy(xpath = "//span[normalize-space()='Create a new State/City']")
    public WebElement createANewStateCity;

    @FindBy(xpath = "//span[normalize-space()='Create or edit a State/City']")
    public WebElement getCreateANewStateCityHeader;

    @FindBy(xpath = "//input[@id='c-state-name']")
    public WebElement stateCityNameBox;

    @FindBy(xpath = "//select[@id='c-state-state']")
    public WebElement countryDropDown;

    @FindBy(xpath = "//*[contains(text(),'A new State is created with identifier')]")
    public WebElement stateCityAlert;

    @FindBy(xpath = "//span[normalize-space()='Save']")
    public WebElement stateCitySaveButton;

    @FindBy(xpath = "//tbody//tr[last()]/td[4]/div/a[3]")
    public WebElement deleteCountry;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-country']//span[contains(text(),'Delete')]")
    public WebElement deleteConfirm;

    @FindBy(xpath = "//td[normalize-space()='umutumut']")
    public WebElement selectCountry;

    @FindBy(xpath = "//*[contains(text(),'A Country is deleted with identifier')]")
    public WebElement deletedMessage;





}
