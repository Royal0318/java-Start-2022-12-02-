
package ObjectOrientation;
public class Januarytwentynineth2 {
    String Game;
    String Game2;
    String Game3;
    String Game4;
    String Game5;

    Januarytwentynineth2(String Game, String Game2, String Game3, String Game4, String Game5) {
        this.Game = Game;
        this.Game2 = Game2;
        this.Game3 = Game3;
        this.Game4 = Game4;
        this.Game5 = Game5;
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
        //4번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game4 + " \n2.게임 설명 : " + Game4Explanation() + " \n3.게임 장르 : " + Game4Genre() + " \n4.게임 플레이 방식 : " + Game4Rull() + " \n5.게임 제작자 : " + Game4Producers() + " \n6.게임 제작기간 : " + Game4MakePeriod() + " \n7.게임 예상 매출액 : " + Game4Sale() + "");
    }
    String Game4Explanation() {
        return "본 게임은 주어진 트랙안에서 상대방과 주어진 자동차로 경주는를 하여 결승전에 먼저 통과하는 플레이어가 승리하는 게임입니다";
    }

    String Game4Genre() {
        return "레이싱";
    }

    String Game4Rull() {
        return "\n①.두 참가자는 제한시간 없이 필드에 주어진 트랙을 먼저 완주하는 플레이어가 승리하는 구조입니다 \n②.역주행은 할 수 없으며 드리프트를 사용하여 부스트를 사용하기위한 게이지를 모을 수 있습니다";
    }

    String Game4Producers() {
        return "게임 제작자 : 박현주,최현우";
    }

    String Game4MakePeriod() {
        return "게임 제작기간 : 2022.11.21 ~ 2023.1.2";
    }

    String Game4Sale() {
        return "예상 매출액은 게임시장을 고려하여 약 1100만원";
    }

    void Game5ListExplanation() {
        //5번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game5 + " \n2.게임 설명 : " + Game5Explanation() + " \n3.게임 장르 : " + Game5Genre() + " \n4.게임 플레이 방식 : " + Game5Rull() + " \n5.게임 제작자 : " + Game5Producers() + " \n6.게임 제작기간 : " + Game5MakePeriod() + " \n7.게임 예상 매출액 : " + Game5Sale() + "");
    }
    String Game5Explanation() {
        return "본 게임은 아군5명과 상대5명이 대결하며 상대의 기지 본체를 먼저 파괴하는 팀이 승리하는 팀전게임입니다";
    }

    String Game5Genre() {
        return "AOS";
    }

    String Game5Rull() {
        return "\n①.5:5참가자가 참가하여 제한시간이 없는 필드로 이동합니다 \n②.필드에 주어진 필드몬스터를 사냥해서 골드를 흭득하거나 상대방을 쓰러트려 레벨업과 아이템을 구매 할 수 있습니다 \n③.각각의 장비를 맞추고 상대방을 쓰러트려 상대 기지의 포탑을 모두 제거 후 본체를 먼저 파괴하는 팀이 승리합니다";
    }

    String Game5Producers() {
        return "게임 제작자 : 공민혁,최종유,김영현,백민지";
    }

    String Game5MakePeriod() {
        return "게임 제작기간 : 2022.11.21 ~ 2023.3.5";
    }

    String Game5Sale() {
        return "예상 매출액은 게임시장을 고려하여 약 3천만원";
    }
}
