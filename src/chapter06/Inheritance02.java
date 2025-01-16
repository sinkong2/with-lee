package chapter06;

// 상속에서의 생성자
// : 상속받은 클래스에서 생성자 호출 순서
// > 부모에서 자식 순서로 진행!

// 자식 클래스 객체를 생성할 때, 자식 클래스는 해당 클래스의 생성자를 통해 객체 생성
// : 자식 클래스의 생성자 호출 시 '항상' 부모 클래스의 생성자가 호출!
// > 사용자 정의 생성자 호출이 필요하지는 X

/*
* Mammal 클래스
* 1) 필드: 이름(name), 숫자(number)
* 2) 생성사: 매개변수 X, 매개변수(String name) - 생성자 오버로딩
* 3) 메서드: 클래스 필드 정보를 출력(displayMammal)




*/

class Mammal {
    String name = "Parent";
    int number = 10;

    Mammal() {
        System.out.println("빈 부모 생성자 - 인스턴스 생성");
    }

    Mammal(String name) {
        // 필드와 지역변수의 이름이 같을 경우 충돌 방지를 위해
        //      필드에 this.키워드로 구분
        this.name = name; // Mammel 클래스로 생성되는 각 객체(this)
    }

    void displayMammal() {
        System.out.println(name);
    }
}
/*
* cat 클래스(자식) - Mammal 클래스(부모)를 상속받음
* 1) 필드: 이름(name)
* 2) 생성자: 매개변수 X, 매개변수(String name) - 생성자 오버로딩
* 3) 메서드: 정보출력(greet)
* */




class Cat extends Mammal {
    String name = "Child";

    //cat () {

    Cat() {
        // super();
        // : 자식 클래스의 기본 생성자는 사용자 정의 생성자 호출이 없더라도
        //      super() 부모 클래스 생성자 호출 키워드가 정의되어 있음 (생략)

        System.out.println("빈 자식 생성자");
    }

    Cat(String name) {
        // super()는 부모 클래스의 생성자를 가져오는 키워드
        // : 부모 클래스 내에 정의된 생성자 형태 그대로를 사용
        super(name);

        // this.name = name;
        System.out.println("자식 클래스가 생성되었습니다.");
    }

    // 인스턴스 메서드
    void greet() {
        // 해당 클래스가 가진 인스턴스 변수에 접근
        // : this (생략 O)
        System.out.println("자식 이름: " + this.name);
        System.out.println("자식 이름: " + name);

        // 부모 클래스가 가진 인스턴스 변수에 접근
        // : super (생략 X)

        // super: 부모 클래스로 생선된 객체 그 자체
        //      - 부모 클래스 내의 필드와 메서드에 접근. 연산자를 사용
        //          super.필드명 / super.메서드명()
        // super(): 부모 클래스 내의 생성자 호출
        System.out.println("부모 이름: " + super.name);
    }
}

public class Inheritance02 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        // 빈 부모 생성자 - 인스턴스 생성
        // 빈 자식 생성자

        Cat cat2 = new Cat("choco");
        System.out.println(cat2.name); // Child

        cat2.greet();
//        자식 이름: Child
//        자식 이름: Child
//        부모 이름: choco

        System.out.println(cat2.number);
    }
}