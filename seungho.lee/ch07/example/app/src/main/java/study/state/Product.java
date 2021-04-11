package study.state;

import lombok.Getter;

@Getter
public class Product {
  private final int id;
  private final Item item;
  private int quantityAvailableForSale;

  Product(int id, Item item, int quantityAvailableForSale) {
    this.id = id;
    this.item = item;
    this.quantityAvailableForSale = quantityAvailableForSale;
  }

  public String getName() {
    return item.getName();
  }

  public int getPrice() {
    return item.getPrice();
  }

  public void increaseQuantity(int quantity) {
    quantityAvailableForSale += quantity;
  }

  public void decreaseQuantity(int quantity) {
    if (quantityAvailableForSale >= quantity) {
      quantityAvailableForSale -= quantity;
    }
  }
}
