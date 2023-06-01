import java.util.Scanner;

public class lottoMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LottoInterface lottoInterface = new LottoProgram();

        while (true) {
            System.out.println("1.로또 돌리기 2.프로그램 종료");

            int menuChoice = sc.nextInt();

            if (menuChoice == 1) {
                System.out.println("=============로또 프로그램을 시작합니다=============");
                lottoInterface.inputMyMoney();
                break;
            } else if (menuChoice == 2) {
                System.out.println("프로그램을 종료합니다");
                break;
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
}
