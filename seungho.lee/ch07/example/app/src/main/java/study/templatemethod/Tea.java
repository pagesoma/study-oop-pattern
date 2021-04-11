package study.templatemethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tea extends CaffeineBevarage {

  @Override
  void brew() {
    System.out.println("차를 우려내는 중");
  }

  @Override
  void addCondiments() {
    System.out.println("레몬을 추가하는 중");
  }

  public boolean customerWantsCondiments() {
    String answer = getUserInput();
    return answer.toLowerCase().startsWith("y");
  }

  private String getUserInput() {
    String answer = null;

    System.out.println("차에 레몬을 넣어 드릴까요? (y/n)");

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      answer = in.readLine();
    } catch (IOException e) {
      System.err.println("IO 오류");
    }

    return (answer == null) ? "no" : answer;
  }
}

