package chapter08;

// === 인터페이스 ===//
// Fruit 과일 인터페이스 정의
// - color: 추상 메서드
// - describe: 디폴트 메서드
// - printType: 정적 메서드

interface Fruit {
    // 인터페이스의 추상 메서드
    // :  public abstract이 생략 되어 있음 (cs. 추상 클래스의 추상 메서드와 다름)
    String color(); // 추상 메서드

    // 디폴트 메서드: 재정의
    default void describe() {
        System.out.println("과일의 색상은" + color() + "이며, 모양은 동그랗습니다.");
    }

    // 정적 메서드: 재정의 (오버라이딩) 불가능
    static void printType() {
        System.out.println("과일(Fruit)의 타입입니다.");
    }
}

class Apple implements Fruit{
    public String color() {
        return "red";
    }
}

class Orenge implements Fruit {
    public String color() {
        return "orange";
    }
}

class Banana implements Fruit {
    public String color() {
        return "yellow";
    }

    @Override
    public void describe () {
        System.out.println("과일의 색상은" + color() + "이며, 모양은 깁니다.");
    }
}

// === 또 다른 인터페이스 === //
interface TropicalFruit extends Fruit {
    // extends ( 상속 - 확장하다 )
    // : 클래스 간에, 인터페이스 간에 가능

    // cf) implements ( 구현 - 구현하다 )
    // : 인터페이스를 클래스로 구현
    default void tropicalFeature() {
        // 열대 과일의 특징
        System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
    }
}

class Mango implements TropicalFruit {
    public String color() {
        return "golden";
    }

    @Override
    public void describe() {
        System.out.println("과일의 색상은" + color() + "이며, 모양은 타원형 입니다.");
    }
}

public class Practice02 {
    public static void main(String[] args) {
        // 다형성 적용
        Fruit apple = new Apple();
        Fruit orange = new Orenge();
        Fruit banana = new Banana();
        TropicalFruit mango = new Mango();

        // == 다형성 예제 == //
        // mango가 Fruit로 형 변환 ( 업 캐스팅 )
        Fruit[] fruits = {apple, orange, banana, mango};

        for (Fruit fruit: fruits) {
            fruit.describe();

            if (fruit instanceof TropicalFruit) {
                TropicalFruit tropicalFruit = (TropicalFruit) fruit; // 다운 캐스팅
                tropicalFruit.tropicalFeature(); // 열대 과일은 후숙하면 더 맛있습니다.
            }
        }

        // cf) A instanceof B 연산자
        // : "A 객체가 B 클래스(종류)와 같은지 확인해줘" 도구
        // >> 확인의 결괏값을 boolean으로 변환
        class 동물 {}
        class 고양이 extends 동물 {}
        class 강아지 extends 동물 {}

        동물 애니멀 = new 동물();
        동물 나비 = new 고양이();
        동물 멍멍이 = new 강아지();

        if (애니멀 instanceof 고양이) {
            System.out.println(" 실행 되지 않음! 부모객체를 자식객체에 자동으로 담을 수 없음");
        }

        // 고양이 고양이로바꿈 =  (고양이) 애니멀;
        // : 형 변환을 시킬 수 없는 상황



        if (나비 instanceof 고양이 && 나비 instanceof 동물) { // 성공
            // 실행 O
            System.out.println("성공");
        }
        if( 멍멍이 instanceof  고양이) {
            // 실행 X
            System.out.println("성공?");
        }

        if (mango instanceof Fruit) {
            Fruit mangoAsFruit = (Fruit) mango;
            mangoAsFruit.describe(); // 과일의 색상은 golden이며, 모양은 타원형입니다.
        }
        if (banana instanceof TropicalFruit) {
            TropicalFruit bananaAsTropical = (TropicalFruit) banana;
            bananaAsTropical.tropicalFeature();
        }else {
            System.out.println("바나나는 열대 과일이 아닙니다."); // 바나나는 열대 과일이 아닙니다.
        }

        Fruit.printType(); // 과일(Fruit)의 타입입니다.


    }
}
