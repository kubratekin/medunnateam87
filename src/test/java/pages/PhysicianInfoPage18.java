package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PhysicianInfoPage18 extends BasePage18 {
    /*
    This page is navigated from signed admin home page from Items&Titles
     */

    public PhysicianInfoPage18() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "(//dd)[1]")
    public WebElement ssn;

    @FindBy(xpath = "/(//dd)[2]")
    public WebElement firstName;

    @FindBy(xpath = "(//dd)[3]")
    public WebElement lastName;

    @FindBy(xpath = "(//dd)[4]")
    public WebElement birthDate;

    @FindBy(xpath = "(//dd)[5]")
    public WebElement phone;

    @FindBy(xpath = "(//dd)[6]")
    public WebElement gender;

    @FindBy(xpath = "(//dd)[7]")
    public WebElement bloodGroup;

    @FindBy(xpath = "(//dd)[8]")
    public WebElement address;

    @FindBy(xpath = "(//dd)[9]")
    public WebElement speciality;

    @FindBy(xpath = "(//dd)[13]")
    public WebElement user;

    @FindBy(xpath = "(//dd)[10]")
    public WebElement description;

    @FindBy(xpath = "(//dd)[11]")
    public WebElement createdDate;

    @FindBy(xpath = "(//dd)[12]")
    public WebElement photo;

    @FindBy(xpath = "(//dd)[14]")
    public WebElement country;

    @FindBy(xpath = "(//dd)[15]")
    public WebElement state;

}
