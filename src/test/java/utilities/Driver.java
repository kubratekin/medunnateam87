package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public abstract class Driver {

    static US17_Page us17Page = new US17_Page();

//My Driver class is abstract so I do not create an object of this class
//TestBase class is also abstract

    private static final int timeout = 5;
    private Driver(){
    }
    private static WebDriver driver;
    public static WebDriver getDriver(){
        if(driver==null) {
            switch (ConfigReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    options.addArguments("disable-gpu");
                    driver = new ChromeDriver(options);
                    break;

            }
        }
        assert driver != null;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver2(String browser){
        if(driver==null) {
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "chrome-headless":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    options.addArguments("disable-gpu");
                    driver = new ChromeDriver(options);
                    break;

            }
        }
        assert driver != null;
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndClick(WebElement element) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }



    public static void waitAndSendText(WebElement element,String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndSendText(WebElement element,String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }
    public static void waitAndSendTextWithDefaultTime(WebElement element,String text) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public static String waitAndGetText(WebElement element, int timeout) {
        String text="";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }


    //Webdriver
    //ChromeDriver
    //Iedriver
    //FirefoxDriver

    public static void wait2(int sec){
        try {
            Thread.sleep(1000*sec);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }catch (TimeoutException e){
            e.printStackTrace();
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    //5 seconds
    public static void waitAndClickElement(WebElement element , int seconds){
        for (int i = 0; i < seconds ; i++) {

            try {
                element.click();
                break;
            }catch (Exception e){
                wait2(1);
            }


        }
    }

    public static void closeDriver(){
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }

    public static void wait(int secs) {


        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    public static void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript(command, element);
    }

    public static void selectAnItemFromDropdown(WebElement item, String selectableItem){
        wait(5);
        Select select = new Select(item);
        for (int i =0;i<select.getOptions().size();i++){
            if(select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)){
                select.getOptions().get(i).click();
                break;
            }
        }

    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param elements
     */
    public static void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each,5));
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", each);
        }
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    public static void selectByVisibleText(WebElement element, String text){
        Select objSelect =new Select(element);
        objSelect.selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement element, int index){
        Select objSelect =new Select(element);
        objSelect.selectByIndex(index);
    }

    public static void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        List<WebElement> elementCount = objSelect.getOptions();
        objSelect.selectByValue(value);
        System.out.println("number of elements: "+elementCount.size());
    }

    public static void sleep(int timeOut){
        try {
            Thread.sleep(timeOut);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void waitAndClickLocationText(WebElement element, String value){
        Driver.getDriver().findElement(By.xpath("//*[text()='"+value+"']")).click();
    }

    public static void navigateToUrl(String url){
        Driver.getDriver().get("https://medunna.com/");
    }

    public static void adminLogIn(String userName, String password){
        navigateToUrl(ConfigReader.getProperty("medunaUrl"));
        HomePageMedunna homePage = new HomePageMedunna();
        waitAndClick(homePage.logInDropdown,1);
        waitAndClick(homePage.signInButton,1);
        SignInPageMedunna signInPage = new SignInPageMedunna();
        waitAndSendText(signInPage.usernameBox,userName);
        waitAndSendText(signInPage.passwordBox,password);
        waitAndClick(signInPage.signInButton,1);
    }

    public static void createNewPatientByAdmin(String firstName,String lastName,String email,String phone){
        adminLogIn("team87_admin","1234567");
        AdminPageMedunna adminPage = new AdminPageMedunna();
        waitAndClick(adminPage.itemsAndTitlesDropdown,1);
        waitAndClick(adminPage.patientButton,2);
        PatientViewByAdminAndStaffPageMedunna viewByAdminAndStaff = new PatientViewByAdminAndStaffPageMedunna();
        waitAndClick(viewByAdminAndStaff.createNewPatientButton,1);
        CreateOrEditPatientPage createPatient = new CreateOrEditPatientPage();
        waitAndSendText(createPatient.firstNameTextBox, firstName);
        waitAndSendText(createPatient.lastNameTextBox, lastName);
        waitAndSendText(createPatient.emailTextBox, email);
        waitAndSendText(createPatient.phoneTextBox, phone);
        waitAndClick(createPatient.saveButton,1);
        Driver.wait(3);
        if (!viewByAdminAndStaff.infoSavedMessage.getText().contains("A Patient is created with identifier")){
            System.out.println("Patient can not be created");
        }
    }

    public static void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void findItemAmongPagesDeleteButton(String name, String description){
        WebElement lastPageButton = Driver.getDriver().findElement(By.xpath("//nav/ul/li[last()]/a"));

        int pagesNumber = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//nav/ul/li[7]")).getText());
        Driver.waitAndClickElement(lastPageButton,2);

        List<WebElement> nameList;
        List<WebElement> desList;

        int row = 1;
        // number of last page
        boolean doWhile = false;        // For breaking the loop
        do {
            nameList= us17Page.nameInfo ;     // Otherwise it gave exception
            desList= us17Page.desInfo;         // Otherwise it gave exception
            System.out.println(nameList.size());
            System.out.println(desList.size());

            for (int i = 0; i < nameList.size(); i++) {
                if (nameList.get(i).getText().equals(name) && desList.get(i).getText().equals(description)) {
                    row = i + 1;
                    doWhile=true;
                    break;
                }
            }
            nameList.clear();
            desList.clear();

            if (doWhile){
                break;
            }

        } while (pagesNumber>1);

        String xpath = "//tbody//tr["+row+"]//td[8]/div/a[3]";
        WebElement deleteButton = Driver.getDriver().findElement(By.xpath(xpath));
        Driver.waitAndClickElement(deleteButton,2);
        Driver.wait(2);
        Driver.waitAndClickElement(us17Page.deleteButton2,2);

    }


}