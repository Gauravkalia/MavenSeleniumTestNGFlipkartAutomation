import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LoginTest {
 public WebDriver driver;

    @Test
    public void validateLogin(){
        System.setProperty("webdriver.chrome.driver", "V:\\PracticeLanguages\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeUsername();
        loginPage.typePassword();
        loginPage.clickSubmitButton();
        loginPage.verifyCheckoutButton();
    }
}
