package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class US22Page {

    public US22Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy( xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement Logindropdown;
    //  @FindBy(xpath = "//li[@class='dropdown show nav-item']")

    //   public WebElement logindropdown;
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signin;

    @FindBy(name="username")
    public WebElement usernamestaff;

    @FindBy (name ="password")
    public WebElement passwordstaff;

    //button[@class='btn btn-primary']
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public WebElement submituser;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;

    @FindBy(id = "entity-menu")
    public WebElement mypage;

    @FindBy(xpath ="//*[text()='Search Patient']")
    public WebElement searchpatient;

    @FindBy (xpath = "//input[@class='form-control']")
    public WebElement ssnblank;

    @FindBy (xpath = "//a[@class='btn btn-warning btn-sm']")
   // @FindBy(xpath = "//*[text()='Show Appointments']")
    public WebElement showapp;

    @FindBy (xpath="(//*[text()='Show Tests'])[2]")
  //  @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[2]")
    public WebElement showtest;

    @FindBy (xpath = "//span[@class='d-none d-md-inline']")
    public WebElement viewresult;

    @FindBy (xpath = "(//a[@class='btn btn-primary btn-sm'])[2]")
    public WebElement testedit;

    @FindBy (xpath = "//*[text()='Create or edit a Test Result']")
    public WebElement testtitle;

    @FindBy (id="c-test-result-result")
    public WebElement resultform;

    @FindBy (id="descriptionLabel")
    public WebElement desLabel;

    @FindBy (id="c-test-result-description")
    public WebElement description;

    @FindBy (id="c-test-result-cTestItem")
    public WebElement testitem;

    @FindBy (id="save-entity")
   // @FindBy (css = "svg.svg-inline--fa[data-icon='save']")
    public WebElement saveresult;










}
