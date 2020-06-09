import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HomePageTest extends LoginTest {

    @Test
    public void enterProductToSearch(){
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct();
    }
}
