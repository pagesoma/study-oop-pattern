package study.state;

public interface State {
  void insertCoin(int coin);

  void select(int productId);

  void returnCoin();
}
