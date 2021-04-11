package study.strategy;

import java.util.List;
import study.strategy.strategy.DiscountStrategy;

public class Calculator {

  private final DiscountStrategy discountStrategy;

  public Calculator(DiscountStrategy discountStrategy) {
    this.discountStrategy = discountStrategy;
  }

  public int calculate(List<Item> items) {
    if (items == null) {
      return 0;
    }

    int sum = 0;
    for (Item item : items) {
      sum += discountStrategy.getDiscountPrice(item);
    }

    return sum;
  }
}
