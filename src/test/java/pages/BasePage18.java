package pages;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class BasePage18 {

    RequestSpecification spec;

    public BasePage18() {
        PageFactory.initElements(Driver.getDriver(), this);


    }
    @FindBy(xpath = "//a[@href='/home']")
    public WebElement homeLink;

    @FindBy(xpath = "//a[@href='/about']")
    public WebElement aboutLink;

    @FindBy(xpath = "//a[@href='/service']")
    public WebElement servicesLink;

    @FindBy(xpath = "//a[@href='/departments']")
    public WebElement departmentsLink;

    @FindBy(xpath = "//a[@href='/doctors']")
    public WebElement doctorsLink;

    @FindBy(xpath = "//a[@href='/contact']")
    public WebElement contactLink;

    @FindBy(xpath = "//div[@class='Tostify']")
    public WebElement toastifyAlertBox;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement toastifyAlertBoxMessage;

    @FindBy(xpath = "//button[@class='Toastify__close-button Toastify__close-button--success']")
    public WebElement toastifyAlertBoxCloseButton;

    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement accountMenu;

    @FindBy(id = "login-item")
    public  WebElement signIn;



    /*
     this function checks Tostify Message with <message> is visible or not
        @return boolean: is visible return true or false
    */
    public boolean isToastifyMessageVisible(String message, int timeToWaitInSec) {
        String xPathStr = "//div[contains(text(),'" + message + "')]";
        WebElement toastifyMessage = Driver.getDriver().findElement(By.xpath(xPathStr));
        boolean isVisible = false;
        try {
            toastifyMessage = Driver.waitForVisibility(toastifyMessage, timeToWaitInSec);
            isVisible = toastifyMessage.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            isVisible = false;
        } catch (TimeoutException e) {
            e.printStackTrace();
            isVisible = false;
        }
        return isVisible;
    }

    public String getToastifyMessage() {
        String xPathStr = "//div[@class='Toastify__toast-body']";
        String message=null;
        try {
            WebElement toastifyMessage = Driver.waitForVisibility(By.xpath(xPathStr), 3);
            message = toastifyMessage.getText();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            message=null;
        } catch (TimeoutException e){
            e.printStackTrace();
            message=null;
        }
        return message;
    }

    public void closeToastify(){
        WebElement closeButton = Driver.waitForClickablility(this.toastifyAlertBoxCloseButton, 2);
        closeButton.click();
    }

    public void url(){
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("ui_base_url")).build();
    }
}