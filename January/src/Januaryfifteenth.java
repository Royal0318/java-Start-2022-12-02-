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
public class Januaryfifteenth {
    public static void main(String[] args) {
        System.out.println("모든 사람의 남은 돈의 합은 "+main()+"원 입니다");
    }
    public static int main() {
        int TotalMoney = 150000;
        int Count2 = 0;
        int ICount = 0;
        int ControlCount = 0;
        int BackCount = 0;
        int SnackCount = 0;
        int BreadCount = 0;
        int FruitCount = 0;
        int DrinkCount = 0;
        int FishCount = 0;
        int[][] arr = new int[15][15]; //행과 열 총 15줄씩
        arr[0][0] = 20000;
        arr[1][0] = 20000;
        arr[2][0] = 20000;
        arr[3][0] = 20000;
        arr[4][0] = 20000;
        arr[5][0] = 10000;
        arr[6][0] = 20000;
        arr[7][0] = 30000;
        arr[8][0] = 40000;
        arr[9][0] = 50000;
        /*
       만약에 arr[0][0]값이 20000이라면 arr[0][1]이 -5000이라면 전체적인값은 어떻게구할것인가?
       예를들어서 arr[1][0]에게 5000원을 빌렸으면 arr[0][1]은 -5000이될것이다 이럴땐 01은 그냥냅두고 arr[0][0] -= 5000을하면되겠다
         */
        int[] Snack = new int[15];
        int[] Bread = new int[15];
        int[] Fruit = new int[15];
        int[] Drink = new int[15];
        int[] Fish = new int[15];
        int[][] PayBackSum = new int[15][15]; //빚 관련 array
        int[][] DebtSum = new int[15][15]; //빚 관련 array
        int[][] lendSum = new int[15][15]; //빌려준 돈관련 array
        return PeopleMoneyInput(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
    }

    public static int PeopleMoneyInput(int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum) {
        Scanner sc = new Scanner(System.in);
        for (int i = 10; i < 15; i++) {
            System.out.println("" + i + "번째 손님의 돈을 입력 해주세요");
            arr[i][0] = sc.nextInt();
            TotalMoney += arr[i][0];
            if (arr[i][0] < 0) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
    }

    public static int Menu(int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum) {
        Scanner sc = new Scanner(System.in);
        for (int i = ICount; i < 15; i++) {
            int NumFixCount = 0; //다시 메뉴판으로 돌아오면은 초기화되도록설정
            int OutPutCount = 0;
            System.out.println("\n1.과자 1500원  \n2.빵 1000원  \n3.과일 2500원  \n4.음료수 1000원   \n5.생선 4000원  \n6.다음 손님  \n7.종료버튼 \n8.제어 \n9.돈갚기");
            if (ControlCount == 1) {//제어로 진입시 나타난다
                System.out.println("10.이전 손님으로 돌아가기\n");
            }
            System.out.println("\n"+(i + 1)+"번째 손님의 선택 \n안내 : 현재 소지 금액 : "+arr[i][0]+"원");
            int Select = sc.nextInt();

            if (Select < 1 || Select > 9 && ControlCount == 0) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
            if (Select < 1 || Select > 10 && ControlCount == 1) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
            if (Select == 6 || Select == 7 || Select == 8) {
                if (ControlCount == 1) {
                    System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
                    i--;
                }
            } else if (Select == 10) {
                i = BackCount - 1;
                ControlCount = 0; //컨트롤값 초기화
            }

            if (Select == 1) {
                return Snackfunction(NumFixCount,ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else if (Select == 2) {
                return Breadfunction(NumFixCount,ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else if (Select == 3) {
                return Fruitfunction(NumFixCount,ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else if (Select == 4) {
                return Drinkfunction(NumFixCount,ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else if (Select == 5) {
                return Fishfunction(NumFixCount,ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else if (Select == 6) {
                return NextPeople(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
            } else if (Select == 7) {
                return BuyMenuPrint(OutPutCount, ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else if (Select == 8) {
                return Control(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else if (Select == 9) {
                return Payback(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else {
                System.out.println("잘못된 입력입니다");
            }
        }
        return 0;
    }

    public static int Snackfunction(int NumFixCount,int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        Scanner sc = new Scanner(System.in);
        if (ControlCount == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (1500 * Number)) { //돈이부족한경우
                arr[i][0] -= (1500 * Number); //미리 계산되고 돈을 보충했을경우 자동구매되도록 설계
                TotalMoney -= (1500 * Number);
                Snack[i] += Number; //과자 개수 카운트하는 변수
                return NeedMoney(NumFixCount, ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else {
                System.out.println("주문이 완료되었습니다");
                Snack[i] += Number;
                SnackCount += 1;
                arr[i][0] -= (1500 * Number);
                TotalMoney -= (1500 * Number);
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
    }

    public static int Breadfunction(int NumFixCount,int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        Scanner sc = new Scanner(System.in);
        if (ControlCount == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (1000 * Number)) {
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
                Bread[i] += Number;
                return NeedMoney(NumFixCount, ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else {
                System.out.println("주문이 완료되었습니다");
                Bread[i] += Number;
                BreadCount += 1;
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);

    }

    public static int Fruitfunction(int NumFixCount,int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        Scanner sc = new Scanner(System.in);
        if (ControlCount == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (2500 * Number)) {
                arr[i][0] -= (2500 * Number);
                TotalMoney -= (2500 * Number);
                Fruit[i] += Number;
                return NeedMoney(NumFixCount, ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else {
                System.out.println("주문이 완료되었습니다");
                Fruit[i] += Number;
                FruitCount += 1;
                arr[i][0] -= (2500 * Number);
                TotalMoney -= (2500 * Number);
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);

    }

    public static int Drinkfunction(int NumFixCount,int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        Scanner sc = new Scanner(System.in);
        if (ControlCount == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (1000 * Number)) {
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
                Drink[i] += Number;
                return NeedMoney(NumFixCount, ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else {
                System.out.println("주문이 완료되었습니다");
                Drink[i] += Number;
                DrinkCount += 1;
                arr[i][0] -= (1000 * Number);
                TotalMoney -= (1000 * Number);
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);

    }

    public static int Fishfunction(int NumFixCount,int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        Scanner sc = new Scanner(System.in);
        if (ControlCount == 0) {
            System.out.println("구매할 개수를 적어주세요");
            int Number = sc.nextInt();
            if (arr[i][0] < (4000 * Number)) {
                arr[i][0] -= (4000 * Number);
                TotalMoney -= (4000 * Number);
                Fish[i] += Number;
                return NeedMoney(NumFixCount, ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum, i);
            } else {
                System.out.println("주문이 완료되었습니다");
                Fish[i] += Number;
                FishCount += 1;
                arr[i][0] -= (4000 * Number);
                TotalMoney -= (4000 * Number);
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);

    }

    public static int NextPeople(int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum) {
        if (ControlCount == 0) {
            if (SnackCount == 0 && BreadCount == 0 && FishCount == 0 && FruitCount == 0 && DrinkCount == 0) {
                ICount++;
            }
            if (SnackCount != 0 || BreadCount != 0 || FishCount != 0 || FruitCount != 0 || DrinkCount != 0) {
                SnackCount = 0;
                BreadCount = 0;
                FishCount = 0;
                FruitCount = 0;
                DrinkCount = 0;
                Count2 = 0;
                ICount++;
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
    }

    public static int BuyMenuPrint(int OutPutCount, int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        if (ControlCount == 0) {
            for (int j = 0; j <= i; j++) {
                if (Snack[j] == 0 && Bread[j] == 0 && Fruit[j] == 0 && Drink[j] == 0 && Fish[j] == 0) {
                    continue; //하나도 구매하지 않은경우 출력되지 않도록 설정한다
                }
                OutPutCount += 1;
                System.out.println("============주문표============");
                if (Snack[j] >= 1) {
                    System.out.println("과자 X " + Snack[j] + " = " + (Snack[j] * 1500) + "원");
                }
                if (Bread[j] >= 1) {
                    System.out.println("빵 X " + Bread[j] + " = " + (Bread[j] * 1000) + "원");
                }
                if (Fruit[j] >= 1) {
                    System.out.println("과일 X " + Fruit[j] + " = " + (Fruit[j] * 2500) + "원");
                }
                if (Drink[j] >= 1) {
                    System.out.println("음료수 X " + Drink[j] + " = " + (Drink[j] * 1000) + "원");
                }
                if (Fish[j] >= 1) {
                    System.out.println("생선 X " + Fish[j] + " = " + (Fish[j] * 4000) + "원");
                }

                System.out.println("===========" + OutPutCount + "번째 손님===========");

                if (Snack[j] >= 1) {
                    System.out.println("과자 X " + Snack[j] + " = " + (Snack[j] * 1500) + "원");
                }
                if (Bread[j] >= 1) {
                    System.out.println("빵 X " + Bread[j] + " = " + (Bread[j] * 1000) + "원");
                }
                if (Fruit[j] >= 1) {
                    System.out.println("과일 X " + Fruit[j] + " = " + (Fruit[j] * 2500) + "원");
                }
                if (Drink[j] >= 1) {
                    System.out.println("음료수 X " + Drink[j] + " = " + (Drink[j] * 1000) + "원");
                }
                if (Fish[j] >= 1) {
                    System.out.println("생선 X " + Fish[j] + " = " + (Fish[j] * 4000) + "원");
                }
                System.out.println("현재 가지고 있는 금액 : " + arr[j][0] + "원  \n빛 진 금액 : " + DebtSum[j][0]  + "원  \n빚을 청산하고 남은 금액 : " + (DebtSum[j][0] - PayBackSum[j][0]) + "원  \n미납 된 금액 : " + (DebtSum[j][0] - PayBackSum[j][0]) + "원  \n빌려준 금액 : " + lendSum[j][0] + "원 \n안내 : 해당 손님 제어를 원하시면 8번 제어하기 --> " + (j + 1) + "번을 입력해주세요\n");
                SnackCount = 0;
                BreadCount = 0;
                FishCount = 0;
                FruitCount = 0;
                DrinkCount = 0; //다음손님이 물건을 고를때 누적되지 않도록 초기화
                Count2 = 0; //처음에 손님이고르고 다음손님으로 넘어갈때 count도 초기화
                ICount ++; //다음손님으로 넘어가는 카운트
            }
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
    }

    public static int Control(int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        Scanner sc = new Scanner(System.in);
        if (ControlCount == 0 && i == 0) {
            System.out.println("최소 2번째 손님부터 제어가 가능합니다");
        } else if (ControlCount == 0) {
            System.out.println("몇번째 손님을 제어 하시겠습니까?");
            BackCount = i; //이전손님의 순서를 미리 저장
            ICount = sc.nextInt() - 1;
            ControlCount = 1;
        } else {
            System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
    }

    public static int Payback (int ICount, int TotalMoney, int Count2, int ControlCount, int BackCount, int SnackCount, int BreadCount, int FruitCount, int DrinkCount, int FishCount, int[][] arr, int[] Snack, int[] Bread, int[] Fruit, int[] Drink, int[] Fish, int[][] PayBackSum, int[][] DebtSum, int[][] lendSum, int i) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("몇번째 손님에게 갚겠습니까?");
            int PeopleSelect = sc.nextInt() - 1;
            System.out.println("얼마를 갚겠습니까?");
            int PayBackMoney = sc.nextInt();

            if (PeopleSelect < 0 || PeopleSelect > 15) {
                System.out.println("잘못된 입력입니다");
            } else if (PayBackMoney < 0) {
                System.out.println("잘못된 입력입니다");
            }

            if (arr[i][i] == arr[i][PeopleSelect]) {
                System.out.println("자신에게 돈을 갚을 수 없습니다");
            } else if (arr[i][PeopleSelect] == 0) { //빌린돈이 0원이라면 빌리지 않은것이니까 내역이 없다고 나옴
                System.out.println("돈을 빌린 내역이 없습니다");
            } else if (arr[i][PeopleSelect] > 0) {
                if (arr[i][PeopleSelect] < PayBackMoney) { //빌린돈보다 많이 갚는경우
                    System.out.println("빌린 돈은 " + arr[i][PayBackMoney] + "원이며 그 값을 초과 할 수 없습니다");
                } else if (arr[i][PeopleSelect] >= PayBackMoney) {
                    arr[i][0] -= PayBackMoney; //빌린사람의 전체돈을 차감
                    arr[i][PeopleSelect] -= PayBackMoney;
                    arr[i + 1][0] += PayBackMoney;
                    arr[i + 1][PeopleSelect] += PayBackMoney; //빌려준사람의 돈을 추가
                    lendSum[i + 1][PeopleSelect] -= PayBackMoney; //빌려준사람의 빌린값에서 차감
                    PayBackSum[i + 1][PeopleSelect] += PayBackMoney;
                    System.out.println("" + (PeopleSelect + 1) + "번째 손님에게 " + PayBackMoney + "원을 갚았습니다   \n남은 빚 : " +  arr[i][PeopleSelect] + "원");
                    return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
                }
            }
        }
    }

    public static int NeedMoney(int NumFixCount,int ICount,int TotalMoney,int Count2,int ControlCount,int BackCount,int SnackCount,int BreadCount,int FruitCount,int DrinkCount,int FishCount,int[][] arr,int[] Snack,int[] Bread,int[] Fruit,int[] Drink,int[] Fish,int[][] PayBackSum,int[][] DebtSum,int[][] lendSum,int i) {
       Scanner sc = new Scanner(System.in);

        if (arr[i][0] < 1000) {
            System.out.println("돈이 부족합니다 다시 선택하시겠습니까?  \n1.Yes  \n2.No(돈빌리기)");
            int ReSelect = sc.nextInt();

            if (ReSelect == 1) {
                System.out.println();
            } else if (ReSelect == 2) {

                for (int j = i; j < 15; j++) {
                    System.out.println("빌리고싶은 금액을 적어주세요");
                    int Borrow = sc.nextInt();

                    //arr[j + 1][j + 1] -= Borrow;//빌려주는 사람이 얼마빌려줬는지 카운트
                    arr[j - NumFixCount][j + 1] += Borrow; //빌리는사람의 전체돈 처음에는 다음사람에게 빌린다
                    arr[j + 1][0] -= Borrow; //빌려주는 사람  전체돈을 차감시킨다
                    arr[j - NumFixCount][0] += Borrow;//돈을 받는사람의 전체돈

                    if (arr[j + 1][0] >= 0 && arr[j - NumFixCount][0] >= 0) { //arr[j + 1]번째 사람이 가지고있는 돈의 합
                        lendSum[j + 1][j + 1 - NumFixCount] += Borrow; //빌려준사람 기록
                        DebtSum[j - NumFixCount][j + 1] += Borrow; //빚진사람 기록
                        System.out.println("" + Borrow + "원을 빌려 현재 " + arr[j - NumFixCount][0] + "원  \n다음사람의 돈은 " + arr[j + 1][0] + "원 입니다  \n1.추가로 빌린다  2.빌리지 않는다");
                        int BorrowSelect = sc.nextInt();//가진돈은 물건값을 구매하고 남은돈이다

                        if (BorrowSelect == 1) {
                            if (ControlCount == 0) {
                                NumFixCount += 1;//더 빌리는경우 그 사람이 계속 고정되고 빌려주는사람만 다다음사람으로 이동되도록 해야하기 때문에 더빌릴때마다 count가 늘어남
                            }
                        } else if (BorrowSelect == 2) {
                            if (arr[j - NumFixCount][0] >= 4000) {
                                System.out.println("안내 : 과자,빵,과일,음료수.생선을 구매 할 수 있습니다");
                            } else if (arr[j - NumFixCount][0] < 4000 && arr[j - NumFixCount][0] >= 2500) {
                                System.out.println("안내 : 과자,빵,과일,음료수를 구매 할 수 있습니다");
                            } else if (arr[j - NumFixCount][0] < 2500 && arr[j - NumFixCount][0] >= 1500) {
                                System.out.println("안내 : 과자,빵,음료수를 구매 할 수 있습니다");
                            } else if (arr[j - NumFixCount][0] < 1500 && arr[j - NumFixCount][0] >= 1000) {
                                System.out.println("안내 : 빵,음료수를 구매 할 수 있습니다");
                            }
                            return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
                        } else {
                            System.out.println("잘못된 입력입니다");
                            return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
                        }
                    } else if (arr[j + 1][0] < 0) {
                        arr[j + 1][0] += Borrow;  //다시 반환
                        arr[j - NumFixCount][j - NumFixCount + 1] -= Borrow;
                        arr[j + 1][j + 1] += Borrow;
                        arr[j - NumFixCount][j - NumFixCount] -= Borrow;
                        System.out.println("다음사람이 가진 돈은 " + arr[j + 1][0] + "원이며 이보다 더 많이 빌릴 수 없습니다");
                        j--;
                    } else if (arr[j + 1][0] > Borrow && arr[j - NumFixCount][0] < 0) {
                        System.out.println("돈이 " + -(arr[j - NumFixCount][0]) + "원 부족합니다 돈을 더 빌리세요");
                        NumFixCount += 1;
                    } else if (Borrow == 0 || Borrow < 0) {
                        System.out.println("최소 1원 이상 빌릴 수 있습니다");
                        j--;
                    } else {
                        System.out.println("잘못된 입력입니다");
                        i--;
                    }
                }
                Count2 = 0; //루프를 빠져나오면서 Count값 초기화
                return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);            }
        }
        return Menu(ICount, TotalMoney, Count2, ControlCount, BackCount, SnackCount, BreadCount, FruitCount, DrinkCount, FishCount, arr, Snack, Bread, Fruit, Drink, Fish, PayBackSum, DebtSum, lendSum);
    }
}
