import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testing.*;

public class BaseTest {

  WebDriver driver;
  ProductsPage productsPage;
  CartPage cartPage;

  @BeforeMethod
  public void setup() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless");
    options.addArguments("--start-maximized");
    options.addArguments("--incognito");
    options.addArguments("--disable-notification");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    productsPage = new ProductsPage(driver);
    cartPage = new CartPage(driver);
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}