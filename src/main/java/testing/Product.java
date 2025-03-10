package testing;

import lombok.Getter;

public class Product {
  @Getter private String name;
  public Product(String name) { this.name = name; }
}
