import java.util.Scanner;
public class forwhile19 {
    public static void main(String[] args) {
        //main값에 변수를 보관한다
        int[] Buyfoodmoneystorage = new int[3];
        //index0 = 전체 누적금액
        //index1 = 재입장여부 확인
        //index2 = 물건을 구매했을때 잠깐 저장하는 기억index
        int CalculatorLastnumber = 0; //계산기 마지막값 기억
        Selectmenu(Buyfoodmoneystorage,CalculatorLastnumber);
    }
    public static void Selectmenu (int[] Buyfoodmoneystorage,int CalculatorLastnumber) {
        Scanner sc = new Scanner(System.in);
        //메인 선택 메소드
        while (true) {
            System.out.println("[1.구구단 2.음식점 3.계산기 4.종료]");
            int Menuchoice = sc.nextInt();

            if (Menuchoice == 1) {
                //간단한 코드라서 따로 메소드를 만들어 리턴보내는것보다 여기에 넣는것이 좋다고 생각했습니다
                for (int i = 0; i < 9; i++) {
                    System.out.println("================" + (i + 1) + "단================");
                    for (int j = 0; j < 9; j++) {
                        System.out.println("" + (i + 1) + " X " + (j + 1) + " = " + ((i + 1) * (j + 1)) + "");
                    }
                }
            } else if (Menuchoice == 2) {
                Restaurant(Buyfoodmoneystorage,CalculatorLastnumber);
            } else if (Menuchoice == 3) {
                if (CalculatorLastnumber >= 1) {
                    //계산기를 다시 진입했을때 2개의 값을 받는것이 아닌 2번째 값만 받기위해 별도의 메소드 작성
                    AgainCalculator(Buyfoodmoneystorage,CalculatorLastnumber);
                } else {
                    //처음 계산기에 진입시
                    Calculator(Buyfoodmoneystorage,CalculatorLastnumber);
                }
            } else if (Menuchoice == 4) {
                System.out.println("시스템을 종료합니다 \n총 누적금액 : "+Buyfoodmoneystorage[0]+"원");
                System.exit(0);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
    }
    public static void Restaurant (int[] Buyfoodmoneystorage,int CalculatorLastnumber) {
        //식당 메소드 음식을 주문하면 가격을 Ordercomplete메소드로 리턴시켜 중복을 제거
        Scanner sc = new Scanner(System.in);
        System.out.println("1.볶음밥[8000원] 2.짜장면[7000원] 3.탕수육 4.돌아가기");
        int Chinesefoodchoice = sc.nextInt();

        //index2에 저장하는 이유는 재입장여부에 따라서 계산을 하는지 안하는지 미리 판단하기 위해 미리 저장해놓는다
        if (Chinesefoodchoice == 1) {
            Buyfoodmoneystorage[2] += 8000;
        } else if (Chinesefoodchoice == 2) {
            Buyfoodmoneystorage[2] += 7000;
        } else if (Chinesefoodchoice == 3) {
            System.out.println("1.Size 대[25000원] 2.Size 중[20000원] 3.Size 소[17000원] 4.돌아가기");
            int Friedsizeselect = sc.nextInt();

            if (Friedsizeselect == 1) {
                Buyfoodmoneystorage[2] += 25000;
            } else if (Friedsizeselect == 2) {
                Buyfoodmoneystorage[2] += 20000;
            } else if (Friedsizeselect == 3) {
                Buyfoodmoneystorage[2] += 17000;
            } else if (Friedsizeselect == 4) {
                Restaurant(Buyfoodmoneystorage, CalculatorLastnumber);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        } else if (Chinesefoodchoice == 4) {
            System.out.println("메인메뉴로 돌아갑니다");
            Buyfoodmoneystorage[1] = 1; //index0은 총주문 값 index1은 재입장여부확인
            Selectmenu(Buyfoodmoneystorage, CalculatorLastnumber);
        } else {
            System.out.println("잘못된 입력입니다");
        }
        //여기서부터 음식을 구매하는경우
        if (Buyfoodmoneystorage[1] == 0) {
            //재입장하지 않은경우
            Buyfoodmoneystorage[0] += Buyfoodmoneystorage[2]; //저장해놨던 값을 넣어준다
        }
        Buyfoodmoneystorage[2] = 0; //초기화
        System.out.println("주문이 완료되었습니다 누적금액 : " + Buyfoodmoneystorage[0] + "원");
        Restaurant(Buyfoodmoneystorage, CalculatorLastnumber);
    }
    static void Calculator (int[] Buyfoodmoneystorage,int CalculatorLastnumber) {
        //계산기 메인메소드 계산을 완료하면 입력한 마지막값을 저장하며 부호와 값을 리턴시킨다
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Calculatormenuchoice = sc.nextInt();

        if (Calculatormenuchoice == 1 || Calculatormenuchoice == 2) {
            System.out.println("두 수를 각각 입력해주세요");
            int Number = sc.nextInt();
            int Number2 = sc.nextInt();

            if (Calculatormenuchoice == 1) {
                CalculatorLastnumber = (Number + Number2);
                System.out.println("" + Number + " + " + Number2 + " = " + CalculatorLastnumber + "");
            } else {
                if (Number < Number2) {
                    System.out.println("두 번째 값이 더 클 수 없습니다!");
                } else {
                    CalculatorLastnumber = (Number - Number2);
                    System.out.println("" + Number + " - " + Number2 + " = " + CalculatorLastnumber + "");
                }
            }
            Calculator(Buyfoodmoneystorage,CalculatorLastnumber);
        } else if (Calculatormenuchoice == 3) {
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + CalculatorLastnumber + "");
            Selectmenu(Buyfoodmoneystorage,CalculatorLastnumber);
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
    public static void AgainCalculator (int[] Buyfoodmoneystorage,int CalculatorLastnumber) {
        //다시 계산기 메소드에 진입할경우 2개의 수를 받지않고 기존 마지막값에서 2번째값을 계산한다
        Scanner sc = new Scanner(System.in);
        System.out.println("<<<1.더하기  2.빼기  3.돌아가기>>>");
        int Againmenuchoice = sc.nextInt();

        if (Againmenuchoice == 1 || Againmenuchoice == 2) {
            System.out.println("두 번째 값을 입력해주세요");
            int Number2 = sc.nextInt();

            if (Againmenuchoice == 1) {
                System.out.println("" + CalculatorLastnumber + " + " + Number2 + " = " + (CalculatorLastnumber + Number2) + "");
                CalculatorLastnumber += Number2;
            } else {
                if (CalculatorLastnumber < Number2) {
                    System.out.println("두 번째 값이 더 큽니다");
                } else {
                    System.out.println("" + CalculatorLastnumber + " - " + Number2 + " = " + (CalculatorLastnumber - Number2) + "");
                    CalculatorLastnumber -= Number2;
                }
            }
            AgainCalculator(Buyfoodmoneystorage,CalculatorLastnumber);
        } else if (Againmenuchoice == 3) {
            System.out.println("메인메뉴로 돌아갑니다 \n안내 : 마지막으로 계산한 값 : " + CalculatorLastnumber + "");
            Selectmenu(Buyfoodmoneystorage, CalculatorLastnumber);
        } else {
            System.out.println("잘못된 입력입니다");
        }
    }
}
