import java.util.Scanner;

public class forwhile37 {
    int Buyfoodmoneystorage;
    //음식점에서 음식을 구매할때 Buyfoodmoneystorage에 저장하여 마지막에 시스템을 종료할때 누적된 금액을 출력하기 위한 변수값
    int CalculatorLastnumber;
    //계산기에서 마지막값을 기억하여 다시 계산기에 진입할때 againCalculator에 진입하여 1번째 값으로 사용되는 변수
    int reentryCheck;
    /*
    reentryCheck가 0인상태는 재진입을 하지 않은상태이므로 Calculator메소드로 리턴되지만
    1인상태에서는 재진입을 한 상태이므로 againCalculator에 진입하도록 인식시켜주는 변수
     */

    forwhile37() {

    }
    forwhile37(int Buyfoodmoneystorage, int CalculatorLastnumber, int reentryCheck) {
        this.Buyfoodmoneystorage = Buyfoodmoneystorage;
        this.CalculatorLastnumber = CalculatorLastnumber;
        this.reentryCheck = reentryCheck;
    }

    public void selectMenu(Scanner sc) {
        //메인 선택 메소드
        System.out.println("[1.구구단 2.음식점 3.계산기 4.종료]");
        int Mainmenuchoice = sc.nextInt();

        //switch문을 사용하였으므로 각 메뉴를 입력시 해당 메소드로 리턴시킵니다
        switch (Mainmenuchoice) {
            case 1 :
                gugudan(sc);
                //구구단메소드로 리턴시킴
                break;
            case 2 :
                restaurant(sc);
                //음식점으로 리턴시킴
                break;
            case 3 :
                if (reentryCheck == 1) {
                    //Calpositioncheck 값이 0인경우 계산기를 2번이상 진입하지 않았다는 뜻
                    //그러므로 1이라는 것은 재진입을하였기 때문에 2번째 값만 입력받는 계산기 메소드로 리턴시킨다
                    againCalculator(sc);
                } else {
                    //재진입을 하지 않고 처음에 계산기를 사용하는경우
                    calculatorMenu(sc);
                }
                break;
            case 4 :
                System.out.println("시스템을 종료합니다 \n총 누적금액 : " + Buyfoodmoneystorage + "원");
                //시스템을 종료하기전 음식을 구매한 총 누적금액을 출력후 종료된다
                System.exit(0);
                break;
            default :
                System.out.println("잘못된 입력입니다");
                //1 ~ 4이외의 번호를 입력시 잘못된 입력입니다 라고 출력 후 다시 메인메뉴에서 선택할 수 있도록 함
                selectMenu(sc);
                break;
        }
    }

    void gugudan (Scanner sc) {
        //1 ~ 9 단까지 출력 출력후 메인선택 메소드로 리턴
        for (int i = 0; i < 9; i++) {
            System.out.println("================" + (i + 1) + "단================");
            for (int j = 0; j < 9; j++) {
                System.out.println(""+(i + 1)+" X "+(j + 1)+" = "+((i + 1) * (j + 1))+"");
            }
        }
        selectMenu(sc);
    }
    void restaurant (Scanner sc) {
        //식당 메소드 음식을 주문하면 가격을 Ordercomplete메소드로 리턴시켜 중복을 제거
        System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
        int Chinesefoodchoice = sc.nextInt();

        //각각의 음식을 주문하면 orderComplete 메소드로 음식의 가격과 Scanner를 리턴시켜 계산을 완료합니다
        if (Chinesefoodchoice == 1) {
            orderComplete(8000,sc);
        }
        else if (Chinesefoodchoice == 2) {
            orderComplete(7000,sc);
        }
        else if (Chinesefoodchoice == 3) {
            //탕수육 메뉴를 선택할경우 대,중,소중에 한가지를 선택하도록 메뉴를 출력
                System.out.println("1.Size 대[25000원] 2.Size 중[20000원] 3.Size 소[17000원] 4.돌아가기");
                int Friedsizechoice = sc.nextInt();

                if (Friedsizechoice == 1) {
                    orderComplete(25000,sc);
                } else if (Friedsizechoice == 2) {
                    orderComplete(20000,sc);
                } else if (Friedsizechoice == 3) {
                    orderComplete(17000,sc);
                } else if (Friedsizechoice == 4) {
                    restaurant(sc);
                } else {
                    System.out.println("잘못된 입력입니다");
                }
        }
        else if (Chinesefoodchoice == 4) {
            System.out.println("메인메뉴로 돌아갑니다");
            selectMenu(sc);
        }
        else {
            System.out.println("잘못된 입력입니다");
        }
        restaurant(sc);
    }
    void orderComplete(int Buyfoodprice,Scanner sc) {
        /*
        구매값을 리턴받아 주문완료시킨다 만약에 음식점을 입장하고나서 음식을 주문하지않고 다시 나가는경우 음식을사지 않았으므로
        재입장해도 돈을 받지만 음식을주문하고 재입장시에는 반대로 주문을 하였지만 돈은 받지 않는다
         */
        if (Buyfoodmoneystorage >= 7000) {
            //리턴 값으로 받은 각 음식의 가격을 Buyfoodprice변수에 넣어놨으므로 if문이 성립할경우 전체 누적금액 변수에 저장한다
            Buyfoodmoneystorage += Buyfoodprice;
        }
        System.out.println("주문이 완료되었습니다 누적금액 : " + Buyfoodmoneystorage + "원");
        restaurant(sc);
    }

    void calculatorMenu(Scanner sc) {
        //계산기 메인메소드 계산을 완료하면 입력한 마지막값을 저장하며 calculationCompleted에 두 수와 선택한 번호를 리턴시켜 계산을 완료한다
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Calculatormenuchoice = sc.nextInt();

        if (Calculatormenuchoice < 1 || Calculatormenuchoice > 3) {
            System.out.println("잘못된 입력입니다");
        } else if (Calculatormenuchoice == 3) {
            reentryCheck = 1;
            /*
            reentryCheck 변수는 처음에 계산기메뉴를 선택했을때 calculatorMenu 메뉴로 가기 때문에 reentryCheck가 0인상태입니다
            calculatorMenu 메뉴에서 계산을 완료하고 메인메뉴로 리턴할때 reentryCheck에 1을부여하여 다음에 다시 계산기를 들어갈때
            calculatorMenu 가 아닌 againCalculator 로 가야하기 위해서 재입장여부를 판단하는 변수입니다
             */
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + CalculatorLastnumber + "");
            selectMenu(sc);
        } else {
            //처음에 입장하는 계산기이므로 2개의 수를 입력받는다 입력 받은 후 선택한 메뉴에 따라 계산되어 calculationCompleted로 리턴시킨다
            System.out.println("두 수를 입력해주세요");
            int calculatorNumber1 = sc.nextInt();
            int calculatorNumber2 = sc.nextInt();

            if (Calculatormenuchoice == 1) {
                calculationCompleted(calculatorNumber1,calculatorNumber2,Calculatormenuchoice,sc);
                //더하기를 하는경우 1번째 값과 2번째 값 어느쪽에 커도 상관없으므로 값을 입력하면 calculationCompleted로 리턴시킨다
            }
            if (Calculatormenuchoice == 2 && calculatorNumber1 >= calculatorNumber2) {
                calculationCompleted(calculatorNumber1,calculatorNumber2,Calculatormenuchoice,sc);
                //빼기를 선택했으며 1번째 값이 더 큰경우 조건에 성립하므로 정상적으로 리턴시킨다
            } else {
                System.out.println("두 번째 값이 더 클 수 없습니다!");
                //빼기를 선택했지만 두번째 값을 더 크게 적은 경우에는 다시 calculatorMenu로 리턴된다
            }
        }
        calculatorMenu(sc);
    }
    void calculationCompleted(int calculatorNumber1, int calculatorNumber2, int Menuchoicenumber,Scanner sc) {
        /*
        calculatorMenu 메뉴에서 더하기,빼기 메뉴를 선택 후 값을 입력했을때 조건에 만족시 calculationCompleted 메소드로
        1번째 값,2번째값,선택한 메뉴가 리턴되며 그 값을 받아 더하기,빼기 연산을 완료시킨 후 다시 계산기 메뉴로 리턴시킵니다
         */
        if (Menuchoicenumber == 1) {
            //더하기를 선택한경우 리턴받은 1번째 값과 2번째 값을 연산하여 출력 후 다시 계산기 메뉴로 돌아갑니다
            CalculatorLastnumber = (calculatorNumber1 + calculatorNumber2);
            System.out.println("" + calculatorNumber1 + " + " + calculatorNumber2 + " = " + (calculatorNumber1 + calculatorNumber2) + "");
        } else {
            //빼기를 선택한경우 리턴받은 1번째 값과 2번째 값을 연산하여 출력 후 다시 계산기 메뉴로 돌아갑니다
            CalculatorLastnumber = (calculatorNumber1 - calculatorNumber2);
            System.out.println("" + calculatorNumber1 + " - " + calculatorNumber2 + " = " + (calculatorNumber1 - calculatorNumber2) + "");
        }
        calculatorMenu(sc);
    }
    void againCalculator(Scanner sc) {
        //calculatorMenu 메뉴에서 계산 후 메인메뉴로 돌아갈때  reentryCheck = 1이 되므로 메인메뉴에서 다시 입장시 againCalculator 메소드를 사용함
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Againcalmenuchoice = sc.nextInt();

        if (Againcalmenuchoice < 1 || Againcalmenuchoice > 3) {
            System.out.println("잘못된 입력입니다");
        } else if (Againcalmenuchoice == 3) {
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + CalculatorLastnumber + "");
            selectMenu(sc);
        } else {
            System.out.println("두 번째 수를 입력해주세요");
            int calculatorNumber2 = sc.nextInt();

            if (Againcalmenuchoice == 1) {
                againCalculatorcomplete(calculatorNumber2,Againcalmenuchoice,sc);
                //더하기를 하는경우 음수를 입력해도 상관없이 계산을 완료할 수 있기 때문에 정상적으로 리턴시킴
            }
            if (Againcalmenuchoice == 2 && CalculatorLastnumber >= calculatorNumber2) {
                againCalculatorcomplete(calculatorNumber2,Againcalmenuchoice,sc);
                //빼기를 선택했으며 CalculatorLastnumber 값이 더 큰경우 조건에 만족하므로 againCalculatorcomplete로 리턴시킨다
            } else {
                System.out.println("두 번째 값이 더 클 수 없습니다!");
                //빼기를 선택했지만 두번째 값을 더 크게 적은 경우에는 다시 againCalculator로 리턴된다
            }
        }
        againCalculator(sc);
        //잘못된 입력입니다는 if문을 빠져나올때 againCalculator(sc);을 통해 다시 입력하도록 리턴시킴
    }
    void againCalculatorcomplete(int calculatorNumber2, int Againcalmenuchoice,Scanner sc) {
        /*
       againCalculator 메뉴에서는 2번째 값만 입력받습니다 그렇기 때문에 2번째 값을 입력받은대로 리턴되어 받으면
       Againcalmenuchoice 번호에 따라 더하기 인지 빼기인지 판단 후 calculatorMenu와 다르게 출력이 먼저 실행되고
       2번째 값을 CalculatorLastnumber에 저장후 다시 againCalculator로 리턴됩니다
        */
        if (Againcalmenuchoice == 1) {
            System.out.println("" + CalculatorLastnumber + " + " + calculatorNumber2 + " = " + (CalculatorLastnumber + calculatorNumber2) + "");
            CalculatorLastnumber += calculatorNumber2;
        } else  {
            System.out.println("" + CalculatorLastnumber + " - " + calculatorNumber2 + " = " + (CalculatorLastnumber - calculatorNumber2) + "");
            CalculatorLastnumber -= calculatorNumber2;
        }
        againCalculator(sc);
    }
}

