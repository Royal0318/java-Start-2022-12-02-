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

    public void Selectmenu (forwhile20 FoodMet) {
        Scanner sc = new Scanner(System.in);
        //메인 선택 메소드
        while (true) {
            System.out.println("[1.구구단 2.음식점 3.계산기 4.종료]");
            int Menuchoice = sc.nextInt();

            if (Menuchoice == 1) {
                FoodMet.Gugudan();
            } else if (Menuchoice == 2) {
                FoodMet.Restaurant(FoodMet);
            } else if (Menuchoice == 3) {
                if (Calmenutoutcheck == 1) {
                    FoodMet.AgainCalculator(FoodMet);
                } else {
                    FoodMet.Calculator(FoodMet);
                }
            } else if (Menuchoice == 4) {
                System.out.println("시스템을 종료합니다 \n총 누적금액 : "+Foodbuymoney+"원");
                System.exit(1);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    void Gugudan() {
        //1 ~ 9 단까지 출력 출력후 메인선택 메소드로 리턴
        for (int i = 0; i < 9; i++) {
            System.out.println("================" + (i + 1) + "단================");
            for (int j = 0; j < 9; j++) {
                System.out.println("" + (i + 1) + " X " + (j + 1) + " = " + ((i + 1) * (j + 1)) + "");
            }
        }
    }

     void Restaurant(forwhile20 FoodMet) {
        //식당 메소드 음식을 주문하면 가격을 Ordercomplete메소드로 리턴시켜 중복을 제거
        Scanner sc = new Scanner(System.in);
        System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
        int Foodchoice = sc.nextInt();

        if (Foodchoice == 1) {
            Ordercomplete(8000,FoodMet);
        } else if (Foodchoice == 2) {
            Ordercomplete(7000,FoodMet);
        } else if (Foodchoice == 3) {
            while (true) {
                System.out.println("1.Size 대[25000원] 2.Size 중[20000원] 3.Size 소[17000원]");
                int Splash = sc.nextInt();

                if (Splash == 1) {
                    Ordercomplete(25000,FoodMet);
                } else if (Splash == 2) {
                    Ordercomplete(20000,FoodMet);
                } else if (Splash == 3) {
                    Ordercomplete(17000,FoodMet);
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
            Selectmenu(FoodMet);
        } else {
            System.out.println("잘못된 입력입니다");
            Restaurant(FoodMet);
        }
    }
    void Ordercomplete(int Buyfoodprice,forwhile20 FoodMet) {
        //구매값을 리턴받아 주문완료시킨다 단 재입장하지 않았을경우 값을 저장 재입장 구매인경우 값을 저장하지 않음
        if (Foodbuycheck == 0) {
            Foodbuymoney += Buyfoodprice;
        }
        System.out.println("주문이 완료되었습니다 누적금액 : " + Foodbuymoney + "원");
        Restaurant(FoodMet);
    }

    void Calculator(forwhile20 FoodMet) {
        //계산기 메인메소드 계산을 완료하면 입력한 마지막값을 저장하며 부호와 값을 리턴시킨다
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Calmethodchoice = sc.nextInt();

        if (Calmethodchoice == 1 || Calmethodchoice == 2) {
            System.out.println("두 수를 입력해주세요");
            int Number = sc.nextInt();
            int Number2 = sc.nextInt();

            if (Calmethodchoice == 1) {
                Calculatorsum = (Number + Number2);
                Calcomplete(Number, Number2, "+",FoodMet);
            } else {
                if (Number < Number2) {
                    System.out.println("두 번째 값이 더 클 수 없습니다!");
                    Calculator(FoodMet);
                } else {
                    Calculatorsum = (Number - Number2);
                    Calcomplete(Number, Number2, "-",FoodMet);
                }
            }
        } else if (Calmethodchoice == 3) {
            Calmenutoutcheck += 1;
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + Calculatorsum + "");
            Selectmenu(FoodMet);
        } else {
            System.out.println("잘못된 입력입니다");
            Calculator(FoodMet);
        }
    }

    void AgainCalculator(forwhile20 FoodMet) {
        //다시 계산기 메소드에 진입할경우 2개의 수를 받지않고 기존 마지막값에서 2번째값을 계산한다
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Calmethodchoice = sc.nextInt();

        if (Calmethodchoice == 1 || Calmethodchoice == 2) {
            System.out.println("두 번째 값을 입력해주세요");
            int Number2 = sc.nextInt();

            if (Calmethodchoice == 1) {
                Againcalcomplete(Number2, "+",FoodMet);
            } else {
                if (Calculatorsum < Number2) {
                    System.out.println("두 번째 값이 더 큽니다");
                    AgainCalculator(FoodMet);
                } else {
                    Againcalcomplete(Number2, "-",FoodMet);
                }
            }
        } else if (Calmethodchoice == 3) {
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + Calculatorsum + "");
            Selectmenu(FoodMet);
        } else {
            System.out.println("잘못된 입력입니다");
            AgainCalculator(FoodMet);
        }
    }

    void Calcomplete(int Number, int Number2, String Sign,forwhile20 FoodMet) {
        //재입장을 하지않았을때 계속 이 메소드를 사용한다
        if (Sign.equals("+")) {
            System.out.println("" + Number + " + " + Number2 + " = " + (Number + Number2) + "");
        } else if (Sign.equals("-")) {
            System.out.println("" + Number + " - " + Number2 + " = " + (Number - Number2) + "");
        }
        Calculator(FoodMet);
    }

    void Againcalcomplete(int Number2, String Sign,forwhile20 FoodMet) {
        //재입장 계산후 리턴받는 메소드
        if (Sign.equals("+")) {
            System.out.println("" + Calculatorsum + " + " + Number2 + " = " + (Calculatorsum + Number2) + "");
            Calculatorsum += Number2;
        } else if (Sign.equals("-")) {
            System.out.println("" + Calculatorsum + " - " + Number2 + " = " + (Calculatorsum - Number2) + "");
            Calculatorsum -= Number2;
        }
        AgainCalculator(FoodMet);
    }
}
