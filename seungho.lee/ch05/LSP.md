# 설계 원칙: SOLID (3/5)

## 리스코프 치환 원칙 (LSP, Liskov substitution principle)
> 상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야 한다.
- `다형성`에 관한 원칙
- 리스코프 치환 원칙이 제대로 지켜지지 않으면 다형성에 기반한 `개방 폐쇄 원칙` 역기 지켜지지 않는다.

```java
// someMethod() 상위 타입인 SuperClass 타입의 객체를 사용하고 있다.
public void someMethod(SuperClass sc) {
  sc.someMethod();
}
```
```java
// 하위 타입의 객체를 전달해도 someMethod()가 정상적으로 동작해야 한다.
someMethod(new SubClass());
```

### 리스코프 치환 원칙을 지키지 않을 때의 문제
- 대표적인 예가 `직사각형-정사각형 문제`
    - Rectangle 클래스의 setHeight() 메서드 명세
        - 높이 값을 파라미터로 전달받은 값으로 변경한다.
        - 폭 값은 변경되지 않는다.
    - Square 클래스의 setHeight() 메서드는 높이와 폭을 함께 변경하므로 예상과 달리 비정상적으로 동작할 수 있다.
    - 이 문제를 해결하기 위해 instanceof 연산자를 사용한다면 리스코프 치환 원칙 위반이 된다.
    - 이것처럼 개념적으로 상속 관계에 있는 것처럼 보일지라도 실제 구현에서는 상속 관계가 아닐 수도 있다.
- 또 다른 흔한 예는 `상위 타입에서 지정한 리턴 값의 범위에 해당되지 않는 값을 리턴`하는 것
    - InputStream의 read() 메서드는 스트림의 끝에 도달한 경우 -1을 리턴한다고 가정
    - InputStream을 상속한 SatanInputStream을 상속한 하위 타입에서 read()메서드를 데이터가 없을 때 0을 리턴하도록 구현하면 이 클래스의 사용자는 객체를 치환했을 때 리턴값이 달라진다.

### 리스코프 치환 원칙은 계약과 확장에 대한 것
- 리스코프 치환 원칙은 `기능의 명세(또는 계약)`에 대한 내용이다.
- 기능 실행의 계약과 관련해서 흔히 발생하는 위반 사례
    - 명시된 명세에서 벗어난 값을 리턴한다.
    - 명시된 명세에서 벗어난 익셉션을 발생한다.
    - 명시된 명세에서 벗어난 기능을 수행한다.
```java
// LSP 원칙 위배
// 이 메서드는 SpecialItem 타입이 존재하는지 알 필요없이 오직 Item 타입만 사용해야한다.
// 하위 타입인 SpecialItem이 상위 타입인 Item을 완벽하게 대체하지 못하는 상황이 발생
public class Coupon {
  public int calculateDiscountAmount(Item item) {
    if (item instanceof SpecialItem)  // LSP 위반 발생
      return 0;

    return item.getPrice() * discountRate;
  }
}
```
```java
// LSP 원칙 적용
// 변화되는 기능을 상위 타입에 추가하고 하위 타입에서 알맞게 오버라이딩
public class Coupon {
  public int calculateDiscountAmount(Item item) {
    if (item.isDiscountAvailable())  // instanceof 연산자 사용 제거
      return 0;

    return item.getPrice() * discountRate;
  }
}
```
