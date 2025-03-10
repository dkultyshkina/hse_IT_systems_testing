package testing;

import java.time.Duration;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class ProductsPage {

  WebDriver driver;

  public ProductsPage(WebDriver driver) { this.driver = driver; }

  private static final String ADD_TO_CART =
      "/html/body/div[5]/div/div[2]/div[2]/div/a";
  private static final String WAIT_INDEX_HTML = "index.html";
  private static final String WAIT_PROD_HTML = "prod.html";
  private static final String WAIT_CART_HTML = "cart.html";

  private static final String PHONES_PAGE_PRODUCT =
      "/html/body/div[5]/div/div[2]/div/div[1]/div/div/h4/a";

  private static final String LAPTOPS_PAGE_PRODUCT = "//a[text()='Laptops']";

  private static final String URL_PRODUCTS =
      "https://www.demoblaze.com/index.html";
  private static final String URL_CART = "https://www.demoblaze.com/cart.html";

  public ProductsPage open() {
    driver.get(URL_PRODUCTS);
    return this;
  }

  public String getTitle() { return driver.getTitle(); }

  public ProductsPage goToProduct() {
    driver.findElement(By.xpath(PHONES_PAGE_PRODUCT)).click();
    return this;
  }
  public ProductsPage addToCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains(WAIT_PROD_HTML));
    driver.findElement(By.xpath(ADD_TO_CART)).click();
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
    alert.accept();
    return this;
  }

  public ProductsPage goBack() {
    driver.navigate().to(URL_PRODUCTS);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains(WAIT_INDEX_HTML));
    return this;
  }

  public ProductsPage goToDifferentProduct() {
    Actions actions = new Actions(driver);
    actions.moveToElement(driver.findElement(By.xpath(LAPTOPS_PAGE_PRODUCT)))
        .click()
        .pause(Duration.ofSeconds(2))
        .perform();
    return this;
  }

  public CartPage clickToCart() {
    driver.navigate().to(URL_CART);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.urlContains(WAIT_CART_HTML));
    return new CartPage(driver);
  }
}