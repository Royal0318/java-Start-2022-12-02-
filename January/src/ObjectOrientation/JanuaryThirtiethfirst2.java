
package ObjectOrientation;
public class JanuaryThirtiethfirst2 {
    String Game;
    String Game2;
    String Game3;
    String Game4;
    String Game4Explanation;
    String Game4Genre;
    String Game4Rull;
    String Game4Producers;
    String Game4Producers2;
    String Game4Producers3;
    String Game4MakePeriod;
    String Game4MakePeriod2;
    String Game4Sale;
    String Game5;
    String Game5Explanation;
    String Game5Genre;
    String Game5Rull;
    String Game5Producers;
    String Game5Producers2;
    String Game5Producers3;
    String Game5MakePeriod;
    String Game5MakePeriod2;
    String Game5Sale;

    JanuaryThirtiethfirst2(String Game, String Game2, String Game3,String Game4,String Game5,String Game4Explanation,String Game4Genre,String Game4Rull,String Game4Producers,String Game4Producers2,String Game4Producers3,String Game4MakePeriod,String Game4MakePeriod2,String Game4Sale,String Game5Explanation,String Game5Genre,String Game5Rull,String Game5Producers,String Game5Producers2,String Game5Producers3,String Game5MakePeriod,String Game5MakePeriod2,String Game5Sale) {
        this.Game = Game;
        this.Game2 = Game2;
        this.Game3 = Game3;
        this.Game4 = Game4;
        this.Game4Explanation = Game4Explanation;
        this.Game4Genre = Game4Genre;
        this.Game4Rull = Game4Rull;
        this.Game4Producers = Game4Producers;
        this.Game4Producers2 = Game4Producers2;
        this.Game4Producers3 = Game4Producers3;
        this.Game4MakePeriod = Game4MakePeriod;
        this.Game4MakePeriod2 = Game4MakePeriod2;
        this.Game4Sale = Game4Sale;
        this.Game5 = Game5;
        this.Game5Explanation = Game5Explanation;
        this.Game5Genre = Game5Genre;
        this.Game5Rull = Game5Rull;
        this.Game5Producers = Game5Producers;
        this.Game5Producers2 = Game5Producers2;
        this.Game5Producers3 = Game5Producers3;
        this.Game5MakePeriod = Game5MakePeriod;
        this.Game5MakePeriod2 = Game5MakePeriod2;
        this.Game5Sale = Game5Sale;
    }
    void GameMainList() {
        //전체 게임리스트 출력
        System.out.println("\n========게임 기획서========\n1." + Game + "\n2." + Game2 + "\n3." + Game3 + "\n4." + Game4 + "\n5." + Game5 + "\n6.시스템종료\n==========================");
        System.out.println("안내 : 기획서를 보고싶은 게임의 번호를 입력해주세요");
    }

    void GameListExplanation() {
        //1번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game1Title() + " \n2.게임 설명 : " + Game1Explanation() + " \n3.게임 장르 : " + Game1Genre() + " \n4.게임 플레이 방식 : " + Game1Rull() + " \n5.게임 제작자 : " + Game1Producers() + " \n6.게임 제작기간 : " + Game1MakePeriod() + " \n7.게임 예상 매출액 : " + Game1Sale() + "");
    }

    String Game1Title() {
        return "Card Game";
    }

    String Game1Explanation() {
        return "본 게임은 상대방과 카드를 비교하여 숫자가 더 큰 참가자가 승리하는 게임입니다";
    }

    String Game1Genre() {
        return "TCG장르";
    }

    String Game1Rull() {
        return "\n①.두 참가자가 제한시간 60초내에 카드를 제시한다 \n②.제시한 카드중 숫자가 더 큰 참가자가 승리 \n③.서로의 카드를 알기 위하여 자유로운 토론이 가능하다 \n④.승점10점을 먼저 흭득한 참가자가 승리!";
    }

    String Game1Producers() {
        return "게임 제작자 : 김현우,최민현,박민지";
    }

    String Game1MakePeriod() {
        return "게임 제작기간 : 2022.11.21 ~ 12.22 (약 1달간 진행)";
    }

    String Game1Sale() {
        return "예상 매출액은 게임시장을 고려하여 약 3천만원";
    }

    void Game2ListExplanation() {
        //2번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game2Title() + " \n2.게임 설명 : " + Game2Explanation() + " \n3.게임 장르 : " + Game2Genre() + " \n4.게임 플레이 방식 : " + Game2Rull() + " \n5.게임 제작자 : " + Game2Producers() + " \n6.게임 제작기간 : " + Game2MakePeriod() + " \n7.게임 예상 매출액 : " + Game2Sale() + "");
    }

    String Game2Title() {
        return "빨리 보스잡기 게임";
    }

    String Game2Explanation() {
        return "본 게임은 상대방과 겨루에 가장 빨리 보스를 잡는 플레이어가 승리하는 게임입니다";
    }

    String Game2Genre() {
        return "MMORPG";
    }

    String Game2Rull() {
        return "\n①.두 참가자가 제한시간 5분이네에 필드에 주어진 보스를 공격한다 \n②.제한시간동안 보스를잡거나 데미지를 더 많이 입힌 플레이어가 승리!";
    }

    String Game2Producers() {
        return "게임 제작자 : 도현우";
    }

    String Game2MakePeriod() {
        return "게임 제작기간 : 2022.11.21 ~ 12.05";
    }

    String Game2Sale() {
        return "예상 매출액은 게임시장을 고려하여 약 500만원";
    }

    void Game3ListExplanation() {
        //3번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game3Title() + " \n2.게임 설명 : " + Game3Explanation() + " \n3.게임 장르 : " + Game3Genre() + " \n4.게임 플레이 방식 : " + Game3Rull() + " \n5.게임 제작자 : " + Game3Producers() + " \n6.게임 제작기간 : " + Game3MakePeriod() + " \n7.게임 예상 매출액 : " + Game3Sale() + "");
    }

    String Game3Title() {
        return "격투게임";
    }

    String Game3Explanation() {
        return "본 게임은 상대방과 겨루에 상대방을 먼저 쓰러트리는 플레이어가 승리하는 게임입니다";
    }

    String Game3Genre() {
        return "액션";
    }

    String Game3Rull() {
        return "\n①.두 참가자가 제한시간 1분이네에 상대의 체력을 모두 깎아 쓰러트리는 플레이어가 승리합니다 \n②.스킬사용이 자유로우며 숨겨진 스킬을 찾아서 상대방을 쓰려트려보세요!";
    }

    String Game3Producers() {
        return "게임 제작자 : 김현준";
    }

    String Game3MakePeriod() {
        return "게임 제작기간 : 2022.11.21 ~ 12.15";
    }

    String Game3Sale() {
        return "예상 매출액은 게임시장을 고려하여 약 750만원";
    }
    void Game4ListExplanation() {
        System.out.println("1.게임 제목 : " + Game4 + " \n2.게임 설명 : " + Game4Explanation + " \n3.게임 장르 : " + Game4Genre + " \n4.게임 플레이 방식 : " + Game4Rull + " \n5.게임 제작자 : " + Game4Producers + " " + Game4Producers2 + " " + Game4Producers3 + " \n6.게임 제작기간 : " + Game4MakePeriod + " " + Game4MakePeriod2 + " \n7.게임 예상 매출액 : " + Game4Sale + "");
    }

    void Game5ListExplanation() {
        System.out.println("1.게임 제목 : " + Game5 + " \n2.게임 설명 : " + Game5Explanation + " \n3.게임 장르 : " + Game5Genre + " \n4.게임 플레이 방식 : " + Game5Rull + " \n5.게임 제작자 : " + Game5Producers + " " + Game5Producers2 + " " + Game5Producers3 + " \n6.게임 제작기간 : " + Game5MakePeriod + " " + Game5MakePeriod2 + " \n7.게임 예상 매출액 : " + Game5Sale + "");
    }
}
