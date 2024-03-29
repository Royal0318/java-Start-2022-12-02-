import java.util.Scanner;
public class forwhile19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int restaurantReentryCheck = 0;
        //식당의 재입장여부를 확인하는 변수 0은 입장하지 않은상태 1은 입장한 상태를 나타낸다
        int[] buyFoodMoneyStorage = new int[2];
        //index0 = 전체 누적금액
        //index1 = 물건을 구매했을때 잠깐 저장하는 기억index
        int calculatorLastNumber = 0;
        //계산기 마지막값 기억하여 게산기 재입장시 1번째 값을 담당한다
        selectMenu(buyFoodMoneyStorage,calculatorLastNumber,restaurantReentryCheck,sc);
    }
    public static void selectMenu (int[] buyFoodMoneyStorage,int calculatorLastNumber,int restaurantReentryCheck,Scanner sc) {
        //메인메뉴 메소드,swich문으로 각 번호를 입력하면 해당 메소드로 리턴시킴
        while (true) {
            System.out.println("[1.구구단 2.음식점 3.계산기 4.종료]");
            int menuChoice = sc.nextInt();

            //swich문을 이용하여 원하는 번호를 입력시 해당 메소드로 리턴시키는 역할
            switch (menuChoice) {
                case 1 :
                    gugudan(buyFoodMoneyStorage,calculatorLastNumber,restaurantReentryCheck,sc);
                    //구구단 1 ~ 9단, gugudan(전체누적금액,계산기 마지막값,레스토랑 재입장여부확인,Scanner sc)
                    break;
                case 2 :
                    restaurant(buyFoodMoneyStorage,calculatorLastNumber,sc);
                    //음식점, restaurant(전체누적금액,계산기 마지막값,레스토랑 재입장여부확인,Scanner sc)
                    break;
                case 3 :
                    if (calculatorLastNumber >= 1) {
                      /*
                      계산기 값이 음수가 나오지 않으므로 마지막으로 계산한 값은 최소 1이상일것이므로 재진입했다고 판단
                      기존계산기로 리턴하는것이아닌
                      다시 계산을 진행할때 Againcalculator라는 2번째 값만 받는 메소드로 리턴시킵니다
                       */
                        againCalculatorMenu(buyFoodMoneyStorage,calculatorLastNumber,restaurantReentryCheck,sc);
                        //재입장시 계산기메뉴, againCalculatorMenu(전체누적금액,계산기 마지막값,레스토랑 재입장여부확인,Scanner sc)
                        break;
                    } else {
                        calculatorMenu(buyFoodMoneyStorage,calculatorLastNumber,restaurantReentryCheck,sc);
                        //처음 입장시 계산기메뉴, calculatorMenu(전체누적금액,계산기 마지막값,레스토랑 재입장여부확인,Scanner sc)
                    }
                    break;
                case 4 :
                    System.out.println("시스템을 종료합니다 \n총 누적금액 : "+buyFoodMoneyStorage[0]+"원");
                    //시스템 종료시 전체 음식을 구매한 누적금액을 출력하며 시스템을 종료시킵니다
                    System.exit(0);
                default :
                    System.out.println("잘못된 입력입니다");
                    //그 이외의 번호를 입력했을 때 잘못된 입력입니다라는 문구가 출력되며 다시 메인메소드에서 선택할 수 있도록합니다
                    break;
            }
        }
    }
    public static void gugudan (int[] buyFoodMoneyStorage,int calculatorLastNumber,int restaurantReentryCheck,Scanner sc) {
        //구구단 메소드 1단부터9단까지 실행 후 다시 메인메뉴로 리턴한다
        for (int i = 1; i <= 9; i++) {
            System.out.println("================" + i + "단================");
            for (int j = 1; j <= 9; j++) {
                System.out.println("" + i + " X " + j + " = " + (i * j) + "");
            }
        }
        selectMenu(buyFoodMoneyStorage,calculatorLastNumber,restaurantReentryCheck,sc);
    }
    public static void restaurant (int[] buyFoodMoneyStorage,int restaurantReentryCheck,Scanner sc) {
        //식당 메소드 음식을 주문하면 가격을 Ordercomplete메소드로 리턴시켜 중복을 제거
        System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
        int chineseFoodMenuChoice = sc.nextInt();
        /*
        Chinesefoodchoice로 원하는 메뉴를 입력하면  Buyfoodmoneystorage[1] 즉 메뉴가격을 저장하는 배열값 index1에 가격을 저장하여
        orderComplete로 리턴되어 주문을 완료시킵니다 이때 재입장여부를 판단하여 재입장을 하지 않았다면  Buyfoodmoneystorage[1]에 저장된 값을  Buyfoodmoneystorage[0] 즉
        전체 누적금액 index에 저장하고  Buyfoodmoneystorage[1]는 0을 부여하여 초기화시킵니다
         */
        if (chineseFoodMenuChoice == 1) {
            buyFoodMoneyStorage[1] += 8000;
        } else if (chineseFoodMenuChoice == 2) {
            buyFoodMoneyStorage[1] += 7000;
        } else if (chineseFoodMenuChoice == 3) {
            //탕수육을 선택했을때 나타나는 메뉴
            System.out.println("1.Size 대[25000원] 2.Size 중[20000원] 3.Size 소[17000원] 4.돌아가기");
            int friedSizeSelect = sc.nextInt();

            switch (friedSizeSelect) {
                case 1 :
                    buyFoodMoneyStorage[1] += 25000;
                    break;
                case 2 :
                    buyFoodMoneyStorage[1] += 20000;
                    break;
                case 3 :
                    buyFoodMoneyStorage[1] += 17000;
                    break;
                case 4 :
                    System.out.println("레스토랑 메뉴로 돌아갑니다");
                    restaurant(buyFoodMoneyStorage,restaurantReentryCheck,sc);
                    break;
                default :
                    System.out.println("잘못된 입력입니다");
                    restaurant(buyFoodMoneyStorage,restaurantReentryCheck,sc);
                    break;
            }
            orderComplete(buyFoodMoneyStorage,restaurantReentryCheck,sc);
        } else if (chineseFoodMenuChoice == 4) {
            //메인메뉴로 돌아갈때 Admissionstatus을 1을 부여하여 다시 입장할때는 재진입아라는 것을 알리고 돈을 받지 않기위함
            System.out.println("메인메뉴로 돌아갑니다");
            restaurantReentryCheck = 1;
            selectMenu(buyFoodMoneyStorage,restaurantReentryCheck,sc)
            ;
        } else  {
            System.out.println("잘못된 입력입니다");
            restaurant(buyFoodMoneyStorage,restaurantReentryCheck,sc);
        }
        orderComplete(buyFoodMoneyStorage,restaurantReentryCheck,sc);
    }
    static void orderComplete(int[] buyFoodMoneyStorage, int calculatorLastNumber, int restaurantReentryCheck, Scanner sc) {
        //여기서부터 음식을 구매했을때 계산을 거쳐서 주문을 완료하고 다시 메인메뉴로 리턴시킵니다
        if (restaurantReentryCheck == 0) {
            //재입장하지 않고 음식을 구매한경우 Buyfoodmoneystorage[1]에 저장되어있던 음식의 가격을 Buyfoodmoneystorage[0] (전체 누적금액 index)에 저장합니다
            buyFoodMoneyStorage[0] += buyFoodMoneyStorage[1];
            System.out.println("주문이 완료되었습니다 누적금액 : " + buyFoodMoneyStorage[0] + "원");
        } else {
            //재입장을 하고 음식을 구매한경우 돈을 받지 않는다는 조건이 있으므로 restaurant메소드에서 저장했던   Buyfoodmoneystorage[1] += 음식가격;을 무시하고
            //else문을 탈출할때   Buyfoodmoneystorage[1] = 0;을 거쳐 그 값이 초기화되고 다시 음식을 선택하는 레스토랑으로 리턴됨
            System.out.println("주문이 완료되었습니다 (식당을 재입장하였으므로 돈을 받지 않습니다)");
        }
        buyFoodMoneyStorage[1] = 0;
        //다시 음식을 구매할 때 가격이 누적되지 않아야하므로 미리 저장index를 초기화시킨다
        restaurant(buyFoodMoneyStorage, calculatorLastNumber,sc);
    }
    static void calculatorMenu (int[] buyFoodMoneyStorage,int calculatorLastNumber,int restaurantReentryCheck,Scanner sc) {
        //계산기 메인메소드 계산을 완료하면 입력한 마지막값을 저장하며 부호와 값을 리턴시킨다
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int calculatorMenuChoice = sc.nextInt();

        if (calculatorMenuChoice == 1 || calculatorMenuChoice == 2) {
            System.out.println("두 수를 각각 입력해주세요");
            int calculatorNumber1 = sc.nextInt();
            int calculatorNumber2 = sc.nextInt();
            //두 수를 각각입력하여 Calculatormenuchoice의 선택이 어떤것인지에 따라 if문에 진입하는 곳이 달라진다

            if (calculatorMenuChoice == 1) {
                //더하기 메뉴를 선택한 경우 두 수를 더해 마지막값을 저장하는 CalculatorLastnumber변수에 넣고 두개의 값을 출력
                calculatorLastNumber = (calculatorNumber1 + calculatorNumber2);
                System.out.println("" + calculatorNumber1 + " + " + calculatorNumber2 + " = " + calculatorLastNumber + "");
            }
            if (calculatorMenuChoice == 2) {
                if (calculatorNumber1 < calculatorNumber2) {
                    //빼기는 두 번째 값이 더 클 수 없다는 조건이 있으므로 다시 리턴시켜 계산하도록합니다
                    System.out.println("두 번째 값이 더 클 수 없습니다!");
                } else {
                    //빼기 메뉴를 선택한 경우 두 수를 더해 마지막값을 저장하는 CalculatorLastnumber변수에 넣고 두개의 값을 출력
                    calculatorLastNumber = (calculatorNumber1 - calculatorNumber2);
                    System.out.println("" + calculatorNumber1 + " - " + calculatorNumber2 + " = " + calculatorLastNumber + "");
                }
            }
        } else if (calculatorMenuChoice == 3) {
            //3번을 선택했을때 계산을하지않고 마지막으로 계산한 값을 출력 후 메인메뉴로 리턴합니다
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + calculatorLastNumber + "");
            selectMenu(buyFoodMoneyStorage,calculatorLastNumber,restaurantReentryCheck,sc);
        } else {
            System.out.println("잘못된 입력입니다");
        }
        calculatorMenu(buyFoodMoneyStorage,calculatorLastNumber,restaurantReentryCheck,sc);
        //계산이 끝난경우나 잘못된 입력을 하였을 시 다시 계산기메뉴로 재리턴시켜 추가적으로 계산을 하는지 여부를 확인
    }
    public static void againCalculatorMenu (int[] buyFoodMoneyStorage,int CalculatorLastnumber,int restaurantReentryCheck,Scanner sc) {
        //다시 계산기 메소드에 진입할경우 이 메소드를 이용한다 2개의 수를 받지않고 2번째의 수만 받고 계산을 완료합니다
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int againCalculatorMenuChoice = sc.nextInt();

        if (againCalculatorMenuChoice == 1 || againCalculatorMenuChoice == 2) {
            System.out.println("두 번째 값을 입력해주세요");
            int calculatorNumber2 = sc.nextInt();

            if (againCalculatorMenuChoice == 1) {
                //더하기 메뉴를 선택한경우 2번째 메뉴값만 받는다 1번째 값은CalculatorLastnumber의 변수이다 이 변수는 calculator에서 마지막으로 계산한 값을 기억한 변수이다
                System.out.println("" + CalculatorLastnumber + " + " + calculatorNumber2 + " = " + (CalculatorLastnumber + calculatorNumber2) + "");
                CalculatorLastnumber += calculatorNumber2;
                //다시 마지막값을 기억하기 위해 입력한 2번째 값을 저장합니다
            }
            if (againCalculatorMenuChoice == 2) {
                if (calculatorNumber2 >= 0) {
                    if (CalculatorLastnumber < calculatorNumber2) {
                        System.out.println("두 번째 값이 더 큽니다");
                    } else {
                        //빼기 메뉴를 선택한경우 2번째 메뉴값만 받는다 1번째 값은CalculatorLastnumber의 변수이다 이 변수는 calculator에서 마지막으로 계산한 값을 기억한 변수이다
                        System.out.println("" + CalculatorLastnumber + " - " + calculatorNumber2 + " = " + (CalculatorLastnumber - calculatorNumber2) + "");
                        CalculatorLastnumber -= calculatorNumber2;
                        //다시 마지막값을 기억하기 위해 입력한 2번째 값을 저장합니다
                    }
                } else {
                    System.out.println("잘못된 입력입니다");
                }
            }
            //다시 계산기 메뉴로 재리턴시켜 추가적으로 계산을 하는지 여부를 확인
            againCalculatorMenu(buyFoodMoneyStorage,CalculatorLastnumber,restaurantReentryCheck,sc);
        } else if (againCalculatorMenuChoice == 3) {
            //3번을 선택했을때 계산을하지않고 마지막으로 계산한 값을 출력 후 메인메뉴로 리턴합니다
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + CalculatorLastnumber + "");
            selectMenu(buyFoodMoneyStorage, CalculatorLastnumber,restaurantReentryCheck,sc);
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
}
