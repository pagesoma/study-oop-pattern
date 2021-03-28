# 설계 원칙: SOLID
- 객체 지향 설계 5 원칙, 이 원칙들의 영어 이름 첫 자를 딴 이름
- 로버트 마틴이 2000년대 초반에 명명한 객체 지향 프로그래밍 및 설계의 다섯 가지 기본 원칙
- 프로그래머가 시간이 지나도 유지 보수와 확장이 쉬운 시스템을 만들고자 할 때 이 원칙들을 함께 적용할 수 있다.
- SOLID 원칙들은 소프트웨어 작업에서 프로그래머가 소스 코드가 읽기 쉽고 확장하기 쉽게 될 때까지 소프트웨어 소스 코드를 리팩터링하여 코드 냄새를 제거하기 위해 적용할 수 있는 지침이다. 

## SOLID
- [단일 책임 원칙 (SRP, Single responsibility principle)](./SRP.md)
- [개방-폐쇄 원칙 (OCP, Open-closed principle)](./OCP.md)
- [리스코프 치환 원칙 (LSP, Liskov substitution principle)](./LSP.md)
- [인터페이스 분리 원칙 (ISP, Interface segregation principle)](./ISP.md)
- [의존 역전 원칙 (DIP, Dependency inversion principle)](./DIP.md)

### 정리
- SRP과 ISP은 객체가 커지지 않도록 막아 준다.
    - 기능 변경을 보다 쉽게 할 수 있도록 만들어 준다.
- OCP를 지원하는 원칙
    - DIP - 추상화를 지원
    - LSP - 다형성을 지원
- SOLID 원칙은 사용자 입장에서의 기능 사용을 중시한다.
- SOLID 원칙은 사용자 관점에서의 설계를 지향한다.