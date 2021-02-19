import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {
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
    public void logInTest() throws InterruptedException {
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
        //String when user logs in
        String expectedURL = "https://www.hgshop.hr/";
        //Expected string which we compare with the actual one
        String actualURL = driver.getCurrentUrl();
        //Comparing two strings of URL's
        Assert.assertEquals(actualURL, expectedURL);
        //Print current URL
        System.out.print("Current URL: ");
        System.out.print(driver.getCurrentUrl());
    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}