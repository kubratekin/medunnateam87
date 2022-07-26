package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactPage {

    public ContactPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath ="//*[text()='CONTACT']")
    public WebElement contactButton;

    @FindBy(xpath ="//h2[text()='Contact']")
    public WebElement contactTextTitle;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement contactNameTextBox;

    @FindBy(xpath ="//input[@name='email']")
    public WebElement contactEmailTextBox;

    @FindBy(xpath ="//input[@name='subject']")
    public WebElement contactSubjectTextBox;

    @FindBy(xpath ="//textarea[@name='message']")
    public WebElement contactMessageTextBox;

    @FindBy(xpath = "//div[text()='Name is required.']")
    public WebElement nameRequiredMessage;

    @FindBy(xpath = "//div[text()='Your email is required.']")
    public WebElement emailRequiredMessage;

    @FindBy(xpath = "//div[text()='This field is required.']")
    public WebElement subjectRequiredMessage;

    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement invalidEmailMessage;


    @FindBy(xpath ="//button[@type='submit']")
    public WebElement contactSendButton;

    @FindBy(xpath ="//div[@class='Toastify__toast-body']")
    public WebElement contactSendAlert;
}
