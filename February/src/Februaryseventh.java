import java.util.Scanner;

public class Februaryseventh {
    public static void main(String[] args) {
        System.out.println(""+NameInput()+"");
    }

    public static int NameInput () {
        Scanner sc = new Scanner(System.in);
        System.out.println("통장을 개설할 3명의 이름을 적어주세요");
        String Name = sc.next();
        String Name2 = sc.next();
        String Name3 = sc.next();
        return TransactionMenu(Name,Name2,Name3);
    }
    public static int TransactionMenu (String Name,String Name2,String Name3) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.5회 계좌거래 \n2.거래내역 조회 \n3.잔액조회 \n4.시스템종료");
            int MeinMenuSelect = sc.nextInt();

            if (MeinMenuSelect == 1) {
                return Accounttransaction(Name,Name2,Name3);
            } else if (MeinMenuSelect == 2) {

            } else if (MeinMenuSelect == 3) {

            } else if (MeinMenuSelect == 4) {
                System.out.println("시스템을 종료합니다");
                System.exit(1);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static int Accounttransaction (String Name,String Name2,String Name3) {
        //5회 계좌거래
        Scanner sc = new Scanner(System.in);
        Februaryseventh2 NameTotal = new Februaryseventh2(""+Name+"",""+Name2+"",""+Name3+"");

        while (true) {
            System.out.println("<<<<<5회 계좌 거래>>>>> \n1." + Name + "님 \n2." + Name2 + "님 \n3." + Name3 + "님");
            int Choice = sc.nextInt();

            if (Choice == 1) {
                NameTotal.NameBankTransaction();
            } else if (Choice == 2) {
                NameTotal.Name2BankTransaction();
            } else if (Choice == 3) {
                NameTotal.Name3BankTransaction();
            } else {
                System.out.println("안내 : 잘못된 입력입니다!");
            }
        }
    }
    /*
    public static int NameOutput () {
        for (int Output : Bank) {
            if (Output < 0) {
                System.out.println("출금 : "+(Output * -1)+"원");
            } else {
                System.out.println("입금 : "+Output+"원");
            }
            System.out.println("잔액은 총 : "+NameTotalMoney+"원 입니다");
        }
    }
    public static int Name2Output () {
        for (int Output : Bank) {
            if (Output < 0) {
                System.out.println("출금 : "+(Output * -1)+"원");
            } else {
                System.out.println("입금 : "+Output+"원");
            }
            System.out.println("잔액은 총 : "+NameTotalMoney+"원 입니다");
        }
    }
    public static int Name3Output () {
        for (int Output : Bank) {
            if (Output < 0) {
                System.out.println("출금 : "+(Output * -1)+"원");
            } else {
                System.out.println("입금 : "+Output+"원");
            }
            System.out.println("잔액은 총 : "+NameTotalMoney+"원 입니다");
        }

    }

     */
}
