import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
   By LoginPageUsername =  By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
   By LoginPagePassword = By.xpath("//input[@type='password']");
   By SubmitButton = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[3]/button/span");

   public LoginPage(WebDriver driver){
       this.driver = driver;
   }

   public void typeUsername(){
       driver.findElement(LoginPageUsername).sendKeys("7434981245");
   }
   public void typePassword(){
       driver.findElement(LoginPagePassword).sendKeys("testflipkart");
   }

   public void clickSubmitButton(){
       driver.findElement(SubmitButton).click();
   }

   public  void verifyCheckoutButton(){
       WebDriverWait wait = new WebDriverWait(driver, 30);
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'My Account')]")));
   }

}
