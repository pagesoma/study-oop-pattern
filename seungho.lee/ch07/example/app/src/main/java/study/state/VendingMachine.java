package study.state;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import study.state.state.NoCoinState;
import study.state.state.SelectableState;
import study.state.state.SoldOutState;
import study.state.state.State;

@Getter
public class VendingMachine {
  private final State noCoinState;
  private final State selectableState;
  private final State soldOutState;

  private State state;
  private int balance;

  private final List<Product> products = new ArrayList<>();

  public VendingMachine() {
    noCoinState = new NoCoinState(this);
    selectableState = new SelectableState(this);
    soldOutState = new SoldOutState(this);

    this.state = new NoCoinState(this);
    this.balance = 0;
  }

  public void insertCoin(int coin) {
    state.insertCoin(coin);
    System.out.printf("%d원이 충전되었습니다.\n", coin);
  }

  public void select(int productId) {
    Product product = getProduct(productId);
    if (product == null) {
      System.out.println("제품을 찾을 수 없습니다.");
      return;
    }

    System.out.printf("%s가 선택되었습니다. (개당 가격: %d원)\n", product.getName(), product.getPrice());
    state.select(productId);
  }

  public void returnCoin() {
    System.out.printf("잔액 반환요청을 하였습니다. (잔액: %d원)\n", balance);
    state.returnCoin();
  }

  public void changeState(State state) {
    this.state = state;
  }

  public void returnBalance() {
    if (hasNoBalance()) {
      System.out.println("반환할 금액이 없습니다.\n");
      return;
    }

    System.out.printf("%d원을 반환합니다.\n\n", balance);
    this.balance = 0;
  }

  public void increaseBalance(int coin) {
    balance += coin;
  }

  public void decreaseBalance(int price) {
    if (balance < price) {
      throw new RuntimeException("잔액이 부족합니다.");
    }

    balance -= price;
  }

  public boolean hasBalance() {
    return balance > 0;
  }

  public boolean hasNoBalance() {
    return !hasBalance();
  }

  public Product getProduct(int productId) {
    return products.stream().filter(p -> p.getId() == productId).findAny().orElse(null);
  }

  public void addProduct(Product product) {
    System.out.printf(
        "%s가 %d개 입고되었습니다. (개당 가격: %d원)\n\n",
        product.getName(), product.getQuantityAvailableForSale(), product.getPrice());
    products.add(product);
  }

  public void provideProduct(int productId) {
    Product product = getProduct(productId);

    if (balance < product.getPrice()) {
      System.out.printf("잔액이 부족하여 %s가 제공되지 않았습니다. (잔액: %d원)\n\n", product.getName(), balance);
      return;
    }

    decreaseBalance(product.getPrice());
    product.decreaseQuantity(1);
    System.out.printf("%s가 제공되었습니다.\n", product.getName());
    System.out.printf("현재 잔액은 %d 원입니다.\n\n", balance);
  }

  public boolean hasQuantityOfProducts() {
    return getQuantityOfProducts() > 0;
  }

  public boolean hasNoQuantityOfProducts() {
    return !hasQuantityOfProducts();
  }

  private int getQuantityOfProducts() {
    return products.stream().map(Product::getQuantityAvailableForSale).reduce(0, Integer::sum);
  }
}
