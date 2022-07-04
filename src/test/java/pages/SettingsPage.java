package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SettingsPage {
    public SettingsPage(){

        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath ="//input[@name='firstName']")
    public WebElement firstnameTextBox;
    @FindBy(xpath ="//input[@name='lastName']")
    public WebElement lastnameTextBox;
    @FindBy(xpath ="//input[@name='email']")
    public WebElement emailTextBox;
    @FindBy (xpath = "//span[text()='Save']")
    public WebElement saveButton;

}
