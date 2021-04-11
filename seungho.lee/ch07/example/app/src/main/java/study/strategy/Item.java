package study.strategy;

import lombok.Getter;

@Getter
public class Item {

  private String name;
  private int price;

  public Item(String name, int price) {
    this.price = price;
    this.name = name;
  }
}
