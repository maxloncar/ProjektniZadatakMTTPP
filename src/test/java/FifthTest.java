import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FifthTest {
    //-------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;
    //Declare a test URL variable
    public String testURL = "https://www.hgshop.hr/";
    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
        //Create a new ChromeDriver
        driver = new ChromeDriver();
        //maximize the browser window
        driver.manage().window().maximize();
        //Go to https://www.hgshop.hr/
        driver.navigate().to(testURL);
    }
    @Test
    public void changeProfileDataTest() throws InterruptedException {
        //Explicit wait until "Prijava" is visible
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tertiary-topbar-nav\"]/a[4]")));
        //Click on navbar element "Prijava" in the top right corner
        WebElement signIn = driver.findElement(By.xpath("//*[@id=\"tertiary-topbar-nav\"]/a[4]"));
        signIn.click();
        //Input Email
        WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        email.sendKeys("djurodjuric@gmail.com");
        //Input Password
        WebElement password = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/input[2]"));
        password.sendKeys("djuro123");
        //Click on checkbox "Zapamti me"
        WebElement rememberCheckBox = driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[5]/label"));
        rememberCheckBox.click();
        //Click on button "PRIJAVI SE"
        driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[6]/input")).click();
        //Explicit wait until "Profil" is visible
        WebDriverWait waitForProfile = new WebDriverWait(driver,2);
        waitForProfile.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tertiary-topbar-nav\"]/a[5]")));
        //Click on navbar element "Profil" in the top right corner
        WebElement checkProfile = driver.findElement(By.xpath("//*[@id=\"tertiary-topbar-nav\"]/a[5]"));
        checkProfile.click();
        //Click on button "PROMIJENI PROFIL"
        WebElement changeProfile = driver.findElement(By.xpath("//*[@id=\"single-product-layout\"]/div/div/div/div[1]/a"));
        changeProfile.click();
        //Clear and input new telephone number
        WebElement telephoneNumber = driver.findElement(By.xpath("//*[@id=\"adresa-isporuke\"]/section[1]/section/input[4]"));
        telephoneNumber.click();
        telephoneNumber.clear();
        telephoneNumber.sendKeys("0987654321");
        //Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        //Click on button "Spremi nove podatke"
        WebElement saveChanges = driver.findElement(By.xpath("//*[@id=\"adresa-isporuke\"]/section[3]/input[2]"));
        saveChanges.click();
        //Expected phone number
        String expectedTelephoneNumber = "0987654321";
        //Actual phone number
        String actualTelephoneNumber = telephoneNumber.getAttribute("value");
        //Comparing two strings of phone numbers
        Assert.assertEquals(actualTelephoneNumber, expectedTelephoneNumber);
        //Print current phone number
        System.out.print("Current telephone number: ");
        System.out.print(actualTelephoneNumber);
    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}