/*
Arraylist 기초문제
1. 은행 창구 프로그램 (기초)
우랑이는 처음으로 통장을 만들었습니다. 통장으로 총 10번의 입출금을 하였고, 이를 통장에 기록하기 위해 은행에 방문해 통장 정리를
하려고 합니다. 이를 프로그램을 만들어 보세요. <입력> 10번의 입출금 내역을 입력받습니다. 출금액은 앞에 –를 붙여 입력합니다. 통장에 들어있는 돈보다 큰 돈은 출금될 수 없으므로 입력할 때 유의하세요.
(가능하면 이를 막을 수 있는 코드도 추가해보세요.)
<입력 예시> 10000 15000 -12000 –2000 3000 –7500 200 –500 7000 -1000
<출력> 모든 입출금 내역과 통잔잔액을 출력합니다. <출력 예시>
입금 10000원
입금 15000원
출금 12000원
출금 2000원
입금 3000원
출금 7500원
입금 200원
출금 500원
입금 7000원
출금 1000원
잔액 : 12200
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Februaryfiveth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TotalMoney = 0;
        ArrayList<Integer> Bank = new ArrayList<>();
        System.out.println("입출금 총 10번진행 출금시 -를 입력");
        for (int i = 0; i < 10; i++) {
            System.out.println("" + (i + 1) + "번째 입출금 진행");
            Bank.add(sc.nextInt());
            TotalMoney += Bank.get(i); //입력한 Bank값을 TotalMoney에 그대로 누적

            if (TotalMoney < 0) { //가지고 있는금액보다 빌린금액이 더 많은경우
                System.out.println("입금 금액보다 많이 출금 할 수 없습니다");
                TotalMoney -= Bank.get(i); //입력한 값 반환
                Bank.remove(i); //해당인덱스 삭제하고 재입력 받도록함
                i--; //다시 입력하도록 i값 되돌림
            }
        }
        for (int Output : Bank) { //인덱스안에 할당된 값을 출력
            if (Output > 0) {
                System.out.println("입금 : " + Output + "원");
            } else {
                System.out.println("출금 : " + (Output * -1) + "원");
            }
        }
        System.out.println("잔액 : "+TotalMoney+"원");
    }
}
