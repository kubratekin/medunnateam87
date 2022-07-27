package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US24Page {
    public US24Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[normalize-space()='MY PAGES(PATIENT)']")
    public WebElement myPage;
    @FindBy(xpath = "//span[normalize-space()='My Appointments']")
    public WebElement myAppointments;
    @FindBy(xpath = "(//span[contains(text(),'Show Tests')])[1]")
    public WebElement showTests;
    @FindBy(xpath = "(//span[contains(text(),'View Results')])[1]")
    public WebElement viewResults;
    @FindBy(xpath = "//body//div//th")
    public List<WebElement> testHeader;
    @FindBy(xpath = "//tbody")
    public List<WebElement> testBody;
    @FindBy(xpath = "//span[contains(text(),'Show Invoice')]")
    public WebElement showInvoice;
    @FindBy(xpath = "//th[normalize-space()='INVOICE']")
    public WebElement invoiceHeader;
    @FindBy(xpath = "(//tr)[3]/th[1]")
    public WebElement dateHeader;
    @FindBy(xpath = "//th[normalize-space()='2022-07-21T10:07:47.795610Z']")
    public WebElement dateOfInvoice;
    @FindBy(xpath = "(//tr)[4]/th[1]")
    public WebElement ssnHeader;
    @FindBy(xpath = "//th[normalize-space()='899-99-9999']")
    public WebElement ssnOfPatientOnInvoice;
    @FindBy(xpath = "(//tr)[5]/th[1]")
    public WebElement nameHeader;
    @FindBy(xpath ="//th[normalize-space()='Cecile Loin']" )
    public WebElement nameOfPatientOnInvoice;
    @FindBy(xpath = "(//tr)[6]/th[1]")
    public WebElement paymentMethod;
    @FindBy(xpath ="//th[normalize-space()='CASH']" )
    public WebElement paymentMethodOfInvoice;
    @FindBy(xpath ="(//tr)[7]/th[1]" )
    public WebElement totalCost;
    @FindBy(xpath = "//th[normalize-space()='36$']")
    public WebElement totalCostOfInvoice;

}

