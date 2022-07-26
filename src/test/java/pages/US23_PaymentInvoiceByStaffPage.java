package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US23_PaymentInvoiceByStaffPage {
    public US23_PaymentInvoiceByStaffPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

//-----------TC01 ----------
    @FindBy(xpath = "//*[@id='account-menu']")
    public WebElement signInLogo;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement signIn;


    @FindBy(xpath = "//*[@id='entity-menu']")
    public WebElement itemsTitles;

    @FindBy(xpath = "//span[normalize-space()='MY PAGES']")
    public WebElement myPages;

    @FindBy(xpath = "//*[contains(text(),'Search Patient')]")
    public WebElement searchPatient;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement ssnSerchBox;

    @FindBy(xpath = "//tbody/tr/td[16]/div/a[3]")
    public WebElement showAppointmentsButton;

    @FindBy(xpath = "//tbody/tr/td[13]/div/a[3]")
    public WebElement paymentInvoiceProccessButton;

    @FindBy(xpath = "//thead/tr/th[text()='PAYMENT DETAIL']")
    public WebElement paymentDetailTitle;
//-------------TC02------------------
    @FindBy(xpath = "//tbody/tr/td[4]")
    public WebElement appointmentsStatus;

    @FindBy(xpath = "//*[text()=' Create Invoice']")
    public WebElement createInvoiceButton;
//--------------TC04-------------------
    @FindBy(xpath = "//*[text()='Exam Fee:']")
    public WebElement examFeeTitle;

    @FindBy(xpath = "//thead/tr/td/table/thead/tr/td[2]")
    public WebElement testItemFeeTitle;
//--------------TC05--------------------
    @FindBy(xpath = "//*[text()=' Show Invoice']")
    public WebElement showInvoiceButton;

    @FindBy(xpath = "//*[text()='INVOICE']")
    public WebElement invoiceTitleInInvoicePage;


//------------ Login Page Elements----------
    @FindBy(name="username")
    public WebElement username;

    @FindBy(name="password")
    public WebElement password;

    @FindBy(xpath="(//span[text()='Sign in'])[3]")
    public WebElement loginButton;


}
