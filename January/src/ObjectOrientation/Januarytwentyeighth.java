package ObjectOrientation;

import java.util.Scanner;

public class Januarytwentyeighth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("4번째 게임과 5번째 게임의 이름을 정해주세요");
        String Game4Name = sc.next();
        String Game5Name = sc.next();

        Januarytwentyeighth2 GameListInput = new Januarytwentyeighth2("Card Game","빨리 보스잡기 게임","격투게임",""+Game4Name+"",""+Game5Name+"");

        GameListInput.GameList();
    }
}
