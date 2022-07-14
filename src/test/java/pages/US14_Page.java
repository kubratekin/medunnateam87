package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_Page {

    public US14_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[contains(text(), 'MY PAGES')]")
    public WebElement myPages;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement myInpatients;

    @FindBy(xpath = "//table[@class='table']" )
    public WebElement entireTable;

    @FindBy(id = "in-patient-description")
    public WebElement description;

    @FindBy(id = "in-patient-createdDate")
    public WebElement createdDate;

    @FindBy(id = "in-patient-status")
    public WebElement status;

    @FindBy(id = "in-patient-room")
    public WebElement room;

    @FindBy(xpath = "//*[contains(text(), 'Save')]")
    public WebElement saveButton;

    @FindBy(xpath = "//a[@href='/in-patient/119355/edit']")
    public WebElement editButton;

    @FindBy(xpath = "//*[contains(text(),'The In Patient is updated with identifier')]")
    public WebElement successMsgAlert;

    @FindBy(xpath = "//*[contains (text(), 'InPatient status can not be changed with this type of status')]")
    public WebElement failureMessage;

    @FindBy(xpath = "//a[@href='/in-patient/116098/edit']")
    public WebElement editButton2;

}
