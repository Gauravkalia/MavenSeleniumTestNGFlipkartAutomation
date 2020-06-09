import Helper.checkoutProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FullFunctionalityForFlipkart {

    WebDriver driver;

    By userName = By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
    By pass = By.xpath("//input[@type='password']");
    By loginButton = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button/span");
    By product1 = By.xpath("//a[@title='Dell Inspiron 5000 Core i5 8th Gen - (8 GB/1 TB HDD/512 GB SSD/Windows 10 Home/2 GB Graphics) 5584 Laptop']");
    By product2 = By.xpath("//a[@title='Dell Inspiron 5000 Core i3 10th Gen - (4 GB/256 GB SSD/Windows 10 Home) 5491 2 in 1 Laptop']");
    By checkoutButton = By.xpath("//*[@id=\"container\"]/div/div[3]/div[2]/div[1]/div[1]/div[2]/div/ul/li[1]/button");

    @BeforeSuite
    public void inializeDriver() {
        System.setProperty("webdriver.chrome.driver", "V:\\PracticeLanguages\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void navigateToFlipkartURI() {
        //Navigate to flipkart.com
        driver.get("https://www.flipkart.com/");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void enterValidLoginCredentials() {


        driver.findElement(userName).sendKeys("");
        driver.findElement(pass).sendKeys("testflipkart");
        driver.findElement(loginButton).click();
        //Wait till user see My Account text in menu section
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'My Account')]")));
    }

    @Test(priority = 2)
    public void enterProductToSearchOnFlipkartSearchTextBox() {
        WebElement searchBox = driver.findElement(By.xpath("//input[@type=\"text\"]"));
        searchBox.sendKeys("dell laptop");
        searchBox.sendKeys(Keys.ENTER);
        verifyIfProductIsAvailable(product1);
    }

    public boolean verifyIfProductIsAvailable(By product) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(product));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test(priority = 3)
    public void addProducts1ToCart() throws InterruptedException {
        //div[@Class="_2NTrR2"]
        //find deal of the day and view all elements
        //driver.findElement(By.xpath("//*[contains(text(),'Deals of the Day')]//following::div[2]")).click();
        driver.findElement(product1).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));

        driver.findElement(checkoutButton).click();
        Thread.sleep(Long.parseLong("2000"));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Test(priority = 4)
    public void addProduct2ToCart() {
        verifyIfProductIsAvailable(product2);
        driver.findElement(product2).click();
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.findElement(checkoutButton).click();
    }

    @AfterSuite
    public void closeBroserAndClearCache() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
