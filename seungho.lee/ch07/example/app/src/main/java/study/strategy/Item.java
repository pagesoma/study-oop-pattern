package study.strategy;

public class Item {

  private String name;
  private int price;

  public Item(String name, int price) {
    this.price = price;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}
