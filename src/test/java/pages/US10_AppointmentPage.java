package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US10_AppointmentPage {
    public US10_AppointmentPage()
    {
     PageFactory.initElements(Driver.getDriver(),this);}



    @FindBy( xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement Logindropdown;
    //  @FindBy(xpath = "//li[@class='dropdown show nav-item']")

    //   public WebElement logindropdown;
    @FindBy(xpath = "//*[text()='Sign in']")
    public WebElement signin;
    @FindBy(name="username")
    public WebElement usernamephysician;
    @FindBy (name ="password")
    public WebElement passwordphysician;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;


    //  @FindBy(xpath = "//*[text()='MY PAGES']")
    //  public WebElement mypage;
    @FindBy(id = "entity-menu")
    public WebElement mypage;
    @FindBy(xpath = "//*[text()='My Appointments']")
    public WebElement myappointment;
    @FindBy(xpath = "//h2[@id='appointment-heading']")
    public WebElement appointmentheading;
    @FindBy (xpath = "//span[@class='d-none d-md-inline']")
    public WebElement editapp;
    @FindBy(xpath = "//*[text()='Start DateTime']")
    public WebElement startdate;
    @FindBy(xpath = "//*[text()='End DateTime']")
    public WebElement enddate;

    @FindBy(xpath = "//select[@id='appointment-status']")
    public WebElement statusapp;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement savesubmit;
    // @FindBy(xpath = "//button[@id='save-entity']")
    // public WebElement saveapp;

}
