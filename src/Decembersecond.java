/*
//간단한 if문과 스캐너를 이용하여 갯수와 가격으로 값을 자동계산해보자!
//문) 1.감자 2.옥수수 3.수박이 주어졌으며
//1번을 누를경우 출력값이 "1번 감자를 선택하였습니다."라는 문구가 나오도록 한다
//그 후 1번 감자는 각각 1000원어치,2000원어치,3000원어치
//2번 옥수수는 4000원어치, 5000원어치, 6000원어치
//3번 수박은 10000원어치, 20000원어치, 30000원어치 라는 문구가 각각나오도록 설정 후
//그 안에서 또 1번을 누를 시
//출력값 "감자 1000원어치를 주문 하였습니다"라는 문장이 나오도록 하며
//갯수를 입력받고 그 갯수에 따라 금액이 변동되는 코드를 작성하시오
//

*/

import java.util.Scanner;

public class Decembersecond {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.감자  \n2.옥수수  \n3.수박");
        int foodselect = sc.nextInt();

        if (foodselect == 1) {
            System.out.println("감자를 선택하셨습니다.");
            System.out.println("\n1.1000원어치 구매 \n2.2000원어치 구매 \n3.3000원어치 구매");
            int moneyselect = sc.nextInt();
            if (moneyselect == 1) {
                System.out.println("감자를 1000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(1000 * num)+"원 입니다");
            }
            if (moneyselect == 1) {
                System.out.println("감자를 2000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(2000 * num)+"원 입니다");
            }
            if (moneyselect == 1) {
                System.out.println("감자를 3000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(3000 * num)+"원 입니다");
            }
        }
        if (foodselect == 2) {
            System.out.println("옥수수를 선택하셨습니다.");
            System.out.println("\n1.4000원어치 구매 \n2.5000원어치 구매 \n3.6000원어치 구매");
            int moneyselect = sc.nextInt();
            if (moneyselect == 1) {
                System.out.println("옥수수를 4000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(4000 * num)+"원 입니다");
            }
            if (moneyselect == 2) {
                System.out.println("옥수수를 5000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(5000 * num)+"원 입니다");
            }
            if (moneyselect == 3) {
                System.out.println("옥수수를 6000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(6000 * num)+"원 입니다");
            }
        }
        if (foodselect == 3) {
            System.out.println("수박을 선택하셨습니다.");
            System.out.println("\n1.10000원어치 구매 \n2.20000원어치 구매 \n3.30000원어치 구매");
            int moneyselect = sc.nextInt();
            if (moneyselect == 1) {
                System.out.println("수박을 10000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(10000 * num)+"원 입니다");
            }
            if (moneyselect == 2) {
                System.out.println("수박을 20000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(20000 * num)+"원 입니다");
            }
            if (moneyselect == 3) {
                System.out.println("수박을 30000원어치 구매하셨습니다 몇개를 구매 하시겠습니까?");
                int num = sc.nextInt();
                System.out.println("총 금액은 "+(30000 * num)+"원 입니다");
            }
        }
    }
}
