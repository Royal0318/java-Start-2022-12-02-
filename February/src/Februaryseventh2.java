import java.util.ArrayList;
import java.util.Scanner;

public class Februaryseventh2 {
    String People;
    String People2;
    String People3;

    Februaryseventh2 (String People,String People2,String People3) {
        this.People = People;
        this.People2 = People2;
        this.People3 = People3;
    }
    void NameBankTransaction () {
        ArrayList<Integer> Bank = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int NameTotalMoney = 0;
        for (int i = 0;i < 5;i++) {
            System.out.println(""+People+"님의"+(i + 1)+"번째 입출금");
            Bank.add(sc.nextInt());
            NameTotalMoney += Bank.get(i);

            if (NameTotalMoney < 0) {
                System.out.println("출금금액이 잔액보다 많습니다");
                NameTotalMoney -= Bank.get(i);
                Bank.remove(i);
                i--;
            }
        }
        System.out.println("거래가 완료되었습니다");
    }
    void Name2BankTransaction () {

    }
    void Name3BankTransaction () {

    }
}
