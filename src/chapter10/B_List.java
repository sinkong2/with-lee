package chapter10;

// === ArrayList VS LinkedList === //

// 1) ArrayList
// : 내부적으로 배열을 사용하여 요소를 저장
// - 빠른 읽기 성능, 느린 삽입/삭제 성능
// - 순차적으로 데이터를 관리: 빠른 데이터 조회에 적합
// - 중간 삽입/삭제 시: 데이터 이동이 필요하므로 상대적으로 성능 저하

// EX. 정렬된 책장
// 책의 번호를 아는 경우 해당 책장에서 책을 빠르게 가져올 수 있음
// 새 책을 책장의 중간에 추가할 경우 - 책을 모두 한칸씩 옮겨야 함 (시간이 오래걸림)

// 2) LinkedList
// : 내부적으로 이중 연결 리스트를 사용하여 요소를 저장
// : 빠른 삽입/삭제 성능, 느린 데이터 접근 성능
// - 연결 기반 데이터 관리: 비순차적 데이터 잡업에 적합
// - 특정 요소 접근 시 : 순차 탐색이 필요하므로 성능 저하

// EX. 도서 대츨 리스트
// 새로운 대출 기록을 추가하거나 기존 기록을 제거하는 것이 용이
// : 옆의 요소와 연결만 변경하면 추가, 삭제가 가능
// 특정 날짜의 대출 기록을 찾으려면 처음부터 하나씩 기록을 읽아야 함 (시간이 오래걸림)

import java.util.ArrayList;
import java.util.LinkedList;

public class B_List {
    public static void main(String[] args) {

        // === List 인터페이스의 주요 구조 === //

        // 1. ArrayList 예제
        System.out.println("=== ArrayList 예제 ===");

        // cf) ArrayList 클래스 - AbstractList를 상속받음
        //      AbstractList 추상 클래스 - List 인터페이스를 구현함.
        ArrayList<String> arrayList = new ArrayList<>();

        // 데이터 추가
        arrayList.add("Java"); // 리스트 끝에 요소를 추가
        arrayList.add(0, "Python"); // 원하는 인덱스에 요로를 추가
        arrayList.add("JavaScript");

        System.out.println(arrayList); // [Python, Java, JavaScript]

        // 데이터 읽기
        String firstElement = arrayList.get(0); // 해당 인덱스 번호의 요소를 가져옴
        System.out.println(firstElement); // Python

        // 데이터 수정 - 요소를 찾아 변경
        arrayList.set(2, "TypeScript");
        System.out.println(arrayList); //[Python, Java, TypeScript]

        // 데이터 삭제
        String removeElement = arrayList.remove(1); // 해당 인덱스 번호의 요소를 삭제하고 변환
        System.out.println(removeElement); // Java
        System.out.println(arrayList); // [Python, TypeScript]

        // 리스트 크기
        System.out.println(arrayList.size()); // 2

        // 리스트 비우기
        arrayList.clear();
        System.out.println(arrayList); // []

        // 2. LinkedList 예제
        System.out.println("=== LinkedList 예제 ===");
        LinkedList<String> linkedList = new LinkedList<>();

        // 데이터 추가
        linkedList.add("Apple");
        linkedList.add("Orange");
        linkedList.add("Mango");
        linkedList.add(1, "Banana");
        System.out.println(linkedList); // [Apple, Banana, Orange, Mango]

        // 데이터 읽기
        String secondFruit = linkedList.get(1);
        System.out.println(secondFruit); // Banana

        // 데이터 포함 여부 확인
        System.out.println("리스트에 Orange 포함?" + linkedList.contains("Orange")); // true
        System.out.println("리스트에 Strawberry 포함?" + linkedList.contains("Strawberry")); // false

        // 데이터 삭제
        linkedList.remove(2);
        System.out.println(linkedList); // [Apple, Banana, Mango]

        // 리스트 초기화
        linkedList.clear();
        System.out.println(linkedList); // []

        // === ArrayList VS LinkedList 성능비교 === //
        System.out.println("=== ArrayList VS LinkedList 성능비교 ===");

        ArrayList<Integer> arrayListTest = new ArrayList<>();
        // : 클래스 구조에는 객체 타입의 데이터만 삽입 가능
        // - 기본 데이터 타입: int, char, boolean (X)
        // - 객체 형식 타입: Integer, Character, Boolean (O)

        long startTime = System.nanoTime();
        // 현재 시간을 나노초 단위로 변환
        // 1초 = 1,000,000,000 나노초

        for (int i = 0; i < 100000; i++) {
            arrayListTest.add(0, i); // 항상 맨 앞에 삽입
        }
        long endTime = System.nanoTime();

        // 448309208ns - 약 4억 나노초
        System.out.println("ArrayList 삽입 시간:" + (endTime - startTime) + "ns");

        LinkedList<Integer> linkedListTest = new LinkedList<>();
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedListTest.add(0, i);
        }
        endTime = System.nanoTime();

        // 3777583ns - 약 4억 나노초
        System.out.println("LinkedList 삽입 시간:" + (endTime - startTime) + "ns");
    }
}