package study.templatemethod;

public abstract class CaffeineBevarage {

  // template method
  void prepareRecipe() {
    boilWater();
    brew();
    pourInCup();
    if (customerWantsCondiments()) {
      addCondiments();
    }
  }

  abstract void brew();

  abstract void addCondiments();

  void boilWater() {
    System.out.println("물 끓이는 중");
  }

  void pourInCup() {
    System.out.println("컵에 따르는 중");
  }

  // hook method
  boolean customerWantsCondiments() {
    return true;
  }
}
