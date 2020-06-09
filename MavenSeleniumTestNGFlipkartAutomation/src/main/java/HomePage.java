import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;

    By searchBox = By.xpath("//input[@type=\"text\"]");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchForProduct(){
        driver.findElement(searchBox).sendKeys("dell laptop");
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Dell Inspiron 5000 Core i5 8th Gen - (8 GB/1 TB HDD/512 GB SSD/Windows 10 Home/2 GB Graphics) 5584 Laptop']")));
    }
}
