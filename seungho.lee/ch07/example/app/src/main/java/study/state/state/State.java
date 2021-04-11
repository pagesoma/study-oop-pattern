package study.state.state;

public interface State {
  void insertCoin(int coin);

  void select(int productId);

  void returnCoin();
}
