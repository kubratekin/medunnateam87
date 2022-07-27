package pages;

import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PatientViewByAdminAndStaffPageMedunna {

    public PatientViewByAdminAndStaffPageMedunna(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#patient-heading>span")
    public WebElement patientInfoTableHeader;

    @FindBy(xpath = "(//table[@class='table']/tbody/tr/td/a)[1]")
    public WebElement idOfFirstPatient;

    @FindBy(xpath = "//*[contains(text(), 'A Patient is updated with identifier')]")
    public WebElement infoSavedMessage;

    @FindBy(xpath = "//tbody/tr/td/div/a[2]")
    public WebElement editButton;

    @FindBy(xpath = "//tbody/tr/td/div/a[1]")
    public WebElement viewButton;

    @FindBy(css = ".form-control")
    public WebElement searchBox;

    @FindBy(id = "jh-create-entity")
    public WebElement createNewPatientButton;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public List<WebElement> nameList;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> ssnList;

    @FindBy(css = ".app-container>div>div>div>.Toastify__toast-body")
    public WebElement appointmentSavedMessage;



// US21

    @FindBy(css = ".col-sm-3>input")
    public WebElement ssnSearchBox;

    @FindBy(xpath = "//tbody/tr/td[last()]/div/a[last()]")
    public WebElement showAppointmentButton;









}
