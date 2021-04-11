package study.state;

public class App {

  public static void main(String[] args) {

    System.out.println("\n======= 자판기 프로그램 =======\n");

    Item coffee = new Item("coffee", 100);
    Product coffees = new Product(1, coffee, 2);

    Item juice = new Item("juice", 200);
    Product juices = new Product(2, juice, 2);

    VendingMachine vendingMachine = new VendingMachine();
    vendingMachine.addProduct(coffees);
    vendingMachine.addProduct(juices);

    vendingMachine.insertCoin(200);
    vendingMachine.select(1);
    vendingMachine.select(2);
    vendingMachine.select(1);
    vendingMachine.select(1);
    vendingMachine.returnCoin();

    vendingMachine.select(1);

    vendingMachine.insertCoin(200);
    vendingMachine.select(2);

    vendingMachine.insertCoin(100);
    vendingMachine.select(2);
    vendingMachine.returnCoin();
  }
}
