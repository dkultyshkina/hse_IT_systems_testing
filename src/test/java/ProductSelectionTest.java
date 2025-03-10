import static org.testng.Assert.*;

import org.testng.annotations.Test;
import testing.*;

public class ProductSelectionTest extends BaseTest {
  @Test
  public void checkOpenProductsPage() {
    Products products = productsPage.open()
                            .goToProduct()
                            .addToCart()
                            .goBack()
                            .goToDifferentProduct()
                            .goToProduct()
                            .addToCart()
                            .clickToCart()
                            .checkCart();
    assertEquals(products.getSize(), 2);
    assertEquals(products.get(1).getName(), "Samsung galaxy s6");
    assertEquals(products.get(0).getName(), "Sony vaio i5");
  }
}
