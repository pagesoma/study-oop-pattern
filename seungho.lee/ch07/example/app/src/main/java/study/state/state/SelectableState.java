package study.state.state;

import study.state.VendingMachine;

public class SelectableState implements State {
  VendingMachine vendingMachine;

  public SelectableState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin(int coin) {
    vendingMachine.increaseBalance(coin);
  }

  @Override
  public void select(int productId) {
    vendingMachine.provideProduct(productId);

    if (vendingMachine.hasNoQuantityOfProducts()) {
      vendingMachine.changeState(vendingMachine.getSoldOutState());
      return;
    }

    if (vendingMachine.hasNoBalance()) {
      vendingMachine.changeState(vendingMachine.getNoCoinState());
    }
  }

  @Override
  public void returnCoin() {
    vendingMachine.returnBalance();
    vendingMachine.changeState(vendingMachine.getNoCoinState());
  }
}
