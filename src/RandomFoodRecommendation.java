import java.util.Random;
import java.util.Scanner;

public class RandomFoodRecommendation {
    public static void main(String[] args) {

        String[] foodMenu = {
                "김치찌개", "비빔밥", "치킨", "짜장면", "불고기", "된장찌개",
                "갈비", "라면", "떡볶이", "초밥", "김밥", "볶음밥", "삼겹살",
                "돈까스", "스시", "순대국", "설렁탕", "우동", "국밥", "유부초밥", "짬뽕", "돌솥 비빔밥", "서브웨이", "조퇴때리기"
        };

        Scanner scanner = new Scanner(System.in);

        while (true) {

            Random random = new Random();
            int randomIndex = random.nextInt(foodMenu.length);  // 0부터 foodMenu.length-1까지의 랜덤 인덱스


            System.out.println("오늘의 추천 메뉴는: " + foodMenu[randomIndex]);


            System.out.println("이 메뉴가 마음에 드시나요? (네/아니요)");
            String response = scanner.nextLine();


            if (response.equalsIgnoreCase("네")) {
                System.out.println("좋은 선택이네요! 맛있게 드세요.");
                break;
            }

            else if (response.equalsIgnoreCase("아니요")) {
                System.out.println("다시 추천해드릴게요!");
            } else {

                System.out.println("잘못된 입력입니다. '네' 또는 '아니요'로 답변해 주세요.");
            }
        }

        scanner.close();
    }
}
