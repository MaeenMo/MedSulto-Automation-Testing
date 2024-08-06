import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestBase {
    WebDriver driver;

    @BeforeTest
    public void setUo() {
        driver = new ChromeDriver();
        driver.get("https://medsultoadmin-staging1.azurewebsites.net/auth/login");
    }
//    @AfterTest
//    public void quit() {
//        driver.quit();
//    }
}