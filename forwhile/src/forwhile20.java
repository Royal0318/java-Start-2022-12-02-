import java.util.Scanner;
public class forwhile20 {
    int Foodbuymoney;
    int Foodbuycheck;
    int Calculatorsum;
    int Calmenutoutcheck;

    forwhile20() {

    }

    forwhile20(int Foodbuymoney, int Foodbuycheck, int Calculatorsum, int Calmenuoutcheck) {
        this.Foodbuymoney = Foodbuymoney;
        this.Foodbuycheck = Foodbuycheck;
        this.Calculatorsum = Calculatorsum;
        this.Calmenutoutcheck = Calmenuoutcheck;
    }

    void Gugudan() {
        for (int i = 0; i < 9; i++) {
            System.out.println("================" + (i + 1) + "단================");
            for (int j = 0; j < 9; j++) {
                System.out.println("" + (i + 1) + " X " + (j + 1) + " = " + ((i + 1) * (j + 1)) + "");
            }
        }
    }

     void Restaurant() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
        int Foodchoice = sc.nextInt();

        if (Foodchoice == 1) {
            Ordercomplete(8000);
        } else if (Foodchoice == 2) {
            Ordercomplete(7000);
        } else if (Foodchoice == 3) {
            while (true) {
                System.out.println("1.Size 대[25000원] 2.Size 중[20000원] 3.Size 소[17000원]");
                int Splash = sc.nextInt();

                if (Splash == 1) {
                    Ordercomplete(25000);
                } else if (Splash == 2) {
                    Ordercomplete(20000);
                } else if (Splash == 3) {
                    Ordercomplete(17000);
                } else {
                    System.out.println("잘못된 입력입니다");
                }
            }
        } else if (Foodchoice == 4) {
            //최소가격의 음식을 구매하고 나갔을경우 다시들어왔을때 돈을 받지 않는다
            if (Foodbuymoney >= 7000) {
                Foodbuycheck += 1;
            }
            System.out.println("메인메뉴로 돌아갑니다");
            //메인메뉴로 리턴하는방법?
        } else {
            System.out.println("잘못된 입력입니다");
            Restaurant();
        }
    }
    void Ordercomplete(int Buyfoodprice) {
        if (Foodbuycheck == 0) {
            Foodbuymoney += Buyfoodprice;
        }
        System.out.println("주문이 완료되었습니다 누적금액 : " + Foodbuymoney + "원");
        Restaurant();
    }

    void Calculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Calmethodchoice = sc.nextInt();

        if (Calmethodchoice == 1 || Calmethodchoice == 2) {
            System.out.println("두 수를 입력해주세요");
            int Number = sc.nextInt();
            int Number2 = sc.nextInt();

            if (Calmethodchoice == 1) {
                Calculatorsum = (Number + Number2);
                Calcomplete(Number, Number2, "+");
            } else {
                if (Number < Number2) {
                    System.out.println("두 번째 값이 더 클 수 없습니다!");
                    Calculator();
                } else {
                    Calculatorsum = (Number - Number2);
                    Calcomplete(Number, Number2, "-");
                }
            }
        } else if (Calmethodchoice == 3) {
            Calmenutoutcheck += 1;
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + Calculatorsum + "");
            //메인메뉴로 리턴하는방법?
        } else {
            System.out.println("잘못된 입력입니다");
            Calculator();
        }
    }

    void AgainCalculator() {
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Calmethodchoice = sc.nextInt();

        if (Calmethodchoice == 1 || Calmethodchoice == 2) {
            System.out.println("두 번째 값을 입력해주세요");
            int Number2 = sc.nextInt();

            if (Calmethodchoice == 1) {
                Againcalcomplete(Number2, "+");
            } else {
                if (Calculatorsum < Number2) {
                    System.out.println("두 번째 값이 더 큽니다");
                    AgainCalculator();
                } else {
                    Againcalcomplete(Number2, "-");
                }
            }
        } else if (Calmethodchoice == 3) {
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + Calculatorsum + "");
            //메인메뉴로 리턴하는방법?
        } else {
            System.out.println("잘못된 입력입니다");
            AgainCalculator();
        }
    }

    void Calcomplete(int Number, int Number2, String Sign) {
        if (Sign.equals("+")) {
            System.out.println("" + Number + " + " + Number2 + " = " + (Number + Number2) + "");
        } else if (Sign.equals("-")) {
            System.out.println("" + Number + " - " + Number2 + " = " + (Number - Number2) + "");
        }
        Calculator();
    }

    void Againcalcomplete(int Number2, String Sign) {
        if (Sign.equals("+")) {
            System.out.println("" + Calculatorsum + " + " + Number2 + " = " + (Calculatorsum + Number2) + "");
        } else if (Sign.equals("-")) {
            System.out.println("" + Calculatorsum + " - " + Number2 + " = " + (Calculatorsum - Number2) + "");
        }
        AgainCalculator();
    }
}
