package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PatientDetailPage {

    public PatientDetailPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".btn:nth-of-type(2)")
    public WebElement editButton;
}
