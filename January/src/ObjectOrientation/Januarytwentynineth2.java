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
public class Januarytwentynineth2 {
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

    Januarytwentynineth2(String Game, String Game2, String Game3, String Game4, String Game5, String GameTitle, String GameExplanation, String GameGenre, String GamePlayWay, String GameProducers, String ProductionPeriod, String EstimatedSales) {
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

    void GameMainList() {
        //전체 게임리스트 출력
        System.out.println("\n========게임 기획서========\n1." + Game + "\n2." + Game2 + "\n3." + Game3 + "\n4." + Game4 + "\n5." + Game5 + "\n6.시스템종료\n==========================");
        System.out.println("안내 : 기획서를 보고싶은 게임의 번호를 입력해주세요");
    }

    void GameListExplanation() {
        //1번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game1Select() + " \n2.게임 설명 : " + Game1Select2() + " \n3.게임 장르 : " + Game1Select3() + " \n4.게임 플레이 방식 : " + Game1Select4() + " \n5.게임 제작자 : " + Game1Select5() + " \n6.게임 제작기간 : " + Game1Select6() + " \n7.게임 예상 매출액 : " + Game1Select7() + "");
    }

    String Game1Select() {
        return "Card Game";
    }

    String Game1Select2() {
        return "본 게임은 상대방과 카드를 비교하여 숫자가 더 큰 참가자가 승리하는 게임입니다";
    }

    String Game1Select3() {
        return "TCG장르";
    }

    String Game1Select4() {
        return "\n①.두 참가자가 제한시간 60초내에 카드를 제시한다 \n②.제시한 카드중 숫자가 더 큰 참가자가 승리 \n③.서로의 카드를 알기 위하여 자유로운 토론이 가능하다 \n④.승점10점을 먼저 흭득한 참가자가 승리!";
    }

    String Game1Select5() {
        return "게임 제작자 : 김현우,최민현,박민지";
    }

    String Game1Select6() {
        return "게임 제작기간 : 2022.11.21 ~ 12.22 (약 1달간 진행)";
    }

    String Game1Select7() {
        return "예상 매출액은 게임시장을 고려하여 약 3천만원";
    }

    void Game2ListExplanation() {
        //2번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game2Select() + " \n2.게임 설명 : " + Game2Select2() + " \n3.게임 장르 : " + Game2Select3() + " \n4.게임 플레이 방식 : " + Game2Select4() + " \n5.게임 제작자 : " + Game2Select5() + " \n6.게임 제작기간 : " + Game2Select6() + " \n7.게임 예상 매출액 : " + Game2Select7() + "");
    }

    String Game2Select() {
        return "빨리 보스잡기 게임";
    }

    String Game2Select2() {
        return "본 게임은 상대방과 겨루에 가장 빨리 보스를 잡는 플레이어가 승리하는 게임입니다";
    }

    String Game2Select3() {
        return "MMORPG";
    }

    String Game2Select4() {
        return "\n①.두 참가자가 제한시간 5분이네에 필드에 주어진 보스를 공격한다 \n②.제한시간동안 보스를잡거나 데미지를 더 많이 입힌 플레이어가 승리!";
    }

    String Game2Select5() {
        return "게임 제작자 : 도현우";
    }

    String Game2Select6() {
        return "게임 제작기간 : 2022.11.21 ~ 12.05";
    }

    String Game2Select7() {
        return "예상 매출액은 게임시장을 고려하여 약 500만원";
    }

    void Game3ListExplanation() {
        //3번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game3Select() + " \n2.게임 설명 : " + Game3Select2() + " \n3.게임 장르 : " + Game3Select3() + " \n4.게임 플레이 방식 : " + Game3Select4() + " \n5.게임 제작자 : " + Game3Select5() + " \n6.게임 제작기간 : " + Game3Select6() + " \n7.게임 예상 매출액 : " + Game3Select7() + "");
    }

    String Game3Select() {
        return "격투게임";
    }

    String Game3Select2() {
        return "본 게임은 상대방과 겨루에 상대방을 먼저 쓰러트리는 플레이어가 승리하는 게임입니다";
    }

    String Game3Select3() {
        return "액션";
    }

    String Game3Select4() {
        return "\n①.두 참가자가 제한시간 1분이네에 상대의 체력을 모두 깎아 쓰러트리는 플레이어가 승리합니다 \n②.스킬사용이 자유로우며 숨겨진 스킬을 찾아서 상대방을 쓰려트려보세요!";
    }

    String Game3Select5() {
        return "게임 제작자 : 김현준";
    }

    String Game3Select6() {
        return "게임 제작기간 : 2022.11.21 ~ 12.15";
    }

    String Game3Select7() {
        return "예상 매출액은 게임시장을 고려하여 약 750만원";
    }

    void Game4ListExplanation() {
        //4번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game4 + " \n2.게임 설명 : " + Game4Select2() + " \n3.게임 장르 : " + Game4Select3() + " \n4.게임 플레이 방식 : " + Game4Select4() + " \n5.게임 제작자 : " + Game4Select5() + " \n6.게임 제작기간 : " + Game4Select6() + " \n7.게임 예상 매출액 : " + Game4Select7() + "");
    }
    String Game4Select2() {
        return "본 게임은 주어진 트랙안에서 상대방과 주어진 자동차로 경주는를 하여 결승전에 먼저 통과하는 플레이어가 승리하는 게임입니다";
    }

    String Game4Select3() {
        return "레이싱";
    }

    String Game4Select4() {
        return "\n①.두 참가자는 제한시간 없이 필드에 주어진 트랙을 먼저 완주하는 플레이어가 승리하는 구조입니다 \n②.역주행은 할 수 없으며 드리프트를 사용하여 부스트를 사용하기위한 게이지를 모을 수 있습니다";
    }

    String Game4Select5() {
        return "게임 제작자 : 박현주,최현우";
    }

    String Game4Select6() {
        return "게임 제작기간 : 2022.11.21 ~ 2023.1.2";
    }

    String Game4Select7() {
        return "예상 매출액은 게임시장을 고려하여 약 1100만원";
    }

    void Game5ListExplanation() {
        //5번 게임 기획서 출력
        System.out.println("1.게임 제목 : " + Game5 + " \n2.게임 설명 : " + Game5Select2() + " \n3.게임 장르 : " + Game5Select3() + " \n4.게임 플레이 방식 : " + Game5Select4() + " \n5.게임 제작자 : " + Game5Select5() + " \n6.게임 제작기간 : " + Game5Select6() + " \n7.게임 예상 매출액 : " + Game5Select7() + "");
    }
    String Game5Select2() {
        return "본 게임은 아군5명과 상대5명이 대결하며 상대의 기지 본체를 먼저 파괴하는 팀이 승리하는 팀전게임입니다";
    }

    String Game5Select3() {
        return "AOS";
    }

    String Game5Select4() {
        return "\n①.5:5참가자가 참가하여 제한시간이 없는 필드로 이동합니다 \n②.필드에 주어진 필드몬스터를 사냥해서 골드를 흭득하거나 상대방을 쓰러트려 레벨업과 아이템을 구매 할 수 있습니다 \n③.각각의 장비를 맞추고 상대방을 쓰러트려 상대 기지의 포탑을 모두 제거 후 본체를 먼저 파괴하는 팀이 승리합니다";
    }

    String Game5Select5() {
        return "게임 제작자 : 공민혁,최종유,김영현,백민지";
    }

    String Game5Select6() {
        return "게임 제작기간 : 2022.11.21 ~ 2023.3.5";
    }

    String Game5Select7() {
        return "예상 매출액은 게임시장을 고려하여 약 3천만원";
    }
}
