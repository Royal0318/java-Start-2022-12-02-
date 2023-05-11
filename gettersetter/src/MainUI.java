import java.util.ArrayList;
import java.util.Scanner;

public class MainUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SubfoodReposity> food = new ArrayList<>();
        SubfoodReposity food1 = new SubfoodReposity("탕수육",15000);
        food.add(food1);

        //main UI
        while (true) {
            System.out.println("===============A 음식점입니다===============");
            System.out.println("1.메뉴 추가 2.메뉴 삭제 3.메뉴 주문 4.메뉴 수정 5.전체 등록된 메뉴 보기 6.시스템종료");
            int menuChoice = sc.nextInt();

            if (menuChoice == 1) {
                food1.addMenu(food,sc);
            }
            else if (menuChoice == 2) {
                food1.deleteMenu();
            }
            else if (menuChoice == 3) {
                food1.orderMenu();
            }
            else if (menuChoice == 4) {
                food1.modifyMenu();
            }
            else if (menuChoice == 5) {
                if (food.isEmpty()) {
                    System.out.println("현재까지 등록된 메뉴가 없습니다");
                } else {
                    System.out.println("현재까지 등록된 모든 결과를 출력합니다");
                    food1.outputMenu(food);
                }
            } else if (menuChoice == 6) {
                System.out.println("시스템을 종료합니다");
                break;
            }
        }
    }
}
