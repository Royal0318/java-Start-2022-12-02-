import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Februaryfourth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TotalMoney = 0; //전체 돈
        int[] Money = new int[10]; //각 index에 입력하는 순서대로 돈을 기록
        ArrayList<String> Bank = new ArrayList<>(Arrays.asList("입금","출금"));

        System.out.println("입출금 총 10번진행 출금시 -를 입력");
        for (int i = 0; i < 10; i++) {
            System.out.println("" + (i + 1) + "번째 입출금 진행");
            int MoneyInput = sc.nextInt();
            TotalMoney += MoneyInput;

            if (TotalMoney < 0) {
                System.out.println("가지고 있는 돈보다 더 많이 출금 할 수 없습니다");
                TotalMoney -= MoneyInput;
                i--;
            } else {
                Money[i] += MoneyInput;
            }
        }
        for (int i = 0; i < 10; i++) {

            if (Money[i] < 0) { //출금
                Bank.remove("입금");
                System.out.println("" + Bank + " : " + (Money[i]) + "원");
            }
            if (Money[i] > 0) { //입금
                Bank.remove("출금");
                System.out.println("" + Bank + " : " + Money[i] + "원");
            }
        }
        System.out.println("잔액 : "+TotalMoney+"원");
    }
}
