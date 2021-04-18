package study.state;

public class NoCoinState implements State {
  VendingMachine vendingMachine;

  public NoCoinState(VendingMachine vendingMachine) {
    this.vendingMachine = vendingMachine;
  }

  @Override
  public void insertCoin(int coin) {
    vendingMachine.increaseBalance(coin);
    vendingMachine.changeState(vendingMachine.getSelectableState());
  }

  @Override
  public void select(int productId) {
    System.out.println("충전된 금액이 없습니다.\n");
  }

  @Override
  public void returnCoin() {
    System.out.println("반환할 금액이 없습니다.\n");
  }
}
