package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US17_Page {

    public US17_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[contains (text(), 'Items&Titles')]")
    public WebElement itemsTitlesDropdown;

    @FindBy(xpath = "(//*[contains (text(), 'Test Item')])[1]")
    public WebElement testItem;

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement createANewTestItem;

    @FindBy(xpath = "//input[@id='c-test-item-name']")
    public WebElement nameBox;

    @FindBy(xpath = "//input[@id='c-test-item-description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//input[@id='c-test-item-price']")
    public WebElement priceBox;

    @FindBy(xpath = "//input[@id='c-test-item-defaultValMin']")
    public WebElement defMinValueBox;

    @FindBy(xpath = "//input[@id='c-test-item-defaultValMax']")
    public WebElement defMaxValueBox;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[contains (text(), 'A new Test Item is created with identifier')]")
    public WebElement createdItemSuccessMsg;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement signOutButton;

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//tbody//tr[1]//td/div/a[2]")
    public WebElement editButton;

    @FindBy(xpath = "//*[contains (text(), 'A Test Item is updated with identifier')]")
    public WebElement updatedItemSuccessMsg;

    @FindBy(xpath = "//tbody//tr[1]//td/div/a[1]")
    public WebElement viewButton;

    @FindBy(xpath = "(//*[contains (text(), 'Test Item')])[2]")
    public WebElement verifyTestItem;

    @FindBy(xpath = "//tbody//tr[7]//td[last()]/div/a[3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-cTestItem']")
    public WebElement deleteButton2;

    @FindBy(xpath = "//*[contains (text(), 'A Test Item is deleted with identifier')]")
    public WebElement deleteSuccessMsg;

    @FindBy(xpath = "//nav/ul/li[last()]/a")
    public WebElement lastPageArow;

    @FindBy(xpath = "//nav/ul/li[2]/a")
    public WebElement previousPageArow;

    @FindBy(xpath = "//li[@class='page-item']")
    public WebElement pageNumberContainer;

    @FindBy(xpath = "//tbody/tr[3]/td[2]")
    public WebElement element;

    @FindBy(xpath = "//tbody//tr//td[3]")
    public List<WebElement> desInfo;

    @FindBy(xpath = "//tbody//tr//td[2]")
    public List<WebElement> nameInfo;

}
