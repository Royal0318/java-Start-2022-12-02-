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
    String GameTitle;
    String GameExplanation;
    String GameGenre;
    String GamePlayWay;
    String GameProducers;
    String ProductionPeriod;
    String EstimatedSales;

    Januarytwentyeighth2(String Game,String Game2,String Game3,String Game4,String Game5,String GameTitle,String GameExplanation,String GameGenre,String GamePlayWay,String GameProducers,String ProductionPeriod,String EstimatedSales) {
        this.Game = Game;
        this.Game2 = Game2;
        this.Game3 = Game3;
        this.Game4 = Game4;
        this.Game5 = Game5;
        this.GameTitle = GameTitle;
        this.GameExplanation = GameExplanation;
        this.GameGenre = GameGenre;
        this.GamePlayWay = GamePlayWay;
        this.GameProducers = GameProducers;
        this.ProductionPeriod = ProductionPeriod;
        this.EstimatedSales = EstimatedSales;
    }
    void GameList () {
        System.out.println("========게임 기획서========\n1."+Game+"\n2."+Game2+"\n3."+Game3+"\n4."+Game4+"\n5."+Game5+"\n6.시스템종료\n==========================");
        System.out.println("안내 : 기획서를 보고싶은 게임의 번호를 입력해주세요");
    }
    void GameListSelect () {
        System.out.println("1.게임 제목 \n2.게임 설명 \n3.게임 장르 \n4.게임 플레이 방식 \n5.게임 제작자 \n6.게임 제작기간 \n7.게임 예상 매출액");
        System.out.println("안내 : 원하는 번호를 입력해주세요");
    }
    void GameListExplanation () {
        System.out.println("1.게임 제목 : "+Select()+" \n2.게임 설명 : "+Select2()+" \n3.게임 장르 : "+Select3()+" \n4.게임 플레이 방식 : "+Select4()+" \n5.게임 제작자 : "+Select5()+" \n6.게임 제작기간 : "+Select6()+" \n7.게임 예상 매출액 : "+Select7()+"");
    }
    String Select () {
        return "Card Game";
    }
    String Select2 () {
        return "본 게임은 상대방과 카드를 비교하여 숫자가 더 큰 참가자가 승리하는 게임입니다";
    }
    String Select3 () {
        return "TCG장르";
    }
    String Select4 () {
        return "1.두 참가자가 제한시간 60초내에 카드를 제시한다 \n2.제시한 카드중 숫자가 더 큰 참가자가 승리 \n3.서로의 카드를 알기 위하여 자유로운 토론이 가능하다 \n4.승점10점을 먼저 흭득한 참가자가 승리!";
    }
    String Select5 () {
        return "게임 제작자 : 김현우,최민현,박민지";
    }
    String Select6 () {
        return "게임 제작기간 : 2022.11.21 ~ 12.22 (약 1달간 진행)";
    }
    String Select7 () {
        return "예상 매출액은 게임시장을 고려하여 약 3천만원";
    }
    void Game2ListExplanation () {
        System.out.println("1.게임 제목 \n2.게임 설명 \n3.게임 장르 \n4.게임 플레이 방식 \n5.게임 제작자 \n6.게임 제작기간 \n7.게임 예상 매출액");
    }
    void Game3ListExplanation () {
        System.out.println("1.게임 제목 \n2.게임 설명 \n3.게임 장르 \n4.게임 플레이 방식 \n5.게임 제작자 \n6.게임 제작기간 \n7.게임 예상 매출액");
    }
    void Game4ListExplanation () {
        System.out.println("1.게임 제목 \n2.게임 설명 \n3.게임 장르 \n4.게임 플레이 방식 \n5.게임 제작자 \n6.게임 제작기간 \n7.게임 예상 매출액");
    }
    void Game5ListExplanation () {
        System.out.println("1.게임 제목 \n2.게임 설명 \n3.게임 장르 \n4.게임 플레이 방식 \n5.게임 제작자 \n6.게임 제작기간 \n7.게임 예상 매출액");
    }
}
