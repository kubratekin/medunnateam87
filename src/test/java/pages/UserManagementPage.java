package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserManagementPage {

    public UserManagementPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//nav/ul/li[last()]")
    public WebElement lastPageButton;

    @FindBy(css = ".modal-content>div:last-of-type>button:last-of-type")
    public WebElement confirmDeleteButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteSuccessMessage;

    @FindBy(xpath = "(//nav/ul/li)[5]/a")
    public WebElement beforePageNumber;

    @FindBy(xpath = "(//nav/ul/li)[6]/a")
    public WebElement actualPageNumber;






}
