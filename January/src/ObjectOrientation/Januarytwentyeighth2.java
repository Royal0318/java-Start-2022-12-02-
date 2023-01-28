/*
1.게임 제목
2.게임설명
2.게임장르
2.게임플레이방식
3.게임을 제작한사람
4.게임 제작기간
5.게임 예상 매출액
 */
package ObjectOrientation;
public class Januarytwentyeighth2 {
    String Game;
    String Game2;
    String Game3;

    String Game4;
    String Game5;

    Januarytwentyeighth2(String Game,String Game2,String Game3,String Game4,String Game5) {
        this.Game = Game;
        this.Game2 = Game2;
        this.Game3 = Game3;
        this.Game4 = Game4;
        this.Game5 = Game5;

    }
    void GameList () {
        System.out.println("========게임 기획서========\n1."+Game+"\n2."+Game2+"\n3."+Game3+"\n4."+Game4+"\n5."+Game5+"\n==========================");
        System.out.println("안내 : 기획서를 보고싶은 게임의 번호를 입력해주세요");
    }
}
