package ObjectOrientation;

import java.util.Scanner;

public class Januarytwentyeighth {
    public static void main(String[] args) {
        System.out.println(""+MainScreen()+"");
    }
    public static String MainScreen () {
        Scanner sc = new Scanner(System.in);
        System.out.println("4번째 게임과 5번째 게임의 이름을 정해주세요");
        String Game4Name = sc.next();
        String Game5Name = sc.next();
        Januarytwentyeighth2 TotalGame = new Januarytwentyeighth2("Card Game", "빨리 보스잡기 게임", "격투게임", "" + Game4Name + "", "" + Game5Name + "", "", "", "", "", "", "", "");

        while (true) {
            TotalGame.GameList();
            int GameListInput = sc.nextInt(); //기획서를 보고싶은 게임번호

            if (GameListInput == 1 || GameListInput == 2 || GameListInput == 3 || GameListInput == 4 || GameListInput == 5) {
                TotalGame.GameListSelect();
                int GameListSelectInput = sc.nextInt();
                return ListDescription(GameListSelectInput,Game4Name,Game5Name);
            } else if (GameListInput == 6) {
                return "시스템을 종료합니다";
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static String ListDescription (int GameListSelectInput,String Game4Name,String Game5Name) {
        Januarytwentyeighth2 TotalGame = new Januarytwentyeighth2("Card Game", "빨리 보스잡기 게임", "격투게임", "" + Game4Name + "", "" + Game5Name + "", "", "", "", "", "", "", "");
        TotalGame.GameListExplanation();
        return "";
    }
}
