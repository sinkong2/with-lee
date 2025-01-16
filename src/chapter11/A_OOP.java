package chapter11;

// OOP  (Object-Oriented Programing)
// : 객체 지향  프로그래밍

// === SOLID 원칙 ===
// : 객체지향 프로그래밍의 5가지 소프트웨어 개발 원칙
// : SRP, OCP, LSP, ISP, DIP >> 회사 취업시 물어볼 가능성이 있음 면접 준비할 때 외우기!!!!!
// - 소프트웨어 설계에서 유지보수성과 확장성을 높이고
// - 다양한 디자인 패턴이(Design Pattern)  SOLID 설계 원칙을 따라 만들어짐

// SOLID 원칙 적용 . 주의점
// ! SOLID 원칙 적용 순서 - X
// ! 5가지 원칙이 모두 필수 - X
// ! 5가지 원칙이 서로 독립된 개념 X / 서로 개념적으로 연관 O

// cf) 상속, 추상화, 다형성, 캡슐화 (OOP의 4가지 특징)

// 1. 단일 책임 원칙 (Single Responsibility Principle, SRP)
// : 클래스는 단 하나의 책임만 가져야함
// - 한 가지의 역할(기능)만 담당
// - 하나의 변화 이유만 가져야 함

// == 하나의 클래스가 가지는 하나의 역할과 관련된 변경사항만 클래스에 영향을 미쳐야 함

class Srp {
    void generateReport () {
        // 보고서 생성
        System.out.println("보고서가 생성됨");
    }
        // 이메일 전송을 담당
    void send() {
        System.out.println("이메일이 전송됨");
    }
}
class EmailSender {
    void sendEmail() {
        System.out.println("이메일이 전송됨");
    }
}

class ReportGenerator {
    //보고서 생성
    void generatorReport () {
        System.out.println("보고서가 생성됨");
    }
}

// 2. 개방-폐쇄 원칙 (Open-Closed Principle, OCP)
// : 소프트웨어 엔티티(클래스, 모듈, 함수등)는 확장에는 열려있어야 하고 , 수정에는 닫혀있어야 한다.
// - 기존 코드를 변경하지 않고 새로은 기능을 추가할 수 있어야 함.

// cf) 확장에 열려있다. - 유연한 코드 추가 가능
//      변경에 닫혀있다. - 객체에 대한 직접적 수정을 제한
// >> 추상화를 통한 관계 추축을 권장

class Discount {
    double calculateDiscount(boolean isStudent, int amount) {
        if (isStudent) {
            return amount * 0.2;
        } else {
            return amount * 0.1;
        }
    }
}

// === OCP 설계 원칙 === //
interface DiscountPolicy {
    double calculateDiscount(int amount);
}

class CommonDiscount implements DiscountPolicy {
    public double calculateDiscount(int amount) {
        return amount * 0.1;
    }
}
class StudentDiscount implements DiscountPolicy {
    public double calculateDiscount (int amount) {
        return amount * 0.2;
    }
}
// >> 추상 클래스, 인터페이스와 상속, 구현을 통한 클래스 관계 구축

// 3. 리스코프 치환 원칙 (Liskov Substitution Principle, LSP)
// : 상위 클래스의 객체를 하위 클래스의 객체로 치환하더라도 프로그램의 동작이 일관되게 유지되어야 함.
// - 자식 클래스는 부모 클래스의 기능을 완전하게 대체할 수 있음.
// - 업캐스팅 상태에서 부모의 메서드를 사용 시 동작이 가능해야 한다.

class Bird {
    void fly() {
        System.out.println("새는 날 수 있습니다.");
    }
}

class Penguin extends Bird {
    @Override
    void fly() { // 펭귄은 '새'를 상속받지만 부모 클래스(Bird)의 Fly 메서드가 가지는 동작의 의도대로 구현되지 X
        System.out.println("펭귄은 날 수 없습니다.");
    }
}

// === LSP 설계 원칙 === ///
abstract class AbstractBird {
    abstract void move();
}
class FlyingBird extends AbstractBird {
    @Override
    public void move() {
        System.out.println("날 수 있는 새들입니다.");
    }
}

class pororo extends AbstractBird{
    @Override
    public void move() {
        System.out.println("펭귄은 수영할 수 있습니다.");
    }
}


public class A_OOP {
    public static void main(String[] args) {

    }
}
