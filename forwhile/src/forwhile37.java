import java.util.Scanner;

public class forwhile37 {
    int Buyfoodmoneystorage; //음식점에서 음식을 구매할때마다 가격 저장
    int CalculatorLastnumber; //계산기에서 마지막값을 저장하는 변수
    int Calpositioncheck; //계산기메뉴 재진입시 두번째 값만 받기위하여 구별해주는 변수

    forwhile37() {

    }
    forwhile37(int Buyfoodmoneystorage, int CalculatorLastnumber, int Calpositioncheck) {
        this.Buyfoodmoneystorage = Buyfoodmoneystorage;
        this.CalculatorLastnumber = CalculatorLastnumber;
        this.Calpositioncheck = Calpositioncheck;
    }

    public void Selectmenu() {
        Scanner sc = new Scanner(System.in);
        //메인 선택 메소드
        System.out.println("[1.구구단 2.음식점 3.계산기 4.종료]");
        int Mainmenuchoice = sc.nextInt();

        switch (Mainmenuchoice) {
            case 1 :
                Gugudan();
            case 2 :
                Restaurant();
            case 3 :
                if (Calpositioncheck == 1) {
                    //계산기를 재입장할경우 2번째 값만 받는 메소드로 이동
                    AgainCalculator();
                } else {
                    Calculator();
                }
            case 4 :
                System.out.println("시스템을 종료합니다 \n총 누적금액 : " + Buyfoodmoneystorage + "원");
                System.exit(0);
            default :
                System.out.println("잘못된 입력입니다");
                Selectmenu();
        }
    }

    void Gugudan() {
        //1 ~ 9 단까지 출력 출력후 메인선택 메소드로 리턴
        for (int i = 0; i < 9; i++) {
            System.out.println("================" + (i + 1) + "단================");
            for (int j = 0; j < 9; j++) {
                System.out.println(""+(i + 1)+" X "+(j + 1)+" = "+((i + 1) * (j + 1))+"");
            }
        }
        Selectmenu();
    }
    void Restaurant() {
        //식당 메소드 음식을 주문하면 가격을 Ordercomplete메소드로 리턴시켜 중복을 제거
        Scanner sc = new Scanner(System.in);
        System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
        int Chinesefoodchoice = sc.nextInt();

        if (Chinesefoodchoice == 1) {
            Ordercomplete(8000);
        } else if (Chinesefoodchoice == 2) {
            Ordercomplete(7000);
        } else if (Chinesefoodchoice == 3) {

                System.out.println("1.Size 대[25000원] 2.Size 중[20000원] 3.Size 소[17000원] 4.돌아가기");
                int Friedsizechoice = sc.nextInt();

                if (Friedsizechoice == 1) {
                    Ordercomplete(25000);
                } else if (Friedsizechoice == 2) {
                    Ordercomplete(20000);
                } else if (Friedsizechoice == 3) {
                    Ordercomplete(17000);
                } else if (Friedsizechoice == 4) {
                    Restaurant();
                } else {
                    System.out.println("잘못된 입력입니다");
                    Restaurant();
                }
        } else if (Chinesefoodchoice == 4) {
            System.out.println("메인메뉴로 돌아갑니다");
            Selectmenu();
        } else {
            System.out.println("잘못된 입력입니다");
            Restaurant();
        }
    }
    void Ordercomplete(int Buyfoodprice) {
        //구매값을 리턴받아 주문완료시킨다 단 재입장하지 않았을경우 값을 저장 재입장 구매인경우 값을 저장하지 않음
        if (Buyfoodmoneystorage >= 7000) {
            Buyfoodmoneystorage += Buyfoodprice;
        }
        System.out.println("주문이 완료되었습니다 누적금액 : " + Buyfoodmoneystorage + "원");
        Restaurant();
    }

    void Calculator() {
        //계산기 메인메소드 계산을 완료하면 입력한 마지막값을 저장하며 부호와 값을 리턴시킨다
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Calculatormenuchoice = sc.nextInt();

        if (Calculatormenuchoice == 1 || Calculatormenuchoice == 2) {
            System.out.println("두 수를 입력해주세요");
            int Number = sc.nextInt();
            int Number2 = sc.nextInt();

            if (Calculatormenuchoice == 1) {
                Calcomplete(Number, Number2, "+");
            } else {
                if (Number < Number2) {
                    System.out.println("두 번째 값이 더 클 수 없습니다!");
                    Calculator();
                } else {
                    Calcomplete(Number, Number2, "-");
                }
            }
        } else if (Calculatormenuchoice == 3) {
            Calpositioncheck += 1;
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + CalculatorLastnumber + "");
            Selectmenu();
        } else {
            System.out.println("잘못된 입력입니다");
            Calculator();
        }
    }
    void Calcomplete(int Number, int Number2, String Sign) {
        //재입장을 하지않았을때 계속 이 메소드를 사용한다
        if (Sign.equals("+")) {
            CalculatorLastnumber = (Number + Number2);
            System.out.println("" + Number + " + " + Number2 + " = " + (Number + Number2) + "");
        } else if (Sign.equals("-")) {
            CalculatorLastnumber = (Number - Number2);
            System.out.println("" + Number + " - " + Number2 + " = " + (Number - Number2) + "");
        }
        Calculator();
    }
    void AgainCalculator() {
        //다시 계산기 메소드에 진입할경우 2개의 수를 받지않고 기존 마지막값에서 2번째값을 계산한다
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Againcalmenuchoice = sc.nextInt();

        if (Againcalmenuchoice == 1 || Againcalmenuchoice == 2) {
            System.out.println("두 번째 값을 입력해주세요");
            int Number2 = sc.nextInt();

            if (Againcalmenuchoice == 1) {
                Againcalcomplete(Number2, "+");
            } else {
                if (CalculatorLastnumber < Number2) {
                    System.out.println("두 번째 값이 더 큽니다");
                    AgainCalculator();
                } else {
                    Againcalcomplete(Number2, "-");
                }
            }
        } else if (Againcalmenuchoice == 3) {
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + CalculatorLastnumber + "");
            Selectmenu();
        } else {
            System.out.println("잘못된 입력입니다");
            AgainCalculator();
        }
    }
    void Againcalcomplete(int Number2, String Sign) {
        //재입장 계산후 리턴받는 메소드
        if (Sign.equals("+")) {
            CalculatorLastnumber += Number2;
            System.out.println("" + CalculatorLastnumber + " + " + Number2 + " = " + (CalculatorLastnumber + Number2) + "");
        } else if (Sign.equals("-")) {
            CalculatorLastnumber -= Number2;
            System.out.println("" + CalculatorLastnumber + " - " + Number2 + " = " + (CalculatorLastnumber - Number2) + "");
        }
        AgainCalculator();
    }
}

