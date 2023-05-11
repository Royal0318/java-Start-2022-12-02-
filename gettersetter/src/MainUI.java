import java.util.ArrayList;
import java.util.Scanner;

public class MainUI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SubfoodReposity> food = new ArrayList<>();
        SubfoodReposity food1 = new SubfoodReposity();
        //main UI
        while (true) {
            System.out.println("\n===============A 음식점입니다===============");
            System.out.println("1.메뉴 추가 2.메뉴 삭제 3.메뉴 수정 4.전체 등록된 메뉴 보기 5.시스템종료");
            int menuChoice = sc.nextInt();

            if (menuChoice == 1) { //메뉴 추가 등록
                food1.addMenu(food,sc);
            }
            else if (menuChoice == 2) { //메뉴 삭제
                if (food.isEmpty()) {
                    System.out.println("<<<현재까지 등록된 메뉴가 없습니다>>>");
                } else {
                    food1.deleteMenu(food,sc);
                }
            }
            else if (menuChoice == 3) { //메뉴 수정
                if (food.isEmpty()) {
                    System.out.println("<<<현재까지 등록된 메뉴가 없습니다>>>");
                } else {
                    food1.modifyMenu(food,sc);
                }
            }
            else if (menuChoice == 4) { //전체 등로된 메뉴를 출력한다
                if (food.isEmpty()) {
                    System.out.println("<<<현재까지 등록된 메뉴가 없습니다>>>");
                } else {
                    System.out.println("현재까지 등록된 모든 결과를 출력합니다");
                    System.out.println("=============================================");
                    food1.outputMenu(food);
                }
            }
            else if (menuChoice == 5) { //시스템 종료
                System.out.println("시스템을 종료합니다");
                break;
            }
            else {
                System.out.println("안내 : 잘못된 입력입니다");
            }
        }
    }
}
