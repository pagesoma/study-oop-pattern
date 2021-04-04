package study.strategy.strategy;

import study.strategy.Item;

public interface DiscountStrategy {
  int getDiscountPrice(Item item);
}
