package study.state;

public class SoldOutState implements State {
  VendingMachine vendingMachine;

  public SoldOutState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin(int coin) {
    vendingMachine.increaseBalance(coin);
  }

  @Override
  public void select(int productId) {
    if (vendingMachine.hasNoQuantityOfProducts()) {
      System.out.println("재고가 없습니다.");
      return;
    }

    vendingMachine.changeState(vendingMachine.getSelectableState());
    vendingMachine.select(productId);
  }

  @Override
  public void returnCoin() {
    vendingMachine.returnBalance();
    vendingMachine.changeState(vendingMachine.getNoCoinState());
  }
}
