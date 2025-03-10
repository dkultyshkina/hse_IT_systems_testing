package testing;

import java.util.ArrayList;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Products {
  private ArrayList<Product> list = new ArrayList<>();
  public Products() {}
  public void addProduct(Product product) { list.add(product); }

  public Product get(int index) { return list.get(index); }

  public int getSize() { return list.size(); }
}
