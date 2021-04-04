package study.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import study.strategy.strategy.DiscountStrategy;
import study.strategy.strategy.FirstGuestDiscountStrategy;
import study.strategy.strategy.NonFreshItemDiscountStrategy;

public class App {

  private final List<Item> items = new ArrayList<>();
  private DiscountStrategy strategy;

  public static void main(String[] args) {
    Item apple = new Item("apple", 800);
    Item cherry = new Item("cherry", 200);

    App app = new App();
    app.setItem(apple);
    app.setItem(cherry);

    app.onFirstGuestButtonClick();
    app.onCalculationButtonClick();

    app.onNonFreshItemButtonClick();
    app.onCalculationButtonClick();
  }

  public void setItem(Item item) {
    items.add(item);
  }

  public void onFirstGuestButtonClick() {
    strategy = new FirstGuestDiscountStrategy();
  }

  public void onNonFreshItemButtonClick() {
    strategy = new NonFreshItemDiscountStrategy();
  }

  public void onCalculationButtonClick() {
    Calculator cal = new Calculator(strategy);
    int price = cal.calculate(items);

    System.out.printf(
        "total items: %s, price: %d%n",
        items.stream().map(Item::getName).collect(Collectors.joining(",")), price);
  }
}
