package study.state;

import lombok.Getter;

@Getter
public class Item {
  private final String name;
  private final int price;

  Item(String name, int price) {
    this.name = name;
    this.price = price;
  }
}
