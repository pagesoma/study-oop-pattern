package study.templatemethod;

public class App {

  public static void main(String[] args) {
    System.out.println("\n차 준비중...");
    Tea tea = new Tea();
    tea.prepareRecipe();

    System.out.println("\n커피 준비중...");
    Coffee coffee = new Coffee();
    coffee.prepareRecipe();
  }
}
