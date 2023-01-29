package ObjectOrientation;

import java.util.Scanner;

public class Januarytwentynineth {
    public static void main(String[] args) {
        //게임리스트에서 종료버튼을 누를시 출력되어 시스템종료
        System.out.println(""+GameNameMake()+"");
    }
    public static String GameNameMake () {
        //게임제목 정하는 메소드
        Scanner sc = new Scanner(System.in);
        System.out.println("4번째 게임의 제목을 정해주세요");
        String Game4 = sc.next();
        System.out.println("5번째 게임의 제목을 정해주세요");
        String Game5 = sc.next();
        return LookGameExplanation(Game4,Game5);
    }
    public static String LookGameExplanation(String Game4,String Game5) {
        //게임 제목 리스트중에서 기획서내용을 보기위한 선택메소드
        Scanner sc = new Scanner(System.in);
        Januarytwentynineth2 TotalGame = new Januarytwentynineth2("Card Game", "빨리 보스잡기 게임", "격투게임", ""+Game4+"", ""+Game5+"", "", "", "", "", "", "", "");

        while (true) {
            TotalGame.GameMainList();
            int GameListInput = sc.nextInt();

            if (GameListInput == 1 || GameListInput == 2 || GameListInput == 3 || GameListInput == 4 || GameListInput == 5) {
                return ListDescription(GameListInput,Game4,Game5);
            } else if (GameListInput == 6) {
                return "시스템을 종료합니다";
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static String ListDescription (int GameListInput,String Game4,String Game5) {
        //게임기획서를 보기위해 게임을 선택하면 기획서가 출력됨
        Januarytwentynineth2 TotalGame = new Januarytwentynineth2("Card Game", "빨리 보스잡기 게임", "격투게임", ""+Game4+"", ""+Game5+"", "", "", "", "", "", "", "");

        if (GameListInput == 1) {
            TotalGame.GameListExplanation();
        } else if (GameListInput == 2) {
            TotalGame.Game2ListExplanation();
        } else if (GameListInput == 3) {
            TotalGame.Game3ListExplanation();
        } else if (GameListInput == 4) {
            TotalGame.Game4ListExplanation();
        } else if (GameListInput == 5) {
            TotalGame.Game5ListExplanation();
        } else {
            System.out.println("잘못된 입력입니다");
        }
        return LookGameExplanation (Game4,Game5);
    }
}
