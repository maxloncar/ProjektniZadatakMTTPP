import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTest {
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
    public void addTwoItemsToShoppingCartTest() throws InterruptedException {
        //Explicit wait until navbar element "Računala" is visible
        WebDriverWait wait = new WebDriverWait(driver,2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"primary-desktop-nav\"]/nav/ul/li[3]")));
        //Click on "RAČUNALA" in navigation bar
        WebElement computers = driver.findElement(By.xpath("//*[@id=\"primary-desktop-nav\"]/nav/ul/li[3]"));
        computers.click();
        //Click on "RAČUNALA ZA KUĆNU PRIMJENU"
        WebElement desktopComputer = driver.findElement(By.xpath("//*[@id=\"primary-desktop-nav\"]/nav/ul/li[3]/div/div[2]/nav/a[1]"));
        desktopComputer.click();
        //Javascript is used for scrolling down so we can press the button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300)");
        //Buy a computer with the button "KUPI"
        WebElement buyComputerButton = driver.findElement(By.xpath("//*[@id=\"products-list-inner\"]/section[1]/div[3]/div[2]"));
        buyComputerButton.click();
        //Continue Shopping -> add to cart (dodati u košaricu)
        WebElement add = driver.findElement(By.xpath("//*[@id=\"kosaricaAdd\"]/a[1]"));
        add.click();
        //Scroll up
        js.executeScript("window.scrollBy(0, -300)");
        //Click on "GAMING" in navigation bar
        WebElement gaming = driver.findElement(By.xpath("//*[@id=\"primary-desktop-nav\"]/nav/ul/li[5]"));
        gaming.click();
        //Click on "IGRE"
        WebElement games = driver.findElement(By.xpath("//*[@id=\"primary-desktop-nav\"]/nav/ul/li[5]/div/div[4]/nav/a[2]"));
        games.click();
        //Buy a game with the button "KUPI"
        WebElement buyGame = driver.findElement(By.xpath("//*[@id=\"products-list-inner\"]/section[1]/div[3]/div[2]"));
        buyGame.click();
        //Complete the purchase with the button "Završi kupovinu"
        WebElement completePurchaseButton = driver.findElement(By.xpath("//*[@id=\"kosaricaAdd\"]/a[2]"));
        completePurchaseButton.click();
        //String when user completes the purchase
        String expectedURL = "https://www.hgshop.hr/kosarica.aspx";
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