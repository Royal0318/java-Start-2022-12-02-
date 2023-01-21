/*
음식 종류 다섯가지, 다음 손님, 종료버튼,돈갚기,제어까지 해서 총 9개 메뉴를 만들어주세요.
 15명의 사람이 있다. 메뉴를 주고 그들이 무엇을 사면 총 얼마가 남았는지에 관한 코딩을 작성해보아라.
   [예 : a[8]에 존자해는 사람이 25000원을 가지고 있을 때 1번 타코야키 2000원을 사먹으면 23000원이 되게 해보아라.]

   [문제출제 : 개발자가 정한 5개의 음식 메뉴와 환불, 돈 갚기, 다음손님 버튼, 몇 번째 손님을 제어할 건지에 대한 메뉴, 종료버튼까지 총 9개의 메뉴가 존재한다.]
   [문제출제 1: 단, 금액이 부족하다면 금액이 부족합니다. 라는 문구가 표시되며 다시 고를 수 있게 하며,
   금액이 있는 음식 종류들 중 아무것도 살 수 없는 상태라면 [소지금이 부족합니다]라는 문구와 함께
   다시 선택할 지 물어보시고, 만약 다시 선택한다면 다시 선택할 수 있게, 만약 아니라면 다음으로 넘어가는 상황을 코딩하시오.
   [문제출제 2 : 각각손님이 몇 번째인지 출력되도록 하시오.]
   [문제출제 3 : 절대로 음수값이 나와서는 안 됨.]
   [문제출제 4 : 만약 돈이 부족하다면 그 다음 순번 사람에게 돈을 꾸는 상황을 코딩하시오.]
   [문제출제 5 : 만약 결제가 완료됐다면 각각 무엇을 주문했는지, 돈이 얼만큼 남았는지 출력하시오.]
   [문제출제 6 : 그리고 마지막 나온 출력값 [가지고 있는 돈]들의 합을 구하시오.]
   [문제출제 7 : 단, 0~4번 사람까지는 20000원을, 5~9번까지의 손님들은 10000원을 가지고 있게끔 코딩하시오.]
   [문제출제 8 : 단, 10~14번 번 손님의 가지고 있는 돈은 scanf로 받을 수 있게 하시오]
   [문제출제 9 : 몇 번째 손님을 제어할지에 대한 메뉴는 내가 예를 들어 지금 현재 5번째 손님일 때,
   해당 버튼을 누르면 5번째 손님은 잠시 내버려두고, 해당 원하는 번째 손님을 제어할 수 있습니다.
   단, 해당 제어하기 버튼으로 들어간 손님의 메뉴에서만 [ 이전 손님으로 돌아가기 ] 버튼이 생기게 되며, [ 다음 손님으로 ] 를 누를 경우 '이전 손님으로 돌아가기밖에 할 수 없습니다.'가 출력된다.]

   [문제출제 9 : 단, 문제출제 7,8번의 경우에는 if문 한 번, 반복문 한 번으로 제한합니다. if or for[while]] - else는 사용하지 않음.
   if한 번 쓰시고, for 한 번 쓰셔도 되고,[문제출제9에만 해당 함]
   if한 번만 쓰셔도 되시고,[문제출제9에만 해당 함]
   for문 한 번만 쓰셔도 됩니다.[문제출제9에만 해당 함]

   [문제출제 10 : 만약 주문이 완료되었다면 아래를 실행하시오.]
예시)
   ===주문표===
타코야키 x 10 = 20000원

===1번째 손님===
원래 가지고 있던 금액 :10000000원
타코야키 x 10 = 20000원
현재 가지고 있는 금액 : 980000원
빚 진 금액 : ?원
빚을 청산하고 남은 금액 : ?원
미납 된 금액 : ?원
빌려준 금액 : ?원
단!
위처럼, 아예 구매하지 않은 음식이나 사람은 나타나지 않습니다.
또한, 1번째 손님이 주문을 하지 않고, 3번의 손님이 주문하였다해도
해당 손님은 1번이 되게 해주세요.
돈이 부족한 경우, 돈을 빌릴 수 있는 시스템.
한 사람 한 사람 빌리는 시스템이기 때문에,

2번 사람이 돈을 꿀 때는 3번사람에게 꾸게 될 것.

그리고 선택지 1.더 빌린다 2.빌리지 않는다.
인데, 이거는 돈을 빌렸는데도 돈이 더 부족할 떄는 자동으로 4번에게 꾸게 되고,[3번이 아님]
만약 돈을 꾸게 되었을 때 돈이 부족하지 않다면,
무엇을 사먹을 수 있습니다.
무엇을 무엇을 사먹을 수 있습니다.
처럼 나타내세요.

또한, 돈이 충분해져도 더 빌릴 수가 있고, 빌리지 않을 수도 있습니다.
더 빌린다고 할 경우 현재 빌린 사람의 다음 순번 사람에게 돈을 꾸게 됩니다.
이번 문제는 함수형을 사용하지 않고 푼다
*

 */
import java.util.Scanner;
public class Januarytwentyoneth {
    public static void main(String[] args) {
        //마지막사람까지 모두 선택시 모든 사람의 남은 돈의합을 더해 출력
        System.out.println("모든 사람의 남은 돈의 합은 "+VariableSave()+"원 입니다");
    }
    public static int VariableSave() {
        int TotalMoney = 150000; //전체 사람이 가지고있는 돈의 합
        int I = 0; //i값이 독자적으로 돌수없기때문에 i값을 보조하는 변수를 추가
        int ControlEntryCheck = 0; //제어에 진입했을때 10번항목에 출력되도록 도와주는 변수
        int SavePreviousIndex = 0; //손님을 제어하기전에 현재인덱스를 미리 저장하는 변수
        int[][] arr = new int[15][15];
        int[] SnackNumberOutput = new int[15]; //종료버튼을 누르면 몇번째손님이 어떤음식을 몇개삿는지 기록하는 변수
        int[] BreadNumberOutput = new int[15];
        int[] FruitNumberOutput = new int[15];
        int[] DrinkNumberOutput = new int[15];
        int[] FishNumberOutput = new int[15];
        int[] lendMoneySum = new int[15]; //빌려준 금액을 모두 합친 배열값
        int[] TotalDebtMoneySum = new int[15]; //빚진금액을 모두 합친 배열값
        int[] DebtMoneySum = new int[15]; //빚진 금액과 갚은금액을 환산하여 나타내는 배열값
        arr[0][0] = 20000;//문제에 지정된 10명까지는 돈을 scanf받지않고 출제자의 의도에 맞춰 돈을 미리 입력
        arr[1][0] = 20000;
        arr[2][0] = 20000;
        arr[3][0] = 20000;
        arr[4][0] = 20000;
        arr[5][0] = 10000;
        arr[6][0] = 10000;
        arr[7][0] = 10000;
        arr[8][0] = 10000;
        arr[9][0] = 10000;
        return PeopleMoneyInput(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck,SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }

    public static int PeopleMoneyInput(int[] TotalDebtMoneySum,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum) {
        Scanner sc = new Scanner(System.in);
        for (int i = 10; i < 15; i++) { //10번째부터 15번째 손님까지 돈을 입력받는다
            System.out.println("" + i + "번째 손님의 돈을 입력 해주세요");
            arr[i][0] = sc.nextInt();
            TotalMoney += arr[i][0];
            if (arr[i][0] < 0) {
                System.out.println("안내 : 잘못된 입력입니다");
                i--;
            }
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck,SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }

    public static int Menu(int[] TotalDebtMoneySum,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput, int[] BreadNumberOutput, int[] FruitNumberOutput, int[] DrinkNumberOutput, int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum) {
        Scanner sc = new Scanner(System.in);
        if (I == 15) { //15명이 모두 물건을 구매하거나 넘겼을때 시스템을 종료시키는 조건
            return TotalMoney;
        }
        for (int i = I; i < 15; i++) {
            int FixedNumberCount = 0; //한 손님이 계속 돈을 빌리는경우 다음손님으로 넘어가지 않도록 다음손님에게 계속빌릴경우 고정시킬수있는 변수
            int OutputOrder = 0; //물건을 산 손님만 출력되고 손님순서가 순서되도록 출력되도록 도와주는 변수
            int ReturnMoney = 0; //물건을 사고나면 미리 결제가 되기 때문에 음식선택을 다시할때 돈을 반환할때 사용하는 변수
            System.out.println("\n1.과자 1500원  \n2.빵 1000원  \n3.과일 2500원  \n4.음료수 1000원   \n5.생선 4000원  \n6.다음 손님  \n7.종료버튼 \n8.제어 \n9.돈갚기");
            if (ControlEntryCheck == 1) {//제어로 진입시 출력
                System.out.println("10.이전 손님으로 돌아가기\n");
            }

            System.out.println("\n"+(i + 1)+"번째 손님의 선택 \n안내 : 현재 소지 금액 : "+arr[i][0]+"원");
            int Select = sc.nextInt();

            if (Select < 1 || Select > 9 && ControlEntryCheck == 0) {
                System.out.println("안내 : 잘못된 입력입니다");
                i--;
            }
            if (Select < 1 || Select > 10 && ControlEntryCheck == 1) {
                System.out.println("안내 : 잘못된 입력입니다");
                i--;
            } else if (Select == 10) { //제어로 진입시에 다시 이전인덱스로 돌아가도록함
                i = SavePreviousIndex - 1;
                I = SavePreviousIndex;
                ControlEntryCheck = 0; //컨트롤값 초기화
            }
            if (Select == 1) { //메뉴선택시 해당메소드로 리턴보낸다
                return Snackfunction(TotalDebtMoneySum,FixedNumberCount,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else if (Select == 2) {
                return Breadfunction(TotalDebtMoneySum,FixedNumberCount,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else if (Select == 3) {
                return Fruitfunction(TotalDebtMoneySum,FixedNumberCount,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else if (Select == 4) {
                return Drinkfunction(TotalDebtMoneySum,FixedNumberCount,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else if (Select == 5) {
                return Fishfunction(TotalDebtMoneySum,FixedNumberCount,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else if (Select == 6) {
                return TheNextPeople(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum);
            } else if (Select == 7) {
                return ReceiptOutput(TotalDebtMoneySum,OutputOrder, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i);
            } else if (Select == 8) {
                return PeopleControl(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i);
            } else if (Select == 9) {
                return PaybackMoney(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr, SnackNumberOutput, BreadNumberOutput, FruitNumberOutput, DrinkNumberOutput, FishNumberOutput, DebtMoneySum, lendMoneySum, i);
            }
        }
        return 0;
    }

    public static int Snackfunction(int[] TotalDebtMoneySum,int FixedNumberCount,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i,int ReturnMoney) {
        Scanner sc = new Scanner(System.in);
        if (ControlEntryCheck == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (1500 * Number)) { //돈이부족한경우
                TotalMoney -= (1500 * Number); //15명의 총 가지고 있는 돈에서 구매한 총 가격만큼 차감
                ReturnMoney += (1500 * Number); //돈이 부족한데 물건을 다시 구매한다고 했을때 구매했던 가격만큼 다시 반환 받기 때문에 저장하는 변수
                arr[i][0] -= (1500 * Number); //?번째 손님이 가지고 있는 돈에서 구매한 총 가격만큼 차감
                SnackNumberOutput[i] += Number;
                return NeedMoneySelect(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else {
                System.out.println("주문이 완료되었습니다"); //주문을 완료한경우
                arr[i][0] -= (1500 * Number);
                TotalMoney -= (1500 * Number);
                SnackNumberOutput[i] += Number;
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다 \n안내 : 제어로 진입시 돈갚기,돌아가기만 가능합니다");
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }

    public static int Breadfunction(int[] TotalDebtMoneySum,int FixedNumberCount,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i,int ReturnMoney) {
        Scanner sc = new Scanner(System.in);
        if (ControlEntryCheck == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (1000 * Number)) {
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
                ReturnMoney += (1000 * Number);
                BreadNumberOutput[i] += Number;
                return NeedMoneySelect(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else {
                System.out.println("주문이 완료되었습니다");
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
                BreadNumberOutput[i] += Number;
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다 \n안내 : 제어로 진입시 돈갚기,돌아가기만 가능합니다");
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);

    }
    public static int Fruitfunction(int[] TotalDebtMoneySum,int FixedNumberCount,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i,int ReturnMoney) {
        Scanner sc = new Scanner(System.in);
        if (ControlEntryCheck == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (2500 * Number)) {
                arr[i][0] -= (2500 * Number);
                TotalMoney -= (2500 * Number);
                ReturnMoney += (2500 * Number);
                FruitNumberOutput[i] += Number;
                return NeedMoneySelect(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else {
                System.out.println("주문이 완료되었습니다");
                arr[i][0] -= (2500 * Number);
                TotalMoney -= (2500 * Number);
                FruitNumberOutput[i] += Number;
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다 \n안내 : 제어로 진입시 돈갚기,돌아가기만 가능합니다");
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);

    }

    public static int Drinkfunction(int[] TotalDebtMoneySum,int FixedNumberCount,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i,int ReturnMoney) {
        Scanner sc = new Scanner(System.in);
        if (ControlEntryCheck == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (1000 * Number)) {
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
                ReturnMoney += (1000 * Number);
                DrinkNumberOutput[i] += Number;
                return NeedMoneySelect(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else {
                System.out.println("주문이 완료되었습니다");
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
                DrinkNumberOutput[i] += Number;
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다 \n안내 : 제어로 진입시 돈갚기,돌아가기만 가능합니다");
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);

    }

    public static int Fishfunction(int[] TotalDebtMoneySum,int FixedNumberCount,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i,int ReturnMoney) {
        Scanner sc = new Scanner(System.in);
        if (ControlEntryCheck == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (4000 * Number)) {
                arr[i][0] -= (4000 * Number);
                TotalMoney -= (4000 * Number);
                ReturnMoney += (4000 * Number);
                FishNumberOutput[i] += Number;
                return NeedMoneySelect(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum, i,ReturnMoney);
            } else {
                System.out.println("주문이 완료되었습니다");
                arr[i][0] -= (4000 * Number);
                TotalMoney -= (4000 * Number);
                FishNumberOutput[i] += Number;
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다 \n안내 : 제어로 진입시 돈갚기,돌아가기만 가능합니다");
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);

    }

    public static int TheNextPeople(int[] TotalDebtMoneySum,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum) {
        //다음손님으로 넘어갈때 이 메소드를 거쳐간다
        if (ControlEntryCheck == 0) { //구매한 음식이 하나도 없는상태에서 다음손님으로 넘어갈때
            if (SnackNumberOutput[I] == 0 && BreadNumberOutput[I] == 0 && FishNumberOutput[I] == 0 && FruitNumberOutput[I] == 0 && DrinkNumberOutput[I] == 0) {
                I++;
            }
            if (SnackNumberOutput[I] != 0 || BreadNumberOutput[I] != 0 || FishNumberOutput[I] != 0 || FruitNumberOutput[I] != 0 || DrinkNumberOutput[I] != 0) {
                I++;
            }
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }

    public static int ReceiptOutput(int[] TotalDebtMoneySum,int OutPutOrder, int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i) {
        if (ControlEntryCheck == 0) {
            for (int j = 0; j <= i; j++) {
                if (SnackNumberOutput[j] == 0 && BreadNumberOutput[j] == 0 && FruitNumberOutput[j] == 0 && DrinkNumberOutput[j] == 0 && FishNumberOutput[j] == 0) {
                    continue; //하나도 구매하지 않은경우 출력되지 않도록 설정한다
                }
                OutPutOrder += 1; //하나도 구매하지 않은경우를 제외하고구매한사람의 인원수대로 누적
                System.out.println("============주문표============");
                if (SnackNumberOutput[j] >= 1) {
                    System.out.println("과자 X " + SnackNumberOutput[j] + " = " + (SnackNumberOutput[j] * 1500) + "원");
                }
                if (BreadNumberOutput[j] >= 1) {
                    System.out.println("빵 X " + BreadNumberOutput[j] + " = " + (BreadNumberOutput[j] * 1000) + "원");
                }
                if (FruitNumberOutput[j] >= 1) {
                    System.out.println("과일 X " + FruitNumberOutput[j] + " = " + (FruitNumberOutput[j] * 2500) + "원");
                }
                if (DrinkNumberOutput[j] >= 1) {
                    System.out.println("음료수 X " + DrinkNumberOutput[j] + " = " + (DrinkNumberOutput[j] * 1000) + "원");
                }
                if (FishNumberOutput[j] >= 1) {
                    System.out.println("생선 X " + FishNumberOutput[j] + " = " + (FishNumberOutput[j] * 4000) + "원");
                }

                System.out.println("===========" + OutPutOrder + "번째 손님===========");

                if (SnackNumberOutput[j] >= 1) {
                    System.out.println("과자 X " + SnackNumberOutput[j] + " = " + (SnackNumberOutput[j] * 1500) + "원");
                }
                if (BreadNumberOutput[j] >= 1) {
                    System.out.println("빵 X " + BreadNumberOutput[j] + " = " + (BreadNumberOutput[j] * 1000) + "원");
                }
                if (FruitNumberOutput[j] >= 1) {
                    System.out.println("과일 X " + FruitNumberOutput[j] + " = " + (FruitNumberOutput[j] * 2500) + "원");
                }
                if (DrinkNumberOutput[j] >= 1) {
                    System.out.println("음료수 X " + DrinkNumberOutput[j] + " = " + (DrinkNumberOutput[j] * 1000) + "원");
                }
                if (FishNumberOutput[j] >= 1) {
                    System.out.println("생선 X " + FishNumberOutput[j] + " = " + (FishNumberOutput[j] * 4000) + "원");
                }
                System.out.println("현재 가지고 있는 금액 : " + arr[j][0] + "원  \n총 빛 진 금액 : " + TotalDebtMoneySum[j]  + "원  \n빚을 청산하고 남은 금액 : " + DebtMoneySum[j] + "원  \n미납 된 금액 : " + DebtMoneySum[j] + "원  \n빌려준 금액 : " + lendMoneySum[j] + "원 \n안내 : 해당 손님 제어를 원하시면 8번 제어하기 --> " + (j + 1) + "번을 입력해주세요\n");
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다 \n안내 : 제어로 진입시 돈갚기,돌아가기만 가능합니다");
            return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
        }
        I++;
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }
    public static int PeopleControl(int[] TotalDebtMoneySum,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i) {
        Scanner sc = new Scanner(System.in);
        if (ControlEntryCheck == 0 && i == 0) {
            System.out.println("최소 2번째 손님부터 제어가 가능합니다");
        } else if (ControlEntryCheck == 0) {
            System.out.println("몇번째 손님을 제어 하시겠습니까?");
            SavePreviousIndex = i; //이전손님의 순서를 미리 저장
            I = sc.nextInt() - 1;
            ControlEntryCheck = 1;
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다 \n안내 : 제어로 진입시 돈갚기,돌아가기만 가능합니다");
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }
    public static int PaybackMoney (int[] TotalDebtMoneySum,int I, int TotalMoney,int ControlEntryCheck,int SavePreviousIndex, int[][] arr, int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum, int i) {
        Scanner sc = new Scanner(System.in);
        if (DebtMoneySum[i] == 0) {
            System.out.println("돈을 빌린 내역이 없습니다");
        } else {
            System.out.println("몇번째 손님에게 갚겠습니까?");
            int PeopleSelect = sc.nextInt() - 1;//인덱스 번호와 실제 나타나고있는 손님의 번호와 차이가있기때문

            if (i == PeopleSelect) {
                System.out.println("자신에게 돈을 갚을 수 없습니다");
                return Menu(TotalDebtMoneySum,I, TotalMoney, ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
            }
            if (PeopleSelect < 0 || PeopleSelect > 15) {
                System.out.println("안내 : 잘못된 입력입니다");
                return Menu(TotalDebtMoneySum,I, TotalMoney, ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
            }
            System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 빌린 돈 : " + arr[i][PeopleSelect] + "원 \n얼마를 갚겠습니까?");
            int PayBackMoney = sc.nextInt();

            if (PayBackMoney < 0) {
                System.out.println("안내 : 잘못된 입력입니다");
                return Menu(TotalDebtMoneySum,I, TotalMoney, ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
            }
            if (arr[i][PeopleSelect] > 0) {
                if (arr[PeopleSelect][0] < PayBackMoney) { //빌린돈보다 많이 갚는경우
                    System.out.println("빌린 돈은 " + arr[i][PeopleSelect] + "원이며 그 값을 초과 할 수 없습니다");
                } else if (arr[i][PeopleSelect] >= PayBackMoney) {
                    DebtMoneySum[i] -= PayBackMoney; //빌린사람이 돈을 갚았으므로 총 빚금액에서 갚은만큼 차감
                    lendMoneySum[i + 1] -= PayBackMoney; //빌려준사람이 돈을 받았으므로 받은만큼 차감
                    arr[i][0] -= PayBackMoney; //빌린사람의 전체돈에서 차감
                    arr[i + 1][0] += PayBackMoney; //빌린돈을 받는사람의 전체돈에서 추가
                    arr[i][PeopleSelect] -= PayBackMoney;//빌린사람에게 갚았으니까 채무내역수정
                    arr[i + 1][PeopleSelect] -= PayBackMoney; //돈을빌린사람에게 받았으니까 채무내역수정
                    System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다 \n남은 빚 : " + arr[i][PeopleSelect] + "원");
                }
            } else {
                System.out.println("돈을 빌린 내역이 없습니다");
            }
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney, ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }
    public static int NeedMoneySelect(int[] TotalDebtMoneySum,int FixedNumberCount,int I,int TotalMoney,int ControlEntryCheck,int SavePreviousIndex,int[][] arr,int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum,int i,int ReturnMoney) {
      //음식을 구매 후 돈이부족할때 넘어오는 메소드
        Scanner sc = new Scanner(System.in);

        if (arr[i][0] < 0) {
            System.out.println("돈이 부족합니다 다시 선택하시겠습니까?  \n1.Yes  \n2.No(돈빌리기)");
            int ReSelect = sc.nextInt();

            if (ReSelect == 1) {
                arr[i][0] += ReturnMoney; //구매했던 금액을 다시 반환시킨다
                return Menu(TotalDebtMoneySum,I, TotalMoney, ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
            } else if (ReSelect == 2) {
                return BorrowNeedMoney(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
            } else {
                System.out.println("안내 : 잘못된 입력입니다");
                arr[i][0] += ReturnMoney; //구매했던 금액을 다시 반환시킨다
                return Menu(TotalDebtMoneySum,I, TotalMoney, ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
            }
        }
        return 0;
    }
    public static int BorrowNeedMoney (int[] TotalDebtMoneySum,int FixedNumberCount,int I,int TotalMoney,int ControlEntryCheck,int SavePreviousIndex,int[][] arr,int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput,int[] DebtMoneySum,int[] lendMoneySum) {
        //돈을빌릴때 쓰는 메소드
        Scanner sc = new Scanner(System.in);
        for (int j = I; j < 15; j++) {
            System.out.println("빌릴 금액을 입력하세요");
            int Borrow = sc.nextInt();

            arr[j + 1][0] -= Borrow; //돈을 빌려주는사람의 전체돈에서 차감
            arr[j - FixedNumberCount][0] += Borrow;//돈을 받는사람의 전체돈에서 차감

            if (arr[j + 1][0] >= 0 && arr[j - FixedNumberCount][0] >= 0) {
                //돈을 정상적으로 빌리는경우
                arr[j + 1][j + 1 - FixedNumberCount] += Borrow; //빌려준사람 기록
                arr[j - FixedNumberCount][j + 1] += Borrow;
                TotalDebtMoneySum[j - FixedNumberCount] += Borrow; //빚진금액을 모두 더한값
                lendMoneySum[j + 1] += Borrow; //빌려주는사람의 총 금액
                DebtMoneySum[j - FixedNumberCount] += Borrow; //빌리는사람의 빚진금액 + 갚은금액
                return AddBorrowSelect(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum,j,Borrow);
            } else if (arr[j + 1][0] < 0) {
                //빌리는사람이 가지고있는 돈보다 더 빌리려는경우
                return OverBorrowing(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum,j,Borrow);
            } else if (arr[j + 1][0] > Borrow && arr[j - FixedNumberCount][0] < 0) {
                //금액을 음수값으로 입력하거나 0원을 입력한경우
                return WrongGuessesInput(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum,j,Borrow);
            } else {
                System.out.println("안내 : 잘못된 입력입니다");
                j--;
            }
        }
        return 0;
    }
    public static int AddBorrowSelect (int[] TotalDebtMoneySum,int FixedNumberCount,int I,int TotalMoney,int ControlEntryCheck,int SavePreviousIndex,int[][] arr,int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput,int[] DebtMoneySum,int[] lendMoneySum,int j,int Borrow) {
        //돈을 빌리고 추가적으로 더 빌릴건지 묻는 메소드
        Scanner sc = new Scanner(System.in);
        System.out.println("" + Borrow + "원을 빌려 현재 " + arr[j - FixedNumberCount][0] + "원  \n다음사람의 돈은 " + arr[j + 1][0] + "원 입니다  \n1.추가로 빌린다  2.빌리지 않는다");
        int BorrowSelect = sc.nextInt();

        //추가적으로 빌리는 질문에 답변
        if (BorrowSelect == 1) {
            if (ControlEntryCheck == 0) {
                I++;
                FixedNumberCount += 1;//더 빌리는경우 그 사람이 계속 고정되고 빌려주는사람만  이동되도록 해야하기위해 추가
                return BorrowNeedMoney(TotalDebtMoneySum,FixedNumberCount,I,TotalMoney,ControlEntryCheck,SavePreviousIndex,arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput,DebtMoneySum,lendMoneySum);
            }
        } else if (BorrowSelect == 2) {
            I = I - FixedNumberCount;
            return AvailableFood(TotalDebtMoneySum,FixedNumberCount,I,TotalMoney,ControlEntryCheck,SavePreviousIndex,arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum,j);
        } else {
            System.out.println("안내 : 잘못된 입력입니다");
            return Menu(TotalDebtMoneySum,I, TotalMoney, ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
        }
        return 0;
    }
    public static int OverBorrowing (int[] TotalDebtMoneySum,int FixedNumberCount,int I,int TotalMoney,int ControlEntryCheck,int SavePreviousIndex,int[][] arr,int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput,int[] DebtMoneySum,int[] lendMoneySum,int j,int Borrow) { //빌리는사람이 가지고있는 돈보다 더 빌리려는경우
        //빌리려는 사람이 가지고 있는 돈 보다 더많이 빌리려고 하는경우와 그외에 다른변수 대처를 정리
        arr[j + 1][0] += Borrow;
        arr[j - FixedNumberCount][0] -= Borrow;
        System.out.println("다음사람이 가진 돈은 " + arr[j + 1][0] + "원이며 이보다 더 많이 빌릴 수 없습니다");
        return BorrowNeedMoney(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }
    public static int WrongGuessesInput (int[] TotalDebtMoneySum,int FixedNumberCount,int I,int TotalMoney,int ControlEntryCheck,int SavePreviousIndex,int[][] arr,int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput,int[] DebtMoneySum,int[] lendMoneySum,int j,int Borrow) { //금액을 음수값으로 입력하거나 0원을 입력한경우
        //돈을 빌릴 때 음수값을 적거나 돈을 빌렸지만 돈이 부족한경우
        if (Borrow == 0 || Borrow < 0) {
            System.out.println("금액은 음수 값이 나올 수 없으며 최소 1원부터 가능합니다");
            arr[j + 1][0] += Borrow;
            arr[j - FixedNumberCount][0] -= Borrow;
            return BorrowNeedMoney(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
        } else  {
            System.out.println("돈이 " + -(arr[j - FixedNumberCount][0]) + "원 부족합니다 돈을 더 빌리세요");
            FixedNumberCount += 1;
            return BorrowNeedMoney(TotalDebtMoneySum,FixedNumberCount, I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
        }
    }

    public static int AvailableFood (int[] TotalDebtMoneySum,int FixedNumberCount,int I,int TotalMoney,int ControlEntryCheck,int SavePreviousIndex,int[][] arr,int[] SnackNumberOutput,int[] BreadNumberOutput,int[] FruitNumberOutput,int[] DrinkNumberOutput,int[] FishNumberOutput, int[] DebtMoneySum, int[] lendMoneySum,int j) {
        //물건을 구매하고 남은돈으로 구매 할 수 있는 음식리스트를 알려준후 다시 메인메뉴로 재리턴
        if (arr[j - FixedNumberCount][0] >= 4000) {
            System.out.println("안내 : 과자,빵,과일,음료수.생선을 구매 할 수 있습니다");
        } else if (arr[j - FixedNumberCount][0] < 4000 && arr[j - FixedNumberCount][0] >= 2500) {
            System.out.println("안내 : 과자,빵,과일,음료수를 구매 할 수 있습니다");
        } else if (arr[j - FixedNumberCount][0] < 2500 && arr[j - FixedNumberCount][0] >= 1500) {
            System.out.println("안내 : 과자,빵,음료수를 구매 할 수 있습니다");
        } else if (arr[j - FixedNumberCount][0] < 1500 && arr[j - FixedNumberCount][0] >= 1000) {
            System.out.println("안내 : 빵,음료수를 구매 할 수 있습니다");
        } else {
            System.out.println("안내 : 잘못된 입력입니다");
        }
        return Menu(TotalDebtMoneySum,I, TotalMoney,ControlEntryCheck, SavePreviousIndex, arr,SnackNumberOutput,BreadNumberOutput,FruitNumberOutput,DrinkNumberOutput,FishNumberOutput, DebtMoneySum, lendMoneySum);
    }
}
