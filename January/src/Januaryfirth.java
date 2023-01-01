//남은일 : 돈을빌려주면 누구에게 빌려줬는지 구현,빚,미납금액구현
import java.util.Scanner;
public class Januaryfirth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TotalMoney = 150000;
        int Count2 = 0;
        int ControlCount = 0;
        int BackCount = 0;
        int SnackCount = 0;
        int BreadCount = 0;
        int FruitCount = 0;
        int DrinkCount = 0;
        int FishCount = 0;
        int OutPutCount = 0;
        int[] arr = new int[15];
        int[] Snack = new int[15];
        int[] Bread = new int[15];
        int[] Fruit = new int[15];
        int[] Drink = new int[15];
        int[] Fish = new int[15];
        int[] Debt = new int[15]; //빚 관련 array
        int[] lendSum = new int[15]; //빌려준 돈관련 array
        int[] ArrCount = new int[15];
        arr[0] = 20000;
        arr[1] = 20000;
        arr[2] = 20000;
        arr[3] = 20000;
        arr[4] = 20000;
        arr[5] = 10000;
        arr[6] = 10000;
        arr[7] = 10000;
        arr[8] = 10000;
        arr[9] = 10000;
        System.out.println("10번째부터 15번째 손님의 돈을 각각 입력해주세요");
        arr[10] = sc.nextInt(); arr[11] = sc.nextInt(); arr[12] = sc.nextInt(); arr[13] = sc.nextInt(); arr[14] = sc.nextInt();
        TotalMoney += arr[10]; TotalMoney += arr[11]; TotalMoney += arr[12]; TotalMoney += arr[13]; TotalMoney += arr[14];

        for (int i = 0; i < 15; i++) {
            int NumFixCount = 0; //다시 메뉴판으로 돌아오면은 초기화되도록설정
            System.out.println("\n1.과자  \n2.빵  \n3.과일  \n4.음료수  \n5.생선  \n6.다음 손님  \n7.종료버튼 \n8.제어 \n9.돈갚기");
            System.out.println("i값 테스트 "+i+" ");

            if (ControlCount == 1) {//제어로 진입시 나타난다
                System.out.println("10.이전 손님으로 돌아가기");
            }
            System.out.println("" + (i + 1) + "번째 손님의 선택입니다 (현재 소지 금액 "+arr[i]+"원)");
            int Select = sc.nextInt();

            if (Select < 1 || Select > 9 && ControlCount == 0) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
            //=============================제어=======================
            if (Select < 1 || Select > 10 && ControlCount == 1) {
                System.out.println("잘못된 입력입니다");
                i--;
            }
            if (Select == 6 || Select == 7 || Select == 8) {
                if (ControlCount == 1) {
                    System.out.println("이전 손님으로 돌아갈 수 밖에 없습니다");
                    i--;
                }
            }
            if (Select == 10) { //이전 손님으로 돌아가기
                i = BackCount - 1;
                ControlCount = 0; //컨트롤값 초기화
            }
            //=============================제어=======================
            if (Select == 1) { /////////과자
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (1500 * Number)) { //돈이부족한경우
                    arr[i] -= (1500 * Number);
                    Snack[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Snack[i] += Number;
                    SnackCount += 1;
                    arr[i] -= (1500 * Number);
                    TotalMoney -= (1500 * Number);
                    i = i - 1;//계속주문하기위해
                }
            } else if (Select == 2) {/////////빵
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (1000 * Number)) {
                    arr[i] -= (1000 * Number);
                    Bread[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Bread[i] += Number;
                    BreadCount += 1;
                    arr[i] -= (1000 * Number);
                    TotalMoney -= (1000 * Number);
                    i = i - 1;
                }
            } else if (Select == 3) {/////////과일
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (2500 * Number)) {
                    arr[i] -= (2500 * Number);
                    Fruit[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Fruit[i] += Number;
                    FruitCount += 1;
                    arr[i] -= (2500 * Number);
                    TotalMoney -= (2500 * Number);
                    i = i - 1;
                }
            } else if (Select == 4) {/////////음료수
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (1000 * Number)) {
                    arr[i] -= (1000 * Number);
                    Drink[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Drink[i] += Number;
                    DrinkCount += 1;
                    arr[i] -= (1000 * Number);
                    TotalMoney -= (1000 * Number);
                    i = i - 1;
                }
            } else if (Select == 5) {/////////생선
                System.out.println("구매할 개수를 적어주세요");
                int Number = sc.nextInt();
                if (arr[i] < (4000 * Number)) {
                    arr[i] -= (4000 * Number);
                    Fish[i] += Number;
                    Count2 = 1;
                } else {
                    System.out.println("주문이 완료되었습니다");
                    Fish[i] += Number;
                    FishCount += 1;
                    arr[i] -= (4000 * Number);
                    TotalMoney -= (4000 * Number);
                    i = i - 1;
                }
            } else if (Select == 6) {
                if (SnackCount == 0 && BreadCount == 0 && FishCount == 0 && FruitCount == 0 && DrinkCount == 0) {//모두 하나도 사지 않은경우
                    System.out.println();
                }
                if (SnackCount != 0 || BreadCount != 0 || FishCount != 0 || FruitCount != 0 || DrinkCount != 0) {
                    SnackCount = 0;BreadCount = 0;FishCount = 0;FruitCount = 0;DrinkCount = 0;
                    Count2 = 0;
                }
            } else if (Select == 7) {
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
                    System.out.println("============" + OutPutCount + "번째 손님============");//얘만 순서대로 출력되면됨 눈에보이는것만
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
                    System.out.println("현재 가지고 있는 금액 : " + arr[j] + "원  \n빛 진 금액 : " + Debt[j] + "원  \n빛을 청산하고 남은 금액 : " + arr[j] + "원  \n미납 된 금액 : " + (Debt[j] - arr[j]) + "원  \n빌려준 금액 : " + lendSum[j] + "원\n");
                    SnackCount = 0;BreadCount = 0;FishCount = 0;FruitCount = 0;DrinkCount = 0;
                    Count2 = 0; //처음에 손님이고르고 다음손님으로 넘어갈때 count도 초기화되야한다
                }
            } else if (Select == 8) {
                if (ControlCount == 0 && i == 0) {
                    System.out.println("최소 2번째 순서부터 제어가 가능합니다");
                    i--;
                } else if (ControlCount == 0) {
                    System.out.println("몇번째 손님을 제어하시겠습니까?");
                    BackCount = i; //이전손님의 순서를 미리 저장
                    i = sc.nextShort() - 2;
                    ControlCount = 1;
                    OutPutCount = 0;
                }
            } else if (Select == 9) {
                System.out.println("빚진사람의 번호와 돈을 받는사람의 번호를 각각 적어주세요");
                int PayBack = sc.nextInt(); //빚진사람
                ArrCount[PayBack] = PayBack;
                int PayBack2 = sc.nextInt(); //돈을 받는사람
                arr[PayBack2] = PayBack2;
                System.out.println("얼마를 갚겠습니까?");
                int PayBackMoney = sc.nextInt();
            }
            if (Count2 == 1) { ////////////////////돈빌림,돈이부족할때 여기로넘어온다
                if (arr[i] < 1000) {
                    System.out.println("돈이 부족합니다 다시 선택하시겠습니까?  \n1.Yes  \n2.No(돈 빌리기)");
                    int ReSelect = sc.nextInt();

                    if (ReSelect == 1) {
                        System.out.println();
                    } else if (ReSelect == 2) {
                        for (int j = i; j < 15; j++) {
                            System.out.println("얼마를 빌리겠습니까?");
                            int Borrow = sc.nextInt();
                            arr[j + 1] -= Borrow; //돈을 빌려주는사람
                            arr[j - NumFixCount] += Borrow; //돈을 받는사람

                            if (arr[j + 1] >= 0 && arr[j - NumFixCount] >= 0) { //다음사람이 가지고있는 돈보다 적게 빌리지만 계산된값이 음수가 아니라 통과된경우
                                lendSum[j + 1] -= Borrow; //다음 사람이 빌려준 금액을 누적
                                Debt[j] += Borrow; //받는 사람이 빛진금액 누적
                                System.out.println("" + Borrow + "원을 빌려 현재 가진돈은 " + arr[j - NumFixCount] + "원  \n다음사람이 가진 돈은 " + arr[j + 1] + "원 입니다  \n1.더 빌린다  2.빌리지 않는다");
                                int BorrowSelect = sc.nextInt();//가진돈은 물건값을 구매하고 남은돈이다

                                if (BorrowSelect == 1) {
                                    NumFixCount += 1;//더 빌리는경우 그 사람이 계속 고정되고 빌려주는사람만 다다음사람으로 이동되도록 해야하기 때문에  더빌릴때마다 count가 늘어남
                                } else if (BorrowSelect == 2) {
                                    if (arr[j - NumFixCount] >= 4000) {
                                        System.out.println("과자,빵,과일,음료수.생선을 구매 할 수 있습니다");
                                    } else if (arr[j - NumFixCount] < 4000 && arr[j - NumFixCount] >= 2500) {
                                        System.out.println("과자,빵,과일,음료수를 구매 할 수 있습니다");
                                    } else if (arr[j - NumFixCount] < 2500 && arr[j - NumFixCount] >= 1500) {
                                        System.out.println("과자,빵,음료수를 구매 할 수 있습니다");
                                    } else if (arr[j - NumFixCount] < 1500 && arr[j - NumFixCount] >= 1000) {
                                        System.out.println("빵,음료수를 구매 할 수 있습니다");
                                    }
                                    break;
                                } else {
                                    System.out.println("잘못된 입력입니다");
                                    break;
                                }
                            } else if (arr[j + 1] >= 0 && arr[j - NumFixCount] < 0) {
                                System.out.println("돈을 "+-(arr[j - NumFixCount])+"원 부족합니다 돈을 더 빌리세요");
                                NumFixCount += 1;
                            } else if (arr[j + 1] < 0) {//다음사람이 가지고있는 돈보다 많이 빌리려고 하는경우
                                arr[j + 1] += Borrow;
                                arr[j - NumFixCount] -= Borrow; //받거나 준것 그대로 반환
                                System.out.println("다음사람이 가진 돈은 "+arr[j + 1]+"원이며 이보다 더 많이 빌릴 수 없습니다");
                                j--;
                            } else {
                                System.out.println("잘못된 입력입니다");
                                i--;
                            }
                        }
                        Count2 = 0;
                    }
                }
            }
        }
        System.out.println("모든 사람의 남은 금액은 "+TotalMoney+"원 입니다");
    }
}
