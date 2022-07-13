package pages;

import io.cucumber.java.zh_cn.假如;
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

    @FindBy(xpath = "((//table/tbody/tr/td)[16]/div/a)[2]")
    public WebElement editButton;

    @FindBy(xpath = "((//table/tbody/tr/td)[16]/div/a)[1]")
    public WebElement viewButton;

    @FindBy(css = ".form-control")
    public WebElement searchBox;

    @FindBy(id = "jh-create-entity")
    public WebElement createNewPatientButton;



    @FindBy(xpath = "(//nav/ul/li)[9]")
    public WebElement lastPageButton;

    @FindBy(xpath = "(//nav/ul/li[6])/a")
    public WebElement actualPageNumber;

    @FindBy(xpath = "(//nav/ul/li[5])/a")
    public WebElement previousPageNumber;



    //   --  //tbody/tr/td[2]
    //   --  //tbody/tr/td/div/a[3]
    // delete confirmation page delete button =>  css = #jhi-confirm-delete-patient





}
