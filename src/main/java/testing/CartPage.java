package testing;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
  WebDriver driver;
  private static final String TABLE_CART =
      "/html/body/div[6]/div/div[1]/div/table/tbody";

  public CartPage(WebDriver driver) { this.driver = driver; }

  public Products checkCart() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement tableBody = wait.until(
        ExpectedConditions.presenceOfElementLocated(By.xpath(TABLE_CART)));

    List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
    Products products = new Products();
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      if (cells.isEmpty()) {
        continue;
      }
      for (WebElement cell : cells) {
        String cellText = cell.getText();
        if (cellText.isEmpty()) {
          continue;
        }
        Product product = new Product(cellText);
        products.addProduct(product);
        break;
      }
    }
    return products;
  }
}
