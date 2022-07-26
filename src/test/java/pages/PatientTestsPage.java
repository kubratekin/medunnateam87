package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PatientTestsPage {

    public PatientTestsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = ".alert>span")
    public WebElement noTestsText;

    @FindBy(css = ".btn-group>a")
    public WebElement viewResultsButton;

    @FindBy(xpath = "//tbody/tr[1]/td")
    public List<WebElement> testResultsList;



}
