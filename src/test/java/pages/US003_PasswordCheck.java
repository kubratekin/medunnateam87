package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class US003_PasswordCheck {

    public US003_PasswordCheck() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div/ul/li[@id = 'account-menu']")
    public WebElement register1;

    @FindBy(xpath = "//div/ul//li[7]//span[text()='Register']")
    public WebElement register2;

    @FindBy (xpath = "//input[@name='firstPassword']")
    public WebElement newPassword;

    @FindBy (xpath = "//input[@name='secondPassword']")
    public WebElement comfirmationPassword;

    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement shortPassword;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[1]")
    public WebElement strength1;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[2]")
    public WebElement strength2;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[3]")
    public WebElement strength3;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[4]")
    public WebElement strength4;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[5]")
    public WebElement strength5;






}
