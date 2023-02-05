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
